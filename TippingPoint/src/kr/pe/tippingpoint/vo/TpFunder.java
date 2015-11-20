package kr.pe.tippingpoint.vo;

public class TpFunder {
	
	private String tpfId;
	private String tpfName;
	private String tpfPassword;
	private String tpfBirth;
	private String tpfGender;
	private String tpfEmail;
	private String tpfZipcode;
	private String tpfAddress;
	private String tpfAddressD;
	private String tpfPhoneNum;
	private String tpfQualifyTpProposer;
	private String tpfAccountType;
	
	public TpFunder(String tpfId, String tpfName, String tpfPassword, String tpfBirth, String tpfGender, String tpfEmail,
			String tpfZipcode, String tpfAddress, String tpfAddressD, String tpfPhoneNum, String tpfQualifyTpProposer,
			String tpfAccountType) {
		super();
		this.tpfId = tpfId;
		this.tpfName = tpfName;
		this.tpfPassword = tpfPassword;
		this.tpfBirth = tpfBirth;
		this.tpfGender = tpfGender;
		this.tpfEmail = tpfEmail;
		this.tpfZipcode = tpfZipcode;
		this.tpfAddress = tpfAddress;
		this.tpfAddressD = tpfAddressD;
		this.tpfPhoneNum = tpfPhoneNum;
		this.tpfQualifyTpProposer = tpfQualifyTpProposer;
		this.tpfAccountType = tpfAccountType;
	}
	
	
	public TpFunder() {}


	public String getTpfId() {
		return tpfId;
	}


	public void setTpfId(String tpfId) {
		this.tpfId = tpfId;
	}


	public String getTpfName() {
		return tpfName;
	}


	public void setTpfName(String tpfName) {
		this.tpfName = tpfName;
	}


	public String getTpfPassword() {
		return tpfPassword;
	}


	public void setTpfPassword(String tpfPassword) {
		this.tpfPassword = tpfPassword;
	}


	public String getTpfBirth() {
		return tpfBirth;
	}


	public void setTpfBirth(String tpfBirth) {
		this.tpfBirth = tpfBirth;
	}


	public String getTpfGender() {
		return tpfGender;
	}


	public void setTpfGender(String tpfGender) {
		this.tpfGender = tpfGender;
	}


	public String getTpfEmail() {
		return tpfEmail;
	}


	public void setTpfEmail(String tpfEmail) {
		this.tpfEmail = tpfEmail;
	}


	public String getTpfZipcode() {
		return tpfZipcode;
	}


	public void setTpfZipcode(String tpfZipcode) {
		this.tpfZipcode = tpfZipcode;
	}


	public String getTpfAddress() {
		return tpfAddress;
	}


	public void setTpfAddress(String tpfAddress) {
		this.tpfAddress = tpfAddress;
	}


	public String getTpfAddressD() {
		return tpfAddressD;
	}


	public void setTpfAddressD(String tpfAddressD) {
		this.tpfAddressD = tpfAddressD;
	}


	public String getTpfPhoneNum() {
		return tpfPhoneNum;
	}


	public void setTpfPhoneNum(String tpfPhoneNum) {
		this.tpfPhoneNum = tpfPhoneNum;
	}


	public String getTpfQualifyTpProposer() {
		return tpfQualifyTpProposer;
	}


	public void setTpfQualifyTpProposer(String tpfQualifyTpProposer) {
		this.tpfQualifyTpProposer = tpfQualifyTpProposer;
	}


	public String getTpfAccountType() {
		return tpfAccountType;
	}


	public void setTpfAccountType(String tpfAccountType) {
		this.tpfAccountType = tpfAccountType;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tpfAccountType == null) ? 0 : tpfAccountType.hashCode());
		result = prime * result + ((tpfAddress == null) ? 0 : tpfAddress.hashCode());
		result = prime * result + ((tpfAddressD == null) ? 0 : tpfAddressD.hashCode());
		result = prime * result + ((tpfBirth == null) ? 0 : tpfBirth.hashCode());
		result = prime * result + ((tpfEmail == null) ? 0 : tpfEmail.hashCode());
		result = prime * result + ((tpfGender == null) ? 0 : tpfGender.hashCode());
		result = prime * result + ((tpfId == null) ? 0 : tpfId.hashCode());
		result = prime * result + ((tpfName == null) ? 0 : tpfName.hashCode());
		result = prime * result + ((tpfPassword == null) ? 0 : tpfPassword.hashCode());
		result = prime * result + ((tpfPhoneNum == null) ? 0 : tpfPhoneNum.hashCode());
		result = prime * result + ((tpfQualifyTpProposer == null) ? 0 : tpfQualifyTpProposer.hashCode());
		result = prime * result + ((tpfZipcode == null) ? 0 : tpfZipcode.hashCode());
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
		TpFunder other = (TpFunder) obj;
		if (tpfAccountType == null) {
			if (other.tpfAccountType != null)
				return false;
		} else if (!tpfAccountType.equals(other.tpfAccountType))
			return false;
		if (tpfAddress == null) {
			if (other.tpfAddress != null)
				return false;
		} else if (!tpfAddress.equals(other.tpfAddress))
			return false;
		if (tpfAddressD == null) {
			if (other.tpfAddressD != null)
				return false;
		} else if (!tpfAddressD.equals(other.tpfAddressD))
			return false;
		if (tpfBirth == null) {
			if (other.tpfBirth != null)
				return false;
		} else if (!tpfBirth.equals(other.tpfBirth))
			return false;
		if (tpfEmail == null) {
			if (other.tpfEmail != null)
				return false;
		} else if (!tpfEmail.equals(other.tpfEmail))
			return false;
		if (tpfGender == null) {
			if (other.tpfGender != null)
				return false;
		} else if (!tpfGender.equals(other.tpfGender))
			return false;
		if (tpfId == null) {
			if (other.tpfId != null)
				return false;
		} else if (!tpfId.equals(other.tpfId))
			return false;
		if (tpfName == null) {
			if (other.tpfName != null)
				return false;
		} else if (!tpfName.equals(other.tpfName))
			return false;
		if (tpfPassword == null) {
			if (other.tpfPassword != null)
				return false;
		} else if (!tpfPassword.equals(other.tpfPassword))
			return false;
		if (tpfPhoneNum == null) {
			if (other.tpfPhoneNum != null)
				return false;
		} else if (!tpfPhoneNum.equals(other.tpfPhoneNum))
			return false;
		if (tpfQualifyTpProposer == null) {
			if (other.tpfQualifyTpProposer != null)
				return false;
		} else if (!tpfQualifyTpProposer.equals(other.tpfQualifyTpProposer))
			return false;
		if (tpfZipcode == null) {
			if (other.tpfZipcode != null)
				return false;
		} else if (!tpfZipcode.equals(other.tpfZipcode))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TpFunder [tpfId=" + tpfId + ", tpfName=" + tpfName + ", tpfPassword=" + tpfPassword + ", tpfBirth="
				+ tpfBirth + ", tpfGender=" + tpfGender + ", tpfEmail=" + tpfEmail + ", tpfZipcode=" + tpfZipcode
				+ ", tpfAddress=" + tpfAddress + ", tpfAddressD=" + tpfAddressD + ", tpfPhoneNum=" + tpfPhoneNum
				+ ", tpfQualifyTpProposer=" + tpfQualifyTpProposer + ", tpfAccountType=" + tpfAccountType + "]";
	}
	
	
	
	
}