<template>
  <div>
    <div style="padding-left: 50px;">

   
    <h3>주문자 정보</h3>

	<table width="90%" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan="3">
				<hr size="2" color="black">
			</td>
		</tr>
		<tr>
			<td width="200" height="50" class="td_default" style="text-indent: 10px;">주문하시는 분</td>
			<td height="50" class="td_default"><input class="input_default"
				type="text" id="mname" size="20" maxlength="20" :value="member.nm" style="width: 330px;height: 35px;"></td>
		</tr>
        <tr>
			<td colspan="2">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
		<tr>
			<td height="50" class="td_default" style="text-indent: 10px;">우편번호</td>
			<td height="50" class="td_default"><input class="input_default"
				type="text" id="mpost" size="6" maxlength="6" :value="member.post" style="width: 200px;height: 35px;" >

			</td>
		</tr>
        <tr>
			<td colspan="2">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
		<tr rowspan="2">
			<td height="50" class="td_default" style="text-indent: 10px;">주 소</td>
			<td height="50" class="td_default"><input class="input_default"
				type="text" id="maddress1" size="35" maxlength="200" :value="member.addr1"
				style="width: 330px;height: 35px;"><br><br> <input class="input_default" type="text"
				id="maddress2" size="35" maxlength="200" :value="member.addr2" style="width: 330px;height: 35px;">
			</td>
		</tr>
        <tr>
			<td colspan="2">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		<tr>
			<td height="50" class="td_default" style="text-indent: 10px;">휴대전화</td>
			<td height="50" class="td_default"><input class="input_default"
				type="text" id="mphone1" size="5" maxlength="5" :value="member.tel1" style="width: 100px;height: 35px;">-<input
				class="input_default" type="text" id="mphone2" size="5" maxlength="5"
				:value="member.tel2" style="width: 100px;height: 35px;">-<input class="input_default" type="text"
				id="mphone3" size="5" maxlength="5" :value="member.tel3" style="width: 100px;height: 35px;"></td>
		</tr>
        <tr>
			<td colspan="2">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
		<tr>
			<td height="50" class="td_default" style="text-indent: 10px;">이메일</td>
			<td height="50" class="td_default"><input class="input_default"
				type="text" id="memail" size="35" maxlength="35" :value="member.email1+member.email2" style="width: 330px;height: 35px;"></td>
		</tr>
		<tr>
			<td colspan="3">
				<hr size="1" color="black">
			</td>
		</tr>
	</table>
    <!-- 주문자 정보 끝 -->
    <br>
    <h3>배송지 정보</h3>
	<table width="90%" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan="2">
				<hr size="2" color="black">
			</td>
		</tr>
		<tr>
			<td width="200" height="50" style="text-indent: 10px;">배송지 확인</td>
			<td class="td_default" height="50"><input type="checkbox" name="same"
				id="same" v-model="isChecked"  > 주문고객 정보와 동일합니다.</td>
		</tr>
        <tr>
			<td colspan="2">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
		<tr>
			<td width="125" height="50" class="td_default" style="text-indent: 10px;">이 름</td>
			<td height="50" class="td_default"><input class="input_default"
				type="text" id="orderName" name="orderName" size="20" maxlength="20"
				value="" style="width: 330px;height: 35px;"></td>
		</tr>
        <tr>
			<td colspan="2">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
		<tr rowspan="2">
			<td height="50" class="td_default" style="text-indent: 10px;">우편번호</td>
			<td height="50" class="td_default">
				<!-- 다음주소 시작--> <input type="text" v-model="post" name="post" id="sample4_postcode"
				placeholder="우편번호" style="width: 200px;height: 35px;"> <input type="button"
				@click="execDaumPostcode" value="우편번호 찾기" style="height: 35px;"><br><br>
				<input type="text" v-model="addr1" name="addr1" id="sample4_roadAddress"
				placeholder="도로명주소" style="width: 330px;height: 35px;"> <input type="text" v-model="addr2" name="addr2"
				id="sample4_jibunAddress" placeholder="상세주소" style="width: 330px;height: 35px;"> <span
				id="guide" style="color: #999"></span> <br> <!-- 다음주소 끝 -->
			</td>
		</tr>

		

        <tr>
			<td colspan="2">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		<tr>
			<td height="50" class="td_default" style="text-indent: 10px;">휴대전화</td>
			<td height="50" class="td_default"><input class="input_default"
				type="text" id="phone1" size="5" maxlength="5" value="" style="width: 100px;height: 35px;">-<input
				class="input_default" type="text" id="phone2" size="5" maxlength="5"
				value="" style="width: 100px;height: 35px;">-<input class="input_default" type="text"
				id="phone3" size="5" maxlength="5" value="" style="width: 100px;height: 35px;"></td>
			
		</tr>
		<tr>
			<td colspan="2">
				<hr size="1" color="black">
			</td>
		</tr>
	</table>
    <!-- 배송지 정보 끝 -->
    <br>
    <h3>주문상품 정보</h3>

    <table width="90%" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan="7">
				<hr size="2" color="black">
			</td>
		</tr>
		<tr>
			<td class="td_default" height="50" style="text-align: center;" width="100"><strong>주문번호</strong></td>
			<td class="td_default" height="50" style="text-align: center;" colspan="2"><strong>상품정보</strong></td>
			<td class="td_default" height="50" style="text-align: center;" width="100"><strong>수량</strong></td>
			<td class="td_default" height="50" style="text-align: center;" width="120"><strong>가격</strong></td>
            <td class="td_default" height="50" style="text-align: center;" width="120"><strong>총 상품 금액</strong></td>
            <td class="td_default" height="50" style="text-align: center;" width="120"><strong>배송비</strong></td>

		</tr>

		<tr>
			<td colspan="7">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
       
		<tr class="block" v-for="(item, idx) in list" v-bind:key="idx">
			<td class="td_default" style="text-align: center;" width="100">{{ item.cartCd }}</td>
            <td class="td_default" width="100"><img
      style="width: 100px; height: 100px"
      :src='`http://localhost:8093/app/api/file/view/${item.imgCd}`'
      /></td>
			<td class="td_default" width="300" style="padding-left: 30px;">{{item.itNm}} <br>
                <span style="font-size: 12px; color: #665b5f" v-if="item.optNm" >[옵션 : 옵션({{ item.optNm }})]</span>
				<span style="font-size: 12px; color: #665b5f" v-else></span>
			</td>
            <td class="td_default" style="text-align: center;" width="100">{{ item.amount }}</td>
			<td class="td_default" style="text-align: center;" width="120">{{ item.price | currency }}</td>
            <td class="td_default" style="text-align: center;" width="120">{{ item.amount * item.price | currency }}</td>
            <td class="td_default" style="text-align: center;" width="120"  v-if="idx==0" :rowspan="list.length">
				<span v-if="deliveryFee == 0"> 무료배송 </span>
				<span v-else>{{deliveryFee | currency}}</span>
				
			</td>

			

		</tr>
      
		<tr>
			<td colspan="7">
				<hr size="1" color="black">
			</td>
		</tr>
	</table>
    <br>
    <h3>최종 결제 금액</h3>
    <table width="90%" cellspacing="0" cellpadding="0">
		<tr>
			<td colspan="2">
				<hr size="2" color="black">
			</td>
		</tr>
        <tr>
            <td height="50">총 상품 금액</td>
            <td height="50">{{totalPrice | currency}} </td>
        </tr>
        <tr>
            <td height="50">배송비</td>
            <td height="50"> 
				<span v-if="deliveryFee == 0"> 0원 </span>
				<span v-else>{{deliveryFee | currency}}</span>
			</td>
        </tr>
        <tr>
			<td colspan="2">
				<hr size="1" color="CCCCCC">
			</td>
		</tr>
        <tr>
            <td height="50">최종 결제 금액</td>
            <td height="50">{{ totalPrice + deliveryFee | currency}} </td>
        </tr>
    </table>

    <br>
    <!-- 결제 수단 시작  -->
	<h3>결제 수단</h3>
	<table width="90%" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<hr size="2" color="black">
			</td>
		</tr>
		<tr>
			<td width="125" height="50" class="td_default"><input
				type="radio" name="payMethod" value="신용카드" checked>신용카드 <input
				type="radio" name="payMethod" value="계좌이체">계좌이체 <input
				type="radio" name="payMethod" value="무통장 입금">무통장 입금</td>

		</tr>
		<td>
			<hr size="1" color="black">
		</td>

	</table>
	<!-- 결제 수단 끝 --> 
    <el-row style="display: flex; justify-content: center;">
        <el-button type="warning" id="paybtn" @click="pay">결제하기</el-button>
    </el-row>

    </div>
  </div>
</template>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>




<script>
import axios from 'axios';
import eventBus from '@/common/EventBus.vue';
export default {
	props : {
		cartString : String
	},
    data:function(){
       return{
        isChecked: false,
		myData : null,
		list:[],
		post:"",
		addr1:"",
		addr2:"",
	//	deliveryFee:0,
		member:{
			nm: "",
			post:"",
			addr1:"",
			addr2:"",
			tel1:"",
			tel2:"",
			tel3:"",
			email1:"",
			email2:""
		},
//		mbId: this.$session.get('memberInfo')

       }
        
    },
	created : function(){
		eventBus.$on("cartAdd", this.cart);
	},
	beforeMount:function(){
		this.itemJoinLists();
		this.memberInfo();
	},
    methods:{ 
		cart : function(name){
			console.log(name);
		},
        //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
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
               this.post = data.zonecode;
               this.addr1 = roadAddr;
			
            }
            }).open();
        },//end 우편주소찾기
		// getCartCd : function(CartCdArr){
		// 	console.log("//>>>>>>>>>>>>>>>" + CartCdArr[0]);
		// 	var arr = [];
		// 	CartCdArr.map((ele)=>{
		// 		arr.push(ele);
		// 	});
		// 	this.list = arr;
		// 	this.itemJoinLists();
		// 	this.memberInfo();
		// },
		itemJoinLists:function(){
			var itemList = this.list;
			var url = 'http://localhost:8093/app/check/orderConfirm';
			var searchParam = { cartCd : this.cartString};
			console.log(searchParam);
			axios.get(url,
			{ params: searchParam })
			.then(
				(res)=>{
					console.log(res);
					res.data.body.map(function(ele,idx){
						itemList.push(ele);
					});
					console.log(itemList.length);
					console.log(itemList[0].mbId)
				}
			).catch(
			(error)=>{
				console.log(error);
			}
			)
			// var itemList = this.list;

			// axios.get("http://localhost:8093/app/check/orderConfirm/?cartCd=2&cartCd=3&cartCd=4&cartCd=5&cartCd=6&cartCd=7&cartCd=8&cartCd=9")
			// .then(
			// 	(res)=>{
			// 		console.log(res);
			// 		res.data.body.map(function(ele,idx){
			// 			itemList.push(ele);
			// 		});
			// 		console.log(itemList.length);
			// 		console.log(itemList[0].mbId)
			// 	}
			// ).
			// catch(
			// 	(error)=>{console.log(error);}
			// )
		},

		memberInfo:function(){
			var memberDto = this.member;
			
			axios.get("http://localhost:8093/app/member/check/mypage/1")
			.then(
				(res)=>{
					console.log(res);
					memberDto = res.data.body;
					console.log(memberDto.email1);
					console.log(memberDto.nm);
					this.member.nm = memberDto.nm;
					this.member.post = memberDto.post;
					this.member.addr1 = memberDto.addr1;
					this.member.addr2 = memberDto.addr2;
					this.member.tel1 = memberDto.tel1;
					this.member.tel2 = memberDto.tel2;
					this.member.tel3 = memberDto.tel3;
					this.member.email1 = memberDto.email1;
					this.member.email2 = memberDto.email2;

					
				}
			).catch(
				(error)=>{console.log(error);}
			)
		},
		
       
        pay: function(){ //유효성 검사
            var mname = document.getElementById("mname").value;
            var mpost = document.getElementById("mpost").value;
            var maddress1 = document.getElementById("maddress1").value;
			var maddress2 = document.getElementById("maddress2").value;
			var mphone1 = document.getElementById("mphone1").value;
			var mphone2 = document.getElementById("mphone2").value;
			var mphone3 = document.getElementById("mphone3").value;
			var memail = document.getElementById("memail").value;
			var orderName = document.getElementById("orderName").value;
			var sample4_postcode = document.getElementById("sample4_postcode").value;
			var sample4_roadAddress = document.getElementById("sample4_roadAddress").value;
			var sample4_jibunAddress = document.getElementById("sample4_jibunAddress").value;
			var phone1 = document.getElementById("phone1").value;
			var phone2 = document.getElementById("phone2").value;
			var phone3 = document.getElementById("phone3").value;

            if(mname.length==0){
				alert("필수 입력 항목");
				document.getElementById("mname").focus();
//				Event.preventDefault;
                return false;
            }    
            if(mpost.length==0){
				alert("필수 입력 항목");
				document.getElementById("mpost").focus();
				return false;
			}
            if(maddress1.length==0){
				alert("필수 입력 항목");
                document.getElementById("maddress1").focus();
				return false;
			}
			if(maddress2.length==0){
				alert("필수 입력 항목");
				document.getElementById("maddress2").focus();
				return false;
			}
			if(mphone1.length==0){
				alert("필수 입력 항목");
				document.getElementById("mphone1").focus();
				return false;
			}
			if(mphone2.length==0){
				alert("필수 입력 항목");
				document.getElementById("mphone2").focus();
				return false;
			}
			if(mphone3.length==0){
				alert("필수 입력 항목");
				document.getElementById("mphone3").focus();
				return false;
			}
			if(memail.length==0){
				alert("필수 입력 항목");
				document.getElementById("memail").focus();
				return false;
			}
			if(orderName.length==0){
				alert("필수 입력 항목");
				document.getElementById("orderName").focus();
				return false;
			}
			if(sample4_postcode.length==0){
				alert("필수 입력 항목");
				document.getElementById("sample4_postcode").focus();
				return false;
			}
			if(sample4_roadAddress.length==0){
				alert("필수 입력 항목");
				document.getElementById("sample4_roadAddress").focus();
				return false;
			}
			if(sample4_jibunAddress.length==0){
				alert("필수 입력 항목");
				document.getElementById("sample4_jibunAddress").focus();
				return false;
			}
			if(phone1.length==0){
				alert("필수 입력 항목");
				document.getElementById("phone1").focus();
				return false;
			}
			if(phone2.length==0){
				alert("필수 입력 항목");
				document.getElementById("phone2").focus();
				return false;
			}
			if(phone3.length==0){
				alert("필수 입력 항목");
				document.getElementById("phone2").focus();
				return false;
			}   
        
            console.log("pay 함수 호출 ====================");
			this.$router.push("/orderDone");
        },

        
    },
	computed:{
		totalPrice(){
			var sum = 0;
			this.list.map(function(ele,idx){
				sum = sum + (ele.amount * ele.price)
				console.log(ele.amount * ele.price);
			})
			return sum;
		},
		deliveryFee(){
			if(this.totalPrice < 50000){
				return 3000;
			}
			return 0;
		}
	},

    watch:{
        isChecked(val){
            if(val){
				document.getElementById("orderName").value=document.getElementById("mname").value;
				this.post = document.getElementById("mpost").value;
				this.addr1 = document.getElementById("maddress1").value;
				this.addr2 = document.getElementById("maddress2").value;
				document.getElementById("phone1").value=document.getElementById("mphone1").value;
				document.getElementById("phone2").value=document.getElementById("mphone2").value;
				document.getElementById("phone3").value=document.getElementById("mphone3").value; 
            }else{
				document.getElementById("orderName").value="";
				this.post ="";
				this.addr1 = "";
				this.addr2 = "";
				document.getElementById("phone1").value="";
				document.getElementById("phone2").value="";
				document.getElementById("phone3").value="";
            }
        }
    }


  
   }
    

</script>



<style>
 

</style>

