show databases;
use bookmanagesys;
-- use minedb;
-- use minesecond;
show tables;


drop table jennycustomer;
----------------------- 创建名字temp表格--------------------------------------

CREATE TABLE temp (
                      number INT(11),
                      name VARCHAR(255),
                      location VARCHAR(255)
);

-- DROP TABLE temp;

desc temp;

select * from temp;

insert into temp values('123','Tom','Changsha');



--------------------- 创建customer表格 -----------------------------------------

CREATE TABLE Customer(
                         customer_user VARCHAR(255) primary key,
                         customer_password VARCHAR(255)
);

-- DROP TABLE Customer;

desc Customer;

select * from Customer;

delete from Customer where customer_user = '123';

insert into customer values('wangshaoyong','12345678');
insert into customer values("tom","12345");

update Customer set customer_password = '123' where customer_user = '123';

delete from Customer where  customer_user = 'jenny';
delete from Customer where  customer_user = 'tony' or customer_user = 'wangshaoyong';


select * from customer;


--------------------   创建naturebook表格------------------------------------------

CREATE TABLE NatureBook(
                           number VARCHAR(255) primary key,
                           classnumber VARCHAR(255),
                           name VARCHAR(255),
                           classname VARCHAR(255),
                           price VARCHAR(255),
                           state VARCHAR(255),
                           total VARCHAR(255)
);

select * from NatureBook;

desc NatureBook;

insert into NatureBook values('N01','1','Nature and Science','Nature','25','在馆','1');
insert into NatureBook values('N02','1','My Nature Science ','Nature','23','在馆','1');
insert into NatureBook values('N03','1','Wonderful Nature  ','Nature','21','在馆','1');
insert into NatureBook values('N04','1','Amazing Nature    ','Nature','22','在馆','1');
insert into NatureBook values('N05','1','Good Science Nature','Nature','25','在馆','1');
insert into NatureBook values('N06','1','People and Nature ','Nature','26','在馆','1');
insert into NatureBook values('N07','1','Hello Nature      ','Nature','14','在馆','1');
insert into NatureBook values('N08','1','Goodbye Nature    ','Nature','26','在馆','1');
insert into NatureBook values('N09','1','Great Nature      ','Nature','20','在馆','1');
insert into NatureBook values('N10','1','Buzz Nature       ','Nature','32','在馆','1');

update NatureBook set total = '1';


alter table NatureBook add column current VARCHAR(255);

alter table NatureBook add column dateon VARCHAR(255);

alter table NatureBook add column dateoff VARCHAR(255);

DESC NatureBook;
select * from NatureBook;
--  drop table naturebook;

--------------------------- 创建sciencebook表格 -----------------------------------

CREATE TABLE ScienceBook(number VARCHAR(255) primary key,classnumber VARCHAR(255),name VARCHAR(255),classname VARCHAR(255),price VARCHAR(255),state VARCHAR(255),total VARCHAR(255) );


select * from ScienceBook;

alter table ScienceBook add column current VARCHAR(255);

alter table ScienceBook add column dateon VARCHAR(255);

alter table ScienceBook add column dateoff VARCHAR(255);

update scienceBook set current = '123' where number = 'S01';

update scienceBook set dateoff = '20170920' where number = 'S01';



-------------------------------


create table 修仙Book(
                         number VARCHAR(255) primary key,
                         classnumber VARCHAR(255),
                         name VARCHAR(255),
                         classname VARCHAR(255),
                         price VARCHAR(255),
                         state VARCHAR(255),
                         total VARCHAR(255)
);
insert into 修仙Book values('N01','1','篮球      ','修仙','25','在馆','∞');
insert into 修仙Book values('N02','1','中分      ','修仙','23','在馆','∞');
insert into 修仙Book values('N03','1','背带裤    ','修仙','21','在馆','∞');
insert into 修仙Book values('N04','1','铁山靠    ','修仙','22','在馆','∞');
insert into 修仙Book values('N05','1','ikun      ','修仙','25','在馆','∞');

select * from 修仙Book;



-- 中文表格居然要这样删，像drop table 修仙Book；是不行的！！！
DROP TABLE `bookmanagesys`.`修仙book`;

