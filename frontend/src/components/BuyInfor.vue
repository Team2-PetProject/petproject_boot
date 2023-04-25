<template>
    <div>
      <h2 style="color : hotpink">결제정보</h2>
        <table style="border-collapse:collapse;">
          <tr class="sp">
            <td
              style="width:800px;">
              총 상품금액
            </td>
            <td style="width:600px;">{{ totalPrice[0] }}원</td>
          </tr>
          <tr class="sp">
            <td>
              배송비
            </td>
            <td>
                <p>{{ dlvy }}원</p>
            </td>
          </tr>
          <tr class="sp">
              <td>
              최종 결제금액
            </td>
              <td>{{ Ptotal }}원</td>
          </tr>
          <tr class="sp">
              <td>
              결제수단
            </td>
            <td>--</td>
          </tr>
      </table>
    </div>
  </template>
  
  <script>
  import eventBus from '@/common/EventBus.vue';
  export default {
      name:"BuyInfor",
      created:function(){
        eventBus.$on('tP', this.tPrice);
      },
      data:function (){
        return{
          totalPrice : [],
          dlvy : 0,
          Ptotal : 0
        }
      },
      // beforeMount : function(){
        
      // },
      methods:{
        tPrice:function(price){
          console.log(price);
          this.totalPrice.push(price);
          this.Pricetotal();
        },
        Pricetotal:function(){
          this.Ptotal = Number.parseInt(this.totalPrice[0]) + this.dlvy;
          // console.log( Number.parseInt(this.totalPrice[0]));
        }

      }
  }
  </script>
  
  <style>
    .sp {border-bottom: 1px solid #EBEEF5; 
              text-align: center; color: #909399;
              font-weight: bold} 
  </style>