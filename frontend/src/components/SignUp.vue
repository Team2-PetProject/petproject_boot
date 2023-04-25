<template>
  <div>
    <el-col :span="8">
    <el-form ref="MemberDTO" v-model="MemberDTO" label-width="120px">
        <el-form-item label="아이디">
            <el-col :span="12" style="margin-right:20px;">
                <el-input v-model="MemberDTO.mbId"></el-input>
            </el-col>
            <el-col :span="4">
                <el-button @click="idCk">중복확인</el-button>
            </el-col>
            <el-col>
            <span>{{ this.idCkmsg }}</span>
        </el-col>
        </el-form-item>
        
        <el-form-item label="비밀번호">
            <el-input type="password" v-model="MemberDTO.pw"></el-input>
        </el-form-item>
        
        <el-form-item label="비밀번호 확인">
            <el-input type="password" v-model="passwdCk"></el-input>
            <el-button size="small" @click="passwdCheck">확인</el-button>
            <span>{{ passwdCkmsg }}</span>
        </el-form-item>

        <el-form-item label="이름">
            <el-input type="text" v-model="MemberDTO.nm"></el-input>
        </el-form-item>

        <el-form-item label="주소">
            <el-col :span="12" style="display:flex;">
                <el-input type="text" v-model="MemberDTO.post" placeholder="우편번호" style="margin-right: 20px;"></el-input>
            </el-col>
            <el-button size="large" @click="execDaumPostcode">우편번호 찾기</el-button>
            <el-input type="text" v-model="MemberDTO.addr1" placeholder="도로명주소"></el-input>
            <el-input type="text" v-model="MemberDTO.addr2" placeholder="상세주소"></el-input>
        </el-form-item>

        <el-form-item label="휴대폰 번호">
            <el-input type="text" v-model="phoneNum" maxlength="11" placeholder="- 를 제외하고 숫자만 입력하세요"></el-input>
        </el-form-item>

        
        <el-form-item label="이메일 주소">
            <el-col :span="7"  style="margin-right:8px;">
                <el-input type="email" v-model="MemberDTO.email1"></el-input>
            </el-col>
            <el-col class="line" :span="1" style="margin-right:8px;">@</el-col>
            <el-col :span="7">
                <el-input type="email" v-model="MemberDTO.email2"></el-input>
            </el-col>
            <el-col class="line" :span="1">&nbsp;</el-col>
            <el-col :span="7">
                <el-select v-model="MemberDTO.email2" placeholder="직접입력">
                    <el-option
                    v-for="item in emaildomain"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
            </el-col>
        </el-form-item>

    </el-form>
    <el-button type="warning" @click="signUp()">회원가입</el-button>
</el-col>
    
  </div>
</template>

<script 
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
import axios from 'axios';

export default {
    name:'SignUp',
    data:function(){
        return{
            idCkmsg:"",
            passwdCk:"",
            passwdCkmsg:"",
            phoneNum:"",
            emaildomain: [
                {
                value: 'naver.com',
                label: 'naver.com'
                }, {
                value: 'gmail.com',
                label: 'gmail.com'
                }, {
                value: 'daum.net',
                label: 'daum.net'
                }, {
                value: '직접입력',
                label: '직접입력'
                }
            ],
            
            MemberDTO:{
                mbId:"",
                pw:"",
                nm:"",
                post:"",
                addr1:"",
                addr2:"",
                tel1:"010",
                tel2:"",
                tel3:"",
                email1:"",
                email2:""
            }
        }
    },//end data
    methods:{
        idCk:function(){
            console.log(this.MemberDTO.mbId);
            var idCkmsg = this.idCkmsg;
            var url=`http://localhost:8093/app/member/idCheck/${this.MemberDTO.mbId}`;
            axios.post(url,
            {
                mbId:this.MemberDTO.mbId
            }
            ).then(
                (res)=>{
                    console.log(res.data.message, this.MemberDTO.mdId);
                    if(res.data.message==="아이디 사용가능"){
                        this.idCkmsg="사용 가능한 아이디입니다.";
                    }else if(res.data.message==='아이디 중복'){
                        this.idCkmsg="이미 사용중인 아이디입니다.";
                        this.MemberDTO.mbId='';
                    }
                }
            ).catch(
                (error)=>{
                    console.log(error);
                }
            )
        },
        passwdCheck: function(){
            if(this.MemberDTO.pw!=this.passwdCk){
                this.passwdCkmsg = '비밀번호가 일치하지 않습니다.';
            }else{
                this.passwdCkmsg="비밀번호가 일치합니다.";
            }
        },
        phoneSelect:function (event) {
          this.MemberDTO.tel1=event.target.value;
        },
        signUp:function (event) {
            //var memberDTO=this.MemberDTO;
            var pNm = this.phoneNum;
            this.MemberDTO.tel1 = pNm.substr(0,3);
            this.MemberDTO.tel2 = pNm.substr(3,4);
            this.MemberDTO.tel3 = pNm.substr(7);
            
            console.log("클릭========", this.MemberDTO);
            
            if(this.MemberDTO.mbId==""){
                alert("아이디를 입력해주세요.");
            }else if(this.idCkmsg=="이미 사용중인 아이디입니다."||this.idCkmsg==''){
                alert("아이디를 확인해주세요.")
            }else if(this.MemberDTO.pw==""){
                alert("비밀번호를 입력해주세요.");
            }else if(this.passwdCk=="" || this.passwdCkmsg!="비밀번호가 일치합니다."){
                alert("비밀번호가 일치하지 않습니다.");
            }else if(this.MemberDTO.nm==""){
                alert("이름을 입력해주세요.");
            }else if(this.MemberDTO.post==""||this.MemberDTO.addr1==""||this.MemberDTO.addr2==""){
                alert("주소를 입력해주세요.")
            }else if(this.MemberDTO.tel1==""||this.MemberDTO.tel2==""||this.MemberDTO.tel3==""){
                alert("핸드폰 번호를 입력해주세요.")
            }else if(this.MemberDTO.email1==""||this.MemberDTO.email2==""){
                alert("이메일을 입력해주세요.")
            }
            var url="http://localhost:8093/app/member/memberAdd";
            axios.post(url,
            {
                mbId:this.MemberDTO.mbId,
                pw:this.MemberDTO.pw,
                nm:this.MemberDTO.nm,
                post:this.MemberDTO.post,
                addr1:this.MemberDTO.addr1,
                addr2:this.MemberDTO.addr2,
                tel1:this.MemberDTO.tel1,
                tel2:this.MemberDTO.tel2,
                tel3:this.MemberDTO.tel3,
                email1:this.MemberDTO.email1,
                email2:this.MemberDTO.email2
            }).then(
                (res)=>{
                    console.log("회원가입 성공");
                    //회원가입 성공 후 main페이지로 이동만들기
                }
            ).catch(
                (error)=>{
                    console.log(error);
                }
            )
        },
        execDaumPostcode(){ //@click을 사용할 때 함수는 이렇게 작성해야 한다.
            new window.daum.Postcode({
            oncomplete: (data) => { //function이 아니라 => 로 바꿔야한다.
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                this.MemberDTO.post = data.zonecode;
                this.MemberDTO.addr1 = roadAddr;
            }
            }).open();
        }//end 우편번호찾기         
    }//end methods

}
</script>

<style>
.el-button{
    margin-right: 10px;
}
</style>