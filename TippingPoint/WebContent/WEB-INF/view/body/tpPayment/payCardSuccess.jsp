<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	out.println(request);
%>
<h2>프로젝트를 후원해주셔서 감사합니다.</h2>
<ul>
	<li>주문번호: ${requestScope.LGD_OID}</li>
	<li>결제금액: ${requestScope.LGD_AMOUNT}</li>
</ul>
 
${requestScope.retMsg}

<hr/>

<table>
<c:forEach items="${request}" var="r">
	<tr>
		<td>${r.key}</td>
		<td>${r.value}</td>
	</tr>
</c:forEach>
</table>
<ul>
	<li>${requestScope.m_szResCode}</li>
	<li>${requestScope.m_szResMsg}</li>
	<li>${requestScope.LGD_TID}</li>
	<li>${requestScope.LGD_MID}</li>
	<li>${requestScope.LGD_OID}</li>
	<li>${requestScope.LGD_AMOUNT}</li>
	<li>${requestScope.LGD_RESPCODE}</li>
	<li>${requestScope.LGD_RESPMSG}</li>
</ul>