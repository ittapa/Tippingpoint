<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<script type = "text/javascript">
   
      function check() {
         var ck = document.cp1;
     
         if (ck.bankEr.value=="") {
             alert("은행의 영문이름을 입력하세요");
             return false;
          }
         
         if (ck.code.value == "") {
        	 alert("은행 코드를 입력하세요");
        	 return false;
         }
         
         if (ck.updateBank.value="") {
        	 alert("은행 정보를 입력하세요");
        	 return false;
         }
      }
   
</script>

<form action="${initParam.rootPath}/updateBank.tp" method="post" name="cp1">
	<table class="register">
	<label>수정할 은행 이름 : <select name="updateBank"> <option value="null">삭제할 은행을 선택하세요</option>
		<c:forEach items="${requestScope.list }" var="tpBankList">
			<option value="${tpBankList.bankKr}" >${tpBankList.bankKr}</option>
		</c:forEach>
	</select></label>
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
			<td>은행 코드 </td>
			<td><input type = "text" name = "code" id = "code">
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
</form>

</html>
