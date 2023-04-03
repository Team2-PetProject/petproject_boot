package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("SequenceDTO")
public class SequenceDTO {
	private int itemListCode;
	private int itemImage;
	public int getItemListCode() {
		return itemListCode;
	}
	public void setItemListCode(int itemListCode) {
		this.itemListCode = itemListCode;
	}
	public int getItemImage() {
		return itemImage;
	}
	public void setItemImage(int itemImage) {
		this.itemImage = itemImage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SequenceDTO [itemListCode=");
		builder.append(itemListCode);
		builder.append(", itemImage=");
		builder.append(itemImage);
		builder.append("]");
		return builder.toString();
	}
	
}
