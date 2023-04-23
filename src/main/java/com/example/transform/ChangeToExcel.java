package com.example.transform;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.CartOrder.dao.DeliveryInfoDAO;
import com.example.CartOrder.dto.UpTmDTO;


@Component
public class ChangeToExcel {

	@Autowired
	private DeliveryInfoDAO deliveryInfoDAO;

	@Scheduled(fixedDelay = 1000 * 60 * 60)
	public void autoUpdate() {
		LocalDate today = LocalDate.now();

		int month = today.getMonthValue();
		String monthVal = String.format("%02d", month);

		int day = today.getDayOfMonth();
		String dayVal = String.format("%02d", day);

		String txtPath = String.format("C:\\log\\order_done.2023-%s-%s.txt", monthVal, dayVal);
		System.out.println(txtPath);
		String excelPath = String.format("C:\\output\\delivery.2023-%s-%s.xlsx", monthVal, dayVal);

		File txtFile = new File(txtPath);
		if (txtFile.exists()) {
			try {
				createExcel(excelPath);
				convert(txtPath, excelPath);
				insertDataToDatabase(excelPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createExcel(String outputFilePath) throws IOException {

		try (Workbook workbook = new XSSFWorkbook();
				FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
			Sheet sheet = workbook.createSheet("New Sheet");
			Row headerRow = sheet.createRow(0);
			Cell cellA1 = headerRow.createCell(0);
			cellA1.setCellValue("DLVY_CD");
			Cell cellB1 = headerRow.createCell(1);
			cellB1.setCellValue("DLVY_END");
			workbook.write(fileOutputStream);
		}
	}

	public static void convert(String inputFilePath, String outputFilePath) throws IOException {
		Path inputPath = Paths.get(inputFilePath);
		Path outputPath = Paths.get(outputFilePath);

		try (BufferedReader reader = Files.newBufferedReader(inputPath);
				Workbook workbook = new XSSFWorkbook();
				FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {

			Sheet sheet = workbook.createSheet("New Sheet");

			String line;
			int rowNum = 0;

			Row headerRow = sheet.createRow(rowNum++);
			headerRow.createCell(0).setCellValue("DLVY_CD");
			headerRow.createCell(1).setCellValue("DLVY_END");

			while ((line = reader.readLine()) != null) {
				Row row = sheet.createRow(rowNum++);
				String[] columns = line.split("\\s*\\|\\|\\s*");

				Cell cellA = row.createCell(0);
				cellA.setCellValue(Integer.parseInt(columns[0]));

				Cell cellB = row.createCell(1);
				cellB.setCellValue(columns[1]); 
			}

			workbook.write(fileOutputStream);
		}
	}

	public void insertDataToDatabase(String excelFilePath) {
		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(excelFilePath))) {
			Sheet sheet = workbook.getSheetAt(0);
			int numberOfRows = sheet.getPhysicalNumberOfRows();

			UpTmDTO upTmDTO = new UpTmDTO();
			for (int i = 1; i < numberOfRows; i++) {
				Row row = sheet.getRow(i);

				Integer dlvyCd = (int) row.getCell(0).getNumericCellValue();
				String dlvyEndString = row.getCell(1).getStringCellValue();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime dlvyEndDateTime = LocalDateTime.parse(dlvyEndString, formatter);
				Timestamp dlvyEnd = Timestamp.valueOf(dlvyEndDateTime);

				upTmDTO.setDlvyCd(dlvyCd);
				upTmDTO.setDlvyEnd(dlvyEnd);

				deliveryInfoDAO.insertEndTm(upTmDTO);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}// class end