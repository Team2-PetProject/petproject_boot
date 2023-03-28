package com.example.dto;

public class FileDTO {
	private int Item_Image;
	private String Image_Name;
	private String Image_Spec;
	private String Image_UpTime;
	public FileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDTO(int item_Image, String image_Name, String image_Spec, String image_UpTime) {
		super();
		Item_Image = item_Image;
		Image_Name = image_Name;
		Image_Spec = image_Spec;
		Image_UpTime = image_UpTime;
	}
	public int getItem_Image() {
		return Item_Image;
	}
	public void setItem_Image(int item_Image) {
		Item_Image = item_Image;
	}
	public String getImage_Name() {
		return Image_Name;
	}
	public void setImage_Name(String image_Name) {
		Image_Name = image_Name;
	}
	public String getImage_Spec() {
		return Image_Spec;
	}
	public void setImage_Spec(String image_Spec) {
		Image_Spec = image_Spec;
	}
	public String getImage_UpTime() {
		return Image_UpTime;
	}
	public void setImage_UpTime(String image_UpTime) {
		Image_UpTime = image_UpTime;
	}
	@Override
	public String toString() {
		return "FileDTO [Item_Image=" + Item_Image + ", Image_Name=" + Image_Name + ", Image_Spec=" + Image_Spec
				+ ", Image_UpTime=" + Image_UpTime + "]";
	}
	
}
