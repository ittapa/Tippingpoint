<%@ page contentType="text/html;charset=UTF-8" %>
<h2>계좌 이체를 통한 프로젝트 후원</h2>
<h3>결제 내용 확인:</h3>

<form name="frmAcc" action="/TippingPoint/payAccountRequestSave.tp" method="post" onsubmit="return chkSubmit();">
<ul>
	<li>프로젝트 명: ${tppTitle}</li>
	<li>결제금액: ${tpAmount}</li>
	<li>주문번호: ${strOrderUId}</li>
	<li>이메일: ${tpfEmail}</li>
	<li><input type="submit" value="결제" /></li>
</ul>
<input type="hidden" name="" value="" />
<input type="hidden" name="" value="" />
</form>
<script>
	function chkSubmit(){
		return confirm("결제요청을 하시겠습니까?");
	}
</script>