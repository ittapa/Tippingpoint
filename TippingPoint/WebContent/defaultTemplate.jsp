<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="TippingPoint is a cloud funding site!">
	<meta name="author" content="Tippingpoint">
	<meta name="keywords" content="TippingPoint, funding, cloud funding, project">
	
	<meta property="og:type" content="website" />
	<meta property="og:site_name" content="TippingPoint" />
	<meta property="og:url" content="<%=request.getScheme() + "://" + request.getServerName() + ((request.getServerPort() != 80) ? ":" : "") + request.getServerPort() + request.getContextPath() + "/"%>" />
<c:choose>
<c:when test="not empty ${requestScope.ogTitle}">
	<meta property="og:title" id="og_title" content="${requestScope.ogTitle}" />
	<meta property="og:description" id="${requestScope.ogDescription}" content="" />
	<meta property="og:image" id="${requestScope.ogImage}" content="" />
</c:when>
<c:otherwise>
	<meta property="og:title" content="Tippoing Point" />
	<meta property="og:description" content="티핑 포인트!" />
	<meta property="og:image" content="https://fbcdn-photos-h-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-0/p526x296/12239489_112859812414625_165558607748774912_n.jpg?oh=6e027fd597778b14a9f82ba16511a58d&oe=56AF9E94&__gda__=1459245757_f6e1c1e33d67e01011fcff0817bf01dd" />
</c:otherwise>
</c:choose>

<link rel="apple-touch-icon" sizes="57x57" href="${initParam.rootPath}/images/favicons/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="${initParam.rootPath}/images/favicons/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="${initParam.rootPath}/images/favicons/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="${initParam.rootPath}/images/favicons/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="${initParam.rootPath}/images/favicons/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="${initParam.rootPath}/images/favicons/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="${initParam.rootPath}/images/favicons/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="${initParam.rootPath}/images/favicons/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="${initParam.rootPath}/images/favicons/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="${initParam.rootPath}/images/favicons/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="${initParam.rootPath}/images/favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="${initParam.rootPath}/images/favicons/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="${initParam.rootPath}/images/favicons/favicon-16x16.png">
<link rel="shortcut icon" type="image/x-icon" href="${initParam.rootPath}/favicon.ico" />
<link rel="manifest" href="${initParam.rootPath}/images/favicons/manifest.json">
<meta name="msapplication-TileColor" content="#fff">
<meta name="msapplication-TileImage" content="${initParam.rootPath}/images/favicons/ms-icon-144x144.png">
<meta name="theme-color" content="#fff">
		
	<title>TippingPoint | Home</title>
	
	<!-- Bootstrap core CSS -->
	<link href="${initParam.rootPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${initParam.rootPath}/css/theme.css" rel="stylesheet">
	<link href="${initParam.rootPath}/css/bootstrap-reset.css" rel="stylesheet">
	<!--external css-->
	<link href="${initParam.rootPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link rel="stylesheet" href="${initParam.rootPath}/css/flexslider.css" />
	<link href="${initParam.rootPath}/assets/bxslider/jquery.bxslider.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${initParam.rootPath}/css/animate.css">
	<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
	
	
	<!-- Custom styles for this template -->
	<link href="${initParam.rootPath}/css/style.css" rel="stylesheet">
	<link href="${initParam.rootPath}/css/style-responsive.css" rel="stylesheet" />
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
	<!--[if lt IE 9]>
	<script src="${initParam.rootPath}/js/html5shiv.js"></script>
	<script src="${initParam.rootPath}/js/respond.min.js"></script>
	<![endif]-->
</head>

<body>
	<!--header start-->
	<header class="head-section">
		<div class="navbar navbar-default navbar-static-top container">
			<div class="navbar-header">
				<button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse" type="button">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">Tipping<span>Point</span></a>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>

<c:choose>
	<c:when test="${sessionScope.userLoginInfo == null}">
					<li><a href="${initParam.rootPath}/tpfunder/registerForm.tp">SIGN UP</a></li>
					<li><a href="${initParam.rootPath}/tpLogin/tpLoginPage.tp">LOGIN</a></li>
	</c:when>

	<c:otherwise>
					<li><a href="${initParam.rootPath}/myPageMain.tp">My Page</a></li>
					<li><a href="${initParam.rootPath}/logout.tp">LOGOUT</a></li>
	</c:otherwise>
</c:choose>
					<li><a href="${initParam.rootPath}/tpProjectRegisterForm.tp">프로젝트 등록하기</a></li>

					<li class="dropdown">
						<a class="dropdown-toggle" data-close-others="false" data-delay="0" data-hover="dropdown" data-toggle="dropdown" href="${initParam.rootPath}/tpProjectBoard.tp">프로젝트 둘러보기 <i class="fa fa-angle-down"></i></a>
					<!-- TODO 프로젝트 카테고리 자동출력-->
						<ul class="dropdown-menu">
							<li><a href="tpProjectBoard.tp">모두보기</a></li>
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
					<li><a href="${initParam.rootPath}/tpNoticeBoard.tp">NOITCE</a></li>
					<!-- search -->
					<li>
						<form action="${initParam.rootPath}/tpProjectSearching.tp" method="post">
							<input class="form-control search" placeholder=" Search" type="text">
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
					<h1>페이지명</h1>
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



	<!--container start-->
	<div class="container">
	
		<div class="row">
			<div class="col-lg-5 col-sm-5 address">
				<section>좌측: 5/12</section>
			</div>
			<div class="col-lg-7 col-sm-7 address">
				<h4>우측: 7/12</h4>
			</div>
		</div>

	</div>
	<!--container end-->

	<div class="container">
		<div class="row mar-b-30">다른 내용2</div>
	</div>

	<!--footer start-->
	<!-- <footer class="footer">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-sm-3 address wow fadeInUp" data-wow-duration="2s" data-wow-delay=".1s">
            <h1>
              contact info
            </h1>
            <address>
              <p>
                <i class="fa fa-home pr-10">
                </i>
                Address: No.XXXXXX street
              </p>
              <p>
                <i class="fa fa-globe pr-10">
                </i>
                Mars city, Country
              </p>
              <p>
                <i class="fa fa-mobile pr-10">
                </i>
                Mobile : (123) 456-7890
              </p>
              <p>
                <i class="fa fa-phone pr-10">
                </i>
                Phone : (123) 456-7890
              </p>
              <p>
                <i class="fa fa-envelope pr-10">
                </i>
                Email :
                <a href="javascript:;">
                  support@example.com
                </a>
              </p>
            </address>
          </div>
          <div class="col-lg-3 col-sm-3 wow fadeInUp" data-wow-duration="2s" data-wow-delay=".3s">
            <h1>
              latest tweet
            </h1>
            <div id="owl-slide">
              <div class="tweet-box">
                <i class="fa fa-twitter">
                </i>
                <em>
                  Please follow
                  <a href="javascript:;">
                    @example
                  </a>
                  for all future updates of us!
                  <a href="javascript:;">
                    twitter.com/TippingPoint
                  </a>
                </em>
              </div>
              <div class="tweet-box">
                <i class="fa fa-twitter">
                </i>
                <em>
                  Please follow
                  <a href="javascript:;">
                    @example
                  </a>
                  for all future updates of us!
                  <a href="javascript:;">
                    twitter.com/TippingPoint
                  </a>
                </em>
              </div>
              <div class="tweet-box">
                <i class="fa fa-twitter">
                </i>
                <em>
                  Please follow
                  <a href="javascript:;">
                    @example
                  </a>
                  for all future updates of us!
                  <a href="javascript:;">
                    twitter.com/TippingPoint
                  </a>
                </em>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-sm-3">
            <div class="page-footer wow fadeInUp" data-wow-duration="2s" data-wow-delay=".5s">
              <h1>
                Our Company
              </h1>
              <ul class="page-footer-list">

                <li>
                  <i class="fa fa-angle-right">
                  </i>
                  <a href="about.html">
                    About Us
                  </a>
                </li>
                <li>
                  <i class="fa fa-angle-right">
                  </i>
                  <a href="faq.html">
                    Support
                  </a>
                </li>
                <li>
                  <i class="fa fa-angle-right">
                  </i>
                  <a href="service.html">
                    Service
                  </a>
                </li>
                <li>
                  <i class="fa fa-angle-right">
                  </i>
                  <a href="privacy-policy.html">
                    Privacy Policy
                  </a>
                </li>
                <li>
                  <i class="fa fa-angle-right">
                  </i>
                  <a href="career.html">
                    We are Hiring
                  </a>
                </li>
                <li>
                  <i class="fa fa-angle-right">
                  </i>
                  <a href="terms.html">
                    Term & condition
                  </a>
                </li>

              </ul>
            </div>
          </div>
          <div class="col-lg-3 col-sm-3">

            <div class="text-footer wow fadeInUp" data-wow-duration="2s" data-wow-delay=".7s">
              <h1>
                Text Widget
              </h1>
              <p>
                This is a text widget.Lorem ipsum dolor sit amet.
                This is a text widget.Lorem ipsum dolor sit amet
              </p>
            </div>
          </div>

        </div>

      </div>
    </footer> -->
	<!-- footer end -->
	<!--small footer start -->
	<footer class="footer-small">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-sm-6 pull-right">
					<ul class="social-link-footer list-unstyled">
						<li class="wow flipInX" data-wow-duration="2s" data-wow-delay=".1s">
							<a href="javascript:snsShare.shareFb()"><i class="fa fa-facebook"></i></a>
						</li>
						<li class="wow flipInX" data-wow-duration="2s" data-wow-delay=".2s">
							<a href="javascript:snsShare.shareGp()"><i class="fa fa-google-plus"></i></a>
						</li>
						<li class="wow flipInX" data-wow-duration="2s" data-wow-delay=".3s">
							<a href="javascript:snsShare.shareTw()"><i class="fa fa-twitter"></i></a>
						</li>
					</ul>
				</div>
				<div class="col-md-4">
					<div class="copyright">
						<p>&copy; Copyright - TippingPoint.</p>
						<ul class="menu">
						<c:if test="${sessionScope.adminId != null}">
							<li><a href="${initParam.rootPath}/tpAdminLogin.tp">관리자 PAGE</a></li>
							<li><a href="${initParam.rootPath}/logout.tp">관리자 로그아웃</a></li>
						</c:if>
						<c:if test="${sessionScope.adminId == null}">
							<li><a href="${initParam.rootPath}/tpAdminAccess.tp">관리자 로그인</a></li>
						</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--small footer end-->

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="${initParam.rootPath}/js/jquery.min.js"></script>
	<script src="${initParam.rootPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${initParam.rootPath}/js/hover-dropdown.js"></script>
	<script type="text/javascript" src="${initParam.rootPath}/assets/bxslider/jquery.bxslider.js"></script>

	<!-- <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&AMP;sensor=false"></script> -->

	<!--common script for all pages-->
	<script src="${initParam.rootPath}/js/common-scripts.js"></script>
	<script src="${initParam.rootPath}/js/wow.min.js"></script>
	<script>
		wow = new WOW({
			boxClass : 'wow', // default
			animateClass : 'animated', // default
			offset : 0
		// default
		})
		wow.init();
		
		var snsShare = {
				shareFb : function(){ //페이스북
					    window.open("https://www.facebook.com/sharer/sharer.php?u=<%=strCurrentUrl%>", "sharer","toolbar=0,status=0,width=626,height=436");
				},
				shareTw : function(){ // 트위터
				    //https://twitter.com/intent/tweet?text=TEXT&url=PAGE_URL
				    window.open("https://twitter.com/intent/tweet?text="+jQuery("#og_title").attr("content")+"&url=<%=strCurrentUrl%>", "_blank","toolbar=0,status=0,width=626,height=436");
				},
				shareGb : function(){ // 구글 플러스
					window.open("https://plus.google.com/share?url=<%=strCurrentUrl%>", "sharer","toolbar=0,status=0,width=626,height=436");
				}				
			};
	</script>


	<script>
		$(document).ready(function() {
			//Set the carousel options
			$('#quote-carousel').carousel({
				pause : true,
				interval : 4000,
			});
		});
	</script>

</body>
</html>
