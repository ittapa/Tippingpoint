<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8 ">
<title>Insert title here</title>
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
</head>
<body>

<!-- 프로젝트 등록  -->

   <h2>관리자 로그인페이지</h2>
   
   <form name = "tp1" action="/TippingPoint/tpAdminLogin.tp" method="post" onsubmit="return check();">
  
      <label>아이디 : <input type = "text" name = "adminId" /></label><p>
      <label>비밀번호: <input type = "password" name = "adminPw"/></label><p>
   
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type = "submit" value = "로그인">
   </form>
</body>
</html>