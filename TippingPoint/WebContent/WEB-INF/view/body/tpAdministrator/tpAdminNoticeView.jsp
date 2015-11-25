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
	
		<div>
				작성일 : ${requestScope.noticeList.tpNoticeDate }	 
	   			작성자 : ${requestScope.noticeList.tpNoticeWriter }	 
	   			제목 : ${requestScope.noticeList.tpNoticeTitle }
				내용 :	${requestScope.noticeList.tpNoticeContents }
				
		</div>

   <form name = "noticeList" action="${initParam.rootPath }/tpNoticeBoard.tp" method="post">
      <input type="submit" value="목록으로">
   </form>

</body>
</html>