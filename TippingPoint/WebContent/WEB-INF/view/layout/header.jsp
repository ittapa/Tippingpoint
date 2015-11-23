
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Tipping Point</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="${initParam.rootPath}/static/css/ie/html5shiv.js"></script><![endif]-->
		<script src="${initParam.rootPath}/static/js/jquery.min.js"></script>
		<script src="${initParam.rootPath}/static/js/jquery.dropotron.min.js"></script>
		<script src="${initParam.rootPath}/static/js/jquery.scrolly.min.js"></script>
		<script src="${initParam.rootPath}/static/js/jquery.onvisible.min.js"></script>
		<script src="${initParam.rootPath}/static/js/skel.min.js"></script>
		<script src="${initParam.rootPath}/static/js/skel-layers.min.js"></script>
		<script src="${initParam.rootPath}/static/js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="${initParam.rootPath}/static/css/skel.css" />
			<link rel="stylesheet" href="${initParam.rootPath}/static/css/style.css" />
			<link rel="stylesheet" href="${initParam.rootPath}/static/css/style-desktop.css" />
			<link rel="stylesheet" href="${initParam.rootPath}/static/css/style-noscript.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="${initParam.rootPath}/static/css/ie/v8.css" /><![endif]-->
	</head>
	<body class="no-sidebar">
	<div id="page-wrapper">

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
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpProjectBoard.tp?pageNo=${param.pageNo }">프로젝트 둘러보기</a></li>
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpNoticeBoard.tp?pageNo=${param.pageNo }">NOITCE</a></li>
					<!-- 검색 -->
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





