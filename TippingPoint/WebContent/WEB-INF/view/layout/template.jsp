<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Tipping Point</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--[if lte IE 8]><script src="${initParam.rootPath}/assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="${initParam.rootPath}/assets/css/main.css">
		<!--[if lte IE 8]><link rel="stylesheet" href="${initParam.rootPath}/assets/css/ie8.css" /><![endif]-->
		
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		
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
		
		
<style type="text/css">
/*메세지 스타일*/
.errorMessage{
	font-size: 12px;
	color: red
}
.normalMessage{
	font-size:12px;
	color:blue;
}
img{
	/*이미지는 부모의 width에 리사이즈 처리*/
	max-width: 100%; 
	height: auto;
}
/*링크에 밑줄 제거*/
a{
	text-decoration: none;
}

/*테이블 기본 스타일*/
table, td, th{
	border: 1px solid black;
	border-collapse: collapse;
}
td, th{
	padding: 5px;
}


div.template{
	margin-top:50px;
	margin-right:auto;/*margin을 auto로 주면 좌우마진이 같게 되어 가운데 정렬 효과가 있다.*/
	margin-left:auto;
	width:1024px;
	
}
nav.template{
	
	height:50px;
	line-height:50px;
	background-color:red;
	font-weight:bold;
	text-align:center;
	border-bottom:1px solid gray;
}
nav.template a:link {text-decoration: none; color: black;}
nav.template a:visited {text-decoration: none; color: black;}
nav.template a:active {text-decoration: none; color: black;}
nav.template a:hover {text-decoration: underline; color: blue;}

section.template{
	
	margin:10px;
	height: auto; overflow:auto;/*hight를 500px에 내용이 늘어나면 늘어나도록 처리*/
}
</style>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	</head>
	<body class="no-sidebar">
	<div id="page-wrapper">

		
	<tiles:insertAttribute name ="header"/>
	
<!-- Main -->
		<div class="wrapper style1">

			<div class="container">
				<article id="main" class="special">



					<section>

				<tiles:insertAttribute name = "body"/>
				
				
			</section>						
		</article>
			</div>

		</div>
		<!--// Main -->
	
	
	<!-- <footer> -->
	
		<tiles:insertAttribute name = "footer"/>
	
	<!-- </footer> -->


	</div>

	<!-- scripts -->
			<script src="${initParam.rootPath}/assets/js/jquery.dropotron.min.js"></script>
			<script src="${initParam.rootPath}/assets/js/jquery.scrolly.min.js"></script>
			<script src="${initParam.rootPath}/assets/js/jquery.onvisible.min.js"></script>
			<script src="${initParam.rootPath}/assets/js/skel.min.js"></script>
			<script src="${initParam.rootPath}/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="${initParam.rootPath}/assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="${initParam.rootPath}/assets/js/main.js"></script>
	<!--// scripts -->
	
</body>
<!--
	Helios by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license) 
-->
</html>