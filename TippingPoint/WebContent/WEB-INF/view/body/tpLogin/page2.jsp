<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<html>
<head>
	<title>Session 사용안함</title>
</head>
<body>
	<P ><!-- align="center" -->
			<FONT size="5"><B>세션 사용안함?</B></FONT>
		</P>
<p>세션 이름 : <b>${sessionScope.userLoginInfo}</b></p>
<P>페이지 상단에 &lt;%@ page session="<font color="red">false</font>" %&gt; 선언함</P>
</body>
</html>
