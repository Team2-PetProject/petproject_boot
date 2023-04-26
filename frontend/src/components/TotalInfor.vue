<template>
  <div>
    <ItemInfor/>
    <BuyInfor />
   <BoxInfor /><br>
   <el-button type="warning" plain v-on:click="orderList">구매내역</el-button>
   <el-button type="warning" plain v-on:click="shop">쇼핑 계속하기</el-button>
  </div>
</template>

<script>
import ItemInfor from '@/components/ItemInfor.vue';
import BuyInfor from '@/components/BuyInfor.vue';
import BoxInfor from '@/components/BoxInfor.vue';
import eventBus from '@/common/EventBus.vue';
export default {
    name:'OrderDone',
    props : {
      formData : Object,
      list : Array
    },
    components:{
      ItemInfor,
      BuyInfor,
      BoxInfor
    },
    mounted : function(){
      this.cartPay();
    },
    methods:{
      cartPay : function(){
        console.log("-----------------------")
        console.log(this.formData);
        console.log(this.list);
      },
      orderList:function(){
        console.log("orderList 함수 호출");
        eventBus.$emit("mypage", `/orderConfirm`,this.mbId);
      },
      shop:function(){
        console.log("shop 함수 호출")
      }
    }
}
</script>

<style>

</style>