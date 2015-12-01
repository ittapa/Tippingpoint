<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<script type = "text/javascript">
   
      function check() {
         var ck = document.cp1;
   
         if (ck.tppCategory.value=="") {
            alert("카테고리 값을 입력하세요");
            return false;
         }
         
         if (ck.tppCategoryName.value=="") {
             alert("카테고리 이름을 입력하세요");
             return false;
          }
      }
   
</script>


<form action="${initParam.rootPath}/insertCategory.tp" method="post" name="cp1">
	<table class="register">
		<tr>
			<td>카테고리 분류(영어)</td>
			<td><input type="text" name="tppCategory" id="tppCategory">
			</td>
		</tr>
		<tr>
			<td>카테고리 이름(한글)</td>
			<td><input type="text" name="tppCategoryName" id="tppCategoryName">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
			</td>
		</tr>
	</table>
</form>

</html>
