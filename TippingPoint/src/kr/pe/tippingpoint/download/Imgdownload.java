package kr.pe.tippingpoint.download;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class Imgdownload extends AbstractView {

	public String getContentType() {
		return "application/octet-stream";
	}

	@Override
	protected void renderMergedOutputModel(Map model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fileName = (String) model.get("zzzz");
		String downFileName = new String(fileName.getBytes("euc-kr"), "8859_1");

		response.setContentType(getContentType());

		response.setHeader("content-disposition", "attachment;filename=" + downFileName);

		FileInputStream fi = new FileInputStream("c:\\java\\down\\" + fileName);
		OutputStream os = response.getOutputStream();

		FileCopyUtils.copy(fi, os);
		
	}
}
