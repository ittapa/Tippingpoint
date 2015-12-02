package kr.pe.tippingpoint.vo;

import java.io.Serializable;


/**
 * TpCardPayment 테이블용 VO
 * @author Timothy 2015-12-02
 *
 */


public class TpCardPayment implements Serializable {
	public int tpCid; // 카드결제ID
	public String tpLgdRespcode; // DEFAULT '0000' NOT NULL / 응답코드
	public String tpLgdResPMsg; // 응답메세지
	public String tpLgdOid; // 상점 거래번호(주문번호)
	public String tpLgdTid; // LG유플러스 거래번호
	public String tpLgdHashData; // 해쉬데이타
	public String tpLgdFinanceCode; // 결제기관코드
	public String tpLgdFinanceName; // 결제기관명
	public String tpLgdEscrowYN; // 최종 에스크로 적용 여부
	public String tpLgdTransAmount; // 환율적용금액
	public String tpLgdExchangeRate; // 적용환율
	public String tpLgdBuyer; // 구매자명
	public String tpLgdBuyerPhone; // 고객휴대폰번호
	public String tpLgdBuyerEmail; // 구매자이메일
	public String tpLgdProductInfo; // 구매내역
	public String tpLgdCardNum; // 신용카드번호
	public String tpLgdCardInstallMonth; // 신용카드할부개월
	public int tpLgdCardNoIntYN; // 신용카드무이자여부
	public String tpLgdFinanceAuthNum; // 결제기관승인번호
	public int tpCAmount; // 결제금액
	
	public TpCardPayment() {}

	public TpCardPayment(int tpCid, String tpLgdRespcode, String tpLgdResPMsg, String tpLgdOid, String tpLgdTid,
			String tpLgdHashData, String tpLgdFinanceCode, String tpLgdFinanceName, String tpLgdEscrowYN,
			String tpLgdTransAmount, String tpLgdExchangeRate, String tpLgdBuyer, String tpLgdBuyerPhone,
			String tpLgdBuyerEmail, String tpLgdProductInfo, String tpLgdCardNum, String tpLgdCardInstallMonth,
			int tpLgdCardNoIntYN, String tpLgdFinanceAuthNum, int tpCAmount) {
		this.tpCid = tpCid;
		this.tpLgdRespcode = tpLgdRespcode;
		this.tpLgdResPMsg = tpLgdResPMsg;
		this.tpLgdOid = tpLgdOid;
		this.tpLgdTid = tpLgdTid;
		this.tpLgdHashData = tpLgdHashData;
		this.tpLgdFinanceCode = tpLgdFinanceCode;
		this.tpLgdFinanceName = tpLgdFinanceName;
		this.tpLgdEscrowYN = tpLgdEscrowYN;
		this.tpLgdTransAmount = tpLgdTransAmount;
		this.tpLgdExchangeRate = tpLgdExchangeRate;
		this.tpLgdBuyer = tpLgdBuyer;
		this.tpLgdBuyerPhone = tpLgdBuyerPhone;
		this.tpLgdBuyerEmail = tpLgdBuyerEmail;
		this.tpLgdProductInfo = tpLgdProductInfo;
		this.tpLgdCardNum = tpLgdCardNum;
		this.tpLgdCardInstallMonth = tpLgdCardInstallMonth;
		this.tpLgdCardNoIntYN = tpLgdCardNoIntYN;
		this.tpLgdFinanceAuthNum = tpLgdFinanceAuthNum;
		this.tpCAmount = tpCAmount;
	}

	public int getTpCid() {
		return tpCid;
	}

	public void setTpCid(int tpCid) {
		this.tpCid = tpCid;
	}

	public String getTpLgdRespcode() {
		return tpLgdRespcode;
	}

	public void setTpLgdRespcode(String tpLgdRespcode) {
		this.tpLgdRespcode = tpLgdRespcode;
	}

	public String getTpLgdResPMsg() {
		return tpLgdResPMsg;
	}

	public void setTpLgdResPMsg(String tpLgdResPMsg) {
		this.tpLgdResPMsg = tpLgdResPMsg;
	}

	public String getTpLgdOid() {
		return tpLgdOid;
	}

	public void setTpLgdOid(String tpLgdOid) {
		this.tpLgdOid = tpLgdOid;
	}

	public String getTpLgdTid() {
		return tpLgdTid;
	}

	public void setTpLgdTid(String tpLgdTid) {
		this.tpLgdTid = tpLgdTid;
	}

	public String getTpLgdHashData() {
		return tpLgdHashData;
	}

	public void setTpLgdHashData(String tpLgdHashData) {
		this.tpLgdHashData = tpLgdHashData;
	}

	public String getTpLgdFinanceCode() {
		return tpLgdFinanceCode;
	}

	public void setTpLgdFinanceCode(String tpLgdFinanceCode) {
		this.tpLgdFinanceCode = tpLgdFinanceCode;
	}

	public String getTpLgdFinanceName() {
		return tpLgdFinanceName;
	}

	public void setTpLgdFinanceName(String tpLgdFinanceName) {
		this.tpLgdFinanceName = tpLgdFinanceName;
	}

	public String getTpLgdEscrowYN() {
		return tpLgdEscrowYN;
	}

	public void setTpLgdEscrowYN(String tpLgdEscrowYN) {
		this.tpLgdEscrowYN = tpLgdEscrowYN;
	}

	public String getTpLgdTransAmount() {
		return tpLgdTransAmount;
	}

	public void setTpLgdTransAmount(String tpLgdTransAmount) {
		this.tpLgdTransAmount = tpLgdTransAmount;
	}

	public String getTpLgdExchangeRate() {
		return tpLgdExchangeRate;
	}

	public void setTpLgdExchangeRate(String tpLgdExchangeRate) {
		this.tpLgdExchangeRate = tpLgdExchangeRate;
	}

	public String getTpLgdBuyer() {
		return tpLgdBuyer;
	}

	public void setTpLgdBuyer(String tpLgdBuyer) {
		this.tpLgdBuyer = tpLgdBuyer;
	}

	public String getTpLgdBuyerPhone() {
		return tpLgdBuyerPhone;
	}

	public void setTpLgdBuyerPhone(String tpLgdBuyerPhone) {
		this.tpLgdBuyerPhone = tpLgdBuyerPhone;
	}

	public String getTpLgdBuyerEmail() {
		return tpLgdBuyerEmail;
	}

	public void setTpLgdBuyerEmail(String tpLgdBuyerEmail) {
		this.tpLgdBuyerEmail = tpLgdBuyerEmail;
	}

	public String getTpLgdProductInfo() {
		return tpLgdProductInfo;
	}

	public void setTpLgdProductInfo(String tpLgdProductInfo) {
		this.tpLgdProductInfo = tpLgdProductInfo;
	}

	public String getTpLgdCardNum() {
		return tpLgdCardNum;
	}

	public void setTpLgdCardNum(String tpLgdCardNum) {
		this.tpLgdCardNum = tpLgdCardNum;
	}

	public String getTpLgdCardInstallMonth() {
		return tpLgdCardInstallMonth;
	}

	public void setTpLgdCardInstallMonth(String tpLgdCardInstallMonth) {
		this.tpLgdCardInstallMonth = tpLgdCardInstallMonth;
	}

	public int getTpLgdCardNoIntYN() {
		return tpLgdCardNoIntYN;
	}

	public void setTpLgdCardNoIntYN(int tpLgdCardNoIntYN) {
		this.tpLgdCardNoIntYN = tpLgdCardNoIntYN;
	}

	public String getTpLgdFinanceAuthNum() {
		return tpLgdFinanceAuthNum;
	}

	public void setTpLgdFinanceAuthNum(String tpLgdFinanceAuthNum) {
		this.tpLgdFinanceAuthNum = tpLgdFinanceAuthNum;
	}

	public int getTpCAmount() {
		return tpCAmount;
	}

	public void setTpCAmount(int tpCAmount) {
		this.tpCAmount = tpCAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tpCAmount;
		result = prime * result + tpCid;
		result = prime * result + ((tpLgdBuyer == null) ? 0 : tpLgdBuyer.hashCode());
		result = prime * result + ((tpLgdBuyerEmail == null) ? 0 : tpLgdBuyerEmail.hashCode());
		result = prime * result + ((tpLgdBuyerPhone == null) ? 0 : tpLgdBuyerPhone.hashCode());
		result = prime * result + ((tpLgdCardInstallMonth == null) ? 0 : tpLgdCardInstallMonth.hashCode());
		result = prime * result + tpLgdCardNoIntYN;
		result = prime * result + ((tpLgdCardNum == null) ? 0 : tpLgdCardNum.hashCode());
		result = prime * result + ((tpLgdEscrowYN == null) ? 0 : tpLgdEscrowYN.hashCode());
		result = prime * result + ((tpLgdExchangeRate == null) ? 0 : tpLgdExchangeRate.hashCode());
		result = prime * result + ((tpLgdFinanceAuthNum == null) ? 0 : tpLgdFinanceAuthNum.hashCode());
		result = prime * result + ((tpLgdFinanceCode == null) ? 0 : tpLgdFinanceCode.hashCode());
		result = prime * result + ((tpLgdFinanceName == null) ? 0 : tpLgdFinanceName.hashCode());
		result = prime * result + ((tpLgdHashData == null) ? 0 : tpLgdHashData.hashCode());
		result = prime * result + ((tpLgdOid == null) ? 0 : tpLgdOid.hashCode());
		result = prime * result + ((tpLgdProductInfo == null) ? 0 : tpLgdProductInfo.hashCode());
		result = prime * result + ((tpLgdResPMsg == null) ? 0 : tpLgdResPMsg.hashCode());
		result = prime * result + ((tpLgdRespcode == null) ? 0 : tpLgdRespcode.hashCode());
		result = prime * result + ((tpLgdTid == null) ? 0 : tpLgdTid.hashCode());
		result = prime * result + ((tpLgdTransAmount == null) ? 0 : tpLgdTransAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TpCardPayment other = (TpCardPayment) obj;
		if (tpCAmount != other.tpCAmount)
			return false;
		if (tpCid != other.tpCid)
			return false;
		if (tpLgdBuyer == null) {
			if (other.tpLgdBuyer != null)
				return false;
		} else if (!tpLgdBuyer.equals(other.tpLgdBuyer))
			return false;
		if (tpLgdBuyerEmail == null) {
			if (other.tpLgdBuyerEmail != null)
				return false;
		} else if (!tpLgdBuyerEmail.equals(other.tpLgdBuyerEmail))
			return false;
		if (tpLgdBuyerPhone == null) {
			if (other.tpLgdBuyerPhone != null)
				return false;
		} else if (!tpLgdBuyerPhone.equals(other.tpLgdBuyerPhone))
			return false;
		if (tpLgdCardInstallMonth == null) {
			if (other.tpLgdCardInstallMonth != null)
				return false;
		} else if (!tpLgdCardInstallMonth.equals(other.tpLgdCardInstallMonth))
			return false;
		if (tpLgdCardNoIntYN != other.tpLgdCardNoIntYN)
			return false;
		if (tpLgdCardNum == null) {
			if (other.tpLgdCardNum != null)
				return false;
		} else if (!tpLgdCardNum.equals(other.tpLgdCardNum))
			return false;
		if (tpLgdEscrowYN == null) {
			if (other.tpLgdEscrowYN != null)
				return false;
		} else if (!tpLgdEscrowYN.equals(other.tpLgdEscrowYN))
			return false;
		if (tpLgdExchangeRate == null) {
			if (other.tpLgdExchangeRate != null)
				return false;
		} else if (!tpLgdExchangeRate.equals(other.tpLgdExchangeRate))
			return false;
		if (tpLgdFinanceAuthNum == null) {
			if (other.tpLgdFinanceAuthNum != null)
				return false;
		} else if (!tpLgdFinanceAuthNum.equals(other.tpLgdFinanceAuthNum))
			return false;
		if (tpLgdFinanceCode == null) {
			if (other.tpLgdFinanceCode != null)
				return false;
		} else if (!tpLgdFinanceCode.equals(other.tpLgdFinanceCode))
			return false;
		if (tpLgdFinanceName == null) {
			if (other.tpLgdFinanceName != null)
				return false;
		} else if (!tpLgdFinanceName.equals(other.tpLgdFinanceName))
			return false;
		if (tpLgdHashData == null) {
			if (other.tpLgdHashData != null)
				return false;
		} else if (!tpLgdHashData.equals(other.tpLgdHashData))
			return false;
		if (tpLgdOid == null) {
			if (other.tpLgdOid != null)
				return false;
		} else if (!tpLgdOid.equals(other.tpLgdOid))
			return false;
		if (tpLgdProductInfo == null) {
			if (other.tpLgdProductInfo != null)
				return false;
		} else if (!tpLgdProductInfo.equals(other.tpLgdProductInfo))
			return false;
		if (tpLgdResPMsg == null) {
			if (other.tpLgdResPMsg != null)
				return false;
		} else if (!tpLgdResPMsg.equals(other.tpLgdResPMsg))
			return false;
		if (tpLgdRespcode == null) {
			if (other.tpLgdRespcode != null)
				return false;
		} else if (!tpLgdRespcode.equals(other.tpLgdRespcode))
			return false;
		if (tpLgdTid == null) {
			if (other.tpLgdTid != null)
				return false;
		} else if (!tpLgdTid.equals(other.tpLgdTid))
			return false;
		if (tpLgdTransAmount == null) {
			if (other.tpLgdTransAmount != null)
				return false;
		} else if (!tpLgdTransAmount.equals(other.tpLgdTransAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TpCardPayment [tpCid=" + tpCid + ", tpLgdRespcode=" + tpLgdRespcode + ", tpLgdResPMsg=" + tpLgdResPMsg
				+ ", tpLgdOid=" + tpLgdOid + ", tpLgdTid=" + tpLgdTid + ", tpLgdHashData=" + tpLgdHashData
				+ ", tpLgdFinanceCode=" + tpLgdFinanceCode + ", tpLgdFinanceName=" + tpLgdFinanceName
				+ ", tpLgdEscrowYN=" + tpLgdEscrowYN + ", tpLgdTransAmount=" + tpLgdTransAmount + ", tpLgdExchangeRate="
				+ tpLgdExchangeRate + ", tpLgdBuyer=" + tpLgdBuyer + ", tpLgdBuyerPhone=" + tpLgdBuyerPhone
				+ ", tpLgdBuyerEmail=" + tpLgdBuyerEmail + ", tpLgdProductInfo=" + tpLgdProductInfo + ", tpLgdCardNum="
				+ tpLgdCardNum + ", tpLgdCardInstallMonth=" + tpLgdCardInstallMonth + ", tpLgdCardNoIntYN="
				+ tpLgdCardNoIntYN + ", tpLgdFinanceAuthNum=" + tpLgdFinanceAuthNum + ", tpCAmount=" + tpCAmount + "]";
	}
	
	
	
	
}
