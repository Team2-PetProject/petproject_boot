<template>
  <div>
    <h1 style="color:rgb(57, 57, 90);">관리자 페이지</h1>
    <el-button @click="moveToHome('/')">홈페이지로 이동</el-button>
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="상품 관리" name="/admin" type="warning">
      </el-tab-pane>
      <el-tab-pane label="상품 등록" name="/register" type="warning">
      </el-tab-pane>
      <el-tab-pane label="문의 내역" name="/adminChat">
      </el-tab-pane>
    </el-tabs>
    <router-view></router-view> 
  </div>
</template>

<script>
import eventBus from '@/common/EventBus.vue';
export default {
    data() {
      return {
        activeName: '/admin',
      };
    },
    created:function(){
      eventBus.$on("moveToAdmin", this.moveToHome);
    },
    methods: {
      handleClick() {
        if(this.$router.path!==this.activeName){
            this.$router.push({path : this.activeName, props : true});
        }
      },
      moveToHome : function(url){
        this.$router.push(url);
      }
    }
}
</script>

<style>

</style>