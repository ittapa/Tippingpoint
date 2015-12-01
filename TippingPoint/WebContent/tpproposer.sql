select * from tpproposer
select * from tpFunder
update tpFunder set TPFQUALIFYTPPROPOSER = 'F'

-- 추가정보 입력 DB
drop table tpProposer
drop table tpProposer

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

insert into tpProposer values ('1', '1002-141-587466', '개인사업자', 't', 920119, 2222222, '11111111');

insert into tpProposer values ('3', '1002-141-587466', '개인사업자', null, 920119, 2222222, '11111111');

insert into tpProposer values (#{tpfId}, #{account}, #{proposerType}, #{certification}, 
			 #{residentRegistrationFirstNum}, #{residentRegistrationLastNum}, #{corporateRegistrationNumber})

