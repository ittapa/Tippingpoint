<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style type="text/css">
div#tpProject_Title {
	background-color: white;
	font-size: 70px;
	font-weight: bold;
	margin-top: 30px;
	margin-bottom: :30px;
	text-align: center;
	height: 130px;
}
.tpProject_midle{
	margin-left: auto;
	margin-right:auto;
	margin-top: 30px;
	margin-bottom: :30px;
}
</style>

	<!-- 상단 영역 -->
	<div id="tpProject_Title">
		<a href="">${requestScope.polist.tppTitle }</a>
	
	</div>
						<!-- 중간 영역  -->
					
	<div class="text-center">
		                 
		<a href="javascript:snsShare.shareFb()" class="btn btn-social-icon btn-facebook"><i class="fa fa-facebook"></i></a>                                
		<a href="javascript:snsShare.shareGp()" class="btn btn-social-icon btn-google-plus"><i class="fa fa-google-plus"></i></a>                          
		<a href="javascript:snsShare.shareTw()" class="btn btn-social-icon btn-twitter"><i class="fa fa-twitter"></i></a>
	</div>


<!-- 오른쪽영역 -->
		<div id="row">
		
			<div class="col-xs-8 .col-md-8">
				<div class="mainImg">
					<img src="${requestScope.polist.tppMainImg }" width="620" class="img-responsive" style="padding-top: 5px"> <br />
				</div>
				
				<div id ="tppProjectContent">${requestScope.polist.tppProjectContent }</div>
			</div>
			
			<script>
				$(function(){
					$("#tppProjectContent").children("img").attr("class", "img-responsive");
					
					/* .addclass("img-responsive") */
				});
			
			</script>
	
	<!-- 왼쪽 영역 -->
	
			<div class= "col-xs-4 .col-md-4">
				<div>
					<br /> 목표금액 ${requestScope.polist.tppTargetAmount } 원 중<br/>
					<font size='70'>${requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount +((requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount %1>0.5)?(1-(requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount %1))%1:-(requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount %1))}</font>
				% 달성 <br/>
						<br /><font size='70'>${requestScope.polist.tppTotalAmount }</font> 원
						<br />
						<br /> 남은시간<br/>
						<font size='70'>${requestScope.remindTime }</font> 일 <br/><br />
					후원자<br />
					<font size='70'> ${requestScope.polist.tppFunderNum }</font>명 <br/><br/>
				</div>
				<div>
					<c:choose>
						<c:when test="${requestScope.polist.tppState == 'O' }">
								<form action="결제">
										<input type="hidden" name="tppId"
													value="${requestScope.polist.tppId}">
										 <input type="submit" value="Funding" class="btn btn-primary" >
								</form>
						</c:when>
						
						<c:otherwise>
							FUNDING이 종료 되었거나 활성화되지 않았습니다.
						</c:otherwise>
						
					</c:choose>
				</div>


				<div>
						<br /> 프로젝트 크리에이터<br /> 
						<img	src="${requestScope.tppWriter.tpfProfileImg }" width="100"> 
						<br />
						${requestScope.tppWriter.tpfId }
						<br/>
						작성자 : ${requestScope.tppWriter.tpfName } 
						<br /> 
						H.P : ${requestScope.tppWriter.tpfPhoneNum }
				</div>
				<div>작성일자 : ${requestScope.polist.tppWriteDate}</div>
				<br/>
				<div>펀딩 횟 수 : ${requestScope.polist.tppFunderNum}</div>
				<div>펀딩 기간 : ${requestScope.polist.tppFundingStartDate } ~ ${requestScope.polist.tppFundingLastDate}</div>
				<br />

		</div>
	
	</div>
	<div class="bottom"></div>

