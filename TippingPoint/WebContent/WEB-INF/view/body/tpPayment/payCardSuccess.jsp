<%@ page contentType="text/html;charset=UTF-8" %>
<%
	out.println(request);
%>
<h2>프로젝트를 후원해주셔서 감사합니다.</h2>
<ul>
	<li>주문번호: ${requestScope.LGD_OID}</li>
	<li>결제금액: ${requestScope.LGD_AMOUNT}</li>
</ul>
 
${requestScope.retMsg}