<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<html>
<head>
	<title>Session 사용</title>
</head>
<body>
	<P ><!-- align="center" -->
			<FONT size="5"><B> session 사용</B></FONT>
		</P>
<p>세션에 추가됨 로그인한 ID는<b>${sessionScope.userLoginInfo}</b> 입니다.</p>
</body>
</html>