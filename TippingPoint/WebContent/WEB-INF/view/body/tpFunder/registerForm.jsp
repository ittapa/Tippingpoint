<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta charset="UTF-8">
<!-- <title>Insert title here</title> -->

	<style type = "text/css">
	.error{
	color: red;
	
	}
</style>

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

<script>
function checkPwd(){ //비밀번호 확인
	var tpfPassword = document.tpFunder.tpfPassword.value; //비밀번호입력
	var passwordConfirm = document.tpFunder.passwordConfirm.value; //비밀번호확인
	if(tpfPassword!=passwordConfirm){
		document.getElementById('checkPwd').innerHTML = "동일한 암호를 입력하세요.";
	}else{
		document.getElementById('checkPwd').innerHTML = "확인되었습니다.";
	}
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
$(document).ready(function() { 
	$("#register").on("click",function(){ //가입 하기 전 확인할것들 처리
		tpfunder = document.tpFunder;
		if(tpfunder.tpfPhoneNum2.value.length<3 || tpfunder.tpfPhoneNum3.value.length<4){
			alert("핸드폰번호를 입력하세요");
			$("#tpfPhoneNum2").focus();
			return false;
		}//핸드폰번호 제대로 입력 안할시 가입 못하게 함
		else if(tpfunder.id_hidden.value=="N"){
			alert("아이디 중복체크를 해주세요");
			return false;
		}//아이디 중복체크 안할시 가입 못하게 함
		else if(tpfunder.tpfPassword.value != tpfunder.passwordConfirm.value){
			alert("비밀번호를 확인하세요");
			return false;
		}//비밀번호 확인 못할시 가입 못하게 함
		else if(tpfunder.phoneNum_hidden.value=="N"){
			alert("핸드폰번호 중복체크를 해주세요");
			return false;
		}//핸드폰번호 중복 체크 안할 시 가입 못하게함
		tpfunder.tpfPhoneNum.value = tpfunder.tpfPhoneNum1.value+"-"+tpfunder.tpfPhoneNum2.value+"-"+tpfunder.tpfPhoneNum3.value;
		//input text에 있는 핸드폰번호 3개를 입력받아 db한컬럼(핸드폰번호)에 넣게 합침
		tpfunder.submit();
	});
});
</script>


<script>
$(document).ready(function(){
	$("#idcheck").on("click",function(){ //아이디 중복확인 및 id 조건 처리
		$.ajax({
			url:"${initParam.rootPath}/idDuplicatedCheck.tp",
			type:"GET",
			data:{tpfId:$("#tpfId").val()},
			dataType:"JSON",
			beforeSend:function(){
				if($("#tpfId").val().length < 6){
					alert("id는 소문자, 숫자 혼용하여 6~12자 까지 가능합니다.");
					$("#tpfId").focus();
					return false;
				}
				for (i=0; i<$("#tpfId").val().length; i++ ){ //for문을 돌려서 아이디 첫글자부터 확인
					ch=$("#tpfId").val().charAt(i)
					if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z')){ //대,소문자 확인
						alert ("아이디는 소문자, 숫자만 입력가능합니다.")
					 	$("#tpfId").focus();
					  	return false;
					}
				}
			},
			success:function(txt){
				if(txt==false){
					alert("가능한 아이디입니다.");
					document.tpFunder.id_hidden.value="Y";
				}else{
					alert("중복입니다.");
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
$(document).ready(function(){
	$("#pncheck").on("click",function(){ //핸드폰 번호 중복확인
		var param = $("#tpfPhoneNum1")+"-"+$("#tpfPhoneNum2")+"-"+$("#tpfPhoneNum3");
		$.ajax({
			url:"${initParam.rootPath}/phoneNumDuplicatedCheck.tp",
			type:"GET",
			data:{tpfPhoneNum:param},
			dataType:"JSON",
			beforeSend:function(){
				if($("#tpfPhoneNum2").val().length<3 || $("#tpfPhoneNum3").val().length<4){
					alert("핸드폰 번호를 입력하세요");
					$("#tpfPhoneNum1").focus();
					return false;
				}
				for (i=0; i<$("#tpfPhoneNum2").val().length; i++ ){ //for문을 돌려서 첫글자부터 확인
					ch=$("#tpfPhoneNum2").val().charAt(i)
					ch2=$("#tpfPhoneNum3").val().charAt(i)
					if (!(ch>='0' && ch<='9') || !(ch2>='0' && ch2<='9')){ 
						alert ("핸드폰 번호는 숫자만 입력가능합니다.")
					 	$("#tpfPhoneNum2").focus();
					  	return false;
					}
				}
			},
			success:function(txt){
				if(txt==false){
					alert("가능한 번호입니다.");
					document.tpFunder.phoneNum_hidden.value="Y";
				}else{
					alert("가입되있는 번호입니다.");
				}
			},
			error: function(){
				alert("에러");
			}
		});
	});
});
</script>

<script type="text/javascript">
//이미지 관련 삭제 및 호출
$(document).ready(function() {
	var defaultImg = "/TippingPoint/defaultImg/tpProfileDefault.png"
	$("#tpfMainImgDelete").on("click", function(){
		if(!$("#upfile").val()){
			alert("추가된 이미지가 없습니다.");
			return false;
		}
		
		var imgconfirm = confirm("추가된 메인이미지를 삭제합니다.");
		if(imgconfirm){
			$("#upfile").val("");
			document.getElementById('imgView').src=defaultImg;
		}else{
			return false
		}
	});
});
</script>

<script type="text/javascript">
function imgChange(evt) {
	alert("대표 이미지를 업로드합니다.");
	var tgt = evt.target || window.event.srcElement,
	files = tgt.files;
	
	// 파일리더를 지원하는 경우
	if (FileReader && files && files.length) {
		var fr = new FileReader();
		fr.onload = function () {
			document.getElementById('imgView').src = fr.result;
		}
		fr.readAsDataURL(files[0]);
	}
					
	// Not supported 아닌경우 아이프레임..ㅠㅠ
	else {
	// fallback -- perhaps submit the input to an iframe and temporarily store
	// them on the server until the user's session ends.
	}
} //imgChange function 종료
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
<form action="${initParam.rootPath}/registerTpFunder.tp" method="post" name="tpFunder" enctype="multipart/form-data">
	<table class="register">
		<tr>
			<td width="150px">ID</td>
			<td><input type="text" name="tpfId" id="tpfId" maxlength="12" value="${requestScope.tpFunder.tpfId }">
			<input type="button" value="중복확인" id="idcheck"/>&nbsp;&nbsp;아이디는 소문자, 숫자 혼용하여 6~12자 까지 가능
			<input type="hidden" name="id_hidden" value="N"/>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="tpfName" id="tpfName" maxlength="6" value="${requestScope.tpFunder.tpfName }">
				<span class="error"><form:errors path="tpFunder.tpfName" delimiter=" | "/></span>
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
			<td><input type="text" name="tpfEmail" id="tpfEmail" maxlength="30" value="${requestScope.tpFunder.tpfEmail }">
				<span class="error"><form:errors path="tpFunder.tpfEmail" delimiter=" | "/></span>
			</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" readonly="readonly" name="tpfZipcode" id="tpfZipcode" placeholder="우편번호" value="${requestScope.tpFunder.tpfZipcode }"> 
				<input type="button" onclick="button()" value="우편번호 찾기">
					<span class="error"><form:errors path="tpFunder.tpfZipcode" delimiter=" | "/></span>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" readonly="readonly" name="tpfAddress" id="tpfAddress" placeholder="주소" value="${requestScope.tpFunder.tpfAddress }">
					<span class="error"><form:errors path="tpFunder.tpfAddress" delimiter=" | "/></span>
			</td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td><input type="text" name="tpfAddressD" id="tpfAddressD" placeholder="상세주소" maxlength="100" value="${requestScope.tpFunder.tpfAddressD }">
					<span class="error"><form:errors path="tpFunder.tpfAddressD" delimiter=" | "/></span>
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
				-
				<input type="text" name="tpfPhoneNum3" id="tpfPhoneNum3" maxlength="4"/>
				<input type="button" value="중복확인" id="pncheck"/>
				<input type="hidden" name="phoneNum_hidden" value="N"/>
				<input type="hidden" name="tpfPhoneNum"/>
			</td>
		</tr>
		<tr>
			<td>대표 이미지</td>
			<td>
			<img src ="${initParam.rootPath}/defaultImg/tpProfileDefault.png" alt = "기본이미지" width ="150"  height = "150" id = "imgView"><br>
				<div class="mainImgfileBox">
					<label>
						사진 업로드 <input type="file" name="upfile" id="upfile" onchange="imgChange(this);"><br>						
					</label>
					<input type="button" id="tpfMainImgDelete" value="이미지 초기화">
				</div>
				<br>
				대표이미지는 가로/세로 150px 이하를 권장합니다.
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록" id="register">
			</td>
		</tr>
	</table>
</form>