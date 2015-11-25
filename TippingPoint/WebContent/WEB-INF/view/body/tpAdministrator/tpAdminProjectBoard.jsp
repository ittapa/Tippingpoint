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
	
		<P ><!-- align="center" -->
			<FONT size="5"><B>프로젝트 목록</B></FONT>
		</P>

	<c:choose>
		<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 글이 없습니다.
		</c:when>
		<c:otherwise>
				<c:forEach items="${requestScope.list }" var="tpProject">
					<div>
						<div><img src="${tpProject.tppMainImg }" ></div>
						<div>${tpProject.tppWriter }</div>
						<div><a href="${initParam.rootPath }/tpAdminFindTpProject.tp?tppId=${tpProject.tppId }">${tpProject.tppTitle }</a></div>
						<div>${tpProject.tppFundingLastDate }</div>
						<div>${tpProject.tppTotalAmount }</div>
					</div>
				</c:forEach>
			<br/>
			<div>총 게시글수 : ${fn:length(requestScope.list) }</div>
					
		</c:otherwise>
	</c:choose>
	
	
	<!-- Paging 처리 -->
	<!-- 
		1. 이전 페이지 그룹으로 이동
			이전페이지 그룹이 있으면 링크처리 없으면 <- 모양만 나오도록 처리.
	 -->
	 <c:choose>
	 	<c:when test="${requestScope.pagingBean.previousPageGroup }">
	 		<a href="${initParam.rootPath }/tpAdminProjectBoard.tp?pageNo=${requestScope.pagingBean.startPageOfPageGroup-1}">◀</a>
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
	 			<a href="${initParam.rootPath }/tpAdminProjectBoard.tp?pageNo=${page }">${page }</a>&nbsp;&nbsp;
	 		</c:otherwise>
	 		</c:choose>
	 </c:forEach>
	 
	 <!-- Paging 처리2 -->
	  <c:choose>
	 	<c:when test="${requestScope.pagingBean.nextPageGroup }">
	 		<a href="${initParam.rootPath }/tpAdminProjectBoard.tp?pageNo=${requestScope.pagingBean.endPageOfPageGroup+1}">▶</a>
	 	</c:when>
	 	<c:otherwise>
	 		▶
	 	</c:otherwise>
	 </c:choose>
	 


<br/>
<a href="/TippingPoint/adminCheckAndMain.tp">관리자 메인 페이지로 이동</a>

</body>
</html>