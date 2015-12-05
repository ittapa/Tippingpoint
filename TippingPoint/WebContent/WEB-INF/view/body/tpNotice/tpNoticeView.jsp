<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>

<body>
   <!-- 공지사항 상세보기 -->


    
   <P ><!-- align="center" -->
         <FONT size="5"><B>공지사항 상세보기</B></FONT>
      </P>
      <table class="table table-bordered">
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
      <input type="submit" value="목록으로" class="btn btn-default">
   </form>


</body>
</html>