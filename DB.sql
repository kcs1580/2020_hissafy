create database ssafy_db;
use ssafy_db;
drop table Pro;
create table Pro (
	Pro_ID varchar(30),
    Pro_PW varchar(30) NOT NULL,
    Pro_NAME varchar(30) NOT NULL,
    Pro_area varchar(30),
    primary key (Pro_ID)
)DEFAULT CHARSET=UTF8;

insert into `Pro` (`Pro_ID`, `Pro_PW`, `Pro_NAME`, `Pro_area`) values
('admin', 'admin', 'SSAFY_PRO', '광주');

select * from Pro;

create table student(
	id int not null,
    group_num int, 
    area varchar(30),
    class int,
    name varchar(30),
    state boolean,
    face_id varchar(40),
    primary key (id)
)DEFAULT CHARSET=UTF8;

select * from student;

create table attendance(
	attendance_date date not null,
    id int not null , 
    attendance_time varchar(30),
    leaving_time varchar(30), 
    attendance_state varchar(30),
    primary key(attendance_date, id),
    foreign key (id) references student(id)
)DEFAULT CHARSET=UTF8;

select * from attendance;