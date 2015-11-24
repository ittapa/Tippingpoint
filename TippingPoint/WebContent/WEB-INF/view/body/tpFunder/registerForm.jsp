<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta charset="UTF-8">
<!-- <title>Insert title here</title> -->


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

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() { //생년월일 찾기
	   $("#tpfBirth").datepicker({
	     changeMonth: true,
	     changeYear: true,
	     dateFormat : "yy-mm-dd",
	     yearRange : "1900:c",
	     monthNamesShort: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ]
	   });
});
</script>

<script>
$(document).ready(function() { //핸드폰번호 3개를 입력받아 db한컬럼에 넣기
	$("#register").on("click",function(){
		tpfunder = document.tpFunder;
		if(tpfunder.tpfPhoneNum2.value.length<3 || tpfunder.tpfPhoneNum3.value.length<4){
			alert("핸드폰번호를 입력하세요");
			$("#tpfPhoneNum2").focus();
			return false;
		}
		else if(tpfunder.id_hidden.value=="N"){
			alert("아이디 중복체크를 해주세요");
			return false;
		}
		tpfunder.tpfPhoneNum.value = tpfunder.tpfPhoneNum1.value+"-"+tpfunder.tpfPhoneNum2.value+"-"+tpfunder.tpfPhoneNum3.value;
		tpfunder.submit();
	});
});
</script>


<script>
$(document).ready(function(){
	$("#idcheck").on("click",function(){ //아이디 중복확인
		$.ajax({
			url:"${initParam.rootPath}/idDuplicatedCheck.tp",
			type:"GET",
			data:{tpfId:$("#tpfId").val()},
			dataType:"JSON",
			beforeSend:function(){
				if(!$("#tpfId").val()){
					alert("id를 입력하세요");
					$("#tpfId").focus();
					return false;
				}
			},
			success:function(txt){
				if(txt==false){
					alert("가능한 아이디입니다.");
					document.tpFunder.id_hidden.value="Y";
				}else{
					alert("중복입니다.");
					document.tpFunder.id_hidden.value="N";
				}
			},
			error: function(){
				alert("에러");
			}
		});
	});
});
</script>

<script>
function checkPwd(){
	var tpfPassword = document.tpFunder.tpfPassword.value;
	var passwordConfirm = document.tpFunder.passwordConfirm.value;
	if(tpfPassword!=passwordConfirm){
		document.getElementById("checkPwd").innerHTML = "동일한 암호를 입력하세요.";
	}else{
		document.getElementById("checkPwd").innerHTML = "확인되었습니다.";
	}
}
</script>

<style type="text/css">
table{
	/* width: 700px; */
}
table, td{
	border: 1px solid black;
	border-collapse: collapse;
	padding: 2px;
}
/*
table.register {
    margin-left: auto;
    margin-right: auto;
}
*/
</style>

<spring:hasBindErrors name="tpFunder"/>
<form action="${initParam.rootPath}/registerTpFunder.tp" method="post" name="tpFunder">
	<table class="register">
		<tr>
			<td width="150px">ID</td>
			<td><input type="text" name="tpfId" id="tpfId" value="${requestScope.tpFunder.tpfId }">
			<input type="button" value="중복확인" id="idcheck"/>
			<span class="error"><form:errors path="tpFunder.tpfId" delimiter=" | "/></span>
			<input type="hidden" name="id_hidden" value="N"/>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="tpfName" id="tpfName" value="${requestScope.tpFunder.tpfName }">
			<form:errors path="tpFunder.tpfName" delimiter=" | "/>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="tpfPassword" id="tpfPassword">
			<span class="error"><form:errors path="tpFunder.tpfPassword" delimiter=" | "/></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" name="passwordConfirm" onkeyup="checkPwd()">
			<div id="checkPwd">동일한 암호를 입력하세요.</div>
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<input type="text" id="tpfBirth" name="tpfBirth" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
			<label>남성 - <input type="radio" name="tpfGender" id="tpfGender" value="m"></label>
			여성 - <input type="radio" name="tpfGender" id="tpfGender" value="f">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="tpfEmail" id="tpfEmail" value="${requestScope.tpFunder.tpfEmail }">
			<form:errors path="tpFunder.tpfEmail" delimiter=" | "/>
			</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" readonly="readonly" name="tpfZipcode" id="tpfZipcode" placeholder="우편번호" value="${requestScope.tpFunder.tpfZipcode }"> 
				<input type="button" onclick="button()" value="우편번호 찾기">
				<form:errors path="tpFunder.tpfZipcode" delimiter=" | "/>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" readonly="readonly" name="tpfAddress" id="tpfAddress" placeholder="주소" value="${requestScope.tpFunder.tpfAddress }">
				<form:errors path="tpFunder.tpfAddress" delimiter=" | "/>
			</td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td><input type="text" name="tpfAddressD" id="tpfAddressD" placeholder="상세주소" value="${requestScope.tpFunder.tpfAddressD }">
				<form:errors path="tpFunder.tpfAddressD" delimiter=" | "/>
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
				<input type="text" name="tpfPhoneNum2" id="tpfPhoneNum2" maxlength="4"/>
				<input type="text" name="tpfPhoneNum3" id="tpfPhoneNum3" maxlength="4"/>
				<input type="hidden" name="tpfPhoneNum"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록" id="register">
			</td>
		</tr>
	</table>
</form>