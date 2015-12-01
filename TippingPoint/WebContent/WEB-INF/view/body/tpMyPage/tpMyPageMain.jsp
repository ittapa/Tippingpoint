<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<P align="left">
	<FONT size="6"><B>${requestScope.tpfId } 님의 My 페이지</B></FONT>
</P>

<a href="${initParam.rootPath}/modifyForm.tp">회원정보 수정 </a>
<br />

<a href="${initParam.rootPath}/logout.tp"> LOGOUT </a>
<br />

<a href="${initParam.rootPath}/searchByWriterProject.tp">내가 등록한 프로젝트 목록</a>
<br/>
<a href = "${initParam.rootPath}/">내가 결제한 프로젝트 목록[미구현]</a>

<br />

<c:choose>

	<c:when test="${requestScope.num == 0 }">
		<a href="${initParam.rootPath}/tpProposer.tp">추가정보 수정</a>
	</c:when>
	<c:otherwise>
		<a href="${initParam.rootPath}/tpProposer.tp">추가정보 입력</a>
	</c:otherwise>

</c:choose>	
<br />
