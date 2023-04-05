package com.example.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("ItemRetrieveDTO")
public class ItemRetrieveDTO {
	private ItemDTO itemDTO;
	private String optionName;
	private List<String> option;
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public List<String> getOption() {
		return option;
	}
	public void setOption(List<String> option) {
		this.option = option;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemRetrieveDTO [itemDTO=");
		builder.append(itemDTO);
		builder.append(", optionName=");
		builder.append(optionName);
		builder.append(", option=");
		builder.append(option);
		builder.append("]");
		return builder.toString();
	}
	
	
}
