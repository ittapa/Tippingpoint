<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>로그인</title>
<style>

/* to.do  로그인 테이블 위치 보류*/
table.login {
 }
</style>


<script type="text/javascript">
var unLogin = "<%=request.getAttribute("unLogin")%>";
	if(unLogin == "unLogin"){
		alert("로그인이 필요한 페이지 입니다.")
	}


<%session.setAttribute("backpage", request.getHeader("referer"));%>
var referrer = document.referrer;


function loginSuccess(){
			//location.href = document.referrer;
			$("#form").submit();
		}
		
$(document).ready(function(){//

			$("#registerBtn").on("click", function(){
				location.href="/TippingPoint/tpfunder/registerForm.tp"  // 페이지 이동...
			});
			
			$("#idFindBtn").on("click", function(){
				location.href="/TippingPoint/tpLogin/findId.tp"  // 페이지 이동...
			});
			$("#passwordFindBtn").on("click", function(){
				location.href="/TippingPoint/tpLogin/findPassword.tp"  // 페이지 이동...
			});
			
			$("#loginBtn").on("click", function(){
				var param = "tpfId" + "=" + $("#id").val() + "&" +"tpfPw" + "="+ $("#pw").val();
				$.ajax({
					"url" : "/TippingPoint/loginCheck.tp", //로그인 체크 컨트롤러
					"type" : "POST",
					"data" : param,// ID 및 password
					"dataType" : "text",//응답 데이터 타입 text,json,jsonp,xml
					"beforeSend":function(){//공백체크
						if(!$("#id").val()){
							alert("ID를 입력해 주세요");
							$("#id").focus();
							return false;
						}
						if(!$("#pw").val()){
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
		
				});
			});
});
	
		

		
</script>

		  <div class="login-bg">
        <div class="container">
            <div class="form-wrapper">
            <form name="form" id = "form" method="post" 
					 	action ="${initParam.rootPath }/loginProcess.tp" class="form-signin wow fadeInUp" >
        
            <h2 class="form-signin-heading">sign in now</h2>
            <div class="login-wrap">
                <input type="text" class="form-control" placeholder="User ID" autofocus id="id" name="tpfId" maxlength="20">
                <input type="password" class="form-control" placeholder="Password" id="pw" name="tpfPw" maxlength="15" >
                <label class="checkbox">
                     <span class="pull-right">
                     	<a data-toggle="modal"  id="idFindBtn" > 아이디 까먹었니?</a>
                     	<br/>
                        <a data-toggle="modal"  id="passwordFindBtn" > 비밀번호 까먹었니?</a>
        				<br/><br/>
                    </span>
                </label>
                <button class="btn btn-lg btn-login btn-block" type="button" id="loginBtn">Sign in</button>
               
               
                <div class="registration">
                    아직 티핑포인트 계정없니?
                    <a class="" id="registerBtn">
                        고럼 만들어야지
                    </a>
                </div>
            </div>

          </form>
          </div>
        </div>
    </div>
					 