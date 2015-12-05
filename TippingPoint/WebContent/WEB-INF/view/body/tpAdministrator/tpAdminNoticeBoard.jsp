<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8 ">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function goRegister2(){//
	$("#writeBtn").on("click", function(){
		location.href="/TippingPoint/tpNotice/tpNoticeWriter.tp"  // 페이지 이동...
	});
});
</script>
<body>

		<P ><!-- align="center" -->
			<FONT size="5"><B>관리자_공지사항 목록</B></FONT>
		</P>
	

	<c:choose>
		<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 글이 없습니다.
		</c:when>
		<c:otherwise>
			<table class="table">
				<tr>
					<th>번호</th>
					<th>작성일</th>
					<th>제목</th>
					<th>작성자</th>
				</tr>
				<c:forEach items="${requestScope.list }" var="tpNotice">
					<tr>
						<td>${tpNotice.tpNoticeNum }</td>
						<td>${tpNotice.tpNoticeDate }</a></td>
						<td><a href="${initParam.rootPath }/adminFindTpNotice.tp?tpNoticeNum=${tpNotice.tpNoticeNum }">${tpNotice.tpNoticeTitle }</a></td>
						<td>${tpNotice.tpNoticeWriter }</td>		
					<tr>
				</c:forEach>
				</table>
					<td colspan="4">총 게시글수 : ${fn:length(requestScope.list) }</td>
				
			
			
			
		</c:otherwise>
	</c:choose>
	
	
	<!-- Paging 처리 -->
	<!-- 
		1. 이전 페이지 그룹으로 이동
			이전페이지 그룹이 있으면 링크처리 없으면 <- 모양만 나오도록 처리.
	 -->
	 <c:choose>
	 	<c:when test="${requestScope.pagingBean.previousPageGroup }">
	 		<a href="${initParam.rootPath }/tpAdminNoticeManager.tp?pageNo=${requestScope.pagingBean.startPageOfPageGroup-1}">◀</a>
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
	 			<a href="${initParam.rootPath }/tpAdminNoticeManager.tp?pageNo=${page }">${page }</a>&nbsp;&nbsp;
	 		</c:otherwise>
	 		</c:choose>
	 </c:forEach>
	 
	 <!-- Paging 처리2 -->
	  <c:choose>
	 	<c:when test="${requestScope.pagingBean.nextPageGroup }">
	 		<a href="${initParam.rootPath }/tpAdminNoticeManager.tp?pageNo=${requestScope.pagingBean.endPageOfPageGroup+1}">▶</a>
	 	</c:when>
	 	<c:otherwise>
	 		▶
	 	</c:otherwise>
	 </c:choose>
	 <br>
	<input type="button" id="writeBtn" value="글쓰기" class="btn btn-default">
</body>
</html>