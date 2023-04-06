<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    fieldset {
        width : 350px; height : 300px;    
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
</head>
<body>
	<header>
		<jsp:include page="common/top.jsp"></jsp:include>
		<br>
		<jsp:include page="common/menu.jsp"></jsp:include>
	</header>
		
<h1>회원가입</h1>
	<main>
	<fieldset>
		<jsp:include page="member/memberForm.jsp"></jsp:include>
	</fieldset>	
	</main>


	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>