<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8 ">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function goModify(){//
	$("#modifyBtn").on("click", function(){
		$("#modify").submit();
	});
});
$(document).ready(function goDelete(){//
	$("#deleteBtn").on("click", function(){
		if (confirm("게시물을 삭제하시겠습니까??") == true){//확인
			$("#delete").submit();
		}else{//취소
		 	return;
		}
	});
});

</script>
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
		

   <form name = "noticeList" action="${initParam.rootPath }/tpAdminNoticeManager.tp">
  	<input type="submit" value="목록으로">
   	<input type="button" id="modifyBtn" value="글수정">
   	<input type="button" id="deleteBtn" value="글삭제">
   </form>
   <form id="delete" action="${initParam.rootPath }/removeNotice.tp">
   <input type ="hidden" name ="tpNoticeNum" value = "${requestScope.noticeList.tpNoticeNum }">
   </form>
   <form id="modify" action="${initParam.rootPath }/modifyNotice.tp">
   <input type ="hidden" name ="tpNoticeNum" value = "${requestScope.noticeList.tpNoticeNum }">
   </form>
</body>
</html>