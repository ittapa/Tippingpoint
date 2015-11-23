<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8 ">
<title>Insert title here</title>
</head>
<body>

	<a href= "/TippingPoint/tpProjectRegister.tp"> 게시글 등록</a>
	<br/>
	<br/>
	<a href= "/TippingPoint/tpProjectBoard.tp?pageNo=${param.pageNo }">게시글 목록</a>
	<br/>
	<br/>
	<a href = "/TippingPoint/tpAdminAccess.tp">관리자 로그인</a>
	<br/>
	<br/>
	<a href = "/TippingPoint/tpNoticeBoard.tp?pageNo=${param.pageNo }">공지사항 게시판</a>
	
	
</body>
</html>
