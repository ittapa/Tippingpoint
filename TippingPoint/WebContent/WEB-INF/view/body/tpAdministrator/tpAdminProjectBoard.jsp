<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
th, tr{
vertical-align: middle;

}

</style>
<!-- 게시판 목록 게시판 -->
	
		<P ><!-- align="center" -->
			<FONT size="5"><B>프로젝트 목록</B></FONT>
		</P>

<ul class="nav nav-tabs">
				<li role="presentation"><a href="/TippingPoint/tpAdminProjectBoard.tp">모두보기</a></li>
				<li role="presentation"><a href="/TippingPoint/tpAdminCategoryProjectBoard.tp?check=A">저장된 프로젝트</a></li>
				<li role="presentation"><a href="/TippingPoint/tpAdminCategoryProjectBoard.tp?check=B">승인요청 프로젝트</a></li>
				<li role="presentation"><a href="/TippingPoint/tpAdminCategoryProjectBoard.tp?check=X">승인거부 프로젝트</a></li>
				<li role="presentation"><a href="/TippingPoint/tpAdminCategoryProjectBoard.tp?check=O">승인완료 프로젝트</a></li>
				<li role="presentation"><a href="/TippingPoint/tpAdminCategoryProjectBoard.tp?check=E">펀딩종료 프로젝트</a></li>
				<li role="presentation"><a href="/TippingPoint/tpAdminCategoryProjectBoard.tp?check=Z">펀딩마감 프로젝트</a></li>
</ul>

								
				
	<c:choose>
		<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 글이 없습니다.
		</c:when>
		<c:otherwise>
				<table class="table">
						<tr>
							<th>프로젝트 ID</th>
							<th>프로젝트 제목</th>
							<th>프로젝트 작성자</th>
							<th>프로젝트 카테고리</th>
							<th>작성/수정 날자</th>
							<th>펀딩 된 금액 / 목표 금액</th>
							<th>펀딩 기간</th>
							<th>프로젝트 상태</th>
							<th>관리자 메시지</th>
							<th></th>
						</tr>		
				<c:forEach items="${requestScope.list }" var="tpProject">
					
				
		
					<tr>
							<td><a href="${initParam.rootPath }/tpAdminFindTpProject.tp?tppId=${tpProject.tppId }"><img src="${tpProject.tppMainImg }"  width="80" ></a></td>
							<td>${tpProject.tppTitle }</td>
							<td>${tpProject.tppWriter }</td>
							<td>${tpProject.tppCategory }</td>
							<td>${tpProject.tppWriteDate }</td>
							<td>${tpProject.tppTotalAmount } / ${tpProject.tppTargetAmount }</td>
							<td>${tpProject.tppFundingStartDate } ~ ${tpProject.tppFundingLastDate }</td>
							<td>
								<c:choose>
									<c:when test="${tpProject.tppState =='A'}">
										저장
									</c:when>
									
									<c:when test="${tpProject.tppState =='B'}">
										승인요청
									</c:when>
									
									<c:when test="${tpProject.tppState =='O'}">
										승인완료
									</c:when>
									
									<c:when test="${tpProject.tppState =='X'}">
										승인거부
									</c:when>
									
									<c:when test="${tpProject.tppState =='E'}">
										펀딩종료
									</c:when>	
									
									<c:when test="${tpProject.tppState =='Z'}">
										펀딩마감
									</c:when>
																	
								</c:choose> 
							</td>
							<td>${tpProject.tppAdminMessage }</td>
							<td>
								<c:if test ="${tpProject.tppState != 'A' or tpProject.tppState != 'B'}" >
								<a href = "${initParam.rootPath }/_____?tppId=${tpProject.tppId }"" class="btn btn-primary">펀딩 내역 조회[미구현]</a>
								</c:if>
								
								<c:choose>
									<c:when test="${tpProject.tppState == 'O'}">
										<form name = tpProjectExit action="/TippingPoint/tpAdminProjectStateConvert.tp" method="post">
				       						<input type = "hidden" name ="tppId" value = '${tpProject.tppId }'>
				      						<input type = "hidden" name = "tppState" value = "E">
				     						<input type="submit" value="프로젝트종료" class="btn btn-danger">
			   							</form>
									</c:when>
									
	   								<c:when test="${tpProject.tppState =='E' }">
										<form name = tpProjectExit action="/TippingPoint/tpAdminProjectStateConvert.tp" method="post">
				       						<input type = "hidden" name ="tppId" value = '${tpProject.tppId }'>
				      						<input type = "hidden" name = "tppState" value = "Z">
				     						<input type="submit" value="프로젝트마감" class="btn btn-danger">
				     						
			   							</form>
	   								</c:when>
	   								
	   								<c:otherwise>
	   								
	   								</c:otherwise>
								</c:choose>
	   							
	   						</td>
					</tr>
				</c:forEach>
			<br/>		
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
	<br/>
	<a href="/TippingPoint/adminCheckAndMain.tp" class="btn btn-info" role="button">관리자 메인 페이지로 이동</a>
