<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <script type = "text/javascript">
   
      function check() {
         var ck = document.tp1;
   
         if (ck.adminId.value=="") {
            alert("ID를 입력하세요");
            return false;
         }
         
         if (ck.adminPw.value=="") {
             alert("비밀번호를 입력하세요");
             return false;
          }
      }
   
</script>

		
     <div class="login-bg">
        <div class="container">
            <div class="form-wrapper">
            <form name = "tp1" action="/TippingPoint/tpAdminLogin.tp" method="post" onsubmit="return check();"
					 	class="form-signin wow fadeInUp" >
        
            <h2 class="form-signin-heading">ADMIN ACCESS</h2>
            <div class="login-wrap">
                <input type="text" class="form-control" placeholder="User ID" autofocus name = "adminId" maxlength="20">
                <input type="password" class="form-control" placeholder="Password" name = "adminPw" maxlength="15" >
        
                <button class="btn btn-lg btn-login btn-block" type="submit">Sign in</button>
               
               
    
            </div>

          </form>
          </div>
        </div>
    </div>


  
</html>