<%@ page contentType="text/html;charset=UTF-8" %>

	 
		<P ><!-- align="center" -->
			<FONT size="5"><B>회원 상세보기</B></FONT>
		</P>
	
			<div>
				회원 ID : ${requestScope.tpFunder.tpfId }
			</div>
			<br/>
			
			<div>
				회원 이름 : ${requestScope.tpFunder.tpfName }
			</div>
			<br/>
			
			<div>
				회원 생년월일 : ${requestScope.tpFunder.tpfBirth }
			</div>
			<br/>
			
			<div>
				회원 성별 : ${requestScope.tpFunder.tpfGender}
			</div>
			<br/>
			
			<div>
				회원 이메일 : ${requestScope.tpFunder.tpfEmail }
			</div>
			<br/>
			
			<div>
				회원 주소 : ${requestScope.tpFunder.tpfZipcode }
			</div>
			<br/>
			
			<div>
				회원 기본주소 : ${requestScope.tpFunder.tpfAddress }
			</div>
			<br/>
			
			<div>
				회원 상세주소 : ${requestScope.tpFunder.tpfAddressD}
			</div>
			<br/>
			
			<div>
				회원 핸드폰번호 : ${requestScope.tpFunder.tpfPhoneNum}
			</div>
			<br/>
			
			<div>
				회원 승인값 : ${requestScope.tpFunder.tpfQualifyTpProposer }
			</div>
			<br/>
	
	