<%@ page contentType="text/html;charset=UTF-8"%>
<!-- Header 영역  -->
&nbsp;
<a href="${initParam.rootPath}/main.tp"> MAIN </a>
&nbsp;
<a href="${initParam.rootPath}/tpfunder/registerForm.tp"> SIGN UP </a>
&nbsp;
<a href="${initParam.rootPath}/tpLogin/tpLoginPage.tp"> LOGIN </a>


<br />
&nbsp;
	<form action = "${initParam.rootPath}/tpProjectSerching.tp" method = "post">
		<input type ="text" name = "keyWord">
		<input type = "submit" value = "Serch">
	</form>
&nbsp;
<a href="/TippingPoint/tpProjectRegister.tp"> 프로젝트 등록하기</a>&nbsp;
<a href="/TippingPoint/tpProjectBoard.tp?pageNo=${param.pageNo }">프로젝트 둘러보기</a>&nbsp;
<a href="/TippingPoint/tpNoticeBoard.tp?pageNo=${param.pageNo }">NOITCE</a>&nbsp;
<br />
