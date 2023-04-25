<template>
    <div>
      <h2 style="color : hotpink">배송정보</h2>
      <table style="border-collapse:collapse;">
          <tr class="sp">
            <td style="width:600px;">
              받는 분
            </td>
            <td style="width:800px;"></td>
          </tr>
          <tr class="sp">
            <td>
              연락처
            </td>
              <td></td>

          </tr>
          <tr class="sp">
            <td>
              주소
            </td>
              <td></td>
          </tr>
      </table>
    </div>
  </template>
  
  <script>
  import eventBus from '@/common/EventBus.vue';
  export default {
      name:"BoxInfor",
      props:{
  
      },
      data: function(){
          return {};
      },
      methods:{
          add:function(){
              console.log("호출");
              eventBus.$emit("", ); //이벤트 전달명
          }
      }
  }
  </script>
  
  <style>
  .sp {border-bottom: 1px solid #EBEEF5; 
              text-align: center; color: #909399;
              font-weight: bold} 
  </style>