package kr.pe.tippingpoint.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.pe.tippingpoint.service.TpProjectService;
import kr.pe.tippingpoint.upload.UploadVo;
import kr.pe.tippingpoint.vo.TpProject;

@Controller
public class TpProjectController {

	@Autowired
	private TpProjectService service;

	@RequestMapping("/registerTpProject")
	public String registerTpProject(@ModelAttribute UploadVo vo, HttpServletRequest request,
			HttpServletResponse response, ModelMap map) throws IOException {
		System.out.println("1. 와썹");

		// 1. 요청파라미터 조회
		TpProject tpvo = new TpProject();
		tpvo.setTppTitle(request.getParameter("title"));

		String startDate = request.getParameter("FundingStartDate");
		int FundingStartDate = Integer.parseInt(startDate);
		tpvo.setTppFundingStartDate(FundingStartDate);

		String lastDate = request.getParameter("FundingLastDate");
		int FundingLastDate = Integer.parseInt(lastDate);
		tpvo.setTppFundingLastDate(FundingLastDate);

		String amount = request.getParameter("targetAmount");
		int targetAmount = Integer.parseInt(amount);
		tpvo.setTppTargetAmount(targetAmount);

		tpvo.setTppProjectContent(request.getParameter("imageInfo"));
		String tpid = request.getParameter("tpid");
		tpvo.setTppId(tpid);
		/////////////////// 여기까지 고객이 입력한 정보///////////////////////////////////////

		tpvo.setTppWriter("작성자1");
		Date date = new Date();

		String day = date.getYear() - 100 + "" + (date.getMonth() + 1) + "" + date.getDate() + "" + date.getHours();
		int days = Integer.parseInt(day);
		tpvo.setTppWriteDate(days);

		System.out.println("2.==" + tpvo.toString());
		service.registerTpProject(tpvo);

		//2.파일 업로드
		String comment = vo.getComment();
		System.out.println("파일명: " + comment);
		List fileList = vo.getUpfile();
		List list = new ArrayList();
		
		if (fileList != null) {// list null인 경우 : upfile이름으로 넘어온 요청파라미터
			for (Object obj : fileList) {
				MultipartFile upfile = (MultipartFile) obj;
				if (!upfile.isEmpty()) { // 업로드된 파일별 처리
					File file = new File("c:\\java\\down", upfile.getOriginalFilename());
					upfile.transferTo(file);// 이동 } } }
					list.add(upfile.getOriginalFilename());
				}

			}
		}
		
		return "/main.jsp";
	}
	

//	@RequestMapping("/tpProjectBoard")
//	public AttributeAndView TpProjectBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int pageNo = 1;
//	       try{
//	          pageNo = Integer.parseInt(request.getParameter("pageNo"));
//	       }catch(Exception e){
//	       }
//	       return new AttributeAndView("/customer/list_paging.jsp",map);
//	}

}
