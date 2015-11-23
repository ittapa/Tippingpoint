<%@ page contentType="text/html;charset=UTF-8"%>

<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>


   <script type="text/javascript">
$(document).ready(function(){
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
	 
	 //저장을 눌렀을시 디폴트값인 
	 $("#save").click(function(){
		//id가 smarteditor인 textarea에 에디터에서 대입
	        oEditors.getById["tppProjectContent"].exec("UPDATE_CONTENTS_FIELD", []);
	         
	        // 이부분에 에디터 validation 검증
	        alert(document.getElementById("tppProjectContent").value); 

	        //폼 submit
	        $("#tpProjectForm").submit();

		 
	 });
	 // 승인요청을 눌렀을시
	 $("#projectSubmit").click(function(){
			//id가 smarteditor인 textarea에 에디터에서 대입
		        oEditors.getById["tppProjectContent"].exec("UPDATE_CONTENTS_FIELD", []);
		        //document.getElementByName("tppState").value;
		        document.getElementById("tppState").value = 'b';
		        // 이부분에 에디터 validation 검증
		        alert(document.getElementById("tppProjectContent").value); 

		        //폼 submit
		        $("#tpProjectForm").submit();

			 
		 });
	 
	$("#tppIdCheck").on("click",function(){ //아이디 중복확인
		$.ajax({
			url:"${initParam.rootPath}/tppIdDuplicatedCheck.tp",
			type:"GET",
			data:{tppId:$("#tppId").val()},
			dataType:"JSON",
			beforeSend:function(){
				if(!$("#tppId").val()){
					alert("id를 입력하세요");
					$("#tppId").focus();
					return false;
				}
	
			},
			success:function(txt){
				if(txt==false){
					alert("가능한 아이디입니다.");
				}else{
					alert("중복입니다.");
				}
			
			},
			error: function(){
				alert("에러");
			}
		});
	});
	}); //document.ready
	
</script>

	<!-- 프로젝트 등록  -->

	<P align="left">
			<FONT size="5"><B>프로젝트 등록</B></FONT>
	</P>
	<form action="submitTpProject.tp" method="post" id ="tpProjectForm"
		enctype="multipart/form-data">
		<label>프로젝트 ID  : <input type="text" name="tppId" id = "tppId"/></label><input type = "button" value = "ID중복 체크" id = "tppIdCheck"/>
		<br /> <br/>
			<label>프로젝트 제목 : <input type="text" name="tppTitle" /></label>
			<br /><br/>
			<label>카테고리 : 
			<select name="tppCategroy" >
			<option  value= "game">게임</option>
			<option  value= "startup">창업</option>
			<option  value= "donation">기부</option>
			<option  value= "business">사업</option>
			<option  value= "publish">출판</option>
			<option  value= "etc">기타</option>
			</select>
			
			<br/>
			<br/>
			썸네일 사진	: <input type="file" name="upfile"><br /> 
			<br/>
			
			  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
			  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
			  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
			 <link rel="stylesheet" href="/resources/demos/style.css">
			 
			  <script>
				//날짜 깞 처리 
			  $(function() {
					    $("#date1, #date2").datepicker({
					      changeMonth: true,
					      changeYear: true,
					      dateFormat : "yy-mm-dd",
					      yearRange : "1900:c"
					    });
					  });
				
			  </script>
			
			  
			<p>프로젝트 시작일 :  <input type="text" id="date1" name="tppFundingStartDate" > 
					<br/>
				프로젝트 마감일 : <input type="text" id="date2" name="tppFundingLastDate" /></p>
			<br/> 
			<label>목표 후원 금액 : <input type="number" name="tppTargetAmount" /></label>
		
			<br /> 
			
			<br> 
			
			프로젝트 내용<br/>
			<textarea name="tppProjectContent" id="tppProjectContent" rows="10" cols="100" style="width: 766px; height: 412px; display: none;">
			에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면됩니다.
	  		</textarea>

			<br/> 
			<!-- //승인요청 a:저장, b: 승인요청,o:승인완료, x승인거부 
								디폴트값 a  승인요청b  승인요청 취소시 다시 a로  삭-->
			
			<input type = "hidden" id = "tppState" name = "tppState" value = "a"/>
			<input type="button" id="save" value="저장" />
			
			<input type="button" id="projectSubmit" value="승인요청" />
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
