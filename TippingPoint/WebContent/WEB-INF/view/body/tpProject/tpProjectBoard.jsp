<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 게시판 목록 게시판 -->
  

<style>
.amount{
float: left;

}
.count{
float: right;
}

</style>
		<div class = "container">
			<div class = "row mar-b-30">
				<div id="portfoliolist-three">
		            <div class="col-xs-9 .col-md-9" style="   ">
				
				   	<c:choose>
				     <c:when test="${fn:length(requestScope.list)==0 }">
				      등록된 글이 없습니다.
					 </c:when>
					   <c:otherwise>
				         <c:forEach items="${requestScope.list }" var="tpProject">  
				         			<div class="portfolio logo mix_all" data-cat="logo" style=" display: inline-block; opacity: 1;">
						                <div class="portfolio-wrapper">
						                    <div class="portfolio-hover">
						                        <div class="image-caption" style="overflow: hidden; display: none;">
						                            
						                            <a href="${tpProject.tppMainImg }" class="magnefig label label-info icon" data-toggle="tooltip" data-placement="top" title="" data-original-title="Zoom"><i class="fa fa-eye"></i></a>
						                            <a href="${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }" class="label label-info icon" data-toggle="tooltip" data-placement="top" title="" data-original-title="Details"><i class="fa fa-link"></i></a>
						                            <!-- <a href="#" class="label label-info icon" data-toggle="tooltip" data-placement="right" title="" data-original-title="Likes"><i class="fa fa-heart"></i></a> -->
													
						                        </div>
						                        <img src="${tpProject.tppMainImg }"" alt="">
						
						                    </div>      
						                </div>
						                         <div align="left">
						                         		<a href="${initParam.rootPath }/tpProject.tp?tppId=${tpProject.tppId }" style ="text-align: center"><font style = "font-size: 16px;">${tpProject.tppTitle } 프로젝트</font></a>
				                  						<br/>
				                  						Projector : ${tpProject.tppWriter }
				                  				</div>
				                  		<hr style="margin-bottom: 5px; margin-top: 5px;">
				                  				<div class ='project-detail'>
					                 				 <div class = 'amount'>
					                 				 		모인금액 
					                 				 		<br/>
					                 				 		<b>${tpProject.tppTotalAmount }원</b>
					                  						<font color='red' size = '1'>${requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount +((requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount %1>0.5)?(1-(requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount %1))%1:-(requestScope.polist.tppTotalAmount / requestScope.polist.tppTargetAmount %1))}%</font>
													</div>
													<div class = "count">
															후원자
															<br/>
															<b>${tpProject.tppFunderNum }명</b>
															
													</div>	
															<br><br><br><br><br>			
												</div>
				                  <div>
				                  </div>
						      </div>
				        
				          </c:forEach>             
				   	</c:otherwise>
	  			</c:choose>   
					
		        
		
		            </div>
		            
					<!-- 카테고리  -->
					<div class= "col-xs-3 .col-md-3"">
									   <c:choose>
									      <c:when test="${fn:length(requestScope.categoryList)==0 }">
									               카테고리 정보를 가져오지 못했습니다.
									      </c:when>
									            
									            <c:otherwise>
									               <a href="${initParam.rootPath}/tpProjectBoard.tp">모두보기</a><br>
									               <c:forEach items="${requestScope.categoryList }" var="list">
									               <a href="${initParam.rootPath }/tpProjectCategoryBoard.tp?&tppCategory=${list.tppCategory }">${list.tppCategoryName }</a>
									               <br>
									               </c:forEach>
									            </c:otherwise>
									   </c:choose>
					</div>	
		        </div>
				
			</div>
		</div>

	


	   <div></div>
	   
	  
	  

 




  <!-- js placed at the end of the document so the pages load faster
    <script src="js/jquery.js"></script> -->
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/hover-dropdown.js"></script>
    <script defer src="js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="assets/bxslider/jquery.bxslider.js"></script>

    <script type="text/javascript" src="js/jquery.parallax-1.1.3.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="assets/owlcarousel/owl.carousel.js"></script>
    <script src="js/mixitup.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/link-hover.js"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>



    <script src="js/jquery.magnific-popup.js"></script>

    <script type="text/javascript">
    $('.image-caption a').tooltip();

    $(function () {

        var filterList = {

            init: function () {

                // MixItUp plugin
                // http://mixitup.io
                $('#portfoliolist-three').mixitup({
                    targetSelector: '.portfolio',
                    filterSelector: '.filter',
                    effects: ['fade'],
                    easing: 'snap',
                    // call the hover effect
                    onMixEnd: filterList.hoverEffect()
                });

            },

            hoverEffect: function () {
                $("[rel='tooltip']").tooltip();
                // Simple parallax effect
                $('#portfoliolist-three .portfolio .portfolio-hover').hover(
                function(){
                    $(this).find('.image-caption').slideDown(250); //.fadeIn(250)
                },
                function(){
                    $(this).find('.image-caption').slideUp(250); //.fadeOut(205)
                }
            );
            }

        };

        // Run the show!
        filterList.init();


    });

    $( document ).ready(function() {
       $('.magnefig').each(function(){
            $(this).magnificPopup({
                    type:'image',
                    removalDelay: 300,
                    mainClass: 'mfp-fade'
               })
        });
    });
    </script>

  <script>



      $(document).ready(function() {

        $("#owl-demo").owlCarousel({

            autoPlay: 3000, //Set AutoPlay to 3 seconds

            items : 4,
            itemsDesktop : [1199,3],
            itemsDesktopSmall : [979,3],
            stopOnHover : true,

        });

      });

      new WOW().init();


  </script>