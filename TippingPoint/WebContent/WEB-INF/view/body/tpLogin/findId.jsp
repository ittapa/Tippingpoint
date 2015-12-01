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
	$("#idFindBtn").on("click", function(){
		var findPhoneNum = $("#findPhoneNum1").val()+"-"+ $("#findPhoneNum2").val()+"-"+$("#findPhoneNum3").val();
		var param = "findPhoneNum"+"="+ findPhoneNum + "&" +"findEmail" + "="+ $("#findEmail").val()
					+ "&" +"findBirth" + "="+ $("#findBirth").val()
		$.ajax({
			"url" : "/TippingPoint/mailId.tp", //아이디 찾기 메일 전송
			"type" : "POST",
			"data" : param,// ID 및 password
			"dataType" : "text",//응답 데이터 타입 text,json,jsonp,xml
			"beforeSend":function(){//공백체크
				if($("#findPhoneNum2").val().length<3 || $("#findPhoneNum3").val().length<4){
					alert("핸드폰 번호를 입력해 주세요");
					$("#findPhoneNum1").focus();
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
					alert("아이디찾기 메일을 보냈습니다. 메일을 확인해 주세요")
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
			<td>휴대폰번호</td>
			<td>
				<select name="findPhoneNum1" id="findPhoneNum1">
					<option value="010">010</option>
					<option value="011">011</option>
				</select>
				-
				<input type="text" name="findPhoneNum2" id="findPhoneNum2" maxlength="4"/>
				-
				<input type="text" name="findPhoneNum3" id="findPhoneNum3" maxlength="4"/>
				<input type="hidden" name="findPhoneNum" id="findPhoneNum"/>
			</td>
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
					<input type="button" value="아이디 찾기" id="idFindBtn">
				</td>
			</tr>
		</table>
	</form> 
</body>
</html>