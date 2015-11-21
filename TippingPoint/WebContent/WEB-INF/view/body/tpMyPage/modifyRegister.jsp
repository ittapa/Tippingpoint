<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> 
<script>
    function button() { //주소 찾기
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('tpfZipcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('tpfAddress').value = fullAddr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('tpfAddressD').focus();
            }
        }).open();
    }
</script>

<body>
<h2>회원정보수정</h2>
<form action="${initParam.rootPath }/modifyRegister.tp" method="post">
<table border="1" style="width:500px">
	<tr>
		<td>ID</td>
		<td>
			<input type="hidden" name="tpfId" id="tpfId"
			value="${requestScope.tpFunder.tpfId }">
		</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="hidden" name="tpfName" id="tpfName"
			value="${requestScope.tpFunder.tpfName }">
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" id="tpfPassword" name="tpfPassword" size="20" value="${requestScope.tpFunder.tpfPassword }">
			<span class="error"><form:errors path="tpFunder.tpfPassword" delimiter=" | "/></span>
		</td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td>
			<input type="password" id="passwordConfirm" name="passwordConfirm" size="20">			
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" id="tpfEmail" name="tpfEmail" value="${requestScope.tpFunder.tpfEmail }">
			<span class="errorMessage"><form:errors path="tpFunder.tpfEmail" delimiter=" | "/></span>
		</td>
	</tr>
	<tr>
		<td>휴대폰번호</td>
		<td>
			<select name="tpfPhoneNum1">
				<option value="010">010</option>
				<option value="011">011</option>
			</select>
			-
			<input type="text" name="tpfPhoneNum2" style="width:50px; height:15px;" value="${requestScope.tpFunder.tpfPhoneNum2 }">
			<input type="text" name="tpfPhoneNum3" style="width:50px; height:15px;" value="${requestScope.tpFunder.tpfPhoneNum3 }">
			<input type="hidden" name="tpfPhoneNum"/>
		</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>
		<input type="text" readonly="readonly" name="tpfZipcode" id="tpfZipcode" placeholder="우편번호" style="width:50px; height:15px;" value="${requestScope.tpFunder.tpfZipcode }"> <input type="button" onclick="button()" value="우편번호 찾기">
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
		<input type="text" readonly="readonly" name="tpfAddress" id="tpfAddress" placeholder="주소" style="width:200px; height:15px;" value="${requestScope.tpFunder.tpfAddress }">
		</td>
	</tr>
	<tr>
		<td>상세주소</td>
		<td>
		<input type="text" name="tpfAddressD" id="tpfAddressD" placeholder="상세주소" style="width:200px; height:15px;" value="${requestScope.tpFunder.tpfAddressD }"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="등록" id="modify">
		</td>
	</tr>
</table>
</form>
</body>
</html>