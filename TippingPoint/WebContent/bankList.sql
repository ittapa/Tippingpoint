create table banklist (

	bankKr varchar2(50),
	bankEr varchar2(50) primary key, 
	code varchar2(10)
)

drop table banklist

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

