package kr.pe.tippingpoint.upload;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

public class UploadVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String comment;
	private List upfile;
	/**
	 * @return the commet
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param commet the commet to set
	 */
	public void setComment(String commet) {
		this.comment = commet;
	}
	/**
	 * @return the upfile
	 */
	public List getUpfile() {
		return upfile;
	}
	/**
	 * @param upfile the upfile to set
	 */
	public void setUpfile(List upfile) {
		this.upfile = upfile;
	}
	
}
