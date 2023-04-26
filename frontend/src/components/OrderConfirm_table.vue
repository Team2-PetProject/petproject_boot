<template>
  <div>

    <div style="margin : 40px auto; width : 60%;text-align : center; ">
        <span style="font-family: 'Helvetica Neue',Arial,sans-serif; color : rgb(57, 57, 90); font-size: x-large; font-weight:300;">주문내역</span>
      </div>
    <table  style=" border-collapse:collapse; text-align: center; margin : 0 auto; width:90%">
      <tr style="border-bottom: 1px solid #EBEEF5; text-align: center; color: #909399; font-weight: bold;">
        <td>주문번호</td>
        <td>주문상품 정보</td>
        <td>상품금액</td>
        <td>배송조회</td>
      </tr>
      <template v-for="(data) in tableData">     
        <tr v-for="(item,idx) in data.data" :key="item.itCd" style="color:#606266; border-bottom: 1px solid #EBEEF5;">
          <td v-if="idx===0" :rowspan="data.data.length">
            {{ data.ordCd }}
          </td>
          <td>
            <el-image
            style="width: 100px; height: 100px"
            :src="`http://localhost:8093/app/api/file/view/${item.imgCd}`"
            fit="fill"></el-image><br/>
            상품 : <span>{{ item.name }}</span><br/>
            <div v-if="item.optNm">
              옵션 : <span>{{ item.optNm }}</span>
            </div>
          </td>
          <td>
            {{ item.price }} 
          </td>
          <td>
              <el-button @click="$emit('newWindow', item)" size="small">배송조회</el-button>
          </td>
        </tr>
      </template>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      totalCount : 0,
      trIndex : 1
    };
  },
  methods: {
    updateTable(newData) {
      this.tableData=[];
      this.totalCount = newData.length;
      var list = [];
      this.orders = newData;
      this.orders.map(function(ele,idx){
        var totalPrice = ele.amount*ele.price;
        console.log("//////////////" + ele.itNm);
        list.push({
            date : ele.payTm,
            name : ele.itNm,
            imgCd : ele.imgCd,
            optNm : ele.optNm,
            amount : ele.amount,
            price : ele.price,
            totalPrice : totalPrice,
            dlvyCd : ele.dlvyCd,
            ordCd :ele.ordCd
          });
        
      });
      
      list.sort((a,b)=>{
          return a.ordCd-b.ordCd
      });
      
      var sortList = this.tableData;
      list.map((ele, idx)=>{
        if(idx===0){
          sortList.push({
            ordCd : ele.ordCd,
            data : [ele]
          });
        }else{
          if(ele.ordCd===list.at(idx-1).ordCd){
            var index = sortList.length-1;
            sortList.at(index).data.push(ele);
          }else{
            sortList.push({
              ordCd : ele.ordCd,
              data : [ele]
            })
          }
        }
        
      });

      

    },
  },
};
</script>
<style></style>