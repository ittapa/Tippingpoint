package kr.pe.tippingpoint.controller;

import java.util.HashMap;
import java.util.Map;

/*
 * Attribute : Request Scope에 설정할 Attribute정보(설정은 front controller가 처리)
 * and
 * View - 응답할 View에 대한 정보를 저장할 VO. 
 * 	- 응답 방식을 boolean으로 이동할 View를 String으로 저장한다.
 */
public class AttributeAndView {
	private String url;//이동할 View의 URL, 경로
	private boolean redirect;//이동방식 - true:redirect방식, false:요청디스패치방식
	private Map<String, Object> attributes;
									//속성들 : String name-Object value X N개
	/**
	 * 이동할 URL을 설정하는 생성자.
	 * 요청방식 : 요청디스패치방식. 
	 * Attribute 는 없다.
	 * @param url
	 */
	public AttributeAndView(String url){
		this.url = url;
	}
	/**
	 * 이동할 URL과 이동방식을 설정하는 생성자.
	 * Attribute 는 없다.
	 * @param url
	 * @param redirect true:redirect방식, false:요청디스패치방식
	 */
	public AttributeAndView(String url, boolean redirect){
		this.url = url;
		this.redirect = redirect;
	}
	/**
	 * View의 정보와 Request Scope에 설정할(binding) Attribute설정 생성자
	 * @param url : 이동할 URL, (이동방식 : 요청디스패치-기본값)
	 * @param attribute : request scope에 binding할 Attribute들을 담은 Map
	 * 					  Attribute가 여러개일 경우 사용될 생성자.
	 */
	public AttributeAndView(String url, Map<String, Object> attribute){
		this.url = url;
		this.attributes = attribute;
	}
	/**
	 * View에 정보와 request scope에 설정할 Attribute 정보를 받는 생성자.
	 * 		- Attribute가 하나일 경우 호출될 생성자
	 * @param url : 이동할 URL (방식은 요청디스패치-기본값)
	 * @param attrName : Attribute의 이름
	 * @param attrValue : Attribute
	 */
	public AttributeAndView(String url, String attrName, Object attrValue){
		this.url = url;
		this.attributes = new HashMap<String, Object>();
		attributes.put(attrName, attrValue);
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	
}









