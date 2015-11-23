<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8 ">
<title>Insert title here</title>
</head>
<body>
	<!-- 공지사항 상세보기 -->


	 
	<P ><!-- align="center" -->
			<FONT size="5"><B>공지사항 상세보기</B></FONT>
		</P>
		<table border="1" style="width: 300px">
			<tr>
				<th>작성일</th>
				<td>${requestScope.noticeList.tpNoticeDate }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${requestScope.noticeList.tpNoticeTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${requestScope.noticeList.tpNoticeContents }</td>
			</tr>
		</table>
		

   <form name = "noticeList" action="${initParam.rootPath }/tpNoticeBoard.tp" method="post">
      <input type="submit" value="목록으로">
   </form>


</body>
</html>