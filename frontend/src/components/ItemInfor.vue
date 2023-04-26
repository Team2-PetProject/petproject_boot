<template>
  <div>
    <h2 style="color : hotpink">상품정보</h2>
    <!-- <table border="1">
        <tr>
            <td width="300">상품명</td>
            <td width="150">판매가</td>
            <td width="150">수량</td>
            <td width="150">합계</td>
        </tr>
        <tr v-for="(itNm, idx) in itemList" v-bind:key="idx">
            <td>{{ itNm.name }}</td>
            <td>{{ itNm.price }}원</td>
            <td>{{ itNm.amount }}</td>
            <td>{{ itNm.total }}원</td>
        </tr>
        <tr>
            <td>총 결제금액</td>
            <td>-</td>
            <td>-</td>
            <td>{{ totalP }}원</td>
        </tr>
    </table> -->
    <!-- <button v-on:click="xx">테스트</button> -->
    <el-table
    :data="itemList"
    height="300"
    max-height="400"
    border
    :summary-method="getSummaries"
    show-summary
    style="width: 100%
    overflow-y : auto">
    <el-table-column
      prop="name"
      label="상품명"
      width="400">
    </el-table-column>
    <el-table-column
      prop="price"
      label="판매가"
      width="150">
    </el-table-column>
    <el-table-column
      prop="amount"
      label="수량"
      width="150">
    </el-table-column>
    <el-table-column
      prop="total"
      label="합계">
    </el-table-column>
  </el-table>
  </div>
  
</template>

<script>
import eventBus from '@/common/EventBus.vue';
import axios from 'axios';
export default {
    name:'ItemInfor',
    props:{

    },
    mounted : function(){
        this.xx()
    },
    data: function(){
        return {
            // itNm : ["aaa", "bbb", "ccc"],
            // price : ["100", "232", "322"],
            // amount : ["1", "4", "2"],
            // total : ""
            itemList : [
                {name : "aaa", price : 100, amount :1, total : 0},
                {name : "bbb", price : 232, amount :4, total : 0},
                {name : "ccc", price : 322, amount :2, total : 0},
                {name : "ddd", price : 122, amount :3, total : 0},
                {name : "eee", price : 323, amount :1, total : 0},
                {name : "fff", price : 511, amount :6, total : 0},
                {name : "ggg", price : 232, amount :2, total : 0}
            ],
            totalP : 0,
        };
    },
    beforeMount : function(){
        this.total();
        this.List();
    },
    methods :{
        getSummaries(param) {
        const { columns, data } = param;
        const sums = [];
        columns.forEach((column, index) => {
          if (index === 0) {
            sums[index] = '총 상품금액';
            return;
          }
          const values = data.map(item => Number(item[column.property]));
          if (!values.every(value => isNaN(value))) {
            sums[index] =values.reduce((prev, curr) => {
              const value = Number(curr);
              if (!isNaN(value)) {
                console.log(prev);
                return prev + curr;
              } else {
                return prev;
              }
            }, 0)+'원';
          } else {
            sums[index] = 'N/A';
          }
          sums[1] = '';
          sums[2] = '';
        });

        return sums;
      },
        List:function(){
            axios
            .post("http://localhost:8093/app/check/orderDone", {})
            .then((res) => {
                console.log(res);
                res.data.map(function(ele, idx){
                    xxx.push(ele);
                });
            })
            .catch((error) => console.log(error));
        },
        total:function(){
            console.log(this.totalP);
            var totalPrice =0;
            // var totalPrice = this.totalP;
            this.itemList.map(function(ele,idx){
                ele.total = ele.price * ele.amount;
                // this.totalP += ele.total
                totalPrice += ele.total;
            })
            console.log(totalPrice);
            this.totalP = totalPrice;
            // eventBus.$emit("tP");
            // return itemList.price * itemListamount;
        },
        xx:function(){
            eventBus.$emit("tP",this.totalP);
        }
    }
    
}
</script>

<style>
    
</style>