<template>
  <div>
    <el-row  class="row-bg">
      <el-col :span="2">&nbsp;</el-col>
      <el-col :span="10" style="text-align: center; margin-top:30px;vertical-align: middle; ">
        <img :src="this.imgUrl" width="400" height="400" >
      </el-col>
      <el-col :span="10" style="margin : 30px auto;">
        <el-row style="margin-left: 50px;">
          <el-row type="flex">
            <el-col >
              <div class="grid-content">
                <el-tag type="warning">{{this.item.cat}}</el-tag><br/>
                <span style="font-size : 30px;font-weight: bold; font-family : Impact, Haettenschweiler,'Arial Narrow Bold', sans-serif;">{{ this.item.name }}</span>
                <div class="grid-content price">{{this.item.price}}원</div>
              </div>
            </el-col>
          </el-row>
        </el-row>
        <el-row  justify="space-around" type="flex" style="margin-top: 80px;" v-if="this.isOption">
          <el-col :span="6" class="row-center bg-purple "><div class="label">옵션</div></el-col>
          <el-col :span="10">
            <div class="grid-content ">
              <el-select size="small" v-model="optionValue" prop="optionValue" :placeholder="this.item.type" @change="handleChange">
                <el-option
                  v-for="item in this.item.option"
                  :key="item.optCd"
                  :label="item.optNm"
                  :value="item.optCd">
                </el-option>
              </el-select>
            </div>
          </el-col>
        </el-row>
        <el-row  justify="space-around" type="flex">
          <el-col :span="6"  class="row-center bg-purple "><div class="label">수량</div></el-col>
          <el-col :span="10"><div class="grid-content ">
            <el-input-number v-model="num" @change="handleChange" :min="1" size="small" ></el-input-number>
          </div></el-col>
        </el-row>
        <el-row  justify="space-around" type="flex">
          <el-col :span="6"  class="row-center bg-purple "><div class="label">총 금액</div></el-col>
          <el-col :span="10"><div class="grid-content ">
            <el-input v-model="item.totalPrice" style="text-align: right;"></el-input> 
          </div></el-col>
        </el-row>
        <el-row style="text-align: center; margin : 50px auto;" justify="space-around" type="flex">
          <el-col :span="2">&nbsp;</el-col>
          <el-col :span="10">
            <el-button @click="cartAdd('form')" size="small" class="buy-button">장바구니</el-button>
          </el-col>
          <el-col :span="2">&nbsp;</el-col>
          <el-col :span="10">
            <el-button @click="fastOrderConfirm" size="small" class="buy-button">바로 구매</el-button>
          </el-col>
          <el-col :span="2">&nbsp;</el-col>
        </el-row>
      </el-col>
      <el-col :span="2">&nbsp;</el-col>
    </el-row>
    <div class="detail-image">
      <el-image :src="this.dImgUrl"></el-image>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
components :{
},
props : {
        id : String
    },
data(){
  return{
    item : {},
    optionValue: '',
    num: 1,
    // totalPrice : this.num*this.item.price,
    isValid:true,
    itCd : 0,
    imgCd : 0,
    imgUrl : "",
    isOption : true,
    dImgUrl : ""
  }
},
created : function(){
  console.log("dd");
  this.itemRetrieve();
  
},
methods : {
  handleChange(value) {
        this.item.totalPrice = value*this.item.price;
      },
  itemRetrieve : async function (){
    // await axios.get(`http://localhost:8093/app/item/itemRetrieve/${itCd}`)
    await axios.get(`http://localhost:8093/app/item/itemRetrieve/${this.id}`)
  .then((res)=>{
      console.log( res);
      var itemDTO = res.data.body.itemDTO;
      this.item = {
        itCd : itemDTO.itCd,
        name : itemDTO.itNm,
        price : itemDTO.price,
        cat : itemDTO.cat,
        type : res.data.body.optionName,
        option : res.data.body.optionCdList,
        itInfoCd : res.data.body.itInfoCd,
        totalPrice : itemDTO.price,
        imgCd : itemDTO.imgCd,
        itInfoCd : res.data.body.itInfoCd
      }
      if(itemDTO.optCd ==null){
        this.isOption=false;
      }else{
        this.isOption = true;
      }
      this.imgUrl = `http://localhost:8093/app/api/file/view/` + this.item.imgCd;
      this.dImgUrl = `http://localhost:8093/app/api/file/detailView/${this.item.itInfoCd}`; 
    })
    .catch((e)=>{
      console.log(e);
    })

}, //end itemRetrieve
cartAdd : async function(){
  if(this.optionValue===''&&this.isOption){
    this.$message.error('옵션값을 선택해주세요.');
    return false;
  }
  var body = {
    itCd: this.item.itCd,
    optCd: this.optionValue,
    amount: this.num
  }
  await axios
  .post('http://localhost:8093/app/check/cartAdd',body)
  .then(response => {
    console.log(response);
    this.num = 1;
    this.$message({
          message: '해당 상품이 장바구니에 추가되었습니다.',
          type: 'warning'
        });
  })
  .catch(e =>{
    console.log(e)
  });
}, //cartAdd
favoriteAdd : async function(item){
  await axios
  .post(`http://localhost:8093/app/check/favorite/`+item.itemDTO.itCd,{
    itCd: item.itemDTO.itCd,
  })
  .then(response => {
    console.log(response);
    this.num = 1;
  })
  .catch(e =>{
    console.log(e)
  });
}, //
fastOrderConfirm : async function(){
  if(this.optionValue===''&&this.isOption==true){
      this.$message.error('옵션값을 선택해주세요.');
      return false;
    }
    //////////////////////// 바로구매 화면으로 연결
    // this.$router.push({path : `/itemRetrieve/${this.item.itCd}/${this.num}/${this.optionValue}`, props : true});
    ////////////////////////
    this.$router.push(`/ItemPay/${this.item.itCd}/${this.num}/${this.optionValue}`);
  }, 
},
}

</script>

<style>
  .el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple {
    background: #eaeaea;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    /* min-height: 36px; */
  }
  .row-bg {
    padding: 10px 0;
    background-color: #ffffff;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    width : 80%;
    margin : 20px auto;
  }
  .buy-button {
    width : 200px
  }
  .label {
    text-align: center;
  }
  .price {
    margin-top : 10px;
    font-size: large;
  }
  .row-center {
    display: flex; flex-direction: column; justify-content: center; align-items: center;
  }
  .detail-image {
    width : 60%;
    margin : 30px auto;
    text-align: center;
  }
</style>