<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


			<script type="text/javascript">
				<!--펀딩종료폼 처리//-->
				$(document).ready(function() {
					  $("#exitButton").click(function(){
					
						  //오늘날짜 호출
							  var date = new Date(); 
							  var year = date.getFullYear(); 
							  var month = new String(date.getMonth()+1); 
							  var day = new String(date.getDate()); 
							  // 한자리수일 경우 0을 채워준다. 
							  if(month.length == 1){ 
							    month = "0" + month; 
							  } 
							  if(day.length == 1){ 
							    day = "0" + day; 
							  } 
			
							var today = Number(year + "" + month + "" + day);
							var tppFundingLastDate = Number($("#tppFundingLastDate").val());
							
							var tppTargetAmount = $("#tppTargetAmount").val();
							var tppTotalAmount = $("#tppTotalAmount").val();
							var confrimtxt = "";
							if(tppFundingLastDate>today){
								confrimtxt = confrimtxt +"펀딩기간이 남아있습니다. ";
							}
							if(tppTargetAmount>tppTotalAmount){
								confrimtxt = confrimtxt +"/n 목표금액에 도달하지 못했습니다.";
							}
						 alert(today);
						 alert(tppFundingLastDate);
						 alert(tppTargetAmount);
						 alert(tppTotalAmount);
						var exitConfirm = confirm(confrimtxt+"프로젝트 펀딩을 종료하시겠습니까?");
						
						
						if(!exitConfirm){
							return false
						}
						  
						
						 $("#tpProjectExit").submit;
					  }); //button click END
					 
				  });
				
				
				
			 
			</script>
	<P><!-- align="center" -->
			<FONT size="5"><B>내가 등록한 프로젝트 목록</B></FONT>
	</P>

<br/>

	<c:choose>
		<c:when test="${fn:length(requestScope.list)==0 }">
		등록된 글이 없습니다.
	</c:when>
		<c:otherwise>
						<table>
						<tr>
							<th>프로젝트 ID</th>
							<th>프로젝트 제목</th>
							<th>프로젝트 카테고리</th>
							<th>작성/수정 날자</th>
							<th>펀딩 된 금액</th>
							<th>목표 펀딩 금액</th>
							<th>펀딩 시작일</th>
							<th>펀딩 마감일</th>
							<th>프로젝트 상태</th>
							<th>관리자 메시지</th>
							<th></th>
						</tr>										
				<c:forEach items="${requestScope.list }" var="tpProject">
						<tr>
							<td><a href="${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }"><img src="${tpProject.tppMainImg }"  width="150" height="1500"></a>
									<br/><a href="${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }">${tpProject.tppId }</a></td>
							<td>${tpProject.tppTitle }</td>
							<td>${tpProject.tppCategory }</td>
							<td>${tpProject.tppWriteDate }</td>
							<td>${tpProject.tppTotalAmount }</td>
							<td>${tpProject.tppTargetAmount }</td>
							<td>${tpProject.tppFundingStartDate }</td>
							<td>${tpProject.tppFundingLastDate }</td>
							<td>${tpProject.tppState }</td>
							<td>${tpProject.tppAdminMessage }</td>
							<td>
								<!-- 프로젝트로 이동 -->
								<form action = "${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }">
										<input type ="hidden" name = "tppId" value = "${tpProject.tppId }">
										<input type = "submit" value = "자세히 보기">
								</form>
								<!-- 프로젝트 수정폼으로 이동 -->
								<form action = "${initParam.rootPath }/tpProjectModifyForm.tp">
										<input type ="hidden" name = "tppId" value = "${tpProject.tppId }">
										<input type="submit" value="수정" />
								</form>		
									<!-- 		//펀딩종료하기-->
								<form action ="??????.tp" id="tpProjectExit">
										<input type ="hidden" name = "tppId" value = "${tpProject.tppId }">
										<input type = "button" value = "펀딩 종료" id = "exitButton">
								</form>
								
							</td>											
						</tr>

							
						

				</c:forEach>
				</table>
			<br/>
			<div>총 등록한 프로젝트 수  : ${fn:length(requestScope.list) }</div>
		
		</c:otherwise>
	</c:choose>
	
	
	