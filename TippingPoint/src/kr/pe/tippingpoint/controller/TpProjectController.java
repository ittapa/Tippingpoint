package kr.pe.tippingpoint.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.service.TpProjectService;
import kr.pe.tippingpoint.vo.Editor;
import kr.pe.tippingpoint.vo.TpProject;

@Controller
public class TpProjectController {

	@Autowired
	private TpProjectService service;

	// 전송TEST 지울것..
	@RequestMapping("/test.tp")
	public String submit(@RequestParam String tppProjectContent) {
		System.out.println("내용" + tppProjectContent);
		System.out.println();
		System.out.println();

		return "/WEB-INF/view/body/tpproject/tpProjectRequestSuccess.jsp";
	}

	
	//사진 첨부하기 (html5가 아닐경우)
	@RequestMapping("/file_uploader.tp")
	public String file_uploader(HttpServletRequest request, HttpServletResponse response, Editor editor) {
		String return1 = request.getParameter("callback");
		String return2 = "?callback_func=" + request.getParameter("callback_func");
		String return3 = "";
		String name = "";
		try {
			if (editor.getFiledata() != null && editor.getFiledata().getOriginalFilename() != null
					&& !editor.getFiledata().getOriginalFilename().equals("")) {
				// 기존 상단 코드를 막고 하단코드를 이용
				name = editor.getFiledata().getOriginalFilename()
						.substring(editor.getFiledata().getOriginalFilename().lastIndexOf(File.separator) + 1);
				String filename_ext = name.substring(name.lastIndexOf(".") + 1);
				filename_ext = filename_ext.toLowerCase();
				String[] allow_file = { "jpg", "png", "bmp", "gif" };
				int cnt = 0;
				for (int i = 0; i < allow_file.length; i++) {
					if (filename_ext.equals(allow_file[i])) {
						cnt++;
					}
				}
				if (cnt == 0) {
					return3 = "&errstr=" + name;
				} else {
					// 파일 기본경로
					String dftFilePath = request.getSession().getServletContext().getRealPath("/");
					// 파일 기본경로 _ 상세경로
					String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator + "upload"
							+ File.separator;
					File file = new File(filePath);
					if (!file.exists()) {
						file.mkdirs();
					}
					String realFileNm = "";
					SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
					String today = formatter.format(new java.util.Date());
					realFileNm = today + UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
					String rlFileNm = filePath + realFileNm;
					///////////////// 서버에 파일쓰기 /////////////////
					editor.getFiledata().transferTo(new File(rlFileNm));
					///////////////// 서버에 파일쓰기 /////////////////
					return3 += "&bNewLine=true";
					return3 += "&sFileName=" + name;
					return3 += "&sFileURL=/TippingPoint/resources/editor/upload/" + realFileNm;
				}
			} else {
				return3 += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + return1 + return2 + return3;
	}

	
	//사진 첨부하기html5
	@RequestMapping("/fuh5.tp")
	public void file_uploader_html5(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("왜안오니");
		try {
			// 파일정보
			String sFileInfo = "";
			// 파일명을 받는다 - 일반 원본파일명
			String filename = request.getHeader("file-name");

			// 파일 확장자
			String filename_ext = filename.substring(filename.lastIndexOf(".") + 1);
			// 확장자를소문자로 변경
			filename_ext = filename_ext.toLowerCase();

			// 이미지 검증 배열변수
			String[] allow_file = { "jpg", "png", "bmp", "gif" };

			// 돌리면서 확장자가 이미지인지
			int cnt = 0;
			for (int i = 0; i < allow_file.length; i++) {
				if (filename_ext.equals(allow_file[i])) {
					cnt++;
				}
			}

			// 이미지가 아님
			if (cnt == 0) {
				PrintWriter print = response.getWriter();
				print.print("NOTALLOW_" + filename);
				print.flush();
				print.close();
			} else {
				// 이미지이므로 신규 파일로 디렉토리 설정 및 업로드
				// 파일 기본경로
				String dftFilePath = request.getSession().getServletContext().getRealPath("/");

				// 파일 기본경로 _ 상세경로
				String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator + "multiupload"
						+ File.separator;
				File file = new File(filePath);

				if (!file.exists()) {
					file.mkdirs();
				}
				String realFileNm = "";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
				String today = formatter.format(new java.util.Date());
				realFileNm = today + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
				String rlFileNm = filePath + realFileNm;
				///////////////// 서버에 파일쓰기 /////////////////
				InputStream is = request.getInputStream();
				OutputStream os = new FileOutputStream(rlFileNm);
				int numRead;
				byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
				while ((numRead = is.read(b, 0, b.length)) != -1) {
					os.write(b, 0, numRead);
				}
				if (is != null) {
					is.close();
				}
				os.flush();
				os.close();
				///////////////// 서버에 파일쓰기 /////////////////

				// 정보 출력
				sFileInfo += "&bNewLine=true";
				// img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
				sFileInfo += "&sFileName=" + filename;
				;
				sFileInfo += "&sFileURL=" + "/TippingPoint/resources/editor/multiupload/" + realFileNm;
				PrintWriter print = response.getWriter();
				print.print(sFileInfo);
				print.flush();
				print.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	//프로젝트등록 컨트롤러
	@RequestMapping("/registerTpProject")
	public String registerTpProject(HttpServletRequest request, HttpServletResponse response, ModelMap map)
			throws IOException {
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
		/////////////////// 여기까지 고객이 입력한
		/////////////////// 정보///////////////////////////////////////

		tpvo.setTppWriter("작성자1");
		Date date = new Date();

		String day = date.getYear() - 100 + "" + (date.getMonth() + 1) + "" + date.getDate() + "" + date.getHours();
		int days = Integer.parseInt(day);
		tpvo.setTppWriteDate(days);

		System.out.println("2.==" + tpvo.toString());
		service.registerTpProject(tpvo);

		return "/main.jsp";
	}

	// 프로젝트 전체보기
	@RequestMapping("/tpProjectBoard")
	public ModelAndView tpProjectBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*if(pageNo == 0){
			pageNo = 1;
		}*/
		int pageNo = 1;
		System.out.println("메롱");
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));

		} catch (Exception e) {
		}

		Map map = service.allListTpProject(pageNo);

		return new ModelAndView("/WEB-INF/view/body/tpproject/tpProjectRequestSuccess.jsp", map);
	}
	
	
	//단일 프로젝트 조회하기
	@RequestMapping("/TpProject.tp")
	public ModelAndView findTpProject(HttpServletRequest request, HttpServletResponse response) {

		// 1.요청파라미터 조회

		String tppId = request.getParameter("tppId");
		TpProject polist = service.findTpProjectById(tppId);

		return new ModelAndView("/WEB-INF/view/body/tpproject/tpProject.jsp", "polist", polist);
	}
}
