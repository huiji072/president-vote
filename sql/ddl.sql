drop table if exists member CASCADE;
create table member
(
id varchar(255) not null unique,
password varchar(255) not null,
name varchar(255) not null,
number int(100) not null unique,
rrn int(100) not null unique ,
primary key (id)

);

--insert into member(id, password, name, number, rrn) values('eunbin', '1234', '이은빈', '1234', '1234');
--insert into member(id, password, name, number, rrn) values('huiji', '1111', '김희지', '1111', '1111');