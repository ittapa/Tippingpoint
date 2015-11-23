package kr.pe.tippingpoint.util;


/**
 * 페이징 처리위한 bean <br>
 * page : 내용(content)들의 묶음
 * page group : page 묶음
 * @author kgmyh
 *
 */
public class TpFunderPagingBean {
	/**
	 * 총 데이터(내용들:rows)의 개수
	 */
	private int totalContent;
	/**
	 * 현재 페이지
	 */
	private int currentPage;
	/**
	 * 한 페이지에 보여질 데이터(내용)개수
	 */
	public static int CONTENTS_PER_PAGE = 10;
	/**
	 * Page Group 내 Page 수.  페이지 그룹에 들어갈 페이지 개수
	 */
	public static int PAGES_PER_PAGEGROUP = 10;
	
	/**
	 * 총 데이터(내용) 개수, 현재 페이지를 받아 member variable에 할당
	 * @param totalContent
	 * @param currentPage
	 */
	public TpFunderPagingBean(int totalContent, int currentPage){
		this.totalContent = totalContent;
		this.currentPage = currentPage;
	}
	/**
	 * 현재 페이지 return
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * 현재 페이지 setting
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

/***************************************************************************
* 아래 메소드들을 구현하시오.
****************************************************************************/

	/**
	 * 총 페이지 수를 return한다.<br>
	 * 1. 전체 데이터(row) % 한 페이지에 보여줄 데이터 개수 => 0 이면 둘을 /  값이 총 페이지 수<br>
	 * 2. 전체 데이터(row) % 한 페이지에 보여줄 데이터 개수 => 0보다 크면 둘을 /  값에 +1을 한 값이 총 페이지 수
	 * @return
	 */
	private int getTotalPage(){
		int totalPage = 0;
		if(totalContent%CONTENTS_PER_PAGE != 0){
			totalPage = totalContent/CONTENTS_PER_PAGE +1;
		}else{
			totalPage = totalContent/CONTENTS_PER_PAGE;
		}		
		return totalPage;
	}
	/**
	 * 총 페이지 그룹의 수를 return한다.<br>
	 * 1. 총 페이지수 %  Page Group 내 Page 수.  => 0 이면 둘을 /  값이 총 페이지 수<br>
	 * 2. 총 페이지수 %  Page Group 내 Page 수.  => 0보다 크면 둘을 /  값에 +1을 한 값이 총 페이지 수
	 * @return
	 */
	private int getTotalPageGroup(){
		
		int totalPageGoup = 0;
		int totalPage = getTotalPage();//전체 페이지 수
		if(totalPage%PAGES_PER_PAGEGROUP != 0){
			totalPageGoup = totalPage/PAGES_PER_PAGEGROUP + 1;
		}else{
			totalPageGoup = totalPage/PAGES_PER_PAGEGROUP;
		}		
		return totalPageGoup;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹 번호(몇 번째 페이지 그룹인지) 을 return 하는 메소드
	 * 1. 현재 페이지 %  Page Group 내 Page 수 => 0 이면 둘을 / 값이 현재 페이지 그룹. 
	 * 2. 현재 페이지 %  Page Group 내 Page 수 => 0 크면 둘을 /  값에 +1을 한 값이 현재 페이지 그룹
	 * @return
	 */
	private int getCurrentPageGroup(){
		
		int currentPageGroup = 0;
		if(currentPage%PAGES_PER_PAGEGROUP != 0){
			currentPageGroup = currentPage / PAGES_PER_PAGEGROUP +1;
		}else{
			currentPageGroup = currentPage / PAGES_PER_PAGEGROUP;
		}
		return currentPageGroup;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹의 시작 페이지 번호를 return 한다.<br>
	 * 1. Page Group 내 Page 수*(현재 페이지 그룹 -1) + 1을 한 값이 첫 페이지이다.(페이지 그룹*페이지 그룹 개수 이 그 그룹의 마지막 번호이므로)
	 * 2. 위의 계산 결과가 0인 경우는 첫페이지 이므로 1을 return 한다. 
	 * @return
	 */
	public int getStartPageOfPageGroup(){
		int startPageNo = (getCurrentPageGroup()-1)*PAGES_PER_PAGEGROUP+1;
		return startPageNo;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹의 마지막 페이지 번호를 return 한다.<br>
	 * 1. 현재 페이지 그룹 * 페이지 그룹내 페이지 수 가 마지막 번호이다.
	 * 2. 그 그룹의 마지막 페이지 번호가 전체 페이지의 마지막 페이지 번호보다 큰 경우는 전체 페이지의 마지막 번호를 return 한다. 
	 * @return
	 */
	public int getEndPageOfPageGroup(){
		int endPageNo =getCurrentPageGroup()*PAGES_PER_PAGEGROUP;
		if(endPageNo>getTotalPage()){//마지막page가 총 page수 보다 크다면
			endPageNo = getTotalPage();
		}		
		return endPageNo;
	}
	/**
	 * 이전 페이지 그룹이 있는지 체크
	 * 현재 페이지가 속한 페이지 그룹이 1보다 크면 true
	 * @return
	 */
	public boolean isPreviousPageGroup(){		
		boolean flag = false;
		if(getCurrentPageGroup()!=1){//현재 pagegroup이 1이 아니면
			flag = true;
		}		
		return flag;
	}
	/**
	 * 다음 페이지 그룹이 있는지 체크
	 * 현재 페이지 그룹이 마지막 페이지 그룹(마지막 페이지 그룹 == 총 페이지 그룹 수) 보다 작으면 true
	 * @return
	 */
	public boolean isNextPageGroup(){		
		boolean flag = false;
		if(getCurrentPageGroup() < getTotalPageGroup()){
			flag = true;
		}		
		return flag;
	}
}









































































