<template>
    <div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
        <el-form-item label="이름" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="비밀번호" prop="passwd">
            <el-input type="password" v-model="ruleForm.passwd" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="비밀번호 확인" prop="passwd2">
            <el-input type="password" v-model="ruleForm.passwd2" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="전화번호">
            <el-col :span="3">
            <el-form-item prop="phon1">
                <el-input v-model="ruleForm.phone1" :placeholder="this.data.tel1" autocomplete="off"></el-input>
            </el-form-item>
            </el-col>
            <el-col class="line" :span="0.5">&nbsp;</el-col>
            <el-col class="line" :span="0.5">-</el-col>
            <el-col class="line" :span="0.5">&nbsp;</el-col>
            <el-col :span="3">
            <el-form-item prop="phone2">
                <el-input v-model="ruleForm.phone2" autocomplete="off"></el-input>
            </el-form-item>
            </el-col>
            <el-col class="line" :span="0.5">&nbsp;</el-col>
            <el-col class="line" :span="0.5">-</el-col>
            <el-col class="line" :span="0.5">&nbsp;</el-col>
            <el-col :span="3">
            <el-form-item prop="phone3">
                <el-input v-model="ruleForm.phone3" autocomplete="off"></el-input>
            </el-form-item>
            </el-col>
        </el-form-item>
        <el-form-item label="주소" prop="address">
            <el-col :span="11">
                <el-form-item prop="address1">
                    <el-input v-model="ruleForm.address1" placeholder="우편번호"></el-input>
                </el-form-item>
            </el-col>
            <el-col class="line" :span="0.5">&nbsp;</el-col>
            <el-form-item prop="findAddress">
                <el-button type="warning" @click="execDaumPostcode()">우편번호 찾기</el-button>
            </el-form-item>
            <el-col :span="11">
                <el-form-item prop="address2">
                    <el-input v-model="ruleForm.address2" placeholder="주소"></el-input>
                </el-form-item>
            </el-col>
            <el-col class="line" :span="0.5">&nbsp;</el-col>
            <el-col :span="11">
                <el-form-item prop="address3">
                    <el-input v-model="ruleForm.address3" placeholder="상세주소"></el-input>
                </el-form-item>
            </el-col>
        </el-form-item>
        <el-form-item label="이메일" prop="email">
            <el-col :span="7">
                <el-input v-model="ruleForm.email1"></el-input>
            </el-col>
            <el-col :span="0.5">&nbsp;</el-col>
            <el-col :span="7">
                <el-input v-model="ruleForm.email2"></el-input>
            </el-col>
            <el-col :span="6">
                <el-select :value="ruleForm.email2" placeholder="email" @change="changeEmail($event)">
                    <el-option label="@naver.com" value="@naver.com"></el-option>
                    <el-option label="@daum.net" value="@daum.net"></el-option>
                    <el-option label="@gmail.com" value="@gmail.com"></el-option>
                </el-select>
            </el-col>
        </el-form-item>
        <el-form-item>
        <el-button type="warning" @click="submitForm('ruleForm')">수정</el-button>
        </el-form-item>
    </el-form>
    </div>    
</template>

<script>
import axios from 'axios';
    export default {
        props : {
            id : String
        },
        beforeMount : function(){
            this.mypage();
        },
        data() {
            var validatePass = (rule, value, callback) => {
                if (value === ''&&this.ruleForm.passwd2 !== '') {
                    callback(new Error("비밀번호를 입력해주세요."));
                    this.$refs.ruleForm.validateField('passwd2');
                } else{
                callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if(this.ruleForm.passwd!==value){
                    callback(new Error('비밀번호를 다시 입력해주세요'));
                }else{
                    callback();
                }
            };
            var validateNumber = (rule, value, callback)=>{
                if (isNaN(value)) {
                callback(new Error('숫자를 입력하세요'));
                } else {
                callback();
                }
            }
        return {
            ruleForm: {
            mbId : '',
            name: '',
            passwd : '',
            passwd2 : '',
            phone1: '',
            phone2: '',
            phone3: '',
            address1 : '',
            address2 : '',
            address3 : '',
            email1 : '',
            email2 :''
            },
            rules: {
                name: [
                    { required: true, message: '상품이름을 적어주세요', trigger: 'blur' },
                ],
                passwd : [
                    {validator : validatePass, trigger : 'blur'}
                ],
                passwd2 : [
                    { validator: validatePass2, trigger: 'blur'}
                ],
                phone1: [
                    { required: true, message: '상품가격을 적어주세요', trigger: 'blur' },
                    { validator : validateNumber, trigger: 'blur'}
                ],
                phone2: [
                    { required: true, message: '상품가격을 적어주세요', trigger: 'blur' },
                    { validator : validateNumber, trigger: 'blur'}
                ],
                phone3: [
                    { required: true, message: '상품가격을 적어주세요', trigger: 'blur' },
                    { validator : validateNumber, trigger: 'blur'}
                ],
                address1: [
                    { required: true, message: '우편번호를 입력해주세요.', trigger: 'blur' },
                ],
                address2: [
                    { required: true, message: '주소를 입력해주세요.', trigger: 'blur' },
                ],
                address3: [
                    { required: true, message: '상세주소를 입력해주세요.', trigger: 'blur' },
                ],
                email1 : [
                    { required: true, message: '이메일을 입력해주세요.', trigger: 'blur' }
                ],
                email2 : [
                    { required: true, message: '이메일을 입력해주세요.', trigger: 'change' }
                ]
            },
            data : {},
            passwd : ''
        };
        },
        methods: {
            submitForm(formName) {
                ///////////////////////////////////////////////////////
                //비밀번호 수정을 하지 않으면 암호화된 비밀번호가 넘어간다. 
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
                if(this.ruleForm.passwd==''){
                    this.ruleForm.passwd=this.passwd;
                    this.ruleForm.passwd2 = this.passwd;
                    console.log(this.ruleForm.passwd);
                }
                var body = {
                    mbId : this.ruleForm.mbId,
                    pw : this.ruleForm.passwd,
                    nm : this.ruleForm.name,
                    post : this.ruleForm.address1,
                    addr1 : this.ruleForm.address2,
                    addr2 : this.ruleForm.address3,
                    tel1 : this.ruleForm.phone1,
                    tel2 : this.ruleForm.phone2,
                    tel3 : this.ruleForm.phone3,
                    email1 : this.ruleForm.email1,
                    email2 : this.ruleForm.email2
                }
                axios.put('http://localhost:8093/app/member/check/update', body)
                .then(
                (res)=>{
                    console.log(res);
                }
                )
                .catch(
                (error) =>{
                    console.log(error);
                }
                )
                this.ruleForm.passwd='';
                this.ruleForm.passwd2='';
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            execDaumPostcode() {
                new window.daum.Postcode({
                    oncomplete: (data) => {
                    if (this.extraAddress !== "") {
                        this.extraAddress = "";
                    }
                    if (data.userSelectedType === "R") {
                        // 사용자가 도로명 주소를 선택했을 경우
                        this.ruleForm.address2 = data.roadAddress;
                    } else {
                        // 사용자가 지번 주소를 선택했을 경우(J)
                        this.ruleForm.address2 = data.jibunAddress;
                    }
            
                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if (data.userSelectedType === "R") {
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                        this.extraAddress += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if (data.buildingName !== "" && data.apartment === "Y") {
                        this.extraAddress +=
                            this.extraAddress !== ""
                            ? `, ${data.buildingName}`
                            : data.buildingName;
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if (this.extraAddress !== "") {
                        this.extraAddress = `(${this.extraAddress})`;
                        }
                    } else {
                        this.extraAddress = "";
                    }
                    // 우편번호를 입력한다.
                    this.ruleForm.address1 = data.zonecode;
                    this.ruleForm.address3 = '';
                    },
                }).open();
            },
            mypage : function(){
                axios.get("http://localhost:8093/app/member/check/mypage/" + this.id)
                .then(
                    (res)=> {
                        console.log(res.body);
                        if(res.data.body !=null){
                            this.data = res.data.body;
                            this.ruleForm.name = this.data.nm;
                            this.passwd = this.data.pw;
                            this.ruleForm.address1 = this.data.post;
                            this.ruleForm.address2 = this.data.addr1;
                            this.ruleForm.address3 = this.data.addr2;
                            this.ruleForm.phone1 = this.data.tel1;
                            this.ruleForm.phone2 = this.data.tel2;
                            this.ruleForm.phone3 = this.data.tel3;
                            this.ruleForm.email1 = this.data.email1;
                            this.ruleForm.email2 = this.data.email2;
                            this.ruleForm.mbId = this.data.mbId;
                        }
                        
                    }
                )
                .catch(
                    (error) => {
                        console.log(error);
                    }
                )
            },
            changeEmail : function(event){
                this.ruleForm.email2 =event;
                
            },
        }
    }
</script>

<style>

</style>