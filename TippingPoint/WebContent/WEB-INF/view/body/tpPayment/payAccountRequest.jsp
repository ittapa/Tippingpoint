<%@ page contentType="text/html;charset=UTF-8" %>
<h2>계좌 이체를 통한 프로젝트 후원</h2>
<h3>결제 내용 확인:</h3>

<form name="frmAcc" action="/TippingPoint/payAccountRequestSave.tp" method="post" onsubmit="return chkSubmit(this);">
<ul>
	<li>프로젝트 명: ${tppTitle}</li>
	<li>결제금액: ${tpAmount}</li>	
	<li><input type="submit" value="결제" /></li>
</ul>
<input type="hidden" name="tppId" value="${tppId }" />
<input type="hidden" name="tpaAmount" value="${tpAmount}" />
환불시 입금받을 계좌정보:
<input type="text" name="tpaReBank" value="" placeholder="환불은행" />
<input type="text" name="tpaReBankAccount" value="" placeholder="환불계좌"/>
<input type="text" name="tpaReUserName" value="" placeholder="환불예금주"/>
<input type="hidden" name="tpaAccDateTime" value="" />
</form>
<script>
	function chkSubmit(payFrm){
		if( (isNaN(payFrm.tpAmount.value)) || (payFrm.tpAmount.value.length < 0) ){
			alert("결제 금액을 확인하여 주십시오.");
			payFrm.tpAmount.focus();
			return false;
		}
		if(payFrm.tpaReBank.value.length < 0){
			alert("환불은행을 확인하여 주십시오.");
			payFrm.tpaReBank.focus();
			return false;
		}
		if(payFrm.tpaReBankAccount.value.length < 0){
			alert("환불계좌를 확인하여 주십시오.");
			payFrm.tpaReBankAccount.focus();
			return false;
		}
		if(payFrm.tpaReUserName.value.length < 0){
			alert("환불예금주를 확인하여 주십시오.");
			payFrm.tpaReUserName.focus();
			return false;
		}
		
		return confirm("결제요청을 하시겠습니까?");
	}
	
	function LPad(digit, size, attatch) {
	    var add = "";
	    digit = digit.toString();

	    if (digit.length < size) {
	        var len = size - digit.length;
	        for (i = 0; i < len; i++) {
	            add += attatch;
	        }
	    }
	    return add + digit;
	}

	function makeCurrentDateTIme() {
		var now = new Date();
		var years = now.getFullYear();
		var months = LPad(now.getMonth() + 1, 2, "0");
		var dates = LPad(now.getDate(), 2, "0");
		var hours = LPad(now.getHours(), 2, "0");
		var minutes = LPad(now.getMinutes(), 2, "0");
		var seconds = LPad(now.getSeconds(), 2, "0");
		var timeValue = years + months + dates + hours + minutes + seconds;
		jQuery('input:hidden[name=tpaAccDateTime]').val(timeValue);
	}
jQuery(function(){
	makeCurrentDateTIme();
});
</script>