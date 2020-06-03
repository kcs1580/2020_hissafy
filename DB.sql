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

insert into Student
(student_id, area, group_num, class_num, name, state, face_id)
values
("0211001","광주",2,2,"강기동","퇴소","1"),
("0211002","광주",2,2,"김대들","입과","2"),
("0211003","광주",2,2,"김보현","입과","3"),
("0211004","광주",2,2,"김진출","퇴소","4"),
("0211005","광주",2,2,"김창수","입과","5"),
("0211006","광주",2,2,"김태동","입과","6"),
("0211007","광주",2,2,"문지환","입과","7"),
("0211008","광주",2,2,"박종수","입과","8"),
("0211009","광주",2,2,"박호연","입과","9"),
("0211010","광주",2,2,"방준영","입과","10"),
("0211011","광주",2,2,"서현준","입과","11"),
("0211012","광주",2,2,"송광우","퇴소","12"),
("0211013","광주",2,2,"양성진","입과","13"),
("0211014","광주",2,2,"오지윤","입과","14"),
("0211015","광주",2,2,"원태희","입과","15"),
("0211016","광주",2,2,"이경석","입과","16"),
("0211017","광주",2,2,"이상아","퇴소","17"),
("0211018","광주",2,2,"이하연","입과","18"),
("0211019","광주",2,2,"정성원","퇴소","19"),
("0211020","광주",2,2,"정준호","퇴소","20"),
("0211021","광주",2,2,"정희선","입과","21"),
("0211022","광주",2,2,"조승우","퇴소","22"),
("0211023","광주",2,2,"최용선","퇴소","23"),
("0211024","광주",2,2,"최창현","입과","24");

select * from student;

select * from student;
select student_id, area, group_num, class_num, name, state, face_id
		from Student;
select student_id, area, group_num, class_num, name, state, face_id
from Student;
drop table attendance;
create table attendance(
	student_id varchar(30) not null,
	attendance_date date not null,
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

select * from attendance;

insert into attendance
(student_id, attendance_date, attendance_time, leaving_time, attendance_state)
values
("0211002","2020-06-03",null,null,null),
("0211003","2020-06-03",null,null,null),
("0211005","2020-06-03",null,null,null),
("0211006","2020-06-03",null,null,null),
("0211007","2020-06-03",null,null,null),
("0211008","2020-06-03",null,null,null),
("0211009","2020-06-03",null,null,null),
("0211010","2020-06-03",null,null,null),
("0211011","2020-06-03",null,null,null),
("0211013","2020-06-03",null,null,null),
("0211014","2020-06-03",null,null,null),
("0211015","2020-06-03",null,null,null),
("0211016","2020-06-03",null,null,null),
("0211018","2020-06-03",null,null,null),
("0211021","2020-06-03",null,null,null),
("0211024","2020-06-03",null,null,null);

select student_id
		from Student
		where state = "입과"
        order by student_id;

select a.student_id, a.area, a.group_num, a.class_num, a.name, a.state, a.face_id, b.attendance_date, b.attendance_time, b.leaving_time, b.attendance_state
from Student as a left join Attendance as b on a.student_id = b.student_id
where state = "입과"
order by student_id;