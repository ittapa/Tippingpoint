<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header 영역  -->
<!-- login 전 -->
<c:if test="${sessionScope.userLoginInfo == null }">
&nbsp;
<a href="${initParam.rootPath}/main.tp"> MAIN </a>
&nbsp;
<a href="${initParam.rootPath}/tpfunder/registerForm.tp"> SIGN UP </a>
&nbsp;
<a href="${initParam.rootPath}/tpLogin/tpLoginPage.tp"> LOGIN </a>
</c:if>

<!-- login 후  -->
<c:if test="${sessionScope.userLoginInfo != null }">
&nbsp;
<a href="${initParam.rootPath}/main.tp"> MAIN </a>
&nbsp;
<a href="${initParam.rootPath}/tpMypage/ex.tp"> My Page </a>
&nbsp;
<a href="${initParam.rootPath}/logout.tp"> LOGOUT </a>
</c:if>

<br />

<br />
&nbsp;
<a href="${initParam.rootPath}/아직한발남았따"> 검색하기 </a>
&nbsp;
<a href="/TippingPoint/tpProjectRegister.tp"> 프로젝트 등록하기</a>&nbsp;
<a href="/TippingPoint/tpProjectBoard.tp?pageNo=${param.pageNo }">프로젝트 둘러보기</a>&nbsp;
<a href="/TippingPoint/tpNoticeBoard.tp?pageNo=${param.pageNo }">NOITCE</a>&nbsp;
<br />
