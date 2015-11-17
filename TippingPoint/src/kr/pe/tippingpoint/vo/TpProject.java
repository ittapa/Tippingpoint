package kr.pe.tippingpoint.vo;


public class TpProject {

	private String tppId;
	private String tppTitle;
	private String tppProjectContent;
	private String tppWriter;
	private int tppWriteDate;
	private int tppTotalAmount;
	private int tppTargetAmount;
	private int tppFundingStartDate;
	private int tppFundingLastDate;
	private int tppFunderNum;
	private String tppState;
	private String tppAdminMessage;
	
	public TpProject(){}

	public String getTppId() {
		return tppId;
	}

	public TpProject(String tppId, String tppTitle, String tppProjectContent, String tppWriter, int tppWriteDate,
			int tppTotalAmount, int tppTargetAmount, int tppFundingStartDate, int tppFundingLastDate, int tppFunderNum,
			String tppState, String tppAdminMessage) {
		super();
		this.tppId = tppId;
		this.tppTitle = tppTitle;
		this.tppProjectContent = tppProjectContent;
		this.tppWriter = tppWriter;
		this.tppWriteDate = tppWriteDate;
		this.tppTotalAmount = tppTotalAmount;
		this.tppTargetAmount = tppTargetAmount;
		this.tppFundingStartDate = tppFundingStartDate;
		this.tppFundingLastDate = tppFundingLastDate;
		this.tppFunderNum = tppFunderNum;
		this.tppState = tppState;
		this.tppAdminMessage = tppAdminMessage;
	}

	public String getTppTitle() {
		return tppTitle;
	}

	public void setTppTitle(String tppTitle) {
		this.tppTitle = tppTitle;
	}

	public String getTppProjectContent() {
		return tppProjectContent;
	}

	public void setTppProjectContent(String tppProjectContent) {
		this.tppProjectContent = tppProjectContent;
	}

	public String getTppWriter() {
		return tppWriter;
	}

	public void setTppWriter(String tppWriter) {
		this.tppWriter = tppWriter;
	}

	public int getTppWriteDate() {
		return tppWriteDate;
	}

	public void setTppWriteDate(int tppWriteDate) {
		this.tppWriteDate = tppWriteDate;
	}

	public int getTppTotalAmount() {
		return tppTotalAmount;
	}

	public void setTppTotalAmount(int tppTotalAmount) {
		this.tppTotalAmount = tppTotalAmount;
	}

	public int getTppTargetAmount() {
		return tppTargetAmount;
	}

	public void setTppTargetAmount(int tppTargetAmount) {
		this.tppTargetAmount = tppTargetAmount;
	}

	public int getTppFundingStartDate() {
		return tppFundingStartDate;
	}

	public void setTppFundingStartDate(int tppFundingStartDate) {
		this.tppFundingStartDate = tppFundingStartDate;
	}

	public int getTppFundingLastDate() {
		return tppFundingLastDate;
	}

	public void setTppFundingLastDate(int tppFundingLastDate) {
		this.tppFundingLastDate = tppFundingLastDate;
	}

	public int getTppFunderNum() {
		return tppFunderNum;
	}

	public void setTppFunderNum(int tppFunderNum) {
		this.tppFunderNum = tppFunderNum;
	}

	public String getTppState() {
		return tppState;
	}

	public void setTppState(String tppState) {
		this.tppState = tppState;
	}

	public String getTppAdminMessage() {
		return tppAdminMessage;
	}

	public void setTppAdminMessage(String tppAdminMessage) {
		this.tppAdminMessage = tppAdminMessage;
	}

	public void setTppId(String tppId) {
		this.tppId = tppId;
	}

	@Override
	public String toString() {
		return "TpProject [tppId=" + tppId + ", tppTitle=" + tppTitle + ", tppProjectContent=" + tppProjectContent
				+ ", tppWriter=" + tppWriter + ", tppWriteDate=" + tppWriteDate + ", tppTotalAmount=" + tppTotalAmount
				+ ", tppTargetAmount=" + tppTargetAmount + ", tppFundingStartDate=" + tppFundingStartDate
				+ ", tppFundingLastDate=" + tppFundingLastDate + ", tppFunderNum=" + tppFunderNum + ", tppState="
				+ tppState + ", tppAdminMessage=" + tppAdminMessage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tppAdminMessage == null) ? 0 : tppAdminMessage.hashCode());
		result = prime * result + tppFunderNum;
		result = prime * result + tppFundingLastDate;
		result = prime * result + tppFundingStartDate;
		result = prime * result + ((tppId == null) ? 0 : tppId.hashCode());
		result = prime * result + ((tppProjectContent == null) ? 0 : tppProjectContent.hashCode());
		result = prime * result + ((tppState == null) ? 0 : tppState.hashCode());
		result = prime * result + tppTargetAmount;
		result = prime * result + ((tppTitle == null) ? 0 : tppTitle.hashCode());
		result = prime * result + tppTotalAmount;
		result = prime * result + tppWriteDate;
		result = prime * result + ((tppWriter == null) ? 0 : tppWriter.hashCode());
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
		TpProject other = (TpProject) obj;
		if (tppAdminMessage == null) {
			if (other.tppAdminMessage != null)
				return false;
		} else if (!tppAdminMessage.equals(other.tppAdminMessage))
			return false;
		if (tppFunderNum != other.tppFunderNum)
			return false;
		if (tppFundingLastDate != other.tppFundingLastDate)
			return false;
		if (tppFundingStartDate != other.tppFundingStartDate)
			return false;
		if (tppId == null) {
			if (other.tppId != null)
				return false;
		} else if (!tppId.equals(other.tppId))
			return false;
		if (tppProjectContent == null) {
			if (other.tppProjectContent != null)
				return false;
		} else if (!tppProjectContent.equals(other.tppProjectContent))
			return false;
		if (tppState == null) {
			if (other.tppState != null)
				return false;
		} else if (!tppState.equals(other.tppState))
			return false;
		if (tppTargetAmount != other.tppTargetAmount)
			return false;
		if (tppTitle == null) {
			if (other.tppTitle != null)
				return false;
		} else if (!tppTitle.equals(other.tppTitle))
			return false;
		if (tppTotalAmount != other.tppTotalAmount)
			return false;
		if (tppWriteDate != other.tppWriteDate)
			return false;
		if (tppWriter == null) {
			if (other.tppWriter != null)
				return false;
		} else if (!tppWriter.equals(other.tppWriter))
			return false;
		return true;
	}
	
	
	
	
	
}
