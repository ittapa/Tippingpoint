<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<form action="${initParam.rootPath}/deleteCategory.tp" method="post" name="cp1">
	<table class="register">
	<label>삭제할 카테고리 이름 : <select name="tppCategoryName"> <option value="null">카테고리를 선택하세요</option>
		<c:forEach items="${requestScope.list }" var="tpProjectCategory">
			<option value="${tpProjectCategory.tppCategoryName}" >${tpProjectCategory.tppCategoryName}</option>
		</c:forEach>
	</select></label>
		<input type="submit" value="삭제">
	</table>
</form>

</html>
