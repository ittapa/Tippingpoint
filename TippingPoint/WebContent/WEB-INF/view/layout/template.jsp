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

		
	<tiles:insertAttribute name ="header"/>

	<!-- container -->
	<div class="container">
		<div class="row mar-b-30">
				<tiles:insertAttribute name = "body"/>
		</div>
	</div>
	<!--// container -->
	
	
	<!-- footer -->
		<tiles:insertAttribute name = "footer"/>
	<!--// footer -->


	</div>	
</body>
<!--
	ACME Html Template: Free for personal and commercial use under the CCA 3.0 license 
-->
</html>