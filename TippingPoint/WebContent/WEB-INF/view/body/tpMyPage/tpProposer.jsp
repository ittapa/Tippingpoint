<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta charset="UTF-8">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> 
<script type="text/javascript">

   $(document).ready(function () {
      $("#register").on("click", function(){
         tpproposer = document.tpProposer;
         
         if (tpproposer.account.value.length < 10) {
            alert("계좌 번호를 제대로 입력해주세요");
            $("#account").focus();
            return false;
         }
         
         else if (tpproposer.residentRegistrationFirstNum.value.length != 6) {
        	 alert ("주민번호 앞자리 6자를 입력해주세요");
        	 $("#residentRegistrationFirstNum").focus();
        	 return false;
         }
         
         else if (tpproposer.residentRegistrationLastNum.value.length != 7) {
        	 alert("주민번호 뒷자리 7자를 입력해주세요");
        	 $("#residentRegistrationLastNum").focus();
        	 return false;
         }
         
         else if (tpproposer.corporateRegistrationNumber.value.length != 10) {
        	 alert("사업자 등록 번호 10자리를 입력해주세요");
        	 $("#corporateRegistrationNumber").focus();
        	 return false;
         }
         
      });      
   });

</script>
   
 
   
   <h2>PROPOSER 가입 양식</h2>
     <form action="addInfo.tp">
   <label> 은행 :
   		<select name = "bankListCategory">
	   		<option value = "null"> 은행을 선택하세요 </option>
	   		<c:choose>
	   		
					<c:when test="${fn:length(requestScope.list)==0 }">
						<option value = null>은행리스트 정보를 가져오지 못했습니다.</option>
					</c:when>
					
					<c:otherwise>
						<c:forEach items="${requestScope.list }" var="tpBankList">
								
								<option value = "${tpBankList.bankEr}">${tpBankList.bankKr}</option>
						</c:forEach>
					</c:otherwise>
			</c:choose>	
		</select>
		계좌번호 <input type = "number" name = "account" /><span class = "error"></label>
		  <span class="error"><form:errors path = "tpProposer.account" delimiter="|"/></span>
      <label>
    

      
      <br/>
      <label>
        주민 번호 : <input type = "number" name = "residentRegistrationFirstNum" maxlength="6"/>
    
       - 
      <input type = "password" name = "residentRegistrationLastNum" maxlength="7"/><span class="error">
    	<span class="error"><form:errors path = "tpProposer.residentRegistrationFirstNum" delimiter=" | "/></span>
      </label><p>
      
      
      <label>제안자 형태 : 
         <label>
            <select name = "proposerType">
               <option value = "normal">일반 개인</option>
               <option value = "business">개인 사업자</option>
               <option value = "corporate">법인 사업자</option>
            </select>
         </label>
      </label>
      <p>
      <label>사업자 번호 : <input type = "number" name = "corporateRegistrationNumber" maxlength="10"/><span class="error">
      <p><form:errors path = "tpProposer.corporateRegistrationNumber" delimiter="|"/></span></label><p>
      <p>
   <input type="submit" value="등록" id = "register"/>
   </form>
   
   