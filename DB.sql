create database ssafy_db;

use ssafy_db;

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
	student_id int not null,
    group_num int, 
    area varchar(30),
    class_num int,
    name varchar(30),
    state varchar(30),
    face_id varchar(40),
    primary key (student_id)
)DEFAULT CHARSET=UTF8;

insert into Student
(student_id, area, group_num, class_num, name, state, face_id)
values
(1,"광주",2,2,"강기동","퇴소","1"),
(2,"광주",2,2,"김대들","입과","2"),
(3,"광주",2,2,"김보현","입과","3"),
(4,"광주",2,2,"김진출","퇴소","4"),
(5,"광주",2,2,"김창수","입과","5"),
(6,"광주",2,2,"김태동","입과","6"),
(7,"광주",2,2,"문지환","입과","7"),
(8,"광주",2,2,"박종수","입과","8"),
(9,"광주",2,2,"박호연","입과","9"),
(10,"광주",2,2,"방준영","입과","10"),
(11,"광주",2,2,"서현준","입과","11"),
(12,"광주",2,2,"송광우","퇴소","12"),
(13,"광주",2,2,"양성진","입과","13"),
(14,"광주",2,2,"오지윤","입과","14"),
(15,"광주",2,2,"원태희","입과","15"),
(16,"광주",2,2,"이경석","입과","16"),
(17,"광주",2,2,"이상아","퇴소","17"),
(18,"광주",2,2,"이하연","입과","18"),
(19,"광주",2,2,"정성원","퇴소","19"),
(20,"광주",2,2,"정준호","퇴소","20"),
(21,"광주",2,2,"정희선","입과","21"),
(22,"광주",2,2,"조승우","퇴소","22"),
(23,"광주",2,2,"최용선","퇴소","23"),
(24,"광주",2,2,"최창현","입과","24");

select * from student;

create table attendance(
	student_id int not null,
	attendance_date date not null,
    attendance_time varchar(30),
    leaving_time varchar(30), 
    attendance_state varchar(30),
    primary key(attendance_date, student_id),
    foreign key (student_id) references student(student_id)
)DEFAULT CHARSET=UTF8;

select * from attendance;

insert into attendance
(student_id, attendance_date, attendance_time, leaving_time, attendance_state)
values
(2,"2020-06-02",null,null,null),
(3,"2020-06-02",null,null,null),
(5,"2020-06-02",null,null,null),
(6,"2020-06-02",null,null,null),
(7,"2020-06-02",null,null,null),
(8,"2020-06-02",null,null,null),
(9,"2020-06-02",null,null,null),
(10,"2020-06-02",null,null,null),
(11,"2020-06-02",null,null,null),
(13,"2020-06-02",null,null,null),
(14,"2020-06-02",null,null,null),
(15,"2020-06-02",null,null,null),
(16,"2020-06-02",null,null,null),
(18,"2020-06-02",null,null,null),
(21,"2020-06-02",null,null,null),
(24,"2020-06-02",null,null,null);