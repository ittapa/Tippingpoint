<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<form action="${initParam.rootPath}/updateCategory.tp" method="post" name="cp1">
	<table class="register">
		<label>수정할 카테고리 이름 : <select name="updateCategory"> <option value="null">카테고리를 선택하세요</option>
		<c:forEach items="${requestScope.list }" var="tpProjectCategory">
			<option value="${tpProjectCategory.tppCategoryName}" >${tpProjectCategory.tppCategoryName}</option>
		</c:forEach>
	</select></label>
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
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
</form>

</html>
