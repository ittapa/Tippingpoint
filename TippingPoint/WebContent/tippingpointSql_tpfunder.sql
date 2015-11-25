create table TPFUNDER(
   TPFID varchar2(20) primary key,
   TPFNAME varchar2(15) not null,
   TPFPASSWORD varchar2(15) not null,
   TPFBIRTH varchar2(10),
   TPFGENDER varchar2(2),
   TPFEMAIL varchar2(30),
   TPFZIPCODE varchar2(10) not null,
   TPFADDRESS varchar2(100) not null,
   TPFADDRESS_D varchar2(100),
   TPFPHONENUM varchar2(13) not null,
   TPFQUALIFYTPPROPOSER varchar2(5) not null,
   TPFACCOUNTTYPE varchar2(2) not null
);

drop table TPFUNDER;
select * from TPFUNDER

INSERT INTO TPFUNDER VALUES ('admin', 'loginuser', 'admin', '19910707', 'F', '123', '122030',
		        'asd', 'asd', '01000000', '0', 'd');

INSERT INTO TPFUNDER VALUES ('1', '1', '1', '19910707', 'F', '123', '122030',
		        'asd', 'asd', '01000000', '0', 'd');
INSERT INTO TPFUNDER VALUES ('2', '2', '2', '19910707', 'F', '123', '122030',
		        'asd', 'asd', '01000000', '0', 'd');

		        
SELECT		TPFQUALIFYTPPROPOSER
			FROM	tpFunder
			
			
			
			select TPFID, TPFNAME, TPFPASSWORD, TPFBIRTH, TPFGENDER,  TPFEMAIL, TPFZIPCODE,  TPFADDRESS,
        		   TPFADDRESS_D, TPFPHONENUM, TPFQUALIFYTPPROPOSER,  TPFACCOUNTTYPE
		from (
			select TPFID, TPFNAME, TPFPASSWORD, TPFBIRTH, TPFGENDER,  TPFEMAIL, TPFZIPCODE,  TPFADDRESS,
        		   TPFADDRESS_D, TPFPHONENUM, TPFQUALIFYTPPROPOSER,  TPFACCOUNTTYPE, ceil(rownum/10) page
			from(
				select TPFID, TPFNAME, TPFPASSWORD, TPFBIRTH, TPFGENDER,  TPFEMAIL, TPFZIPCODE,  TPFADDRESS,
        		   TPFADDRESS_D, TPFPHONENUM, TPFQUALIFYTPPROPOSER,  TPFACCOUNTTYPE
				from TPFUNDER
				order by TPFID
			)
		)
		where page = 1
		
		