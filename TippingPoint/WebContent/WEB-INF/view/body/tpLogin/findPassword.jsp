<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() { //생년월일 찾기
      $("#findBirth").datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat : "yy-mm-dd",
        yearRange : "1900:c",
        monthNamesShort: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ]
      });
});
</script>
<script type="text/javascript">
$(document).ready(function loginCheck(){
	$("#passwordFindBtn").on("click", function(){
		var param = "findId" + "=" + $("#findId").val() + "&" +"findEmail" + "="+ $("#findEmail").val() + "&" +"findName" + "="+ $("#findName").val() 
					+ "&" +"findBirth" + "="+ $("#findBirth").val()
		$.ajax({
			"url" : "/TippingPoint/mailPw.tp", //비밀번호 메일 전송
			"type" : "POST",
			"data" : param,// ID 및 password
			"dataType" : "text",//응답 데이터 타입 text,json,jsonp,xml
			"beforeSend":function(){//공백체크
				if(!$("#findId").val()){
					alert("ID를 입력해 주세요");
					$("#findId").focus();
					return false;
				}
				if(!$("#findName").val()){
					alert("이름을 입력해 주세요");
					$("#findName").focus();
					return false;
				}
				if(!$("#findEmail").val()){
					alert("이메일을 입력해 주세요");
					$("#findEmail").focus();
					return false;
				}
				if(!$("#findBirth").val()){
					alert("생년월일을 입력해 주세요");
					$("#findEmail").focus();
					return false;
				}
			},
			"success" : function(txt){//로그인이 성공했는지 확인							
				if(txt=="success"){
					alert("비밀번호찾기 메일을 보냈습니다. 메일을 확인해 주세요")
					$("#form").submit();//성공하면 세션생성및 로그인!
				}else{
					alert(txt);
					return false;
				}	
			},
			"error" : function(){
					alert("잘못된 접근입니다."); 
			}

		});
	});
});	

</script>
<body>
	<form name="form" id = "form" method="post" action ="${initParam.rootPath }/tpLogin/tpLoginPage.tp">

		<table border="1">
			<tr align="center">
				<td width="100">아이디</td>
				<td><input type="text" id="findId" name="findId" size="20" maxlength="20"></td>
			</tr>

			<tr align="center">
				<td>이름</td>
				<td><input type="text" id="findName" name="findName" size="20" maxlength="20"></td>
			</tr>
			<tr align="center">
				<td>이메일 주소</td>
				<td><input type="text" id="findEmail" name="findEmail" size="20" maxlength="20"></td>
			</tr>
			<tr align="center">
				<td>생년월일</td>
				<td><input type="text" id="findBirth" name="findBirth" size="20" maxlength="20"></td>
			</tr>

			<tr>
				<td colspan="2" align="center" height="30">
					<input type="button" value="비밀번호 이메일 전송" id="passwordFindBtn">
				</td>
			</tr>
		</table>
	</form> 
</body>
</html>