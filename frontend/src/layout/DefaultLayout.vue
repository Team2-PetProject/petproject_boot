<template>
  <div>
    <HeaderLayout></HeaderLayout>
    <div v-if="this.isMypage" class="mypage">
      <el-tabs type="card" tab-position="left" v-model="activeName" @tab-click="handleClick" class="card">
        <el-tab-pane label="회원정보 수정" :name=this.mypage></el-tab-pane>
        <el-tab-pane label="주문내역" name="/orderConfirm"></el-tab-pane>
        <el-tab-pane label="1대1 문의내역" :name=this.chat></el-tab-pane>
      </el-tabs>
      <router-view></router-view>
    </div>
    <div v-else>
      <router-view></router-view>
    </div>
    <FooterLayout></FooterLayout>
  </div>
</template>

<script>
import HeaderLayout from '@/common/HeaderLayout.vue';
import eventBus from '@/common/EventBus';
import FooterLayout from '@/common/FooterLayout.vue';
export default {
    components : {
        HeaderLayout,
        FooterLayout
    },
    created : function(){
      eventBus.$on("mypage", this.moveToMy);
    },
    data : function(){
      return {
        isMypage : false,
        activeName: '/mypage/1',
        itCd : '',
        mypage : '',
        chat : ''
      }
    },
    methods : {
      handleClick() {
        this.$router.push({path : this.activeName, props : true});
      },
      moveToMy : function(url, mbId){
        console.log(url);
        if(url==='/mypage'){
          this.isMypage = true;
          this.activeName = `/mypage/${mbId}`;
          this.mypage = `/mypage/${mbId}`;
          this.chat = `/chat/${mbId}`;
          this.$router.push(this.activeName);
        }else{
          this.isMypage = false;
          this.$router.push(url);
        }
        
      }
    }
}
</script>

<style>
.mypage{
  width : 80%;
  margin : 60px auto;
}
</style>