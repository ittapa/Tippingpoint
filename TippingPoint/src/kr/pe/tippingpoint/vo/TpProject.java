package kr.pe.tippingpoint.vo;


public class TpProject {

	private String tppId;
	private String tppTitle;
	private String tppProjectContent;
	private String tppWriter;
	private int tppWriteDate;
	private int tppTotalAmount;
	private int tppTargetAmount;
	private String tppFundingStartDate;
	private String tppFundingLastDate;
	private int tppFunderNum;
	private String tppState;
	private String tppAdminMessage;
	private String tppMainImg; //fdfdfd
	
	
	//노아규 생성자
	public TpProject(){}

	//전체 생성자
	public TpProject(String tppId, String tppTitle, String tppProjectContent, String tppWriter, int tppWriteDate,
			int tppTotalAmount, int tppTargetAmount, String tppFundingStartDate, String tppFundingLastDate,
			int tppFunderNum, String tppState, String tppAdminMessage, String tppMainImg) {
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
		this.tppMainImg = tppMainImg;
	}

	public String getTppId() {
		return tppId;
	}

	public void setTppId(String tppId) {
		this.tppId = tppId;
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

	public String getTppFundingStartDate() {
		return tppFundingStartDate;
	}

	public void setTppFundingStartDate(String tppFundingStartDate) {
		this.tppFundingStartDate = tppFundingStartDate;
	}

	public String getTppFundingLastDate() {
		return tppFundingLastDate;
	}

	public void setTppFundingLastDate(String tppFundingLastDate) {
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

	public String getTppMainImg() {
		return tppMainImg;
	}

	public void setTppMainImg(String tppMainImg) {
		this.tppMainImg = tppMainImg;
	}

	@Override
	public String toString() {
		return "TpProject [tppId=" + tppId + ", tppTitle=" + tppTitle + ", tppProjectContent=" + tppProjectContent
				+ ", tppWriter=" + tppWriter + ", tppWriteDate=" + tppWriteDate + ", tppTotalAmount=" + tppTotalAmount
				+ ", tppTargetAmount=" + tppTargetAmount + ", tppFundingStartDate=" + tppFundingStartDate
				+ ", tppFundingLastDate=" + tppFundingLastDate + ", tppFunderNum=" + tppFunderNum + ", tppState="
				+ tppState + ", tppAdminMessage=" + tppAdminMessage + ", tppMainImg=" + tppMainImg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tppAdminMessage == null) ? 0 : tppAdminMessage.hashCode());
		result = prime * result + tppFunderNum;
		result = prime * result + ((tppFundingLastDate == null) ? 0 : tppFundingLastDate.hashCode());
		result = prime * result + ((tppFundingStartDate == null) ? 0 : tppFundingStartDate.hashCode());
		result = prime * result + ((tppId == null) ? 0 : tppId.hashCode());
		result = prime * result + ((tppMainImg == null) ? 0 : tppMainImg.hashCode());
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
		if (tppFundingLastDate == null) {
			if (other.tppFundingLastDate != null)
				return false;
		} else if (!tppFundingLastDate.equals(other.tppFundingLastDate))
			return false;
		if (tppFundingStartDate == null) {
			if (other.tppFundingStartDate != null)
				return false;
		} else if (!tppFundingStartDate.equals(other.tppFundingStartDate))
			return false;
		if (tppId == null) {
			if (other.tppId != null)
				return false;
		} else if (!tppId.equals(other.tppId))
			return false;
		if (tppMainImg == null) {
			if (other.tppMainImg != null)
				return false;
		} else if (!tppMainImg.equals(other.tppMainImg))
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
	
	//세터겟터 tosring 및 해쉬/이큐얼
	
	
	
	
	
	
	
	
}
