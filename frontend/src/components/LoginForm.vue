<template>
  <div style="margin : 0 auto; width : 60%; text-align: center;">
    <p>로그인</p>
    아이디 <input type="text" v-model="id"><br>
    비번 <input type="password" v-model="pw"><br>
    <button @click="login">로그인</button>

    <div>
    <el-link type="info" @click="$router.push('/SignUp')">회원가입</el-link>
    </div>
  </div>
</template>

<script 
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
import axios from 'axios';
import eventBus from '@/common/EventBus.vue';

export default {
  name: 'LoginForm',
  data:function(){
    return{
        id:'',
        pw:''
    }
  },//end data
  methods:{
    login:function(){
      console.log("로그인 클릭");
      axios.post(`http://localhost:8093/app/member/login`,
      {
        mbId: this.id,
        pw:this.pw
      }
      ).then(
        (res)=>{
          console.log(res);
          if(this.id==='admin'&&this.pw==='admin'){
            this.$router.push("/admin");
          }else{
            this.$router.push({
              path:'/'
              //params:{mbId:this.id}
            });
            eventBus.$emit("loginsuccess", this.id);
          }
          
          
        }
      ).catch(
        (error)=>{
          console.log("error", error);
          
        }
      )
    }
  }

}
</script>

<style>
.el-link{
    margin-right:30px;
}
</style>