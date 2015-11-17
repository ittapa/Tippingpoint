<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>전송 받은 값</h2>

${requestScope.tppProjectContent }
${requestScope.upfile }


<br/>
<%
request.setCharacterEncoding("utf-8");
out.println("<br>에디터 결과<br>");  


out.println(request.getParameter("tppProjectContent"));
out.println("<br><br>");  

%>
</body>
</html>