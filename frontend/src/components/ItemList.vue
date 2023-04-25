<template>
  <div>
    <div class="container">
      <!-- 화면 중앙에 위치한 요소 -->
      <div class="centered">

        <el-row :gutter="20" >   <!-- gutter :카드간의 간격 -->
            <el-col :span="6" v-for="(item, idx) in itemList" :key="idx"  style="margin-bottom: 20px; ">
                <div class="grid-content bg-purple"  @click="itemRetrive(item.itCd)">
                    <el-card :body-style="{ padding: '0px' }">
                        <img :src='`http://localhost:8093/app/api/file/view/${item.imgCd}`'  class="image">
                        <div style="padding: 14px;">
                            
                            <div class="bottom clearfix">
                              <div style="margin-bottom : 3px;height:50px;">{{item.itNm}}</div>
                              <time class="time">{{ item.price | currency }}</time>
                            </div>
                        </div>
                    </el-card>
                </div>
            </el-col>
        </el-row>
        <br>
        <br>

        <div class="block">
          <el-pagination
            :page-size="16"
            :pager-count="5"
            layout="prev, pager, next"
            :page-count="this.totalPage"
            @current-change="handlePageChange"
            >
          </el-pagination>
        </div>
      </div>
    </div> 
  </div>
</template>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
import axios from 'axios';
import eventBus from '@/common/EventBus.vue';
export default {
  props : {
    cat : {
      type : String, default : "food"
    },
    curPage : {
      type : String, default : '1'
    }
  },
    data() {
      return {
        // cat : 'food',
        itemList:[],
        currentPg:1,
        totalPage:0
      };
    },
    beforeMount:function(){
      this.getitemList();
    },
    methods:{
      // changeCat : function(cat){
      //   console.log("dddddddddddddddd");
      //   this.cat = cat;
      //   this.getitemList();
      // },
      itemRetrive : function(itCd){
        this.$router.push({path : `/itemRetrieve/${itCd}`, props : true});
      },
      getitemList(){
        console.log("addaaaaaaa");
        this.itemList = [];
        var list = this.itemList;
        
        axios.get(`http://localhost:8093/app/item/itemList/${this.cat}/`+this.currentPg)   //주소 처리 해야함!!!!!
        .then(
          (res)=>{
            console.log(res);
            console.log(res.data.body.list);
            res.data.body.list.map(function(ele,idx){
              list.push(ele);
            });
            console.log(list.length);
            var total = res.data.body.list.length;
            if(total <16){
              this.totalPage = res.data.body.totalPage
            }else{
            this.totalPage = res.data.body.totalPage + 1;
            }
            console.log("totalPage>>>>>>"+this.totalPage);
          }
        ).
        catch(
          (error) => {console.log(error);}
        )
      },
      handlePageChange(currentPage){
        //console.log("현재페이지>>>>"+this.currentPg)
        // console.log(currentPage);
         this.currentPg = currentPage;
         console.log("this.currentPg>>>>>"+this.currentPg);
         this.itemList =[];
         this.getitemList();
      }
    },
    watch : {
      cat(){
        this.getitemList();
      }
    }

}//end export default
</script>

<style>

.container {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px; 
}


.centered {
  max-width: 1000px; 
  text-align: center; 
}


  /* 카드 스타일 */
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 18px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    height: 250px;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>