use rivetbank;
select * from users;
DELETE users WHERE id=5;

alter table users add accountType varchar(45) CHECK(accountType IN('saving', 'current'));
alter table users add Gender varchar(10) check(Gender in('M','F'));

insert into users values(1234567891, 'abhi', 123, 'vapi', 23, 12000, 'saving', 'M');

ALTER TABLE users  DROP COLUMN accountType;    

alter table users drop accountType;
ALTER TABLE users DROP CONSTRAINT accountType;
alter table users alter age bigint; 

create table customer(id int PRIMARY kEY, name varchar(48) not null, mobileNumber int not null, city varchar(45) not null, accountType varchar(45) not null,
accountNumber int,  balance DECIMAL(10), age tinyint, Gender varchar(10));

select * from customer;

create table rivetBankAdmin(userId varchar(128) not null, password varchar(16) not null);

insert into rivetbankadmin values('111', '111');

delete from rivetbankadmin where userid ='111'
select * from rivetbankadmin;
SELECT * FROM customer WHERE id=3


create table jdbc(id int, name varchar(16), city varchar(15));
