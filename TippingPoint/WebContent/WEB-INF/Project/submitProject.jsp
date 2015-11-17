<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 프로젝트 등록  -->


	<h2>프로젝트 등록</h2>
	 <h2>프로젝트 등록</h2>
   
   <form action="/TippingPoint/registerTpProject.do" method="post" enctype="multipart/form-data" >
      <label>도메인명(id) : <input type = "text" name = "tpid"/></label><p>
      <label>프로젝트 이름 : <input type = "text" name = "title"/></label><p>
      <label>프로젝트 시작일 : <input type = "number" name = "FundingStartDate"/></label><br>
      <label>프로젝트 마감일 : <input type = "number" name = "FundingLastDate"/></label><p>
      <label>목표 후원 금액 : <input type = "number" name = "targetAmount"/></label>
   
      프로젝트 메인 사진<br>
      <input type = "file" name = "upfile"><p>
   
      첨부 사진 <br>
      <input type = "file" name = "upfile"><br>
      <input type = "file" name = "upfile"><br>
      <input type = "file" name = "upfile"><br>
   
      프로젝트 내용 <p>
      <textarea name = "imageInfo"  rows = "10" cols = "50"></textarea><br>
   
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type = "submit" value = "저장">
   </form>
   
	
	<!-- 
	제목
	메인사진.
	사진등록
	목표금액
	마감기간
	시작날짜
	내용.
	저장.
	등록신청.
	취소.
	 -->

</body>
</html>