package kr.pe.tippingpoint.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * TPProjectFundingList 테이블용 VO
 * @author Timothy 2015-12-01
 *
 */

public class TPProjectFundingList implements Serializable {
	private int listNum; // 결제정보테이블ID
	private String tpPid; // 프로젝트ID 
	private String tpFid; // 일반회원ID
	private int tpCid; // 카드결제ID
	private int tpAid; // 계좌이체정보ID
	private String tppPayType; // 결제타입
	private String tppPayState; // 결제상태: DEFAULT 'o'
	private Date tppPayDateTime; // 결제일시
	private Date tppPayCancelReqDateTime; // 현금결제취소요청일
	private int tpCCid; // 카드결제취소ID
	
	public TPProjectFundingList() {	}

	public TPProjectFundingList(int listNum, String tpPid, String tpFid, int tpCid, int tpAid, String tppPayType,
			String tppPayState, Date tppPayDateTime, Date tppPayCancelReqDateTime, int tpCCid) {
		this.listNum = listNum;
		this.tpPid = tpPid;
		this.tpFid = tpFid;
		this.tpCid = tpCid;
		this.tpAid = tpAid;
		this.tppPayType = tppPayType;
		this.tppPayState = tppPayState;
		this.tppPayDateTime = tppPayDateTime;
		this.tppPayCancelReqDateTime = tppPayCancelReqDateTime;
		this.tpCCid = tpCCid;
	}

	public int getListNum() {
		return listNum;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}

	public String getTpPid() {
		return tpPid;
	}

	public void setTpPid(String tpPid) {
		this.tpPid = tpPid;
	}

	public String getTpFid() {
		return tpFid;
	}

	public void setTpFid(String tpFid) {
		this.tpFid = tpFid;
	}

	public int getTpCid() {
		return tpCid;
	}

	public void setTpCid(int tpCid) {
		this.tpCid = tpCid;
	}

	public int getTpAid() {
		return tpAid;
	}

	public void setTpAid(int tpAid) {
		this.tpAid = tpAid;
	}

	public String getTppPayType() {
		return tppPayType;
	}

	public void setTppPayType(String tppPayType) {
		this.tppPayType = tppPayType;
	}

	public String getTppPayState() {
		return tppPayState;
	}

	public void setTppPayState(String tppPayState) {
		this.tppPayState = tppPayState;
	}

	public Date getTppPayDateTime() {
		return tppPayDateTime;
	}

	public void setTppPayDateTime(Date tppPayDateTime) {
		this.tppPayDateTime = tppPayDateTime;
	}

	public Date getTppPayCancelReqDateTime() {
		return tppPayCancelReqDateTime;
	}

	public void setTppPayCancelReqDateTime(Date tppPayCancelReqDateTime) {
		this.tppPayCancelReqDateTime = tppPayCancelReqDateTime;
	}

	public int getTpCCid() {
		return tpCCid;
	}

	public void setTpCCid(int tpCCid) {
		this.tpCCid = tpCCid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + listNum;
		result = prime * result + tpAid;
		result = prime * result + tpCCid;
		result = prime * result + tpCid;
		result = prime * result + ((tpFid == null) ? 0 : tpFid.hashCode());
		result = prime * result + ((tpPid == null) ? 0 : tpPid.hashCode());
		result = prime * result + ((tppPayCancelReqDateTime == null) ? 0 : tppPayCancelReqDateTime.hashCode());
		result = prime * result + ((tppPayDateTime == null) ? 0 : tppPayDateTime.hashCode());
		result = prime * result + ((tppPayState == null) ? 0 : tppPayState.hashCode());
		result = prime * result + ((tppPayType == null) ? 0 : tppPayType.hashCode());
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
		TPProjectFundingList other = (TPProjectFundingList) obj;
		if (listNum != other.listNum)
			return false;
		if (tpAid != other.tpAid)
			return false;
		if (tpCCid != other.tpCCid)
			return false;
		if (tpCid != other.tpCid)
			return false;
		if (tpFid == null) {
			if (other.tpFid != null)
				return false;
		} else if (!tpFid.equals(other.tpFid))
			return false;
		if (tpPid == null) {
			if (other.tpPid != null)
				return false;
		} else if (!tpPid.equals(other.tpPid))
			return false;
		if (tppPayCancelReqDateTime == null) {
			if (other.tppPayCancelReqDateTime != null)
				return false;
		} else if (!tppPayCancelReqDateTime.equals(other.tppPayCancelReqDateTime))
			return false;
		if (tppPayDateTime == null) {
			if (other.tppPayDateTime != null)
				return false;
		} else if (!tppPayDateTime.equals(other.tppPayDateTime))
			return false;
		if (tppPayState == null) {
			if (other.tppPayState != null)
				return false;
		} else if (!tppPayState.equals(other.tppPayState))
			return false;
		if (tppPayType == null) {
			if (other.tppPayType != null)
				return false;
		} else if (!tppPayType.equals(other.tppPayType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TPProjectFundinglist [listNum=" + listNum + ", tpPid=" + tpPid + ", tpFid=" + tpFid + ", tpCid=" + tpCid
				+ ", tpAid=" + tpAid + ", tppPayType=" + tppPayType + ", tppPayState=" + tppPayState
				+ ", tppPayDateTime=" + tppPayDateTime + ", tppPayCancelReqDateTime=" + tppPayCancelReqDateTime
				+ ", tpCCid=" + tpCCid + "]";
	}
	
	
	
}
