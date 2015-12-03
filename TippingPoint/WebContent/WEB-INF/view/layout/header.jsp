<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--header start-->
	<header class="head-section">
		<div class="navbar navbar-default navbar-static-top container">
			<div class="navbar-header">
				<button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse" type="button">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${initParam.rootPath}/">Tipping<span>Point</span></a>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${initParam.rootPath}/">HOME</a></li>

<c:choose>
	<c:when test="${sessionScope.userLoginInfo == null}">
					<li><a href="${initParam.rootPath}/tpfunder/registerForm.tp">SIGN UP</a></li>
					<li><a href="${initParam.rootPath}/tpLogin/tpLoginPage.tp">LOGIN</a></li>
	</c:when>

	<c:otherwise>
					<li class="dropdown">
						<a class="dropdown-toggle" data-close-others="false" data-delay="0" data-hover="dropdown" data-toggle="dropdown" href="${initParam.rootPath}/myPageMain.tp">My Page <i class="fa fa-angle-down"></i></a>
				
						<ul class="dropdown-menu">
						<!--// 로그인시 회원관련 -->
							<li><a href="${initParam.rootPath}/logout.tp"> LOGOUT </a></li>
							<li><a href="${initParam.rootPath}/modifyForm.tp">회원정보 수정 </a></li>
							<li><a href="${initParam.rootPath}/searchByWriterProject.tp">내가 등록한 프로젝트 목록</a></li>
							<li><a href = "${initParam.rootPath}/">내가 결제한 프로젝트 목록[미구현]</a></li>
							<li><a href="${initParam.rootPath}/tpProposer.tp">제안자 정보 입력 및 수정</a></li>
							
						</ul>
					</li>
	</c:otherwise>
</c:choose>
					<li><a href="${initParam.rootPath}/tpProjectRegisterForm.tp">프로젝트 등록하기</a></li>

					<li class="dropdown">
						<a class="dropdown-toggle" data-close-others="false" data-delay="0" data-hover="dropdown" data-toggle="dropdown" href="${initParam.rootPath}/tpProjectBoard.tp">프로젝트 둘러보기 <i class="fa fa-angle-down"></i></a>
					<!-- TODO 프로젝트 카테고리 자동출력-->
						<ul class="dropdown-menu">
							<li><a href="${initParam.rootPath}/tpProjectBoard.tp">모두보기</a></li>
							<li><a href="${initParam.rootPath}/tpProjectCategoryBoard.tp?&tppCategory=game">게임</a></li>
							<li><a href="${initParam.rootPath}/tpProjectCategoryBoard.tp?&tppCategory=startup">창업</a></li>
							<li><a href="${initParam.rootPath}/tpProjectCategoryBoard.tp?&tppCategory=donation">기부</a></li>
							<li><a href="${initParam.rootPath}/tpProjectCategoryBoard.tp?&tppCategory=business">사업</a></li>
							<li><a href="${initParam.rootPath}/tpProjectCategoryBoard.tp?&tppCategory=publish">출판</a></li>
							<li><a href="${initParam.rootPath}/tpProjectCategoryBoard.tp?&tppCategory=etc">기타</a></li>
							<!--// TODO 프로젝트 카테고리 자동출력-->
						</ul>
					</li>

					<li><a href="${initParam.rootPath}/tpHelpPage.tp">HELP</a></li>
					<li><a href="${initParam.rootPath}/tpNoticeBoard.tp">NOTICE</a></li>
					<!-- search -->
					<li>
						<form action="${initParam.rootPath}/tpProjectSearching.tp" method="post">
							<input class="form-control search" placeholder=" Search" type="text" name = "keyWord">
							<input type="submit" value="Search" style="display:none">
						</form>
					</li>
					<!--// search -->
				</ul>
			</div>
		</div>
	</header>
	<!--header end-->
	
	
	<!--breadcrumbs start-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-sm-4">
					<h1>${requestScope.pageNavPageName}</h1>
				</div>
				<div class="col-lg-8 col-sm-8">
					<ol class="breadcrumb pull-right">
						<li><a href="#"> Home </a></li>
						<c:if test="${not empty requestScope.pageNavMidCate}">
						<li><a href="#"> ${requestScope.pageNavMidCate } </a></li>
						</c:if>
						<li class="active">${requestScope.pageNavThirdCate}</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<!--breadcrumbs end-->
	