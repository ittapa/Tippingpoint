<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>

  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  
   <script type="text/javascript">
$(function(){
	 var oEditors = [];
	 nhn.husky.EZCreator.createInIFrame({
	  oAppRef: oEditors,
	  elPlaceHolder: "tppProjectContent",
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
	        oEditors.getById["tppProjectContent"].exec("UPDATE_CONTENTS_FIELD", []);
	         
	        // 이부분에 에디터 validation 검증
	        alert(document.getElementById("tppProjectContent").value); 

	        //폼 submit
	        $("#reproform").submit();

		 
	 });
	 
	 
 
	
		//날짜 깞 처리 
	  $(function() {
			    $("#date1, #date2").datepicker({
			      changeMonth: true,
			      changeYear: true,
			      dateFormat : "yy-mm-dd",
			      yearRange : "1900:c"
			    });
			  });
	
	}); //document.ready

	
	
</script>

<title>Insert title here</title>
</head>
<body>
	<!-- 프로젝트 등록  -->


	<h2>프로젝트 등록</h2>
	<br />
	<form action="submitTpProject.tp" method="post" id ="reproform"
		enctype="multipart/form-data">
		<label>프로젝트 ADMIN  : <input type="text" name="tppId" /></label>
		<br /> <br/>
			<label>프로젝트 제목 : <input type="text" name="tppTitle" /></label>
			<br /><br/>
			썸네일 사진	: <input type="file" name="upfile"><br /> 
			<br/>
			<p>프로젝트 시작일 :  <input type="text" id="date1" name="tpFundingStartDate" >       프로젝트 마감일 : <input type="text" id="date2" name="tpFundingLastDate" /></p>
			<br/> 
			<label>목표 후원 금액 : <input type="number" name="tpTargetAmount" /></label>

			<br /> 
			
			<br> 
			
			프로젝트 내용<br/>
			<textarea name="tppProjectContent" id="tppProjectContent" rows="10" cols="100" style="width: 766px; height: 412px; display: none;">
			에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면됩니다.
	  		</textarea>

			<br/> 
			<input type="button" id="ResultOut" value="데이터전송" />
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