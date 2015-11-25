<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<form>
작성일 : <% %> 



	 
	   			작성자 : ${requestScope.noticeList.tpNoticeWriter }	 
	   			제목 : ${requestScope.noticeList.tpNoticeTitle }
				내용 :	${requestScope.noticeList.tpNoticeContents }
				
</form>