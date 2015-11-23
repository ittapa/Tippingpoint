package kr.pe.tippingpoint.exception;

/**
 * 수정/삭제할 고객을 찾지 못했을때 발생시킬 Exception
 */
public class TpFunderNotFoundException extends Exception{
	public TpFunderNotFoundException(){}
	public TpFunderNotFoundException(String message){
		super(message);
	}
}
