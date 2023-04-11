package com.example.common.dto;

import org.apache.ibatis.type.Alias;

import com.example.common.constant.ComConstant;

@Alias("PagingDTO")
public class PagingDTO {
	private Integer curPage;
	private Integer perPage;
	
	public PagingDTO() {
		this.curPage = ComConstant.DEFAULT_CURPAGE;
		this.perPage = ComConstant.DEFAULT_PERPAGE;
	}

	public Integer getCurPage() {
		if(this.curPage==null) {
			this.curPage = ComConstant.DEFAULT_CURPAGE;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		if(this.perPage==null) {
			this.perPage = ComConstant.DEFAULT_PERPAGE;
		}
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public Integer getStartIdx() {
		if(curPage==null) {
			curPage = ComConstant.DEFAULT_CURPAGE;
		}
		if(this.perPage==null) {
			this.perPage = ComConstant.DEFAULT_PERPAGE;
		}
		return (curPage-1)*perPage+1;
	}
	
	public Integer getEndIdx() {
		Integer startIdx = getStartIdx();
		return this.perPage*startIdx;
	}
	
}
