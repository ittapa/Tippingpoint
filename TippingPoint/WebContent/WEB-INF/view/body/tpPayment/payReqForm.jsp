<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/** @todo: 회원ID 결제타입에 따라, js동적 변경 */
%>
	<h2>프로젝트 페이지 내 후원 폼</h2>
	후원방식 선택
	<form action="/TippingPoint/pay/payRequest.do" method="post">
		회원ID: <input type="text" name="strUserId" /><br/>
		프로젝트 ID: <input type="text" name="tppId" /><br/>
		결제 방식: <select name="tppPayType">
			<option value="c">카드</option>
			<option value="p">계좌이체</option>
		</select><br/>
		@todo: 카드일 경우: radio / 현금일 경우, input text (동적 변경) <br/>
		결제금액: <input type="text" name="tpAmount" /><br/>
		<input type="submit" value="후원"/><br/>
	</form>
</body>
</html>