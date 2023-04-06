<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    fieldset {
        width : 130px; height : 130px;  }      

    .center{
	width: 100px; 
	margin: 0 auto;
}    
</style>
<meta charset="UTF-8">
<title>Kkosunnae</title>
<!-- 메타 태그 설정, 키워드, 설명  -->
<meta name="description" content="애견용품 전문 쇼핑몰, 애견과 함께하는 행사 소개">
<meta name="keywords" content="애견용품,애견간식,애견식품,목줄,애견집,애견축제">
<style type="text/css">
html,
body {
  height: 100%;
}

body {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}

main {
  flex: 1; /* flex-grow */
}

</style>

<!-- font-awesome-icon -->   
<%
	String mesg = (String) session.getAttribute("mesg");
	if(mesg != null){
%>
	<script type="text/javascript">
		alert("<%=mesg%>");
	</script>
<%
	session.removeAttribute("mesg");
	} %>
</head>
<body>
	<header>  
		<jsp:include page="common/top.jsp"></jsp:include>
		<hr>
		<jsp:include page="common/menu.jsp"></jsp:include>
	</header>
<hr>
<!-- <div class="login_page center" > -->
<fieldset>
<jsp:include page="member/loginForm.jsp" flush="true" />
</fieldset>
<!-- </div> -->
<hr>
<%-- <jsp:include page="common/footer.jsp" flush="true"></jsp:include> --%>
</body>
</html>