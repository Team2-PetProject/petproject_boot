package com.example.dto;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("CartDTO")
@Schema(description = "장바구니")
public class CartDTO {

	@Schema(description = "장바구니 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private Integer cartCd;
	@Schema(description = "상품 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private Integer itCd;
	@Schema(description = "멤버 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private String mbId;
	@Schema(description = "수량", example="수량", required = true, minLength = 1, maxLength = 50)
	private Integer amount;
	@Schema(description = "옵션 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private Integer optCd;

	public Integer getCartCd() {
		return cartCd;
	}
	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}
	public Integer getItCd() {
		return itCd;
	}
	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getOptCd() {
		return optCd;
	}
	public void setOptCd(Integer optCd) {
		this.optCd = optCd;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartDTO [cartCd=");
		builder.append(cartCd);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", optCd=");
		builder.append(optCd);
		builder.append("]");
		return builder.toString();
	}
}
