<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<script type="text/javascript">
$(document).ready(function loginCheck(){
	$("#passwordFindBtn").on("click", function(){
		var param = "findId" + "=" + $("#findPd").val() + "&" +"findEmail" + "="+ $("#findEmail").val();
		$.ajax({
			"url" : "/TippingPoint/sendpw.tp", //로그인 체크 컨트롤러
			"type" : "POST",
			"data" : param,// ID 및 password
			"dataType" : "text",//응답 데이터 타입 text,json,jsonp,xml
			"beforeSend":function(){// 아이디 공백체크
				if(!$("#findId").val()){
					alert("ID를 입력해 주세요");
					$("#findId").focus();
					return false;
				}
				if(!$("#findEmail").val()){
					alert("이메일을 입력해 주세요");
					$("#findEmail").focus();
					return false;
				}
			},
			"success" : function(txt){//로그인이 성공했는지 확인							
				if(txt=="success"){
					alert("비밀번호찾기 메일을 보냈습니다<br>메일을 확인해 주세요")
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

		<table class="login" border="1">
			<tr align="center">
				<td width="100">아이디</td>
				<td><input type="text" id="findId" name="findId" size="20" maxlength="20"></td>
			</tr>

			<tr align="center">
				<td>이메일 주소</td>
				<td><input type="text" id="findEmail" name="findEmail" size="20" maxlength="20"></td>
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