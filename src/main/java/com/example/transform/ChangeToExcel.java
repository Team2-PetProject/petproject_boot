package com.example.transform;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ChangeToExcel {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();

		int month = today.getMonthValue();
		String monthVal = String.format("%02d", month);
		//설정에서 하이폰 빼기 가능한데 그냥 디렉토리 생성 고려해서 다 하이폰 붙임

		int day = today.getDayOfMonth();
		String dayVal = String.format("%02d", day);

		String txtPath = String.format("C:\\log\\logFile.2023-%s-%s.log", monthVal, dayVal);
//		String txtPath = String.format("C:\\log\\order_done.2023-%s-%s.log", monthVal, dayVal);
		System.out.println(txtPath);
		String excelPath = String.format("C:\\output\\delivery.2023-%s-%s.xlsx", monthVal, dayVal);
		try {
			createExcel(excelPath);
			convert(txtPath, excelPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	} // main end

	public static void createExcel(String outputFilePath) throws IOException {
		
		try (Workbook workbook = new XSSFWorkbook();
				FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
			Sheet sheet = workbook.createSheet("New Sheet");
			Row headerRow = sheet.createRow(0);
			Cell cellA1 = headerRow.createCell(0);
			cellA1.setCellValue("DLVY_CD");
			Cell cellB1 = headerRow.createCell(1);
			cellB1.setCellValue("DATE");
			workbook.write(fileOutputStream);
		}
	}

	public static void convert(String inputFilePath, String outputFilePath) throws IOException {
		Path inputPath = Paths.get(inputFilePath);
		Path outputPath = Paths.get(outputFilePath);
		

		try (BufferedReader reader = Files.newBufferedReader(inputPath);
				Workbook workbook = new XSSFWorkbook(new FileInputStream(outputFilePath));
				FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {

			Sheet sheet = workbook.getSheetAt(0);
			String line;
			int rowNum = 1;
			//rowNum 1로 변경해줘야 입력해준값 나옴
			while ((line = reader.readLine()) != null) {
				Row row = sheet.createRow(rowNum++);
				String[] columns = line.split("\t");
				int colNum = 0;

				for (String columnValue : columns) {
					Cell cell = row.createCell(colNum++);
					cell.setCellValue(columnValue);
				}
			}

			workbook.write(fileOutputStream);
		}
	}
}// class end