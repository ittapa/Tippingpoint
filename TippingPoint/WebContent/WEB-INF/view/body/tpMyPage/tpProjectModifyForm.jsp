<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<%@page import ="kr.pe.tippingpoint.vo.TpProject" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 
<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>
	
	<style type = "text/css">
	.error{
	color: red;
	
	}
</style>

   <script type="text/javascript">
$(document).ready(function(){

	
	//네이버 에디터 textarea 수정
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
		
			//id 중복확인여부
	/*        	if($("#idCheck").val() !="O"){
	       		alert("프로젝트 ID 중복확인을 하시기 바랍니다.");
	       		return false;
	       	} 수정에서는 ID값은 고정*/
		
			//시작일 입력여부

			if(!$("#date1").val()){
			alert("프로젝트 시작일을 입력하시기 바랍니다.");
			return false
			}
			
			//마감일 입력여부
		
			if(!$("#date2").val()){
				alert("프로젝트 마감일을 입력하시기 바랍니다.");
				return false
			}
			
			//목표금액 입력여부
			if(!$("#tppTargetAmount").val()){
				alert("목표금액을 입력하시기 바랍니다.");
				return false;
			}
			
			
			//네이버 에디터 처리부분
			oEditors.getById["tppProjectContent"].exec("UPDATE_CONTENTS_FIELD", []);
			document.getElementById("tppState").value = "A";
	        // 이부분에 에디터 validation 검증
	       var saveConfirm =  confirm("프로젝트를 저장하시겠습니까?");
	        
	        if(!saveConfirm){
	        	return false;
	        	
	        }else{
	        	 //폼 submit
		        $("#tpProjectForm").submit();
	        }

	       

		 
	 });
	 // 승인요청을 눌렀을시
	 $("#projectSubmit").click(function(){

		
		
			//시작일 입력여부

			if(!$("#date1").val()){
			alert("프로젝트 시작일을 입력하시기 바랍니다.");
			return false
			}
			
			//마감일 입력여부
		
			if(!$("#date2").val()){
				alert("프로젝트 마감일을 입력하시기 바랍니다.");
				return false
			}
			
			//목표금액 입력여부
			if(!$("#tppTargetAmount").val()){
				alert("목표금액을 입력하시기 바랍니다.");
				return false;
			}
		 
		 
		 //id가 smarteditor인 textarea에 에디터에서 대입
		        oEditors.getById["tppProjectContent"].exec("UPDATE_CONTENTS_FIELD", []);
		        //document.getElementByName("tppState").value;
		     
		        // 이부분에 에디터 validation 검증
		       var submitConfirm= confirm("내용 수정 및 관리자에게 프로젝트 승인요청을 하시겠습니까?"); 
		            
		       if(!submitConfirm){
		        	return false;
		        }else{
		       	var tppStateValue = document.getElementById("tppState").value;
				if(tppStateValue =='O'){
					
				}else{
		       	tppStateValue = "B";
				}
		       	alert(tppStateValue);
		        	
		        //폼 submit
		        $("#tpProjectForm").submit();
		        }
			 	
		 });
	 
	 //메인이미지 삭제
		var defaultImg = "/TippingPoint/defaultImg/tpProjectDefault.png"
			$("#tppMainImgDelete").on("click", function(){
				/* if(!$("#upfile").val()){
					alert("추가된 이미지가 없습니다.");
					return false;
				} */
				
				var imgconfimr = confirm("메인이미지를 기본이미지로 변경합니다.");
				if(imgconfimr){
					$("#upfile").val("");
					document.getElementById('imgView').src=defaultImg;
				}else{
					return false
				}
			});
	 
	 //이미지 되돌리기
	 var originImag =  '<%=((TpProject)request.getAttribute("tpProject")).getTppMainImg()%>';
	 		$("#tppMainImgOrigin").on("click", function(){
	 			$("#upfile").val("");
				document.getElementById('imgView').src=originImag;
	 			
	 		});
	 
		
	 
	//프로젝트아이디 중복확인 안함 수정이라서
					/*  $("#tppIdCheck").on("click",function(){ 
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
									document.getElementById("idCheck").value = "O";
									alert("사용 가능한 아이디입니다.");
									
								}else{
									alert("중복입니다.");
								}
							
							},
							error: function(){
								alert("에러");
							}
						});
					}); */
	}); //document.ready
	
</script>

	<!-- 프로젝트 등록  -->

	<P align="left">
			<FONT size="5"><B>프로젝트 등록</B></FONT>
	</P>
	

	
	
	<spring:hasBindErrors name="tpProject"/>
	<form action="modifyTpProject.tp" method="post" id ="tpProjectForm"
		enctype="multipart/form-data">

		<input type = "hidden" value = "${requestScope.errorCheck }" id = "errorCheck"/>
		
		<script type="text/javascript">
		if($("#errorCheck")){
			 if($("#errorCheck").val() == "submitError"){
				 alert("프로젝트 승인요청 실패");
			 }else if( $("#errorCheck").val() == "saveError"){
				 alert("프로젝트 저장요청 실패");
			 }
		}
		</script>	
			
		<label>프로젝트 ID  : <input type="text" name="tppId" id = "tppId" value ='${requestScope.tpProject.tppId }' readonly="readonly"></label>
<!-- 		<input type = "hidden" value = "X" name = "idCheck" id = "idCheck"/>
		<input type = "button" value = "ID중복 체크" id = "tppIdCheck"/> ID는 한번 정한대로-->
		
		<br/>
		<span class="error"><form:errors path = "tpProject.tppId" delimiter = " | "/></span>
		<br /> <br/>
			<label>프로젝트 제목 : <input type="text" name="tppTitle" value = '${requestScope.tpProject.tppTitle }'/></label>
			<span class="error"><form:errors path = "tpProject.tppTitle" delimiter = " | "/></span>
			<br /><br/>
			
			<!-- 카테고리 -->
			<label>카테고리 :
			<select name="tppCategory" selected = "${list.tppCategory }">
			<option  value= "null">카테고리를 선택하세요</option>
			<c:choose>
				<c:when test="${fn:length(requestScope.categoryList)==0 }">
					<option value = null>카테고리 정보를 가져오지 못했습니다.</option>
				</c:when>
			
				<c:otherwise>
					${requestScope.tpProject.tppCategory }
					<c:forEach items="${requestScope.categoryList }" var="list">
							<option  value= "${list.tppCategory }" 
							${list.tppCategory==requestScope.tpProject.tppCategory ? 'selected="selected"' : '' }>
							${list.tppCategoryName }
							</option>
					</c:forEach>
				</c:otherwise>
			</c:choose>	
			</select>
			<span class="error"><form:errors path = "tpProject.tppCategory" delimiter = " | "/></span>
			
			<br/>
			<br/>
			<div>
			<img src ="${requestScope.tpProject.tppMainImg }" width="200" id = "imgView" name = "imgView"><br/>
			대표 이미지<br/>
			<input type = "hidden" name = "tppMainImg" value = "${requestScope.tpProject.tppMainImg }" >
			<div class= "mainImagfileBox">
				<label >
					사진 업로드	<input type="file" name="upfile"  id = "upfile"  onchange ="imgChange(this);">
					<br />대표이미지는 가로/세로 300px이하를 권장합니다.
			<br/>
				</label>
				<input type ="button" id = "tppMainImgDelete" value = "기본 이미지">
				<input type ="button" id = "tppMainImgOrigin" value = "원래 이미지">
			</div>
			<script type="text/javascript">
			function imgChange(evt) {
				alert("대표 이미지를 업로드합니다.");
				var tgt = evt.target || window.event.srcElement,
		   		 files = tgt.files;

				    // 파일리더를 지원하는 경우
				    if (FileReader && files && files.length) {
				        var fr = new FileReader();
				        fr.onload = function () {
				            document.getElementById('imgView').src = fr.result;
				        }
				        fr.readAsDataURL(files[0]);
				    }
				
				    // Not supported 아닌경우 아이프레임..ㅠㅠ
				    else {
				        // fallback -- perhaps submit the input to an iframe and temporarily store
				        // them on the server until the user's session ends.
				    }
				} //imgChange function 종료
			</script>
			 
			 
			  <script>
				//날짜 깞 처리 
			  $(function() {
					    $("#date1, #date2").datepicker({
					      changeMonth: true,
					      changeYear: true,
					      dateFormat : "yymmdd",
					      yearRange : "1900:c+1"
					    });
					  });
				
			  </script>
			
			  
			<p>프로젝트 시작일 :  <input type="text" id="nono" name="tppFundingStartDate"  readonly="readonly" value = '${requestScope.tpProject.tppFundingStartDate }'> 
				<span class="error"><form:errors path = "tpProject.tppFundingStartDate" delimiter = " | "/></span>
					
					<br/>
					<br/>
				프로젝트 마감일 : <input type="text" id="date2" name="tppFundingLastDate" id ="tppFundingLastDate" readonly="readonly" value = '${requestScope.tpProject.tppFundingLastDate }'/>
				<span class="error"><form:errors path = "tpProject.tppFundingLastDate" delimiter = " | "/></span>
				</p>
			<br/> 
			<label>목표 후원 금액 : <input type="number" name="tppTargetAmount" id = "tppTargetAmount" value = "${requestScope.tpProject.tppTargetAmount }" />
			<br/>
			<span class="error"><form:errors path = "tpProject.tppTargetAmount" delimiter = " | "/></span>
		
			<br /> 
			
			<br> 
			
			프로젝트 내용<br/>
			<span class="error"><form:errors path = "tpProject.tppProjectContent" delimiter = " | "/></span>
			<br/>
			<textarea name="tppProjectContent" id="tppProjectContent" rows="10" cols="100" style="width: 766px; height: 412px; display: none;">
			${requestScope.tpProject.tppProjectContent }
			 </textarea>
			<br/> 
	
		
			<!-- //승인요청 a:저장, b: 승인요청,o:승인완료, x승인거부 
								디폴트값 a  승인요청b  승인요청 취소시 다시 a로  삭-->
			
			<br>
			프로젝트 현재 상태 :
			<input type = "hidden" id = "tppState" name = "tppState" value = "${requestScope.tpProject.tppState }"/>
			<c:choose>
				<c:when test = "${requestScope.tpProject.tppState =='A' }">
				저장<br/><br/>
					<input type="button" id="save" value="저장" /> 
					<input type="button" id="projectSubmit" value="승인요청" />
				</c:when>
				
				<c:when test = "${requestScope.tpProject.tppState =='B' }">
				승인요청<br/>
						<input type="button" id="projectSubmit" value="내용 수정" />
						<input type="button" id="save" value="승인요청 취소" /><br/>
						승인 요청취소 시 저장상태로 변경됩니다.
				</c:when>
				
				<c:when test = "${requestScope.tpProject.tppState =='O' }">
				승인완료<bt/>
						<input type="button" id="projectSubmit" value="내용 수정" />
				</c:when>
				
				<c:when test = "${requestScope.tpProject.tppState =='X' }">
				승인거부
					<input type="button" id="save" value="저장" /> 
					<input type="button" id="projectSubmit" value="재승인요청" />
				</c:when>
				<c:when test = "${requestScope.tpProject.tppState =='E' or requestScope.tpProject.tppState =='Z'}">
				펀딩종료
				</c:when>
			</c:choose>
		<br/><br/>
			</form>
		
			
		

			
			
			


