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
		등록하신 프로젝트가 없습니다.
	</c:when>
		<c:otherwise>
					<div>총 등록한 프로젝트 수  : ${fn:length(requestScope.list) }</div>
						<table>
						<tr>
							<th>프로젝트 ID</th>
							<th>프로젝트 제목</th>
							<th>프로젝트 카테고리</th>
							<th>작성/수정 날자</th>
							<th>펀딩 된 금액 / 목표 펀딩 금액</th>
							<th>펀딩 기간</th>
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
								
								</form>
								
									<c:choose>
										<c:when test="${tpProject.tppState =='A' or tpProject.tppState == 'B' or tpProject.tppState == 'O' or tpProject.tppState == 'X'}">
												<!-- 프로젝트 수정폼으로 이동 -->
												<form action = "${initParam.rootPath }/tpProjectModifyForm.tp">
														<input type ="hidden" name = "tppId" value = "${tpProject.tppId }">
														<input type="submit" value="수정" />
												</form>		
										</c:when>
				
									
									<c:when test="${tpProject.tppState =='O'}">
										<!-- 		//펀딩종료하기-->
											<form name = "exit" action ="${initParam.rootPath }/tpProjectExit.tp" id="tpProjectExit" method = "post">
													<input type ="hidden" name = "tppId" value = "${tpProject.tppId }">
													<input type = "hidden" name = "tppState" value = "E">
													<input type = "submit" value = "펀딩 종료" id = "exitButton">
											</form>			
									</c:when>	
															
								</c:choose> 
								
								
								<!-- 프로젝트로 이동 -->
								<form action = "${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }">
										<input type ="hidden" name = "tppId" value = "${tpProject.tppId }">
										<input type = "submit" value = "자세히 보기">
									
								
								
							</td>											
						</tr>

							
						

				</c:forEach>
				</table>
			<br/>

		
		</c:otherwise>
	</c:choose>
	
	
	