drop table tpproject

create table tpproject(
	tppId varchar2(100) primary key,
	tppTitle varchar2(200) not null,
	tppProjectContent varchar2(2000) not null,
	tppWriter varchar2(100) not null,
	tppWriteDate number(20) not null,
	tppTotalAmount number(20) default(0),
	tppTargetAmount number(20),
	tppFundingStartDate number(20),
	tppFundingLastDate number(20),
	tppFunderNum number(20) default(0),
	tppState varchar2(10) default('s'),
	tppAdminMessage varchar2(200)
	
);

select * from TPPROJECT

insert into tpproject values(100, '홍대리', 'aa@ss.com', '회장', 90000000, '20001212', 1);
insert into tpproject values('56','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('57','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('58','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('59','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('50','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('71','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('72','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('73','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('74','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('72','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('76','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('78','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');


insert into tpproject values('156','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('157','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('158','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('159','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('150','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('171','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('172','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('173','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('174','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('172','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('176','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('178','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');


insert into tpproject values('256','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('257','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('258','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('259','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('250','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('271','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('272','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('273','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('274','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('272','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('276','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');
insert into tpproject values('278','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');

select rownum, tppTitle, tppWriter from tpproject
select tppTitle, tppWriter, tppFundingLastDate, tppTotalAmount
	 		from(
	 			select ceil(rownum/10) page, tppTitle, tppWriter, tppFundingLastDate, tppTotalAmount
	 			from(
	 				select tppTitle, tppWriter, tppFundingLastDate, tppTotalAmount
	 				from tpproject
	 				order by tppFundingLastDate
	 			)
	 		) 
		where page = 1
	 	
	 	
select count(tppId) from tpproject



select tppId, tppTitle, tppProjectContent, tppWriter, tppWriteDate, tppTotalAmount,
				 tppTargetAmount, tppFundingStartDate, tppFundingLastDate, 
				 tppFunderNum, tppState, tppAdminMessage from tpproject where tppId = '2'





