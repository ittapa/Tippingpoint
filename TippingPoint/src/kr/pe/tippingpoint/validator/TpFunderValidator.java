package kr.pe.tippingpoint.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.pe.tippingpoint.vo.TpFunder;

public class TpFunderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(TpFunder.class);
	}
	
	@Override
	//등록/수정 공통 체크.
	public void validate(Object target, Errors errors) {
		
		if(!supports(target.getClass())){
			errors.reject("notsupport","우어엉");
			return;
		}
		
		TpFunder tpfunder = (TpFunder)target;
		
		if(tpfunder.getTpfId()==null || tpfunder.getTpfId().trim().length() < 1){
			errors.rejectValue("tpfId", "requeired", new Object[]{"tpfId"}, "ID를 넣으세요");
		}if(tpfunder.getTpfPassword()==null || tpfunder.getTpfPassword().trim().isEmpty()){
			errors.rejectValue("tpfPassword", "required", new Object[]{"tpfPassword"}, "패스워드를 넣으세요");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfName", "requried", new Object[]{"이름"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfEmail", "requried", new Object[]{"이메일"}, "필수입력사항입니다.");
	
	}
	
}
