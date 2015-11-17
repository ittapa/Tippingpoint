<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src ="lib/js/jquery.js"></script>
<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>
 <script type="text/javascript">
 $(function(){
	 var oEditors = [];
	 nhn.husky.EZCreator.createInIFrame({
	  oAppRef: oEditors,
	  elPlaceHolder: "projectText",
	  sSkinURI: "se2/SmartEditor2Skin.html",
	  htParams : {
          // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
          bUseToolbar : true,             
          // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
          bUseVerticalResizer : true,     
          // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
          bUseModeChanger : true },
	  fCreator: "createSEditor2"
	  
	 });
	 
	 $("#ResultOut").click(function(){
		//id가 smarteditor인 textarea에 에디터에서 대입
	        oEditors.getById["projectText"].exec("UPDATE_CONTENTS_FIELD", []);
	         
	        // 이부분에 에디터 validation 검증
	        alert(document.getElementById("projectText").value); 

	        //폼 submit
	        $("#boradForm").submit();

		 
	 });
	 
	 
 });
 
 
</script>
<title>Insert title here</title>
</head>
<body>
<h2>게시판</h2>

<form action = "/tpTeam1/submit.tp" method ="post" id="boradForm">

<textarea name="projectText" id="projectText" rows="10" cols="100" style="width:766px; height:412px;display:none;">
에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면됩니다.
</textarea>
<br>
<input type = "text" name ="text" id = text> 

<input type="button" id="ResultOut" value="데이터전송" />
</form>



</body>
</html>