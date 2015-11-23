package kr.pe.tippingpoint.exception;
/**
 * 등록하려는 고객의 ID가 이미 있는 경우 발생시킬 Exception
 */
public class DuplicatedIdException extends Exception {

	public DuplicatedIdException(){}
	public DuplicatedIdException(String message){
		super(message);
	}
}
