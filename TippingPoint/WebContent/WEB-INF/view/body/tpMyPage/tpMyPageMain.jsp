<%@ page contentType="text/html;charset=UTF-8"%>


<P align="left">
	<FONT size="6"><B>${requestScope.tpfId } 님의 My 페이지</B></FONT>
</P>

<a href="${initParam.rootPath}/modifyForm.tp">회원정보 수정 </a>
<br />

<a href="${initParam.rootPath}/logout.tp"> LOGOUT </a>
<br />

<a href="${initParam.rootPath}/searchByWriterProject.tp">내가 등록한 프로젝트 목록</a>

<br />
<a href="${initParam.rootPath}/tpProposer.tp">추가정보입력</a>
<br />
