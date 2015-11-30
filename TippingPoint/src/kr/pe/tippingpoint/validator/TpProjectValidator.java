package kr.pe.tippingpoint.validator;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpProject;
import sun.print.resources.serviceui;

public class TpProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(TpProject.class);
	}
	//클래스 맞는지 확인하기
	
	@Override
	//등록/수정 공통 체크.
	public void validate(Object target, Errors errors) {
		
		if(!supports(target.getClass())){
			errors.reject("notsupport","TpProject Propety값 불일치");
			return;
		}
		
		TpProject tpProject = (TpProject)target;
		System.out.println(tpProject.getTppId());
		//프로젝트 ID
		if(tpProject.getTppId()==null ||tpProject.getTppId().trim().length()==0){
			errors.rejectValue("tppId", "required", new Object[]{"프로젝트 ID"}, "프로젝트 ID는 한 글자 이상 입력해야 합니다.");
		}
		//프로젝트제목
		if(tpProject.getTppTitle() ==null || tpProject.getTppTitle().trim().length()==0){
			errors.rejectValue("tppTitle", "required", new Object[]{"프로젝트 제목"}, "프로젝트 제목은 한 글자 이상 입력해야 합니다.");
		}
	
	
		if(tpProject.getTppCategory().equals("null")){
			System.out.println("아메리카노");
			errors.rejectValue("tppCategory", "selected", new Object[]{"카테고리"}, "필수입력사항입니다.");
		}
		
		//시작일과 마감일 관련 처리
		//미입력
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tppFundingStartDate", "selected", new Object[]{"시작일"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tppFundingLastDate", "selected", new Object[]{"마감일"}, "필수입력사항입니다.");
		
		//날짜 잘못입력시, 오늘날짜보다 뒤에 날짜 일시 , 시작날짜보다 마감날짜가 멀시.
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd");
		int numToday = Integer.parseInt(form.format(new Date()));
		
		
		//TODO : 
		
		System.out.println("null로 떠라 젠장알"+tpProject.getTppId());
		if((tpProject.getTppState() =="A"||tpProject.getTppId() == null)&&tpProject.getTppFundingStartDate().length()!=8 || Integer.parseInt(tpProject.getTppFundingStartDate()) < numToday){
			errors.rejectValue("tppFundingStartDate","mistake","유효하지 않은 날자 입니다.");
		}
		
		if(tpProject.getTppFundingStartDate().length()!=8 || Integer.parseInt(tpProject.getTppFundingLastDate()) < numToday){
			errors.rejectValue("tppFundingLastDate","mistake","유효하지 않은 날자 입니다.");
		}
		
		if(Integer.parseInt(tpProject.getTppFundingLastDate()) < Integer.parseInt(tpProject.getTppFundingStartDate())){
			errors.rejectValue("tppFundingLastDate","mistake","마감일이 시작일보다 빠릅니다.");
	
		}
		System.out.println("오늘"+numToday+" 시작일"+tpProject.getTppFundingStartDate()+" 마감일 "+tpProject.getTppFundingLastDate());
		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tppTargetAmount", "required", new Object[]{"목표금액"}, "목표 금액을 입력해주세요");
		if(tpProject.getTppTargetAmount()< 1000 || tpProject.getTppTargetAmount()%1000 !=0){
			errors.rejectValue("tppTargetAmount","mistake","유효하지 않은 목표금액입니다.");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tppProjectContent", "null", new Object[]{"내용"},"내용을 입력하세요");
		if(tpProject.getTppProjectContent().equals("<p>&nbsp;</p>")){
			errors.rejectValue("tppProjectContent", "null",  new Object[]{"내용"},"내용을 입력하세요");
		}
	}
	
}
