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

		<P ><!-- align="center" -->
			<FONT size="5"><B>공지사항 목록</B></FONT>
		</P>
	

	<c:choose>
		<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 글이 없습니다.
		</c:when>
		<c:otherwise>
			<table style="width: 500px" border="1" >
				<tr>
					<th>번호</th>
					<th>작성일</th>
					<th>제목</th>
				</tr>
				<c:forEach items="${requestScope.list }" var="tpNotice">
					<tr>
						<td>${tpNotice.tpNoticeNum }</td>
						<td><a href="${initParam.rootPath }/findTpNotice.tp?tpNoticeNum=${tpNotice.tpNoticeNum }">${tpNotice.tpNoticeTitle }</a></td>
						<td>${tpNotice.tpNoticeDate }</td>
						
					<tr>
				</c:forEach>
				<tr>
					<td colspan="3">총 게시글수 : ${fn:length(requestScope.list) }</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	
	<nav>
		<ul class="pagination">
	<!-- Paging 처리 -->
	<!-- 
		1. 이전 페이지 그룹으로 이동
			이전페이지 그룹이 있으면 링크처리 없으면 <- 모양만 나오도록 처리.
	 -->
	 <c:choose>
	 	<c:when test="${requestScope.pagingBean.previousPageGroup }">
	 	<li>
	 		<a href="${initParam.rootPath }/tpAdminProjectBoard.tp?pageNo=${requestScope.pagingBean.startPageOfPageGroup-1}" aria-label="Previous"><span aria-hidden="true">◀</span></a>
	 	</li>
	 	</c:when>
	 	<c:otherwise>
	 	<li class="disabled">
	 	<span aria-hidden="true">◀</span>
	 	</li>
	 	</c:otherwise>
	 </c:choose>
	 <!-- Page Group내의 page들 링크처리
	 		- PageGroup의 시작/끝 페이지번호 - 반복문처리
	  -->
	 <c:forEach begin="${requestScope.pagingBean.startPageOfPageGroup}" end="${requestScope.pagingBean.endPageOfPageGroup}" var="page">
	 		<c:choose>
	 			<c:when test="${page == requestScope.pagingBean.currentPage }">
	 				<li class="active"><a href="javascript:void(0)">${page}</a></li>
	 			</c:when>
			<c:otherwise>
	 			<li><a href="${initParam.rootPath }/tpAdminProjectBoard.tp?pageNo=${page }">${page }</a></li>
	 		</c:otherwise>
	 		</c:choose>
	 </c:forEach>
	 <!-- Paging 처리2 -->
	  <c:choose>
	 	<c:when test="${requestScope.pagingBean.nextPageGroup }">
		<li>
	 		<a href="${initParam.rootPath }/tpAdminProjectBoard.tp?pageNo=${requestScope.pagingBean.endPageOfPageGroup+1}" aria-label="Next"><span aria-hidden="true">▶</span></a>
	 	</li>
	 	</c:when>
	 	<c:otherwise>
	 	<li class="disabled">
	 		<span aria-hidden="true">▶</span>
	 	</li>
	 	</c:otherwise>
	 </c:choose>
		</ul>
	</nav>	



</body>
</html>