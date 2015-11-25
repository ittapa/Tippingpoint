<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		<!-- Header -->
		<div id="header">
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/">Home</a></li>
					
					
					<c:if test="${sessionScope.userLoginInfo == null }">
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpfunder/registerForm.tp">SIGN UP</a></li>
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpLogin/tpLoginPage.tp">LOGIN</a></li>
					</c:if>
					
					
					<c:if test="${sessionScope.userLoginInfo != null }">
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/myPageMain.tp">My Page</a></li>
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/logout.tp">LOGOUT</a></li>
					</c:if>
					
					
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpProjectRegisterForm.tp">프로젝트 등록하기</a></li>
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpProjectBoard.tp">프로젝트 둘러보기</a></li>
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpNoticeBoard.tp">NOITCE</a></li>
					<!-- 검색 -->
					<br/><br/>
					<form action="${initParam.rootPath}/tpProjectSearching.tp" method="post" >
						<input type="text" name="keyWord">
						<input type="submit" value="Serch">
					</form>
					<!-- @TODO: 적절한 CSS를 적용할 예정입니다. -->
					<!-- li style="white-space: nowrap;">
						<form action="${initParam.rootPath}/tpProjectSerching.tp" method="post">
						<input type="text" name="keyWord">
						<input type="submit" value="Serch">
					</form></li -->
					<!--// 검색 -->
				</ul>
			</nav>
	</div>

