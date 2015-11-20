package kr.pe.tippingpoint.exception;

/**
 * 수정/삭제할 고객을 찾지 못했을때 발생시킬 Exception
 */
public class TpfunderNotFoundException extends Exception{
	public TpfunderNotFoundException(){}
	public TpfunderNotFoundException(String message){
		super(message);
	}
}
