package com.example.dto;

import org.apache.ibatis.type.Alias;

@Alias("RegisterInfoDTO")
public class RegisterInfoDTO {
	private ItemDTO itemDTO;
	private OptionDTO optionDTO;
	private OptionTypeDTO itemOptionDTO;
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public OptionDTO getOptionDTO() {
		return optionDTO;
	}
	public void setOptionDTO(OptionDTO optionDTO) {
		this.optionDTO = optionDTO;
	}
	public OptionTypeDTO getItemOptionDTO() {
		return itemOptionDTO;
	}
	public void setItemOptionDTO(OptionTypeDTO itemOptionDTO) {
		this.itemOptionDTO = itemOptionDTO;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterInfoDTO [itemDTO=");
		builder.append(itemDTO);
		builder.append(", optionDTO=");
		builder.append(optionDTO);
		builder.append(", itemOptionDTO=");
		builder.append(itemOptionDTO);
		builder.append("]");
		return builder.toString();
	}
	
	
}
