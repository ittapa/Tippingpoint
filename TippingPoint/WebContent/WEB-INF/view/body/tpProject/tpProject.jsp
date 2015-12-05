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

</style>

<!-- 상단 영역 -->
<div id="tpProject_Title">
	<a href="">${requestScope.polist.tppTitle }</a>

</div>

<!-- 오른쪽영역 -->
		<div id="row">
		
			<div class="col-xs-8 .col-md-8">
				<div class="mainImg">
					<img src="${requestScope.polist.tppMainImg }" width="620"> <br />
				</div>
				<div>공유하기(구현할껏)</div>
				<div>설명문 : ${requestScope.polist.tppProjectContent }</div>
			</div>
	
	<!-- 왼쪽 영역 -->
	
			<div class= "col-xs-4 .col-md-4">
				<div>
					<br /> 목표 ${requestScope.polist.tppTargetAmount } 원 중
					${requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount *100 }%모임 <br/>
						<br /><font size='80'>${requestScope.polist.tppTotalAmount }</font> 원
						<br />
						<br /> 남은시간<br/>
						<font size='80'>${requestScope.remindTime }</font> 일 <br/><br />
					후원자<br />
					<font size='80'> ${requestScope.polist.tppFunderNum }</font>명 <br/><br/>
				</div>
				<div>
					<c:choose>
						<c:when test="${requestScope.polist.tppState == 'O' and (not empty sessionScope.userLoginInfo) }">
							<form name="frmPayStart" action="/TippingPoint/payCardRequest.tp" method="post" onsubmit="return chkPayFrm(this)" class="form-horizontal">
							<div class="form-group">
							<label class="radio-inline">
								<input type="radio" name="tppPayType" value="c" checked="checked"/> 카드
							</label>
							<label class="radio-inline">
								<input type="radio" name="tppPayType" value="p"/> 계좌이체
							</label>
							</div>
							<div class="form-group">	
								<div class="col-sm-12">
									<input type="number" name="tpAmount" class="form-control" placeholder="결제금액"/>
								</div>
							</div>
							
								<input type="hidden" name="tppId" value="${requestScope.polist.tppId}">
								<input type="hidden" name="tppTitle" value="${requestScope.polist.tppTitle}" />
								
								<input type="submit" value="Funding" class="btn btn-default">
							</form>
						</c:when>
						
						<c:otherwise>
							Funding이 종료 되었거나 활성화되지 않았습니다.
						</c:otherwise>
						
					</c:choose>
				</div>


				<div>
						<br /> 프로젝트 크리에이터<br /> 
						<img	src="${requestScope.tppWriter.tpfProfileImg }"
								 width="100"> <br />${requestScope.tppWriter.tpfId }
																/ ${requestScope.tppWriter.tpfName } <br /> H.P
									${requestScope.tppWriter.tpfPhoneNum }
				</div>
				<br />

				<div>작성일자 : ${requestScope.polist.tppWriteDate}</div>
				<br /> <br /> <br />
				<div>펀딩 횟 수 : ${requestScope.polist.tppFunderNum}</div>
				<div>펀딩 기간 : ${requestScope.polist.tppFundingStartDate } ~ ${requestScope.polist.tppFundingLastDate}</div>
				<br />

		</div>
	
	</div>
	<div class="bottom"></div>


<script>
function chkPayFrm(payFrm){	
	if( (isNaN(payFrm.tpAmount.value)) || (payFrm.tpAmount.value.length < 0) ){
		alert("결제 금액을 확인하여 주십시오.");
		payFrm.tpAmount.focus();
		return false;
	} else if(payFrm.tpAmount.value < 1000 ){
		alert("최소 결제 금액은 1000원입니다.");
		payFrm.tpAmount.focus();
		return false;
	}
}

jQuery(function(){
	jQuery(":radio[name=tppPayType]").on("click", function(){
		if(jQuery(this).val() == "c"){
			jQuery("form[name=frmPayStart]").attr("action", "/TippingPoint/payCardRequest.tp");
		}else{
			jQuery("form[name=frmPayStart]").attr("action", "/TippingPoint/payAccountRequest.tp");
		}
	});
});

</script>
