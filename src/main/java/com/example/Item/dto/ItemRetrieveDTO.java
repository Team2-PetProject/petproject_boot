package com.example.Item.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("ItemRetrieveDTO")
public class ItemRetrieveDTO {

	private ItemDTO itemDTO;
	private String optionName;
	private List<OptionCdNmDTO> optionCdList;
	private Integer itInfoCd;
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
	public List<OptionCdNmDTO> getOptionCdList() {
		return optionCdList;
	}
	public void setOptionCdList(List<OptionCdNmDTO> optionCdList) {
		this.optionCdList = optionCdList;
	}
	public Integer getItInfoCd() {
		return itInfoCd;
	}
	public void setItInfoCd(Integer itInfoCd) {
		this.itInfoCd = itInfoCd;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemRetrieveDTO [itemDTO=");
		builder.append(itemDTO);
		builder.append(", optionName=");
		builder.append(optionName);
		builder.append(", optionCdList=");
		builder.append(optionCdList);
		builder.append(", itInfoCd=");
		builder.append(itInfoCd);
		builder.append("]");
		return builder.toString();
	}
	
	

}