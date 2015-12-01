
package kr.pe.tippingpoint.vo;

public class TpProposer {

	private String tpfId;// 아이디
	private String account;// 계좌
	private String proposerType;// 일반개인or법인or개인사업자
	private String certification;// 승인값
	private String corporateRegistrationNumber;// 사업자번호
	private String residentRegistrationFirstNum;// 주민번호 앞자리
	private String residentRegistrationLastNum;// 주민번호 뒷자리
	private String bankListCategory; // BANKLISTCATEGORY

	public TpProposer() {
	}

	public TpProposer(String tpfId, String account, String proposerType, String certification,
			String corporateRegistrationNumber, String residentRegistrationFirstNum, String residentRegistrationLastNum,
			String bankListCategory) {
		super();
		this.tpfId = tpfId;
		this.account = account;
		this.proposerType = proposerType;
		this.certification = certification;
		this.corporateRegistrationNumber = corporateRegistrationNumber;
		this.residentRegistrationFirstNum = residentRegistrationFirstNum;
		this.residentRegistrationLastNum = residentRegistrationLastNum;
		this.bankListCategory = bankListCategory;
	}

	public String getTpfId() {
		return tpfId;
	}

	public void setTpfId(String tpfId) {
		this.tpfId = tpfId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getProposerType() {
		return proposerType;
	}

	public void setProposerType(String proposerType) {
		this.proposerType = proposerType;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getCorporateRegistrationNumber() {
		return corporateRegistrationNumber;
	}

	public void setCorporateRegistrationNumber(String corporateRegistrationNumber) {
		this.corporateRegistrationNumber = corporateRegistrationNumber;
	}

	public String getResidentRegistrationFirstNum() {
		return residentRegistrationFirstNum;
	}

	public void setResidentRegistrationFirstNum(String residentRegistrationFirstNum) {
		this.residentRegistrationFirstNum = residentRegistrationFirstNum;
	}

	public String getResidentRegistrationLastNum() {
		return residentRegistrationLastNum;
	}

	public void setResidentRegistrationLastNum(String residentRegistrationLastNum) {
		this.residentRegistrationLastNum = residentRegistrationLastNum;
	}

	public String getBankListCategory() {
		return bankListCategory;
	}

	public void setBankListCategory(String bankListCategory) {
		this.bankListCategory = bankListCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((bankListCategory == null) ? 0 : bankListCategory.hashCode());
		result = prime * result + ((certification == null) ? 0 : certification.hashCode());
		result = prime * result + ((corporateRegistrationNumber == null) ? 0 : corporateRegistrationNumber.hashCode());
		result = prime * result + ((proposerType == null) ? 0 : proposerType.hashCode());
		result = prime * result
				+ ((residentRegistrationFirstNum == null) ? 0 : residentRegistrationFirstNum.hashCode());
		result = prime * result + ((residentRegistrationLastNum == null) ? 0 : residentRegistrationLastNum.hashCode());
		result = prime * result + ((tpfId == null) ? 0 : tpfId.hashCode());
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
		TpProposer other = (TpProposer) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (bankListCategory == null) {
			if (other.bankListCategory != null)
				return false;
		} else if (!bankListCategory.equals(other.bankListCategory))
			return false;
		if (certification == null) {
			if (other.certification != null)
				return false;
		} else if (!certification.equals(other.certification))
			return false;
		if (corporateRegistrationNumber == null) {
			if (other.corporateRegistrationNumber != null)
				return false;
		} else if (!corporateRegistrationNumber.equals(other.corporateRegistrationNumber))
			return false;
		if (proposerType == null) {
			if (other.proposerType != null)
				return false;
		} else if (!proposerType.equals(other.proposerType))
			return false;
		if (residentRegistrationFirstNum == null) {
			if (other.residentRegistrationFirstNum != null)
				return false;
		} else if (!residentRegistrationFirstNum.equals(other.residentRegistrationFirstNum))
			return false;
		if (residentRegistrationLastNum == null) {
			if (other.residentRegistrationLastNum != null)
				return false;
		} else if (!residentRegistrationLastNum.equals(other.residentRegistrationLastNum))
			return false;
		if (tpfId == null) {
			if (other.tpfId != null)
				return false;
		} else if (!tpfId.equals(other.tpfId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TpProposer [tpfId=" + tpfId + ", account=" + account + ", proposerType=" + proposerType
				+ ", certification=" + certification + ", corporateRegistrationNumber=" + corporateRegistrationNumber
				+ ", residentRegistrationFirstNum=" + residentRegistrationFirstNum + ", residentRegistrationLastNum="
				+ residentRegistrationLastNum + ", bankListCategory=" + bankListCategory + "]";
	}

}
