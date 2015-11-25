<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 게시판 목록 게시판 -->
		<P ><!-- align="center" -->
			<FONT size="5"><B>프로젝트 둘러보기</B></FONT>
		</P>


<!-- 카테고리 조회 -->		
<p>
	카테고리<br>
	<c:choose>
		<c:when test="${fn:length(requestScope.categoryList)==0 }">
					카테고리 정보를 가져오지 못했습니다.
		</c:when>
				
				<c:otherwise>
					<a href="${initParam.rootPath}/tpProjectBoard.tp">모두보기</a><br>
					<c:forEach items="${requestScope.categoryList }" var="list">
					<a href="${initParam.rootPath }/tpProjectCategoryBoard.tp?&tppCategory=${list.tppCategory }">${list.tppCategoryName }</a>
					<br>
					</c:forEach>
				</c:otherwise>
	</c:choose>
</p>
	
	<c:choose>
		<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 글이 없습니다.
	</c:when>
		<c:otherwise>
	
			<c:forEach items="${requestScope.list }" var="tpProject">
					<div>
						<p>
						<br/>
						<div><a href="${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }"><img src="${tpProject.tppMainImg }"  width="200" height="200"></a></div>
						<div><a href="${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }">${tpProject.tppTitle }</a></div>
						<div>Projector : ${tpProject.tppWriter }</div>
						<div>Funding Money : ${tpProject.tppTotalAmount }</div>
						<br/>
						</p>
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
	 </c:choose>