package com.example.CartOrder.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("OrderSearchDTO")
public class OrderSearchDTO {
	private List<OrderSearchListDTO> list;
	private String mbId;
	private Integer startIdx;
	private Integer endIdx;
	private String startDay;
	private String endDay;
	private Integer perPage = 12;
	private Integer curPage;
	private Integer totalPage;
	public List<OrderSearchListDTO> getList() {
		return list;
	}
	public String getMbId() {
		return mbId;
	}
	public Integer getStartIdx() {
		return startIdx;
	}
	public Integer getEndIdx() {
		return endIdx;
	}
	public String getStartDay() {
		return startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public Integer getPerPage() {
		return perPage;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setList(List<OrderSearchListDTO> list) {
		this.list = list;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public void setStartIdx(Integer startIdx) {
		this.startIdx = startIdx;
	}
	public void setEndIdx(Integer endIdx) {
		this.endIdx = endIdx;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderSearchDTO [list=");
		builder.append(list);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", startIdx=");
		builder.append(startIdx);
		builder.append(", endIdx=");
		builder.append(endIdx);
		builder.append(", startDay=");
		builder.append(startDay);
		builder.append(", endDay=");
		builder.append(endDay);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append(", curPage=");
		builder.append(curPage);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append("]");
		return builder.toString();
	}


	}