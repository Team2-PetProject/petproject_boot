<template>
  <div>
    <div style="display:flex; align-items: flex-end; justify-content: space-between;"><!-- 가로정렬위한거-->
      <img src="@/assets/image/ex.png" @click="go('/')">
      <!-- <img src="@/assets/image/ex.png" @click="$router.push('/')"> -->
      <div style="display:flex; margin-right: 30px;">

        <el-button v-if="mbId==''" @click="go('/loginForm')" type="warning">
          로그인
        </el-button>

        <div v-if="mbId!=''">
          <el-badge :value="1" class="item" type="warning" style="margin-right: 20px;" >
            <el-button @click="moveToChat">채팅</el-button>
          </el-badge>
          <el-button @click="moveToCart" type="warning" style="margin-right: 20px;">
            장바구니
          </el-button>
          <el-dropdown>
          <el-button type="warning">
            {{ mbId }}님<i class="el-icon-arrow-down el-icon--right"></i>
          </el-button>
          <el-dropdown-menu slot="dropdown">
            <div @click="mypage"><el-dropdown-item>마이페이지</el-dropdown-item></div>
            <div @click="logout"><el-dropdown-item divided>로그아웃</el-dropdown-item></div>
          </el-dropdown-menu>
          </el-dropdown>
        </div><!-- end mbId!='' -->
      </div>
    </div><!-- 가로정렬위한거-->
    

    <!-- 이거 Navigation-Tabs로 나중에 바꿔보기... -->
    <!-- <el-menu default-active="1" class="el-menu" mode="horizontal" 
              active-text-color="#F89500" > 
      <div style="display: flex; justify-content: space-evenly;">
        <el-menu-item index="1" @click="cat('food')">식품/식기류</el-menu-item>
        <el-menu-item index="2" @click="cat('fashion')">패션</el-menu-item>
        <el-menu-item index="3" @click="cat('beauty')">미용/목욕</el-menu-item>
        <el-menu-item index="4" @click="cat('toy')">장난감</el-menu-item>
      </div>
    </el-menu> -->

    <el-tabs v-model="activeName" @tab-click="handleClick" stretch :active-class="activeTabClass">
        <el-tab-pane label="식품/식기" name="/ItemList/food/1"></el-tab-pane>
        <el-tab-pane label="패션" name="/ItemList/fashion/1" ></el-tab-pane>
        <el-tab-pane label="미용/목욕" name="/ItemList/beauty/1" ></el-tab-pane>
        <el-tab-pane label="장난감" name="/ItemList/toy/1"></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script 
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
import axios from 'axios';
import eventBus from '@/common/EventBus.vue';
import VueRouter from 'vue-router';
import ItemList from '@/components/ItemList';

export default {
  name:'HeaderLayout',
  data:function(){
    return{
      mbId:'',
      activeName : '/ItemList/food/1',
      activeTabClass: ''
    }
  },//end data
  created:function(){
    eventBus.$on("loginsuccess", this.receive);
  },
  methods:{
    handleClick(tab){
      // if(this.$router.path!==this.activeName){
        this.activeTabClass = 'tab-active';
        eventBus.$emit("mypage", this.activeName, this.mbId);
        // this.$router.push({path : this.activeName, props : true});
      // }
    },
    go: function(path){
      if(this.$route.path!==path){
        eventBus.$emit("mypage", path,this.mbId);
      }
    },
    receive:function(v1){
      this.mbId=v1;
      console.log("mbId: ", v1);
    },
    cat: function(cat){
      this.$router.push(`/ItemList/${cat}`);
      // console.log("dsssssssd");
      // const router = new VueRouter({
      //   path : "/ItemList", component : ItemList, name : "ItemList"
      // });
      // router.beforeEach((to, from, next)=>{
      //   console.log("ddd");
      //   eventBus.$emit("changeCat", cat);
      //   next();
      // })
    },
    moveToCart: function(){
      console.log("장바구니로 이동 클릭");
      eventBus.$emit("mypage", `/Cart`,this.mbId);
    },
    moveToChat : function(){
      console.log("채팅으로 이동");
      eventBus.$emit("mypage", `/chat/${this.mbId}`,this.mbId);
    },
    logout: function(){
      console.log("로그아웃 클릭");
      var url = "http://localhost:8093/app/member/check/logout";
      axios.delete(url
      ).then(
        (res) => {
          console.log("로그아웃", res);
          this.mbId='';
          eventBus.$emit("mypage", `/`,this.mbId);
        }
      ).catch(
        (error)=>{
          console.log(error);
        }
      )
    },
    mypage : function(){
      eventBus.$emit("mypage", `/mypage`, this.mbId);
    }
  }//end methods
}
</script>

<style>
 .el-dropdown {
    vertical-align: top;
  }
  .el-dropdown + .el-dropdown {
    margin-left: 15px;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
  /* .el-tabs__item-active {
    color : red !important;
  } */
  .tab-active {
    color : blueviolet
  }
</style>