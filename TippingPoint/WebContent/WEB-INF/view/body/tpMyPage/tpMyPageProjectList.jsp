<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<P><!-- align="center" -->
			<FONT size="5"><B>내가 등록한 프로젝트 목록</B></FONT>
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
			<div>총 등록한 프로젝트 수  : ${fn:length(requestScope.list) }</div>
					
		<input type="submit" value="수정" />
		</c:otherwise>
	</c:choose>
	
	
	