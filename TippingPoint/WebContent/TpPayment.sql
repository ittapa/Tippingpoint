/* 결제정보 */
CREATE TABLE TPPROJECTFUNDINGLIST (
	LISTNUM NUMBER NOT NULL, /* 결제정보테이블ID */
	tppId varchar2(100), /* 프로젝트ID */
	TPFID VARCHAR2(20), /* 일반회원ID */
	TPCID NUMBER, /* 카드결제ID */
	TPAID NUMBER, /* 계좌이체정보ID */
	tppPayType VARCHAR2(1) NOT NULL, /* 결제타입 */
	tppPayState CHAR(1) DEFAULT 'o' NOT NULL, /* 결제상태 */
	tppPayDateTime DATE NOT NULL, /* 결제일시 */
	tppPayCancelReqDateTime DATE, /* 현금결제취소요청일 */
	TPCCID NUMBER /* 카드결제취소ID */
);

COMMENT ON TABLE TPPROJECTFUNDINGLIST IS '결제 취소시, 결제완료정보가 결제취소정보로 이동됨';

COMMENT ON COLUMN TPPROJECTFUNDINGLIST.LISTNUM IS '결제정보테이블ID';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.tppId IS '프로젝트ID';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.TPFID IS '일반회원ID';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.TPCID IS '카드결제ID';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.TPAID IS '계좌이체정보ID';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.tppPayType IS '카드/현금 결제방식';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.tppPayState IS 'p:현금입금요청 / o:결제완료 / r:취소요청 / c:취소완료
현금입금요청(p)->현금결제완료(o)
취소요청(r)->취소완료(c)

현금결제완료: 카드결제완료 및 현금결제완료';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.tppPayDateTime IS '카드: 결제완료일시 / 현금: 입금확인요청일시';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.tppPayCancelReqDateTime IS '현금결제취소요청시, 요청일시 저장후, 결제취소처리 완료시 이용';
COMMENT ON COLUMN TPPROJECTFUNDINGLIST.TPCCID IS '카드결제취소ID';

CREATE UNIQUE INDEX PK_TPPROJECTFUNDINGLIST
	ON TPPROJECTFUNDINGLIST (
		LISTNUM ASC
	);
	
ALTER TABLE TPPROJECTFUNDINGLIST
	ADD
		CONSTRAINT PK_TPPROJECTFUNDINGLIST
		PRIMARY KEY (
			LISTNUM
		);

SELECT * FROM TPPROJECTFUNDINGLIST;



/* 계좌이체정보 */
CREATE TABLE TPACCOUNTPAYMENT (
	TPAID NUMBER NOT NULL, /* 계좌이체정보ID */
	tpaAmount NUMBER(15) DEFAULT 0 NOT NULL, /* 금액 */
	tpaReBank VARCHAR2(25) NOT NULL, /* 환불은행 */
	tpaReUserName VARCHAR2(20), /* 환불예금주 */
	tpaReBankAccount VARCHAR2(25) NOT NULL, /* 환불계좌 */
	tpaAccDateTime DATE /* 결제처리일시 */
);

COMMENT ON TABLE TPACCOUNTPAYMENT IS '계좌이체시 취소정보 포함';

COMMENT ON COLUMN TPACCOUNTPAYMENT.TPAID IS '계좌이체정보ID';
COMMENT ON COLUMN TPACCOUNTPAYMENT.tpaAmount IS '금액';
COMMENT ON COLUMN TPACCOUNTPAYMENT.tpaReBank IS '환불은행';
COMMENT ON COLUMN TPACCOUNTPAYMENT.tpaReUserName IS '환불예금주';
COMMENT ON COLUMN TPACCOUNTPAYMENT.tpaReBankAccount IS '환불계좌';
COMMENT ON COLUMN TPACCOUNTPAYMENT.tpaAccDateTime IS '입금 확인처리DATE(어드민)';

CREATE UNIQUE INDEX PK_TPACCOUNTPAYMENT
	ON TPACCOUNTPAYMENT (
		TPAID ASC
	);
	
ALTER TABLE TPACCOUNTPAYMENT
	ADD
		CONSTRAINT PK_TPACCOUNTPAYMENT
		PRIMARY KEY (
			TPAID
		);

SELECT * FROM TPACCOUNTPAYMENT;

/* 카드결제완료 */
CREATE TABLE TPCARDPAYMENT (
	TPCID NUMBER NOT NULL, /* 카드결제ID */
	TPLGD_RESPCODE VARCHAR2(4) DEFAULT '0000' NOT NULL, /* 응답코드 */
	TPLGD_RESPMSG VARCHAR2(160), /* 응답메세지 */
	TPLGD_OID VARCHAR2(64) NOT NULL, /* 상점 거래번호(주문번호) */
	TPLGD_TID VARCHAR2(24) NOT NULL, /* LG유플러스 거래번호 */
	TPLGD_HASHDATA VARCHAR2(150), /* 해쉬데이타 */
	TPLGD_FINANCECODE VARCHAR2(10), /* 결제기관코드 */
	TPLGD_FINANCENAME VARCHAR2(20), /* 결제기관명 */
	TPLGD_ESCROWYN CHAR(1) DEFAULT 'N', /* 최종 에스크로 적용 여부 */
	TPLGD_TRANSAMOUNT VARCHAR2(12), /* 환율적용금액 */
	TPLGD_EXCHANGERATE VARCHAR2(12), /* 적용환율 */
	TPLGD_BUYER VARCHAR2(10) NOT NULL, /* 구매자명 */
	TPLGD_BUYERPHONE VARCHAR2(11), /* 고객휴대폰번호 */
	TPLGD_BUYEREMAIL VARCHAR2(40), /* 구매자이메일 */
	TPLGD_PRODUCTINFO VARCHAR2(128), /* 구매내역 */
	TPLGD_CARDNUM VARCHAR2(20) NOT NULL, /* 신용카드번호 */
	TPLGD_CARDINSTALLMONTH VARCHAR2(2), /* 신용카드할부개월 */
	TPLGD_CARDNOINTYN NUMBER(1,0) DEFAULT 0, /* 신용카드무이자여부 */
	TPLGD_FINANCEAUTHNUM VARCHAR2(20), /* 결제기관승인번호 */
	TPCAmount NUMBER NOT NULL /* 결제금액 */
);

COMMENT ON TABLE TPCARDPAYMENT IS '카드결제완료';

COMMENT ON COLUMN TPCARDPAYMENT.TPCID IS '카드결제ID';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_RESPCODE IS '응답코드, ''0000'' 이면 성공 이외는 실패';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_RESPMSG IS '응답메세지';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_OID IS '상점 거래번호(주문번호)';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_TID IS 'LG유플러스 거래번호';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_HASHDATA IS '해쉬데이타';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_FINANCECODE IS '결제기관코드';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_FINANCENAME IS '결제기관명';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_ESCROWYN IS '최종 에스크로 적용 여부';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_TRANSAMOUNT IS '환율적용금액';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_EXCHANGERATE IS '적용환율';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_BUYER IS '구매자명';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_BUYERPHONE IS '고객휴대폰번호';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_BUYEREMAIL IS '구매자이메일';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_PRODUCTINFO IS '구매내역';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_CARDNUM IS '신용카드번호(일반 가맹점은 *처리됨)';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_CARDINSTALLMONTH IS '신용카드할부개월';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_CARDNOINTYN IS '신용카드무이자여부
1: 무이자 0 : 일반';
COMMENT ON COLUMN TPCARDPAYMENT.TPLGD_FINANCEAUTHNUM IS '결제기관승인번호';
COMMENT ON COLUMN TPCARDPAYMENT.TPCAmount IS '20151118 추가: 결제금액';

CREATE UNIQUE INDEX PK_TPCARDPAYMENT
	ON TPCARDPAYMENT (
		TPCID ASC
	);
	
ALTER TABLE TPCARDPAYMENT
	ADD
		CONSTRAINT PK_TPCARDPAYMENT
		PRIMARY KEY (
			TPCID
		);

SELECT * FROM TPCARDPAYMENT;



/* 카드취소완료 */
CREATE TABLE TPCANCELCARDPAYMENT (
	TPCCID NUMBER NOT NULL, /* 카드결제취소ID */
	TPLGD_RESPCODE VARCHAR2(4) NOT NULL, /* 응답코드 */
	TPLGD_RESPMSG VARCHAR2(160), /* 응답메세지 */
	tpcAccDateTime DATE /* 취소처리일시 */
);

COMMENT ON TABLE TPCANCELCARDPAYMENT IS '카드취소완료';
COMMENT ON COLUMN TPCANCELCARDPAYMENT.TPCCID IS '카드결제취소ID';
COMMENT ON COLUMN TPCANCELCARDPAYMENT.TPLGD_RESPCODE IS '취소성공 처리해야 할 결과코드: 0000, AV11';
COMMENT ON COLUMN TPCANCELCARDPAYMENT.TPLGD_RESPMSG IS '응답메세지';
COMMENT ON COLUMN TPCANCELCARDPAYMENT.tpcAccDateTime IS '취소처리일시';

CREATE UNIQUE INDEX PK_TPCANCELCARDPAYMENT
	ON TPCANCELCARDPAYMENT (
		TPCCID ASC
	);
	
ALTER TABLE TPCANCELCARDPAYMENT
	ADD
		CONSTRAINT PK_TPCANCELCARDPAYMENT
		PRIMARY KEY (
			TPCCID
		);

SELECT * FROM TPCANCELCARDPAYMENT;