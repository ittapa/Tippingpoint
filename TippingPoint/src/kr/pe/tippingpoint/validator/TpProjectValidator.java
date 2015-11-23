package kr.pe.tippingpoint.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.pe.tippingpoint.vo.TpFunder;
import kr.pe.tippingpoint.vo.TpProject;

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
		
		TpFunder tpfunder = (TpFunder)target;
		
		if(tpfunder.getTpfId()==null || tpfunder.getTpfId().trim().length() < 2){
			errors.rejectValue("tpfId", "required", new Object[]{"ID"}, "ID를 넣으세요");
		}if(tpfunder.getTpfPassword()==null || tpfunder.getTpfPassword().trim().isEmpty()){
			errors.rejectValue("tpfPassword", "required", new Object[]{"비밀번호"}, "패스워드를 넣으세요");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfName", "requried", new Object[]{"이름"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfEmail", "requried", new Object[]{"이메일"}, "필수입력사항입니다.");
	
	}
	
}
