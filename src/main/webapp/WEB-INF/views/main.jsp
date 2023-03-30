<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
	String mesg = (String) session.getAttribute("memberAdd");
	if(mesg != null){
%>
	<script type="text/javascript">
		alert("회원가입을 축하드립니다!");
	</script>
<%
	session.removeAttribute("memberAdd");
	}
%>
<%
	String mesg2 = (String) session.getAttribute("mesg");
	if(mesg2 != null){
%>
	<script type="text/javascript">
		alert("<%=mesg2%>");
	</script>
<%
	session.removeAttribute("mesg");
	}
%>
</head>
<body>
	<header>
		<jsp:include page="common/top.jsp" flush="true"></jsp:include>
		<hr>
		<jsp:include page="common/menu.jsp" flush="true"></jsp:include>
	</header>
	<main>
		<hr>
		<%-- <jsp:include page="goods/new.jsp" flush="true"></jsp:include>> --%>
		<hr>
		<%-- <jsp:include page="goods/best.jsp" flush="true"></jsp:include> --%>
	</main>
	<%-- <jsp:include page="common/footer.jsp" flush="true"></jsp:include> --%>
</body>
</html>