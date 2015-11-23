<%@ page contentType="text/html;charset=UTF-8"%>

		<!-- Header -->
		<div id="header">

			<!-- Inner -->
			<div class="inner">
				<header>
					<h1>
						<a href="index.html" id="logo">Tipping Point</a>
					</h1>
				</header>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li style="white-space: nowrap;"><a href="index.html">Home</a></li>					
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpfunder/registerForm.tp">SIGN UP</a></li>
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpLogin/tpLoginPage.tp">LOGIN</a></li>
					<li style="white-space: nowrap;"><a href="${initParam.rootPath}/tpProjectRegister.tp">프로젝트 등록하기</a></li>
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


