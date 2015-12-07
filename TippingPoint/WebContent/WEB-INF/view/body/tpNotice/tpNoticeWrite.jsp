<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<script type="text/javascript" src="/TippingPoint/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
    <script type="text/javascript">
        $(document).ready(function(){
        	
       	 var oEditors = [];
       	 nhn.husky.EZCreator.createInIFrame({
       	  oAppRef: oEditors,
       	  elPlaceHolder: "tpNoticeContents",
       	  sSkinURI: "/TippingPoint/se2/SmartEditor2Skin.html",
       	  htParams : {
                 // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
                 bUseToolbar : true,             
                 // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
                 bUseVerticalResizer : true,     
                 // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
                 bUseModeChanger : true },
       	  fCreator: "createSEditor2"
        });
       //작성을 눌렀을시 Default값 확인
    	 $("#writeBtn").click(function(){
    			//제목 NUll 확인 여부
    	       	if(!$("#tpNoticeTitle").val()){
    	       		alert("제목을 입력해 주세요");
    	       		return false;
    	       	}
    			
    			//네이버 에디터 처리부분
    			oEditors.getById["tpNoticeContents"].exec("UPDATE_CONTENTS_FIELD", []);
    	         
    	        // 이부분에 에디터 validation 검증
    	        var saveConfirm =  confirm($("#tpNoticeContents").val());
    	        if(!saveConfirm){
    	        	return false;
    	        }else{
    	        	 //폼 submit
    		        $("#form").submit();
    	        
    	        }
    	 	});
        });  	 
    </script>


<div class="row">
	<div>
		<span>게시글 작성</span>
		<form id="form" method="post" action ="${initParam.rootPath }/noticeWrite.tp">
		<input type="text" id="tpNoticeTitle" name="tpNoticeTitle" class="wdp_90" placeholder="제목"/>
		<textarea rows="20" cols="100" title="내용" id="tpNoticeContents" name="tpNoticeContents" style="width: 766px; height: 412px; display: none;"></textarea>
		 
			<input type="button" id="writeBtn" value="작성하기">
	    </form>
    <br>
    <form name = "noticeList" action="${initParam.rootPath }/tpAdminNoticeManager.tp">
	  	<input type="submit" value="목록으로">
  	</form>
	</div>
</div>