<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String mesg = (String)request.getAttribute("mesg");
  if(mesg!=null){
%>    
   <script>
     alert('<%=mesg %>');
   </script>
<%
  }
%>
<%
   String pwUdmesg = (String)session.getAttribute("pwUdmesg");
  if(pwUdmesg!=null){
%>    
   <script>
     alert('<%=pwUdmesg %>');
   </script>
<%
	session.removeAttribute("pwUdmesg");
  }
%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
   
    	 $("form").on("submit",function(event){		
    		 var member_code = $("#member_code").val();
    		 var member_passwd = $("#member_passwd").val();
    	    		if(member_code.length==0){
    	    			alert("userid 필수")
    	    			$("#member_code").focus();
    	    			event.preventDefault();
    	    		}else if(member_passwd.length==0){
    	    			alert("passwd 필수")
    	    			$("#member_passwd").focus();
    	    			event.preventDefault();
    	    		}
    	    	});
    	 
    	 $("#pwSearch").on("click",function(){
    		 location.href = "PwSearchUIServlet";
    	 });//end click
   });
</script>    
<form action="login" method="post">
아이디<input type="text" name="member_code" id="member_code"><br>
비밀번호<input type="text" name="member_passwd" id="member_passwd"><br> 
<input type="submit" value="로그인">
<input type="button" value="아이디찾기" onClick="location.href='MemberIdSearchUIServlet'">

</form>
<button id="pwSearch">비밀번호찾기</button>


