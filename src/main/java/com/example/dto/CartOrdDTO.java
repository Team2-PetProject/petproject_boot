package com.example.dto;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;

@Alias("CartOrdDTO")
@Schema(description = "주문상품 정보")
public class CartOrdDTO {
	@Schema(description = "장바구니 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private Integer cartCd;
	@Schema(description = "고객 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private Integer OrdCd;
	@Schema(description = "멤버 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private String mbId;
	@Schema(description = "상품 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private Integer itCd;
	@Schema(description = "수량", example="1", required = true, minLength = 1, maxLength = 50)
	private Integer amount;
	@Schema(description = "카테고리", example="카테고리", required = true, minLength = 1, maxLength = 50)
	private String cat;
	@Schema(description = "가격", example="0", required = true, minLength = 1, maxLength = 50)
	private Integer price;
	@Schema(description = "이미지 번호", example="번호", required = true, minLength = 1, maxLength = 50)
	private Integer imgCd;
	@Schema(description = "옵션 번호", example="번호", required = false, minLength = 1, maxLength = 50)
	private Integer optCd;
	public Integer getCartCd() {
		return cartCd;
	}
	public void setCartCd(Integer cartCd) {
		this.cartCd = cartCd;
	}
	public Integer getOrdCd() {
		return OrdCd;
	}
	public void setOrdCd(Integer ordCd) {
		OrdCd = ordCd;
	}
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public Integer getItCd() {
		return itCd;
	}
	public void setItCd(Integer itCd) {
		this.itCd = itCd;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getImgCd() {
		return imgCd;
	}
	public void setImgCd(Integer imgCd) {
		this.imgCd = imgCd;
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
		builder.append("CartOrdDTO [cartCd=");
		builder.append(cartCd);
		builder.append(", OrdCd=");
		builder.append(OrdCd);
		builder.append(", mbId=");
		builder.append(mbId);
		builder.append(", itCd=");
		builder.append(itCd);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", cat=");
		builder.append(cat);
		builder.append(", price=");
		builder.append(price);
		builder.append(", imgCd=");
		builder.append(imgCd);
		builder.append(", optCd=");
		builder.append(optCd);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
