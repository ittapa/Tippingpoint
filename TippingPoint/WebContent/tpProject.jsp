<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8 ">
<title>Insert title here</title>
</head>
<body>
	<!-- 게시판 상세보기 -->


	<center>
	<h2>프로젝트 상세보기</h2>
		<table border="1" style="width: 300px">
			<tr>
				<th>도메인아이디</th>
				<td>${requestScope.polist.tppId }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${requestScope.polist.tppTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${requestScope.polist.tppProjectContent }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${requestScope.polist.tppWriter }</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td>${requestScope.polist.tppWriteDate}</td>
			</tr>


			<tr>
				<th>모인 금액</th>
				<td>${requestScope.polist.tppTotalAmount }</td>
			</tr>
			<tr>
				<th>목표 금액</th>
				<td>${requestScope.polist.tppTargetAmount }</td>
			</tr>
			<tr>
				<th>시작일</th>
				<td>${requestScope.polist.tppFundingStartDate }</td>
			</tr>
			<tr>
				<th>마감일</th>
				<td>${requestScope.polist.tppFundingLastDate}</td>
			</tr>
			<tr>
				<th>후원자수</th>
				<td>${requestScope.polist.tppFunderNum}</td>
			</tr>
		</table>
	</center>
</body>
</html>