<%@ page contentType="text/html;charset=UTF-8" %>

   
   <h2>PROPOSER 가입 양식</h2>
   <form action="/TippingPoint/addInfo.tp" method="post">
      <label>계좌 번호 : <input type = "text" name = "account"/></label><p>
      <label>주민 번호 : <input type = "text" name = "residentRegistrationFirstNum"/> - 
      <input type = "text" name = "residentRegistrationLastNum"/></label><p>
      <label>제안자 형태 : 
         <label>
            <select name = "proposerType">
               <option value = "normal">일반 개인</option>
               <option value = "business">개인 사업자</option>
               <option value = "corporate">법인 사업자</option>
            </select>
         </label><p>
      <label>사업자 번호 : <input type = "number" name = "corporateRegistrationNumber"/></label><p>
      <p>
	<input type="submit" value="등록" />
   </form>
