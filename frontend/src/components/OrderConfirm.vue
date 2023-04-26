<template>
  <div>
    <OrderConfirmSearch></OrderConfirmSearch>
    <OrderConfirmTable ref="OrderConfirmTable" @newWindow="newWindow"></OrderConfirmTable>
    <el-pagination
    background
    layout="prev, pager, next" 
    :page-count="this.totalPage" style="margin : 20px auto; text-align: center; " :current-page="this.curPage" 
    @current-change="changePage">
    </el-pagination>
     <el-dialog
      :visible.sync="dialogVisible"
      width="60%" >
      <div style="margin : 20px auto; width : 60%;text-align : center; ">
        <span style="font-family: 'Helvetica Neue',Arial,sans-serif; color : rgb(57, 57, 90); font-size: x-large; font-weight:300;">배송정보</span>
      </div>
          <el-steps :active="step" align-center style="margin-top : 40px">
            <el-step title="Step 1" description="배송 시작"></el-step>
            <el-step title="Step 2" description="배송 중"></el-step>
            <el-step title="Step 3" description="배송 완료"></el-step>
          </el-steps>
          <el-table :data ="itemList" style="margin : 0 auto; width : 70%; text-align: center; ">
            <el-table-column prop="itNm" width="400"></el-table-column>
            <el-table-column  prop="optNm"></el-table-column>
          </el-table>
          <table style="border-collapse:collapse; margin : 0 auto; width : 70%">
      
            <tr class="tr-style">
              <td class="td-key">택배사</td>
              <td class="td-value">{{ this.com }}</td>
            </tr>
            <tr class="tr-style">
              <td class="td-key">송장번호</td>
              <td class="td-value">{{ this.inv }}</td>
            </tr>
            <tr class="tr-style">
              <td class="td-key">배송지</td>
              <td class="td-value">서울 강남</td>
            </tr>
          </table>

        <!-- </el-row> -->
        
      <!-- </el-col> -->
    </el-dialog> 
    
  </div>
</template>
<script>
// import Vue from 'vue';
import axios from 'axios';
// import DeliveryState from './DeliveryState.vue';
import OrderConfirmSearch from './OrderConfirm_search.vue';
import OrderConfirmTable from './OrderConfirm_table.vue';
import eventBus from '@/common/EventBus.vue';

export default {
  components: {
    OrderConfirmSearch,
    OrderConfirmTable,
  },
  data() {
    return {
      isModalVisible: false, // 모달 보이기 여부
      deliveryData: null, // 배송 데이터
      windowRef : null,
      dialogVisible: false,
      step : 1,
      itemList : [],
      totalPage : 0,
      curPage : 1,
      startDay : '',
      endDay : '',
      itNm : '',
      com : '',
      inv : '',

    };
  },
  created: function () {
    this.daySearch();
    eventBus.$on("daySearch",this.daySearch);
    eventBus.$on("newWindow", this.newWindow);
  },
  methods: {
    daySearch: async function (startDay = "", endDay = "", itNm = "") {
      this.startDay = startDay;
      this.endDay = endDay;
      this.itNm = itNm;
      console.log(this.startDay + "//" + this.endDay);
      let url = 'http://localhost:8093/app/check/orderSearch';
      if (startDay || endDay || itNm) {
        url += `/${startDay}/${endDay}/${itNm}`;
      }
      var body = {
        curPage  : this.curPage
      }
      await axios
        .get(url,body)
        .then((response) => {
          console.log(response);
          this.$refs.OrderConfirmTable.updateTable(response.data.body);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    newWindow(item) { 
      axios.get(`http://localhost:8093/app/check/dlvyState/${item.dlvyCd}`)
      .then(
        (res)=>{
          console.log(res.data.body);
          this.deliveryData = res.data.body[0];
          this.com = this.deliveryData.com;
          this.inv = this.deliveryData.inv;
          this.dialogVisible = true;
          this.itemList = [{
            itNm : item.name, optNm : item.optNm
          }]
        }
      )
      
    },
    changePage : function(currentPage){
            console.log(currentPage);
            this.curPage = currentPage;
            this.tableData = [];
            this.ItemList();
            this.daySearch(this.startDay, this.endDay, this.itNm);
        },
 
  }
}
</script>
<style>
  td {
    padding : 4px;
  }
  .tr-style {
    border-bottom: 1px solid #EBEEF5; text-align: center; 
  }
  .td-key{
    font-weight: bold; 
    color: #909399; 
  }
  .td-value {
    color: black;
  }
</style>