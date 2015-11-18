<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8 ">
<title>Insert title here</title>
</head>
<body>
<!-- 게시판 목록 게시판 -->
	
	<h2>프로젝트 목록</h2>

	<c:choose>
		<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 글이 없습니다.
	</c:when>
		<c:otherwise>
			<table style="width: 500px" border="1">
				<tr>
					<th>작성자</th>
					<th>제목</th>
					<th>마감일</th>
					<th>모인금액</th>
				</tr>
				<c:forEach items="${requestScope.list }" var="tpProject">
					<tr>
						<td>${tpProject.tppWriter }</td>
						<td><a href="/TippingPoint/TpProject.tp?tppId=${tpProject.tppId }">${tpProject.tppTitle }</a></td>
						<td>${tpProject.tppFundingLastDate }</td>
						<td>${tpProject.tppTotalAmount }</td>
					<tr>
				</c:forEach>
				<tr>
					<td colspan="3">총 게시글수 : ${fn:length(requestScope.list) }</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	
	
	<!-- Paging 처리 -->
	<!-- 
		1. 이전 페이지 그룹으로 이동
			이전페이지 그룹이 있으면 링크처리 없으면 <- 모양만 나오도록 처리.
	 -->
	 <c:choose>
	 	<c:when test="${requestScope.pagingBean.previousPageGroup }">
	 		<a href="/TippingPoint/tpProjectBoard.tp?pageNo=${requestScope.pagingBean.startPageOfPageGroup-1}">◀</a>
	 	</c:when>
	 	<c:otherwise>
	 	◀
	 	</c:otherwise>
	 </c:choose>
	 
	 <!-- Page Group내의 page들 링크처리
	 		- PageGroup의 시작/끝 페이지번호 - 반복문처리
	  -->
	 <c:forEach begin="${requestScope.pagingBean.startPageOfPageGroup}" end="${requestScope.pagingBean.endPageOfPageGroup}" var="page">
	 		<c:choose>
	 			<c:when test="${page == requestScope.pagingBean.currentPage }">
	 				[${page}]&nbsp;
	 			</c:when>
			<c:otherwise>
	 			<a href="/TippingPoint/tpProjectBoard.tp?pageNo=${page }">${page }</a>&nbsp;&nbsp;
	 		</c:otherwise>
	 		</c:choose>
	 </c:forEach>
	 
	 <!-- Paging 처리2 -->
	  <c:choose>
	 	<c:when test="${requestScope.pagingBean.nextPageGroup }">
	 		<a href="/TippingPoint/tpProjectBoard.tp?pageNo=${requestScope.pagingBean.endPageOfPageGroup+1}">▶</a>
	 	</c:when>
	 	<c:otherwise>
	 		▶
	 	</c:otherwise>
	 </c:choose>
	 
		


</body>
</html>