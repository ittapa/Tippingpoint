<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style type="text/css">
div#tpProject_Title {
	background-color: white;
	display: red;
	font-size: 60px;
	font-style: normal;
	font-weight: bold;
	margin-top: 30px;
	margin-bottom: :30px;
	text-align: center;
	height: 200px;
}

div#tpProject_Contents {
	margin: 0 auto;
	width: 960px;
	position: relative;
}

div#tpProject_Contents .left {
	margin-left: 10px;
	margin-right: 10px;
	float: left;
	width: 620px;
}

div#tpProject_Contents .right {
	margin-left: 10px;
	margin-right: 10px;
	padding-left: 20px;
	width: 280px;
	float: left;
}

.tpProject_mainImg {
	margin-bottom: 0px;
	margin-left: 0px;
	margin-right: 0px;
	margin-top: 0px;
	padding-bottom: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
	width: 620px;
	word-wrap: break-word;
	zoom: 1;
	border-style: solid;
}

div#tpProject_Contents .bottom {
	clear: both;
}
</style>

<!-- 상단 영역 -->
<div id="tpProject_Title">
	<a href="">${requestScope.polist.tppTitle }</a>

</div>

<!-- 오른쪽영역 -->
<div id="tpProject_Contents">
	<div class=left>
		<div class="mainImg">
			<img src="${requestScope.polist.tppMainImg }" height="620"> <br />
		</div>
		<div>공유하기(구현할껏)</div>
		<div>설명문 : ${requestScope.polist.tppProjectContent }</div>
	</div>
	<!-- 왼쪽 영역 -->
	<div class=right>
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
				<c:when test="${requestScope.polist.tppState = 'O' }">
					<form action="결제">
						<input type="hidden" name="tppId"
							value="${requestScope.polist.tppId}"> <input
							type="submit" value="Funding">
					</form>
				</c:when>
				<c:otherwise>
							Fudning이 종료 되었거나 활성화되지 않았습니다.
						</c:otherwise>
			</c:choose>
		</div>


		<div>
			<br /> 프로젝트 크리에이터<br /> <img
				src="${requestScope.tppWriter.tpfProfileImg }" width="100"> <br />${requestScope.tppWriter.tpfId }
			/ ${requestScope.tppWriter.tpfName } <br /> H.P
			${requestScope.tppWriter.tpfPhoneNum }
		</div>
		<br />

		<div>작성일자 : ${requestScope.polist.tppWriteDate}</div>
		<br /> <br /> <br />
		<div>후원자수 : ${requestScope.polist.tppFunderNum}</div>
		<div>시작일 : ${requestScope.polist.tppFundingStartDate }</div>
		<br />

		<div>마감일 : ${requestScope.polist.tppFundingLastDate}</div>
		<br />

	

	</div>
	<div class="bottom"></div>
</div>
