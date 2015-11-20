<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h2>회원 목록</h2>
<c:choose>
	<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 회원이 없습니다.
	</c:when>
	<c:otherwise>
		<table style="width:500px" border="1">
			<tr>
				<th>회원 ID</th>
				<th>회원 이름</th>
				<th>이메일주소</th>
				<th>권한 부여 상태</th>
			</tr>
			<c:forEach items="${requestScope.list }" var="tpFunder">
			<tr>
				<td>${tpFunder.tpfId }</td>
				<td>
<a href="${initParam.rootPath}/findByTpfId.tp?tpfId=${tpFunder.tpfId}&pageNo=${requestScope.tpFunderPagingBean.currentPage}">
						${tpFunder.tpfName}
					</a>
				</td>
				<td>${tpFunder.tpfEmail}</td>
				<td>${tpFunder.tpfQualifyTpProposer}</td>
			<tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
<p/>
<!-- Paging 처리 -->
<!-- 
1. 이전 페이지 그룹으로 이동 처리
  이전페이지 그룹이 있으면 링크처리 없으면 <- 모양만 나오도록 처리.
 -->
 <c:choose>
 	<c:when test="${requestScope.pagingBean.previousPageGroup }">
 		<a href="${initParam.rootPath }/list.tp?pageNo=${requestScope.TpFunderPagingBean.startPageOfPageGroup-1}">
 			◀
 		</a>
 	</c:when>
 	<c:otherwise>
 		◀
 	</c:otherwise>
 </c:choose>

<!-- Page Group 내의 page들 링크 처리
	- PageGroup의 시작/끝페이지 번호 - 반복문 처리
 -->
<c:forEach begin="${requestScope.TpFunderPagingBean.startPageOfPageGroup }" 
		   end="${requestScope.TpFunderPagingBean.endPageOfPageGroup }" var="page">
	<c:choose>
		<c:when test="${page == requestScope.TpFunderPagingBean.currentPage }">
			[${page}]
		</c:when>
		<c:otherwise>
			<a href="${initParam.rootPath }/list.tp?pageNo=${page }">
				${page }
			</a>
		</c:otherwise>
	</c:choose>
	&nbsp;&nbsp;
</c:forEach>
<!-- 3. 다음 페이지 그룹 링크
    다음 페이지 그룹이 있으면 링크 처리 없으면 그냥 화살표만 나오도록 처리.
 -->

<c:choose>
	<c:when test="${requestScope.TpFunderPagingBean.nextPageGroup }">
		<a href="${initParam.rootPath }/list.tp?pageNo=${requestScope.TpFunderPagingBean.endPageOfPageGroup+1}">
			▶
		</a>
	</c:when>
	<c:otherwise>▶</c:otherwise>
</c:choose>