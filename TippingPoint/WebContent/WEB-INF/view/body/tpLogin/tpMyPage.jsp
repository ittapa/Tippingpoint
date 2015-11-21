<%@ page contentType="text/html;charset=UTF-8"%> 



$(document).ready(function goLogout(){//
	$("#myPageBtn").on("click", function(){
		location.href="/TippingPoint/tpfunder/register_form.tp"   // 페이지 이동...
	});
});

$(document).ready(function goLogout(){//
	$("#logoutBtn").on("click", function(){
		location.href="/TippingPoint/tpfunder/logout.tp"  // 로그아웃 페이지 이동...
	});
});
</script>

	<P align="left">
			<FONT size="6"><B>My 페이지</B></FONT>
	</P>
	<form id ="mypage" method ="post" action = "">
	
		<table class="login" border="1">
			<tr align="center">
				<td colspan="2"	align="center" height="30">
				<input type="button" value="투자현황" id="investBtn">
			</tr>

			<tr align="center">
				<td colspan="2"	align="center" height="30">
				<input type="button" value="내 정보 조회 및 수정" id="myPageBtn">
			</tr>

			<tr>
				<td colspan="2" align="center" height="30">
					<input type="button" value="로그아웃" id="logoutBtn">
				</td>
			</tr>
		</table>
	</form> 