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
				errors.reject("notsupport","에러");
				return;
			}
			
			TpFunder tpfunder = (TpFunder)target;
			
			if(tpfunder.getTpfPassword()==null || tpfunder.getTpfPassword().trim().length() < 8){
				errors.rejectValue("tpfPassword", "pass", new Object[]{"비밀번호"}, " ");
			}
			
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfName", "requried", new Object[]{"이름"}, "필수입력사항입니다.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfEmail", "requried", new Object[]{"이메일"}, "필수입력사항입니다.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfZipcode", "required", new Object[]{"우편번호"}, "필수입력사항입니다.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfAddress", "required", new Object[]{"주소"}, "필수입력사항입니다.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tpfAddressD", "required", new Object[]{"상세주소"}, "필수입력사항입니다.");
		}
	
}
