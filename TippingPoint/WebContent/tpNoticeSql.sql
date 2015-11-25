drop table tpnotice;


select * from tpnotice;

-- 공지
create table tpnotice(
	tpNoticeNum number(20) primary key,
	tpNoticeDate varchar2(10),
	tpNoticeTitle varchar2(200) not null,
	tpNoticeContents varchar2(2000) not null,
	tpNoticeWriter varchar2(20)
);


insert into tpnotice values(1,'20151120', '첫번째 공지', '첫번째 공지사항입니다 ㅎㅎㅎㅎㅎㅎㅎ','관리자');
insert into tpnotice values(2,'20151120', '두번째 공지', '두번째 공지사항입니다 ㅎㅎㅎㅎㅎㅎㅎ','admin');
insert into tpnotice values(3,'20151120', '세번째 공지', '세번째 공지사항입니다 ㅎㅎㅎㅎㅎㅎㅎ','admin');