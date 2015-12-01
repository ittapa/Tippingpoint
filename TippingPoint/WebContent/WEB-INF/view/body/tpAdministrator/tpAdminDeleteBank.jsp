<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<form action="${initParam.rootPath}/deleteBank.tp" method="post" name="cp1">
	<table class="register">
		<label>삭제할 은행 이름 : <select name="bankKr"> <option value="null">삭제할 은행을 선택하세요</option>
		<c:forEach items="${requestScope.list }" var="tpBankList">
			<option value="${tpBankList.bankKr}" >${tpBankList.bankKr}</option>
		</c:forEach>
	</select></label>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="삭제">
			</td>
		</tr>
	</table>
</form>

</html>
