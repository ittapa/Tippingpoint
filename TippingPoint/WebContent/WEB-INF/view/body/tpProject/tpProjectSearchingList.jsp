<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<P><!-- align="center" -->
			<FONT size="5"><B>'${requestScope.keyWord}' 로 검색 한 결과</B></FONT>
	</P>

<br/>

	<c:choose>
		<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 글이 없습니다.
	</c:when>
		<c:otherwise>
	
			<c:forEach items="${requestScope.list }" var="tpProject">
					<div>
						<p>
						<div><a href="${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }"><img src="${tpProject.tppMainImg }"  width="200" height="200"></a></div>
						<div>${tpProject.tppWriter }</div>
						<div><a href="${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }">${tpProject.tppTitle }</a></div>
						<div>${tpProject.tppFundingLastDate }</div>
						<div>${tpProject.tppTotalAmount }</div>
						</p>
					</div>
				</c:forEach>
			<br/>
			<div>총 검색된 프로젝트 수  : ${fn:length(requestScope.list) }</div>
					
		</c:otherwise>
	</c:choose>
	
	
	
	
	<%-- todo 페이징 처리 보류
	
	
	
	<!-- Paging 처리 -->
	<!-- 
		1. 이전 페이지 그룹으로 이동
			이전페이지 그룹이 있으면 링크처리 없으면 <- 모양만 나오도록 처리.
	 -->
	 <c:choose>
	 	<c:when test="${requestScope.pagingBean.previousPageGroup }">
	 		<a href="${initParam.rootPath }/tpProjectBoard.tp?pageNo=${requestScope.pagingBean.startPageOfPageGroup-1}">◀</a>
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
	 			<a href="${initParam.rootPath }/tpProjectBoard.tp?pageNo=${page }">${page }</a>&nbsp;&nbsp;
	 		</c:otherwise>
	 		</c:choose>
	 </c:forEach>
	 
	 <!-- Paging 처리2 -->
	  <c:choose>
	 	<c:when test="${requestScope.pagingBean.nextPageGroup }">
	 		<a href="${initParam.rootPath }/tpProjectBoard.tp?pageNo=${requestScope.pagingBean.endPageOfPageGroup+1}">▶</a>
	 	</c:when>
	 	<c:otherwise>
	 		▶
	 	</c:otherwise>
	 </c:choose> --%>
