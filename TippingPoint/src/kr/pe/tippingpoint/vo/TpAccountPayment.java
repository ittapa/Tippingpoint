package kr.pe.tippingpoint.vo;

import java.io.Serializable;
import java.sql.Date;


/**
 * TpAccountPayment 테이블용 VO
 * @author Timothy 2015-12-03
 *
 */


public class TpAccountPayment implements Serializable {
	private int tpAid; // 계좌이체정보ID
	private int tpaAmount; // 금액
	private String tpaReBank; // 환불은행
	private String tpaReUserName; // 환불예금주
	private String tpaReBankAccount; // 환불계좌
	private Date tpaAccDateTime; // 결제처리일시
	
	public TpAccountPayment() {	}

	public TpAccountPayment(int tpAid, int tpaAmount, String tpaReBank, String tpaReUserName, String tpaReBankAccount,
			Date tpaAccDateTime) {
		this.tpAid = tpAid;
		this.tpaAmount = tpaAmount;
		this.tpaReBank = tpaReBank;
		this.tpaReUserName = tpaReUserName;
		this.tpaReBankAccount = tpaReBankAccount;
		this.tpaAccDateTime = tpaAccDateTime;
	}

	public int getTpAid() {
		return tpAid;
	}

	public void setTpAid(int tpAid) {
		this.tpAid = tpAid;
	}

	public int getTpaAmount() {
		return tpaAmount;
	}

	public void setTpaAmount(int tpaAmount) {
		this.tpaAmount = tpaAmount;
	}

	public String getTpaReBank() {
		return tpaReBank;
	}

	public void setTpaReBank(String tpaReBank) {
		this.tpaReBank = tpaReBank;
	}

	public String getTpaReUserName() {
		return tpaReUserName;
	}

	public void setTpaReUserName(String tpaReUserName) {
		this.tpaReUserName = tpaReUserName;
	}

	public String getTpaReBankAccount() {
		return tpaReBankAccount;
	}

	public void setTpaReBankAccount(String tpaReBankAccount) {
		this.tpaReBankAccount = tpaReBankAccount;
	}

	public Date getTpaAccDateTime() {
		return tpaAccDateTime;
	}

	public void setTpaAccDateTime(Date tpaAccDateTime) {
		this.tpaAccDateTime = tpaAccDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tpAid;
		result = prime * result + ((tpaAccDateTime == null) ? 0 : tpaAccDateTime.hashCode());
		result = prime * result + tpaAmount;
		result = prime * result + ((tpaReBank == null) ? 0 : tpaReBank.hashCode());
		result = prime * result + ((tpaReBankAccount == null) ? 0 : tpaReBankAccount.hashCode());
		result = prime * result + ((tpaReUserName == null) ? 0 : tpaReUserName.hashCode());
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
		TpAccountPayment other = (TpAccountPayment) obj;
		if (tpAid != other.tpAid)
			return false;
		if (tpaAccDateTime == null) {
			if (other.tpaAccDateTime != null)
				return false;
		} else if (!tpaAccDateTime.equals(other.tpaAccDateTime))
			return false;
		if (tpaAmount != other.tpaAmount)
			return false;
		if (tpaReBank == null) {
			if (other.tpaReBank != null)
				return false;
		} else if (!tpaReBank.equals(other.tpaReBank))
			return false;
		if (tpaReBankAccount == null) {
			if (other.tpaReBankAccount != null)
				return false;
		} else if (!tpaReBankAccount.equals(other.tpaReBankAccount))
			return false;
		if (tpaReUserName == null) {
			if (other.tpaReUserName != null)
				return false;
		} else if (!tpaReUserName.equals(other.tpaReUserName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TpAccountPayment [tpAid=" + tpAid + ", tpaAmount=" + tpaAmount + ", tpaReBank=" + tpaReBank
				+ ", tpaReUserName=" + tpaReUserName + ", tpaReBankAccount=" + tpaReBankAccount + ", tpaAccDateTime="
				+ tpaAccDateTime + "]";
	}
	
	
	
}
