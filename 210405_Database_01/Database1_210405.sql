create database homeworkDB
default character set utf8mb3 collate utf8mb3_general_ci;

use homeworkDB;
-- 1번
create table product(
	productid char(4) not null,
    productname varchar(20) not null,
    price int not null,
    adder varchar(16) not null,
    adddate timestamp not null default current_timestamp,
    primary key(productid)
)engine=InnoDB default charset=utf8;
-- 2번
insert into product
values('1234', 'TV', 1000000, 'mmmm', now()); 

insert into product
values('2222', '노트북', 1500000, 'mmmm', now());

insert into product
values('7891', '모니터', 500000, 'mmmm', now());

insert into product
values('2233', '아이패드', 700000, 'mmmm', now());

insert into product
values('8979', '미네랄워터', 2000, 'mmmm', now());

insert into product
values('7891', '모니터', 500000, 'mmmm', now());

insert into product
values
('7788', '삼성TV', 1500000, 'mmmm', now()),
('8526', '삼성TV(QLED)', 2000000, 'mmmm', now());

select * from product;
-- 3번
select productid, productname, price, ceil(price*0.85) sale, adder, adddate 
from product;
-- 4번
update product set price=ceil(price*0.8)
where productname like '%TV%';

select * from product;
-- 5번
select sum(price) sum from product;


 