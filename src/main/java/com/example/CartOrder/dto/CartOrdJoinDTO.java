package com.example.CartOrder.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.lang.Nullable;

@Alias("CartOrdJoinDTO")
public class CartOrdJoinDTO {

   private Integer cartCd;
   private String mbId;
   private Integer itCd;
   private String itNm;
   private Integer amount;
   private Integer price;
   private Integer imgCd;
   private Integer optCd;
   private String optNm;
   public Integer getCartCd() {
      return cartCd;
   }
   public void setCartCd(Integer cartCd) {
      this.cartCd = cartCd;
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
   public String getItNm() {
      return itNm;
   }
   public void setItNm(String itNm) {
      this.itNm = itNm;
   }
   public Integer getAmount() {
      return amount;
   }
   public void setAmount(Integer amount) {
      this.amount = amount;
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
   public String getOptNm() {
      return optNm;
   }
   public void setOptNm(String optNm) {
      this.optNm = optNm;
   }
   @Override
   public String toString() {
      return "CartOrdJoinDTO [cartCd=" + cartCd + ", mbId=" + mbId + ", itCd=" + itCd + ", itNm=" + itNm + ", amount="
            + amount + ", price=" + price + ", imgCd=" + imgCd + ", optCd=" + optCd + ", optNm=" + optNm + "]";
   }
   
   
   
}