package kr.pe.tippingpoint.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.pe.tippingpoint.vo.TpProposer;

public class TpProposerValidator implements Validator{

	@Override
	public boolean supports (Class<?> clazz) {
		return clazz.isAssignableFrom(TpProposer.class);
	}
	
	@Override
	public void validate (Object target, Errors errors) {
		
		if (!supports(target.getClass())) {
			errors.reject("notsupport", "에러");
			return;
		}
		
		TpProposer tpproposer = (TpProposer)target;
		
		if(tpproposer.getBankListCategory().equals("null")){
			System.out.println("은행잘못입력");
			errors.rejectValue("bankListCategory", "required", new Object[]{"은행정보"}, "은행정보를 선택해주세요");
		}
		
		if (tpproposer.getAccount().trim().length() == 0) {
			errors.rejectValue("account", "required", new Object[]{"계좌번호"}, "다시 입력해주세요.");
		}
		if (tpproposer.getAccount().trim().length() < 10) {
			errors.rejectValue("account", "checkacount", new Object[]{"계좌번호"}, "계좌번호를 확인해주세요.");
		}
		if (tpproposer.getResidentRegistrationFirstNum() == null || tpproposer.getResidentRegistrationFirstNum().trim().length() != 6 ||
				tpproposer.getResidentRegistrationLastNum() == null || tpproposer.getResidentRegistrationLastNum().trim().length() != 7) {
			errors.rejectValue("residentRegistrationFirstNum", "check", new Object[]{"주민번호"}, "주민번호를 확인해주세요");
		}
		
		if(tpproposer.getProposerType().equals("null")){
			System.out.println("제안자 유형 입력안한거");
			errors.rejectValue("proposerType","selected",new Object[]{"제안자 유형을 선택해주세요"},"제안자 유형을 선택해주세요");
		}
		
		if (tpproposer.getCorporateRegistrationNumber() == null ) {
			errors.rejectValue("corporateRegistrationNumber", "required", new Object[]{"사업자 번호"}, "필수 입력 사항입니다. ");
		}
		if (tpproposer.getCorporateRegistrationNumber().trim().length() != 10 ) {
			errors.rejectValue("corporateRegistrationNumber", "bbbb", new Object[]{"사업자 번호"}, "사업자번호 10자리를 입력해주시기 바랍니다.");
		}
	
		
	}
}


























