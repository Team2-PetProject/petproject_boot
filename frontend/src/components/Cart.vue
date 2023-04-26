<template>
  <div style="margin : 0 auto; width : 90%">
    <h1>장바구니</h1>
<!-- {{ receiveData }} -->

    <table style="border-collapse:collapse; width : 100%">
      <tr style="border-bottom: 1px solid #EBEEF5; text-align: center; color: #909399; font-weight: bold;">
        <td>
          <input type="checkbox" v-model="allChecked" @click="checkedAll($event.target.checked)" />
        </td>
        <td colspan="2">상품정보</td>
        <td>판매가</td>
        <td>수량</td>
        <td>주문금액</td>
        <td></td>
      </tr>
      <tr v-for="(data, index) in receiveData" :key="index" style="color:#606266; border-bottom: 1px solid #EBEEF5;">
        <td>
          <input type="checkbox" v-model="data.chk" @change="checked($event)">
        </td>               
        <td><img :src='`http://localhost:8093/app/api/file/view/${data.imgCd}`' style="width:100px; height:100px"></td>
        <td>
          {{data.itNm}}&nbsp;
          <div v-if="data.optNm!=null">
            <span>옵션 | </span>
            <el-select v-model="data.optNm" size="mini" @change="specUpdate($event, data.cartCd)">
              <el-option
                v-for="(opt, index) in data.optCds" :key="index+11" 
                :label="opt.optNm"
                :value="opt.optCd">
              </el-option>
            </el-select>
          </div>
        </td>
        <td>{{ data.price }}</td>
        <td><el-input-number v-model="data.amount" @change="amtUpdate($event, data.cartCd)" :min="1" :max="10" size="small"></el-input-number></td>
        <td>{{ data.price * data.amount }}</td>
        <td>
          <!-- <el-button type="warning" size="mini" plain style="width:80px">바로구매</el-button><br> -->
          <el-button icon="el-icon-close" type="default" size="mini" @click="del(data.cartCd)">삭제</el-button><br>
        </td>
      </tr>
    </table>
    <el-button plain size="small" @click="delAll">선택상품 삭제</el-button>
    <el-button plain size="small" @click="delAll">전체상품 삭제</el-button>
<br>
<br>
<br>
    <table style="border-collapse:collapse; text-align: center;width : 80%">
      <tr style="color: #909399; font-weight: bold;">
        <td>총 주문금액</td>
        <td rowspan="2">+</td>
        <td>배송비</td>
        <td rowspan="2">=</td>
        <td>총 결제금액</td>
      </tr>
      <tr style="color: #909399; font-weight: bold;">
        <td><span style="font-size: 30px;">{{ sum }}</span>원</td>
        <td><span style="font-size: 30px;">{{ deliveryFee }}</span>원</td>
        <td><span style="font-size: 30px;">{{ totalPrice }}</span>원</td>
      </tr>
      <tr>
        <td colspan="5" style="text-align: end;">배송비 3,000원<br>50,000원 이상 구매시 무료</td>
      </tr>
    </table>
    
    <el-button @click="order">선택주문</el-button>
    <el-button type="warning" @click="order">전체주문</el-button>
    <br>
<br>
<br>

    
    
  </div>
</template>

<script 
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
import axios from 'axios';
import eventBus from '@/common/EventBus.vue';

export default {
    name:'Cart',
    created:function(){
      this.loadCartList();
    }, //end created
    data:function(){
      return{
        receiveData:[],
        allChecked: true,
        sum:0,
        // deliveryFee: 0,
        // totalPrice:0
      }
    }, //end data
    methods:{
      loadCartList:function(){
        axios.get(`http://localhost:8093/app/check/cartList`
        ).then(
        (res)=>{

          console.log("+++++++++++++++++++++++++++++++++", res.data);

        for (let index = 0; index < res.data.length; index++) {
          if(res.data[index].amount!=0){
            this.receiveData.push(res.data[index]);
          }        
        }
        console.log("수량 0빼고 push한 결과==========",this.receiveData);
        for (let i = 0; i < this.receiveData.length; i++) {
            this.receiveData[i].chk= true;
            this.sum = this.sum + (this.receiveData[i].amount * this.receiveData[i].price);
          }
          
        }
        ).catch(
          (error)=>{
            console.log("error", error);
          }
        );
        console.log(this.receiveData);
      }, //end 카트리스트 불러오기
      amtUpdate(amt, cartCd) {
        this.receiveData.amount = amt;
        console.log("amount", this.receiveData.amount);
        console.log("cartCd >>>", cartCd);
        var url = `http://localhost:8093/app/check/specUpdate/${cartCd}/amt/${amt}`;
        axios.put(url,
        {
          cartCd: cartCd,
          amount: amt
        }
        ).then(
          (res)=>{
            //console.log("수량변경 res ============", res);
            this.sumfn();
          }
        ).catch(
          (error)=>{
            console.log(error);
          }
        )
      }, //end 수량변경
      checkedAll(v) {
        this.allChecked = v;
        for (let i = 0; i < this.receiveData.length; i++) {
          this.receiveData[i].chk= this.allChecked;
        }
        this.sumfn();
      }, //end 전체선택
      checked(e) {
        console.log("checked===========================");
        this.sumfn();
        for(let i = 0; i< this.receiveData.length; i++){
          if(! this.receiveData[i].chk){
            this.allChecked = false;
            //this.sumfn();
            return;
          }else{
            this.allChecked = true;
          }
        }
        
      }, //end 개별 선택
      specUpdate:function(optCd, cartCd){
        //console.log("옵션변경");
        //console.log("...........", event, cartCd);
        var url = `http://localhost:8093/app/check/specUpdate/${cartCd}/option/${optCd}`;
        axios.put(url, {
          cartCd: cartCd,
          optCd: optCd
        }
        ).then(
          (res)=>{
            //console.log("옵션 변경 res================= ",res);
          }
        ).catch(
          (error)=>{
            console.log(error);
          }
        )
      }, //end 옵션변경
      del: function(cartCd){
        //console.log("개별 삭제 cartCd ============= ", cartCd);
        var url = `http://localhost:8093/app/check/cartDelete/${cartCd}`;
        axios.delete(url, {
          cartCd: cartCd
        }
        ).then(
          (res)=>{
            console.log(res);
            this.receiveData=[];
            this.loadCartList();
          }
        ).catch(
          (error)=>{
            console.log(error);
          }
        )
      },//end 개별삭제
      delAll:function(){
        //console.log("여러개 삭제 클릭 ============");
        
        var cartCdArr = [];
        for (let i = 0; i < this.receiveData.length; i++) {
          if(this.receiveData[i].chk===true){
            cartCdArr.push(Number.parseInt(this.receiveData[i].cartCd));
          }
          //console.log("================", cartCdArr);
        }
        const searchParam = {
          cartCd: cartCdArr.join(",")
        }
        //console.log("************** ", searchParam);
        
        var url = 'http://localhost:8093/app/check/checkDelete';
        
        axios.delete(url,
        {
          params: searchParam
        }
        ).then(
          (res)=> {
            console.log(res);
            this.receiveData=[];
            this.loadCartList();
          }
        ).catch(
          (error)=>{
            console.log(error);
          }
        )
      },//end 여러개 삭제
      order: function(){
        //router.push로 주문페이지로 넘어간 후 아래 코드는 created부분에서 해주기
        var cartCdArr = [];
        for (let i = 0; i < this.receiveData.length; i++) {
          if(this.receiveData[i].chk===true){
            cartCdArr.push(Number.parseInt(this.receiveData[i].cartCd));
          }
        }
        var cartString = cartCdArr.join(",");
        this.$router.push(`/CartPay/${cartString}`);
      },
      sumfn: function(){
          var priceSum = 0;
          console.log("rrrrr", this.receiveData);
          for(let i=0; i<this.receiveData.length; i++){
            if(this.receiveData[i].chk==true){
              console.log("//////////////////", this.receiveData[i].price);
              priceSum = priceSum + (this.receiveData[i].amount * this.receiveData[i].price);
            }
          }
          this.sum = priceSum;
        },
      },//end methods
      computed:{
        deliveryFee: function(){
          if(this.sum>=50000 || this.sum ==0){
            return 0;
          }
          return 3000;
        },
        totalPrice: function(){
          return this.sum+this.deliveryFee;
        }
      }//end computed
    }
    
</script>

<style>
td{
  padding-left:30px;
  padding-right:30px;
}
</style>