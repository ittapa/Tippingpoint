tpfudner / tpNotice / tpProjectCategory / tpProposer /tpProject / tpbankList


drop table TPFUNDER;
drop table tpnotice;
drop table tpProjectCategory;
drop table tpProposer;
drop table tpproject;
drop table banklist;
drop SEQUENCE SEQ_TPNOTICE_NUM

create table TPFUNDER(
	   TPFID varchar2(20) primary key,
	   TPFNAME varchar2(15) not null,
	   TPFPASSWORD varchar2(15) not null,
	   TPFBIRTH varchar2(10),
	   TPFGENDER varchar2(2),
	   TPFEMAIL varchar2(30) not null,
	   TPFZIPCODE varchar2(10) not null,
	   TPFADDRESS varchar2(100) not null,
	   TPFADDRESS_D varchar2(100),
	   TPFPHONENUM varchar2(13) unique,
	   TPFQUALIFYTPPROPOSER varchar2(5) not null,
	   TPFACCOUNTTYPE varchar2(2) not null,
	   TPFPROFILEIMG varchar2(100)
	);

create table tpnotice(
		   tpNoticeNum number(20) primary key,
		   tpNoticeDate varchar2(20),
		   tpNoticeTitle varchar2(200) not null,
		   tpNoticeContents long not null,
		   tpNoticeWriter varchar2(20)
		);
		
		CREATE SEQUENCE SEQ_TPNOTICE_NUM
		START WITH 1
		INCREMENT BY 1
		NOMAXVALUE
		NOCACHE;

create table tpProjectCategory(
		tppCategory varchar2(20) primary key,
		tppCategoryName varchar2(20)
		);
			insert into tpProjectCategory values('game','게임');
			insert into tpProjectCategory values('startup','창업');
			insert into tpProjectCategory values('donation','기부');
			insert into tpProjectCategory values('business','사업');
			insert into tpProjectCategory values('publish','출판');
			insert into tpProjectCategory values('etc','기타');
			
create table tpProposer (
   tpfId varchar2(20) primary key,
   account varchar2(20) not null,
   proposerType varchar2(50) not null,
   certification varchar2(10),
   residentRegistrationFirstNum varchar2(6) not null,
   residentRegistrationLastNum varchar2(7) not null,
   corporateRegistrationNumber varchar2(15),
   bankListCategory varchar2(10) not null
);
			
create table tpproject(
tppId varchar2(100) primary key,
tppTitle varchar2(200) not null,
tppProjectContent long not null,
tppWriter varchar2(100) not null,
tppWriteDate number(20) not null,
tppTotalAmount number(30) default(0),
tppTargetAmount number(30) not null, 
tppFundingStartDate varchar2(10) not null,
tppFundingLastDate varchar2(10) not null,
tppFunderNum number(20) default(0),
tppState varchar2(4) default('a'),
tppAdminMessage varchar2(200),
tppMainImg varchar2(100) not null,
tppCategory varchar2(20) not null	
);


create table banklist (

	bankKr varchar2(50),
	bankEr varchar2(50) primary key, 
	code varchar2(10)
);

insert into banklist values ('기업', 'ibk', '033');
insert into banklist values ('외환', 'wh', '005');
insert into banklist values ('국민', 'kb', '004');
insert into banklist values ('농협', 'nh', '011');
insert into banklist values ('우리', 'woori', '020');
insert into banklist values ('신한', 'shinhan', '088');
insert into banklist values ('제일', 'jaeil', '023');
insert into banklist values ('씨티', 'city', '027');
insert into banklist values ('대구', 'daegu', '031');
insert into banklist values ('부산', 'busan', '032');
insert into banklist values ('동양증권', 'dongyang', '209');
insert into banklist values ('미래에셋', 'mirae', '230');
insert into banklist values ('신한금융투자', 'shinhangy', '278');
insert into banklist values ('광주', 'guangju', '034');
insert into banklist values ('전북', 'jeonbuk', '037');
insert into banklist values ('경남', 'kyungnam', '039');
insert into banklist values ('우체국', 'woochaeguk', '071');
insert into banklist values ('하나', 'hana', '081');
insert into banklist values ('신협', 'shinhyup', '048');
insert into banklist values ('새마을금고', 'saemaeul', '045');
insert into banklist values ('제주', 'jeju', '035');
insert into banklist values ('수협', 'suhyup', '007');
insert into banklist values ('산업', 'sanyup', '002');
insert into banklist values ('삼성증권', 'sansung', '240');
insert into banklist values ('한국투자증권', 'hanguk', '243');
insert into banklist values ('한화증권', 'hanwha', '269');



