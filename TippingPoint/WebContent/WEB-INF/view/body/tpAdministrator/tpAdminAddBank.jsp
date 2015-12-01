<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<script type = "text/javascript">
   
      function check() {
         var ck = document.cp1;
   
         if (ck.bankKr.value=="") {
            alert("은행의 한글이름을 입력하세요");
            return false;
         }
         
         if (ck.bankEr.value=="") {
             alert("은행의 영문이름을 입력하세요");
             return false;
          }
         
         if (ck.code.value == "") {
        	 alert("은행 코드를 입력하세요");
        	 return false;
         }
      }
   
</script>


<form action="${initParam.rootPath}/insertBank.tp" method="post" name="cp1">
	<table class="register">
		<tr>
			<td>은행 이름 한글</td>
			<td><input type="text" name="bankKr" id="bankKr">
			</td>
		</tr>
		<tr>
			<td>은행 이름 영문</td>
			<td><input type="text" name="bankEr" id="bankEr">
			</td>
		</tr>
		<tr>
			<td>은행 코드</td>
			<td><input type = "text" name = "code" id = "code">			
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
			</td>
		</tr>
	</table>
</form>

</html>
