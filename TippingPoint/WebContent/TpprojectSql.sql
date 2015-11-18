drop table tpproject

select * from TPPROJECT


create table tpproject(
	tppId varchar2(100) primary key,
	tppTitle varchar2(200) not null,
	tppProjectContent varchar2(2000) not null,
	tppWriter varchar2(100) not null,
	tppWriteDate number(20) not null,
	tppTotalAmount number(20) default(0),
	tppTargetAmount number(20),
	tppFundingStartDate varchar2(10),
	tppFundingLastDate varchar2(10),
	tppFunderNum number(20) default(0),
	tppState varchar2(4) default('a'),
	tppAdminMessage varchar2(200),
	tppMainImg varchar2(100),
	tppCategroy varchar2(20)
	
);

select * from TPPROJECT
select tppProjectContent from TPPROJECT




insert into tpproject values('id1','title','2','내용', 20121212, 10000, 999999, '20121212', '20121212', 1, 'a', 'message','메인이미지경로','game');
insert into tpproject values('id2','title','2','내용', 20121212, 10000, 999999, '20121212', '20121212', 1, 'a', 'message','메인이미지경로','game');
insert into tpproject values('id3','title','2','내용', 20121212, 10000, 999999, '20121212', '20121212', 1, 'b', 'message','메인이미지경로','game');
insert into tpproject values('id4','title','2','내용', 20121212, 10000, 999999, '20121212', '20121212', 1, 'b', 'message','메인이미지경로','game');



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





