package com.example.Item.dto;

public class ItemListDTO {

	private String cat;
	private Integer startIdx;
	private Integer endIdx;
	
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public Integer getStartIdx() {
		return startIdx;
	}
	public void setStartIdx(Integer startIdx) {
		this.startIdx = startIdx;
	}
	public Integer getEndIdx() {
		return endIdx;
	}
	public void setEndIdx(Integer endIdx) {
		this.endIdx = endIdx;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemListDTO [cat=");
		builder.append(cat);
		builder.append(", startIdx=");
		builder.append(startIdx);
		builder.append(", endIdx=");
		builder.append(endIdx);
		builder.append("]");
		return builder.toString();
	}


}