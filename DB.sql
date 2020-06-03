create database hissafy;
use hissafy;
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

drop table student;
create table student(
	student_id varchar(30) not null,
    area varchar(30),
    group_num int, 
    class_num int,
    name varchar(30),
    state varchar(30),
    face_id varchar(40),
    primary key (student_id)
)DEFAULT CHARSET=UTF8;

insert into `student`  (`student_id`,`group_num`,`area`,`class_num`,`name`,`state`,`face_id`) values
('0211062','2', '광주','1','이하연', '재학', '123');

select * from student;
select student_id, area, group_num, class_num, name, state, face_id
		from Student;
select student_id, area, group_num, class_num, name, state, face_id
from Student;
drop table attendance;
create table attendance(
	attendance_date date not null,
    student_id int not null , 
    attendance_time varchar(30),
    leaving_time varchar(30), 
    attendance_state varchar(30),
    primary key(attendance_date, student_id),
    foreign key (student_id) references student(student_id)
)DEFAULT CHARSET=UTF8;

drop table timeConfig;
create table timeConfig(
time_id int auto_increment ,
  attendance_start_h varchar(10) not null,
  attendance_start_m varchar(10) not null,
  attendance_end_h varchar(10) not null,
  attendance_end_m varchar(10) not null,
  leaving_start_h varchar(10) not null,
  leaving_start_m varchar(10) not null,
  leaving_end_h varchar(10) not null,
  leaving_end_m varchar(10) not null,
  primary key(time_id)
);
