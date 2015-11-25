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

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tippingpoint.service.TpProjectService;
import kr.pe.tippingpoint.validator.TpProjectValidator;
import kr.pe.tippingpoint.vo.Editor;
import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpProject;
import kr.pe.tippingpoint.vo.TpProjectCategory;

@Controller
public class TpProjectController {

	@Autowired
	private TpProjectService service;
	
	//프로젝트 등록 폼 컨트롤러
	@RequestMapping("/tpProjectRegisterForm")
	public String tpProjectForm(ModelMap map){
		//to.do id 체크, 권한 체크
		List<TpProjectCategory> list = service.tpProjectCategoryList();
		map.addAttribute("categoryList", list);

		return "tpProject/tpProjectRegisterForm.tiles";
	}
	
	
	
	
	// 프로젝트등록 컨트롤러
		@RequestMapping("/submitTpProject")

		public String registerTpProject(@ModelAttribute TpProject tpvo, @RequestParam MultipartFile upfile, 
											HttpServletRequest request, ModelMap map, Errors errors,HttpSession session)
											throws IOException {
			
			//등록관련 validator 처리
			TpProjectValidator val = new TpProjectValidator();
	
			val.validate(tpvo, errors);
			
			System.out.println("프로젝트 등록중 총 검증 실패 개수:" +errors.getErrorCount());
			System.out.println(tpvo.getTppState());
			if(errors.hasErrors()){//  true = 오류가 있다.
				if(tpvo.getTppState().equals("b")){
					
					map.addAttribute("errorCheck", "submitError");					
				}else if(tpvo.getTppState().equals("a")){
					
					map.addAttribute("errorCheck", "saveError");	
				}
				
				return "/tpProjectRegisterForm.tp";
				
			}
	
			
			//승인요청 a:저장, b: 승인요청,o:승인완료, x승인거부 jsp단에서 받아서 들어감깔꺼ㅏㄹ
			
			
			
			tpvo.setTppWriter((String)session.getAttribute("userLoginInfo")); //session ID추출해서넣기
			
			//작성일자
			Date date = new Date();
			String day = date.getYear() - 100 + "" + (date.getMonth() + 1) + "" + date.getDate() + "" + date.getHours();
			int days = Integer.parseInt(day);
			
			//작성일자 vo에 넣기
			tpvo.setTppWriteDate(days);
	
			/////////////////// 정보 입력 끝 이미지 경로 빼고///////////////////////////////////////
			
			
			////////// main image 처리////////////////////
			
			// null : upImage name의 요청파라미터가 아야 없는 경우.
			// isEmpty -true: 사용자가 파일을 전송하지 않은 경우.
			
			//패스 및 경로 호출
			String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			String rootPath = request.getSession().getServletContext().getInitParameter("rootPath");
			
			
			if (upfile != null && !upfile.isEmpty()) { // 업로드된 파일이 있다.
				// 업로드 된 파일으 ㅣ정보를 조회
				// 파일을 임시저장경로에서 최종 저장경로로 이동.
			
				String mainImgName = upfile.getOriginalFilename(); //이미지 원래 이름
				long fileSize = upfile.getSize();
				System.out.println(mainImgName + " - " + fileSize);

				
		
				// 이미지이므로 신규 파일로 디렉토리 설정 및 업로드
				// 파일 기본경로
				
				// 파일 기본경로 _ 상세경로
				String filePath_A = "resources" + File.separator + "project" + File.separator + "mainImage"
						+ File.separator;
				// 파일 기본경로 _ 상세경로
				String filePath = dftFilePath + filePath_A;
				
	
				System.out.println("메인이미지 저장경로"+filePath);
				File file = new File(filePath);
				//메인 이미지 저장경로 설정....
				
				//있는지 확인하고 만들기
				if (!file.exists()) {
					file.mkdirs();
				}
				
				long timeMilis = System.currentTimeMillis(); // 현재 시간
				
				String realMainImgName = tpvo.getTppId()+timeMilis+mainImgName;
				System.out.println("miain이미지 이름 저장되는 이름"+realMainImgName);
 
				//저장설정
				File upImg = new File(filePath, realMainImgName);

				// 임시경로에서 레알로 저장하기
				upfile.transferTo(upImg);
				//메인이미지 경로 저장
				
				//vo에 이미지 경로 저장
				tpvo.setTppMainImg(rootPath+"/"+filePath_A+realMainImgName); //upfile
			}else{
				//이미지 안넣었을때 디폴트 이미지
				tpvo.setTppMainImg(rootPath+"/test/Desert.jpg");
			}
			

			System.out.println("-----------------------------------------------");
			System.out.println(tpvo);
			//비즈니스 로직 처리하기 서비스
			service.registerTpProject(tpvo);
			
			if(tpvo.getTppState()=="b"){ //승인요청 성공페이지
			return "tpProject/tpProjectRequestSuccess.tiles";
			}
			
			return "tpProject/tpProjectSaveSuccess.tiles";	
		}
	
	

	// 사진 첨부하기 (html5가 아닐경우)
	@RequestMapping("/file_uploader.tp")
	public String file_uploader(HttpServletRequest request, HttpServletResponse response, Editor editor) {
		System.out.println("file uploader");
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
		System.out.println("redirect:" + return1 + return2 + return3);
		return "redirect:" + return1 + return2 + return3;
	}

	// 사진 첨부하기html5
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
				
				String today = formatter.format(new java.util.Date()); //현재 날자 시간을  네임에 담기
				
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

	// 프로젝트 전체보기(o)것만
	@RequestMapping("/tpProjectBoard")
	public ModelAndView tpProjectBoard(HttpServletRequest request) throws Exception{
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			
		} catch (Exception e) {
		}
		
		Map map = service.allListTpProject(pageNo);

		List<TpProjectCategory> list = service.tpProjectCategoryList();
		map.put("categoryList", list);


		
		return new ModelAndView("tpProject/tpProjectBoard.tiles", map);
	}

	
	//	단일 프로젝트 조회하기(관리자)
	@RequestMapping("/tpProject.tp")
	public ModelAndView findTpProject(@RequestParam String tppId) {

		//to.do 검증 추가해야됨.
		TpProject polist = service.findTpProjectById(tppId);

		return new ModelAndView("tpProject/tpProject.tiles", "polist", polist); 
	}
	
	//프로젝트 검색하기
	@RequestMapping("/tpProjectSearching")
	public ModelAndView serchTpProject(@RequestParam String keyWord){
		
		if(keyWord == null||keyWord.trim().length()==0){
			//todo처리
		}
		
		Map<String, Object> map = service.serchTpProjectByKeyWord(keyWord);
		map.put("keyWord", keyWord);
		
		return new ModelAndView("tpProject/tpProjectSearchingList.tiles", map);
	}
	
	//프로젝트 ID 중복 조회
	@RequestMapping("tppIdDuplicatedCheck")
	@ResponseBody
	public String tppIdDuplicatedCheck(@RequestParam String tppId){
		TpProject tpproject = service.findTpProjectById(tppId);
		return String.valueOf(tpproject != null);
	}
	

	//작성자 아이디로 프로젝트 검색

	@RequestMapping("/searchByWriterProject")
	public ModelAndView searchByWriterProject(HttpSession session , HttpServletRequest request){
		int pageNo = 1;
		String writer = (String) session.getAttribute("userLoginInfo");
		System.out.println(writer);
		Map map = service.findTpProjectByWriter(writer);
		map.put("writer", writer);
		
		return new ModelAndView("tpMyPage/tpMyPageProjectList.tiles",map);
	}
	
	// 프로젝트 전체보기(o)것 카테고리별 조회
		@RequestMapping("/tpProjectCategoryBoard")
		public ModelAndView tpProjectCategoryBoard(HttpServletRequest request) throws Exception{
			int pageNo = 1;
			try {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			} catch (Exception e) {
			}
			String tppCategory = request.getParameter("tppCategory");
			System.out.println(tppCategory);
			
			Map map = service.selectCategoryProject(pageNo,tppCategory);
			
			List<TpProjectCategory> list = service.tpProjectCategoryList();
			map.put("categoryList", list);
			
			System.out.println("오잉? 와썹?");
			return new ModelAndView("tpProject/tpProjectBoard.tiles", map);
		}
	
	//프로젝트 수정 메서드
		@RequestMapping("/tpProjectModifyForm.tp")
		public ModelAndView tpProjectModifyForm(@RequestParam String tppId){
			
			TpProject tpProject = service.findTpProjectById(tppId);
			
			return new ModelAndView("tpMyPage/tpProjectModifyForm.tiles", "tpProject", tpProject);
		}
		
		
		// 프로젝트 수정 및 편집 컨트롤러
		@RequestMapping("/modifyTpProject")

		public String modifyTpProject(@ModelAttribute TpProject tpvo, @RequestParam MultipartFile upfile, 
											HttpServletRequest request, ModelMap map, Errors errors,HttpSession session)
											throws IOException {
			
			//등록관련 validator 처리
			TpProjectValidator val = new TpProjectValidator();
	
			val.validate(tpvo, errors);
			
			System.out.println("프로젝트 등록중 총 검증 실패 개수:" +errors.getErrorCount());
			System.out.println(tpvo.getTppState());
			if(errors.hasErrors()){//  true = 오류가 있다.
				if(tpvo.getTppState().equals("b")){
					
					map.addAttribute("errorCheck", "submitError");					
				}else if(tpvo.getTppState().equals("a")){
					
					map.addAttribute("errorCheck", "saveError");	
				}
				
				return "/tpProjectModifyForm.tp";
				
			}
	
			
			//승인요청 a:저장, b: 승인요청,o:승인완료, x승인거부 jsp단에서 받아서 들어감깔꺼ㅏㄹ
			
			
			//수정이니깐 작성지 할필요 없음
			//tpvo.setTppWriter((String)session.getAttribute("userLoginInfo")); //session ID추출해서넣기
			
			//작성일자
			Date date = new Date();
			String day = date.getYear() - 100 + "" + (date.getMonth() + 1) + "" + date.getDate() + "" + date.getHours();
			int days = Integer.parseInt(day);
			
			//작성일자 vo에 넣기
			tpvo.setTppWriteDate(days);
	
			/////////////////// 정보 입력 끝 이미지 경로 빼고///////////////////////////////////////
			
			
			////////// main image 처리////////////////////
			
			// null : upImage name의 요청파라미터가 아야 없는 경우.
			// isEmpty -true: 사용자가 파일을 전송하지 않은 경우.
			
			//패스 및 경로 호출
			String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			String rootPath = request.getSession().getServletContext().getInitParameter("rootPath");
			
			
			if (upfile != null && !upfile.isEmpty()) { // 업로드된 파일이 있다.
				// 업로드 된 파일으 ㅣ정보를 조회
				// 파일을 임시저장경로에서 최종 저장경로로 이동.
			
				String mainImgName = upfile.getOriginalFilename(); //이미지 원래 이름
				long fileSize = upfile.getSize();
				System.out.println(mainImgName + " - " + fileSize);

				
		
				// 이미지이므로 신규 파일로 디렉토리 설정 및 업로드
				// 파일 기본경로
				
				// 파일 기본경로 _ 상세경로
				String filePath_A = "resources" + File.separator + "project" + File.separator + "mainImage"
						+ File.separator;
				// 파일 기본경로 _ 상세경로
				String filePath = dftFilePath + filePath_A;
				
	
				System.out.println("메인이미지 저장경로"+filePath);
				File file = new File(filePath);
				//메인 이미지 저장경로 설정....
				
				//있는지 확인하고 만들기
				if (!file.exists()) {
					file.mkdirs();
				}
				
				long timeMilis = System.currentTimeMillis(); // 현재 시간
				
				String realMainImgName = tpvo.getTppId()+timeMilis+mainImgName;
				System.out.println("miain이미지 이름 저장되는 이름"+realMainImgName);
 
				//저장설정
				File upImg = new File(filePath, realMainImgName);

				// 임시경로에서 레알로 저장하기
				upfile.transferTo(upImg);
				//메인이미지 경로 저장
				
				//vo에 이미지 경로 저장
				tpvo.setTppMainImg(rootPath+"/"+filePath_A+realMainImgName); //upfile
			}else{
				//TODO 
				//이미지 안넣었을때 디폴트 이미지 수정이라서 필용벗음
				//tpvo.setTppMainImg(rootPath+"/test/Desert.jpg");
			}
			

			System.out.println("-----------------------------------------------");
			System.out.println(tpvo);
			//비즈니스 로직 처리하기 서비스
			service.updateTpProject(tpvo);
			
			if(tpvo.getTppState()=="b"){ //승인요청 성공페이지
			return "tpProject/tpProjectRequestSuccess.tiles";
			}
			
			return "tpProject/tpProjectSaveSuccess.tiles";	
		}
	
		
}
