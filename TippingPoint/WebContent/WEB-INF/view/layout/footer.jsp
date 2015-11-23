<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String strCurrentUrl = request.getScheme() + "://" + request.getServerName() 
			+ ((request.getServerPort() != 80) ? ":" : "") + request.getServerPort() + request.getContextPath() + "/"; 
%>
		<!-- Footer -->
		<div id="footer">
			<div class="container">


				<div class="row">
					<div class="12u">

						<!-- Contact -->
						<section class="contact">
							<header>
								<h3>Tipping Point 사이트와 프로젝트를 알리고 싶다고요?</h3>
							</header>
							<p>아래의 소셜 네트워크를 통해 공유하실 수 있습니다.</p>
							<ul class="icons">
								<li><a href="javascript:snsShare.shareTw()" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="javascript:snsShare.shareFb()" class="icon fa-facebook"><span class="label">Facebook</span></a></li>




							</ul>
						</section>

						<!-- Copyright -->
						<div class="copyright">
							<ul class="menu">
								<li>© Tipping Point. All rights reserved.</li>
								<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
								<li><a href="#">개인정보보호정책</a></li>

								<li><a href="${initParam.rootPath}/tpAdminAccess.tp">관리자 로그인</a></li>
							</ul>
						</div>

					</div>

				</div>
			</div>
		</div>

		<!--// Footer -->
<script>
var snsShare = {
	shareFb : function(){ //페이스북
		    window.open("https://www.facebook.com/sharer/sharer.php?u=<%=strCurrentUrl%>", "sharer","toolbar=0,status=0,width=626,height=436");
	},
	shareTw : function(){ // 트위터
	    //https://twitter.com/intent/tweet?text=TEXT&url=PAGE_URL
	    window.open("https://twitter.com/intent/tweet?text="+jQuery("#og_title").attr("content")+"&url=<%=strCurrentUrl%>", "_blank","toolbar=0,status=0,width=626,height=436");
	}
	
};
</script>

