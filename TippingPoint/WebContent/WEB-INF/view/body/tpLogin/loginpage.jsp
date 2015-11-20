<%@ page contentType="text/html;charset=UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
table.login {
    margin-left: auto;
    margin-right: auto;
}
</style>
<script type="text/javascript" src="/TippingPoint/script/jquery.js"></script>
<script type="text/javascript">

function loginSuccess(){
	
	$("#form").submit();
}

$(document).ready(function loginCheck(){
	$("#loginBtn").on("click", function(){
		var param = "tpfId" + "=" + $("#id").val() + "&" +"tpfPw" + "="+ $("#pw").val();
		$.ajax({
			"url" : "/TippingPoint/loginCheck.tp", //로그인 체크 컨트롤러
			"type" : "POST",
			"data" : param,// ID 및 password
			"dataType" : "text",//응답 데이터 타입 text,json,jsonp,xml
			"beforeSend":function(){// 아이디 공백체크
				if(!$("#id").val()){
					alert("ID를 입력해 주세요");
					$("#id").focus();
					return false;
				}
				if(!$("#pw").val()){// 비밀번호 공백체크
					alert("비밀번호를 입력해 주세요");
					$("#pw").focus();
					return false;
				}
				
			},
			"success" : function(txt){//로그인이 성공했는지 확인							
				if(txt=="success"){
					loginSuccess();//성공하면 세션생성및 로그인!
				}else{
					alert(txt);
					return false;
				}	
			},
			"error" : function(){
					alert("잘못된 접근입니다."); 
			}

		})
	});
});	
$(document).ready(function goRegister(){//
	$("#registerBtn").on("click", function(){
		location.href="/TippingPoint/tpfunder/register_form.tp"  // 페이지 이동...
	});
});

	
</script>
</head>
<body>
	<br>
	<form name="form" id = "form" method="post" action ="${initParam.rootPath }/loginProcess.tp">
		<P align="center">
			<FONT size="6"><B>로그인 페이지</B></FONT>
		</P>
		<table class="login" border="1">
			<tr align="center">
				<td width="100">아이디</td>
				<td><input type="text" id="id" name="tpfId" size="12" maxlength="20"></td>
			</tr>

			<tr align="center">
				<td>비밀번호</td>
				<td><input type="password" id="pw" name="tpfPw" size="12" maxlength="15"></td>
			</tr>

			<tr>
				<td colspan="2" align="center" height="30">
					<input type="button" value="로그인" id="loginBtn"> 
					<input type="button" value="회원 가입" id="registerBtn">
					<input type="button" value="비밀번호 찾기" id="passwordCheckBtn">
				</td>
			</tr>
		</table>
	</form> 
</body>
</html>