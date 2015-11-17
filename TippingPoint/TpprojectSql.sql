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


insert into tpproject values(100, '홍대리', 'aa@ss.com', '회장', 90000000, '20001212', 1);
insert into tpproject values('2','2','2','2', 20121212, 1, 1, 20121212, 20121212, 1, '2', '3');


select tppTitle, tppWriter, tppFundingLastDate, tppTotalAmount
	 		from(
	 			select ceil(1/2) page, tppTitle, tppWriter, tppFundingLastDate, tppTotalAmount
	 			from(
	 				select tppTitle, tppWriter, tppFundingLastDate, tppTotalAmount
	 				from tpproject
	 				order by tppFundingLastDate
	 			)
	 		) 
	 	where page = 1
