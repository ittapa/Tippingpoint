package kr.pe.tippingpoint.vo;

public class TpBankList {

	private String bankKr;
	private String bankEr;
	private String code;
	
	public TpBankList () {}

	public String getBankKr() {
		return bankKr;
	}

	public void setBankKr(String bankKr) {
		this.bankKr = bankKr;
	}

	public String getBankEr() {
		return bankEr;
	}

	public void setBankEr(String bankEr) {
		this.bankEr = bankEr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "TpBankList [bankKr=" + bankKr + ", bankEr=" + bankEr + ", code=" + code + "]";
	}

	public TpBankList(String bankKr, String bankEr, String code) {
		super();
		this.bankKr = bankKr;
		this.bankEr = bankEr;
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankEr == null) ? 0 : bankEr.hashCode());
		result = prime * result + ((bankKr == null) ? 0 : bankKr.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		TpBankList other = (TpBankList) obj;
		if (bankEr == null) {
			if (other.bankEr != null)
				return false;
		} else if (!bankEr.equals(other.bankEr))
			return false;
		if (bankKr == null) {
			if (other.bankKr != null)
				return false;
		} else if (!bankKr.equals(other.bankKr))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
	
	
	
}
