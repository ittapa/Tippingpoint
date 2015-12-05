<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<P><!-- align="center" -->
			<FONT size="5"><B>'${requestScope.keyWord}' 로 검색 한 결과</B></FONT>
	</P>

<br/>

	<div class = "container">
			<div class = "row mar-b-30">
				<div id="portfoliolist-three">

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
		            
		
		  
				
			</div>
		</div>