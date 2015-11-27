<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/TippingPoint/jquery/jquery.js"></script>
</head>
<body>
<%
/** @todo: 회원ID 결제타입에 따라, js동적 변경 */
%>
	<h2>프로젝트 페이지 내 후원 폼</h2>
	후원방식 선택
	<form name="frmPayStart" action="/TippingPoint/pay/payRequest.tp" method="post" onsubmit="return chkPayFrm(this)">
		회원ID: <input type="text" name="strUserId" value="${sessionScope.userLoginInfo}" /><br/>
		프로젝트 ID: <input type="text" name="tppId" value="id1" /><br/>
		프로젝트 Title: <input type="text" name="tppTitle" value="myProjectTitle" /><br/>
		결제 방식: <select name="tppPayType">
			<option value="c" selected="selected">카드</option>
			<option value="p">계좌이체</option>
		</select><br/>
		결제금액: <input type="text" name="tpAmount" value="1000" /><br/>
		<input type="submit" value="후원"/><br/>
	</form>
</body>
<script>
	function chkPayFrm(payFrm){
		
		if( (isNaN(payFrm.tpAmount.value)) || (payFrm.tpAmount.value.length < 0) ){
			alert("결제 금액을 확인하여 주십시오.");
			payFrm.tpAmount.focus();
			return false;
		} else if(payFrm.tpAmount.value < 1000 ){
			alert("최소 결제 금액은 1000원입니다.");
			payFrm.tpAmount.focus();
			return false;
		}
		
	}
	
</script>

</html>