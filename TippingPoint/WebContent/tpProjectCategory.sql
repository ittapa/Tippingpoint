drop table tpProjectCategory
create table tpProjectCategory(
		tppCategory varchar2(20) primary key,
		tppCategoryName varchar2(20)
)
select * from tpProjectCategory
select * from tpProjectCategory
tpProjectCategory
insert into tpProjectCategory values('game','게임');
insert into tpProjectCategory values('startup','창업');
insert into tpProjectCategory values('donation','기부');
insert into tpProjectCategory values('business','사업');
insert into tpProjectCategory values('publish','출판');
insert into tpProjectCategory values('etc','기타');

select * from tpProjectCategory 

insert into tppCategory values('');


drop table tpProjectCategory


	<option  value= "null">카테고리를 선택하세요</option>
			<option  value= "game">게임</option>
			<option  value= "startup">창업</option>
			<option  value= "donation">기부</option>
			<option  value= "business">사업</option>
			<option  value= "publish">출판</option>
			<option  value= "etc">기타</option>