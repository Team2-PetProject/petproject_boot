<template>
    <div class="row-bg" style="width : 70%; margin-top: 20px;">
      <div style="margin : 30px auto; width : 60%;text-align : center; ">
        <span style=" font-family: 'Helvetica Neue',Arial,sans-serif; color : rgb(57, 57, 90); font-size: x-large; font-weight:300;">주문조회</span>
      </div>
      <el-form style=" margin : 0 auto; width:70%;" :rules="rules" ref="form" :model="form">
        <el-form-item label="간격" prop="selectDay">
          <el-radio-group v-model="form.selectDay" size="medium">
            <el-radio-button label="하루" @click="setDate(yesterday)"></el-radio-button>
            <el-radio-button label="일주일" @click="setDate(lastweek)"></el-radio-button>
            <el-radio-button label="2주일" @click="setDate(twoagoweek)"></el-radio-button>
            <el-radio-button label="1개월" @click="setDate(lastmonth)"></el-radio-button>
            <el-radio-button label="6개월" @click="setDate(sixagomonth)"></el-radio-button>
            <el-radio-button label="1년" @click="setDate(lastyear)"></el-radio-button>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="기간" prop="value1">
          <el-date-picker
            v-model="form.value1"
            type="daterange"
            range-separator="~"
            start-placeholder="시작일"
            end-placeholder="종료일"
            format="yyyy-MM-dd" @change="changeDate"
            >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="검색" prop="itNm" >
          <el-input style="width : 400px" v-model="form.itNm" placeholder="주문상품을 검색하세요."></el-input>
        </el-form-item>
        <el-form-item style="text-align: center;">
          <el-button type="warning" size="small" @click.prevent="submit('form')">조회하기</el-button>
        </el-form-item>
      </el-form>
        
    </div>
  </template>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script>
  import eventBus from '@/common/EventBus.vue';
  export default {
    props : {
   

    },
    data() {
      const today = new Date();

      const dayFormat =this.getDateFormat(today);

      const FormatYear = dayFormat.substring(0,4);
      const FormatMonth = dayFormat.substring(4,6);
      const FormatDay = dayFormat.substring(6,8);


      const yesterday = new Date(today);
      yesterday.setDate(yesterday.getDate() - 1);
      const lastweek = new Date(today);
      lastweek.setDate(lastweek.getDate() - 7);
      const twoagoweek = new Date(today);
      twoagoweek.setDate(twoagoweek.getDate() - 14);
      const lastmonth = new Date(today);
      lastmonth.setMonth(lastmonth.getMonth() - 1);
      const sixagomonth = new Date(today);
      sixagomonth.setMonth(sixagomonth.getMonth() - 6);
      const lastyear = new Date(today);
      lastyear.setFullYear(lastyear.getFullYear() - 1);
      
    return {
        defaultDay : new Date(),
        from_year : FormatYear,
        from_month : FormatMonth,
        from_day : FormatDay,
        to_year : FormatYear,
        to_month : FormatMonth,
        to_day : FormatDay,
        today : this.getDateFormat(today),
        yesterday : this.getDateFormat(yesterday),
        lastweek : this.getDateFormat(lastweek),
        twoagoweek : this.getDateFormat(twoagoweek),
        lastmonth : this.getDateFormat(lastmonth),
        sixagomonth : this.getDateFormat(sixagomonth),
        lastyear : this.getDateFormat(lastyear),
        rules : {
          itNm : [
            { required: true, message: '상품을 검색해주세요.', trigger: 'blur' }
          ],
          value1 : [
            { type: 'array', required: true, message: '기간을 선택해주세요.', trigger: 'change' }
          ]
        },
        form : {
          selectDay : '하루',
          value1 : '',
          itNm : ''
        },
        
    };
  },
  computed: {
    fromDay() {
      return this.from_year + this.from_month + this.from_day;
    },
    toDay() {
      return this.to_year + this.to_month + this.to_day;
    }
  },
    methods:{
       setDate : async function(ago){
        console.log("**************");
          let startDay = ago;
          let endDay = this.today;
          let itNm = this.form.itNm;

          if (startDay && endDay) {
            await eventBus.$emit("daySearch", startDay, endDay, itNm);
          }    
      }, 
      getDateFormat(date){
          const yyyy = date.getFullYear();
          const mm = String(date.getMonth() + 1).padStart(2, '0');
          const dd = String(date.getDate()).padStart(2, '0');
          return `${yyyy}${mm}${dd}`;
      },
      changeDate(){
        var startformat = this.getDateFormat(this.form.value1[0]);
        var year = startformat.substring(0,4);
        var month = startformat.substring(4,6);
        var day = startformat.substring(6,8);
        this.from_year = year;
        this.from_month = month;
        this.from_day = day;

        var endformat = this.getDateFormat(this.form.value1[1]);
        this.to_year = endformat.substring(0,4);
        this.to_month = endformat.substring(4,6);
        this.to_day = endformat.substring(6,8);
      },
      submit : function(formName){
        this.$refs[formName].validate((valid) => {
          if(valid){
            this.setDate(this.fromDay,this.toDay);
          }else{
            return false;
          }
        });
      }
    }
  
  }
  </script>
  
  <style>
  .row-bg {
    padding: 10px 0;
    background-color: #fffffff1;
    box-shadow:  0 2px 12px 0 rgba(0, 0, 0, 0.1);
    border-radius: 0px;
    width : 80%;
    margin : 0 auto;
  }
  </style>