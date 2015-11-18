drop table tpproject

create table tpproject(
	tpp_Id varchar2(100) primary key,
	tpp_Title varchar2(200) not null,
	tpp_ProjectContent varchar2(2000) not null,
	tpp_Writer varchar2(100) not null,
	tpp_WriteDate number(20) not null,
	tpp_TotalAmount number(20) default(0),
	tpp_TargetAmount number(20),
	tpp_FundingStartDate number(20),
	tpp_FundingLastDate number(20),
	tpp_FunderNum number(20) default(0),
	tpp_State varchar2(10) default('s'),
	tpp_AdminMessage varchar2(200)
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

select rownum, tpp_Title, tpp_Writer from tpproject
select tpp_Title, tpp_Writer, tpp_FundingLastDate, tpp_TotalAmount
	 		from(
	 			select ceil(rownum/10) page, tpp_Title, tpp_Writer, tpp_FundingLastDate, tpp_TotalAmount
	 			from(
	 				select tpp_Title, tpp_Writer, tpp_FundingLastDate, tpp_TotalAmount
	 				from tpproject
	 				order by tpp_FundingLastDate
	 			)
	 		) 
		where page = 1
	 	
	 	
select count(tpp_Id) from tpproject



select tpp_Id, tpp_Title, tpp_ProjectContent, tpp_Writer, tpp_WriteDate, tpp_TotalAmount,
				 tpp_TargetAmount, tpp_FundingStartDate, tpp_FundingLastDate, 
				 tpp_FunderNum, tpp_State, tpp_AdminMessage from tpproject where tpp_Id = '2'





