package com.example.dto;

import java.util.Arrays;

import org.apache.ibatis.type.Alias;

@Alias("ImageDTO")
public class ImageDTO {
	private int id;
	private String mimeType;
	private String originalName;
	private byte[] data;
	private String created;
	public ImageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImageDTO(int id, String mimeType, String original_name, byte[] data, String created) {
		super();
		this.id = id;
		this.mimeType = mimeType;
		this.originalName = original_name;
		this.data = data;
		this.created = created;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getOriginal_name() {
		return originalName;
	}
	public void setOriginal_name(String original_name) {
		this.originalName = original_name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "ImageDTO [id=" + id + ", mimeType=" + mimeType + ", original_name=" + originalName + ", data="
				+ Arrays.toString(data) + ", created=" + created + "]";
	}
	
}
