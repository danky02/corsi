create table student(
student_name varchar2(30) not null,
student_surname varchar2(30) not null,
student_code int,
educational_background number(1),
constraint pk_stud_code primary key(student_code)
);

create table professor(
professor_name varchar2(30) not null,
professor_surname varchar2(30) not null,
professor_cv varchar2(30),
professor_code int,
constraint pk_prof_code primary key(professor_code)
);

create table course(
course_code int,
course_name varchar2(30) not null,
start_date Date not null,
end_date Date not null,
course_cost number(7,2) not null,
course_comments varchar2(200),
course_room varchar2(30),
professor_code int,
constraint pk_course_code primary key(course_code),
constraint fk_professor_code foreign key(professor_code) references professor(professor_code)
);

create table student_course(
student_code int,
course_code int,
constraint fk_std_code foreign key(student_code) references student(student_code),
constraint fk_crs_code foreign key(course_code) references course(course_code)
);

create table admin(
admin_name varchar2(30),
admin_surname varchar2(30),
admin_username varchar2(20) unique,
admin_code int,
constraint pk_admin_code primary key(admin_code)
);

create table course_comment(
student_code int,
course_code int,
comment_description varchar2(30),
constraint fk_cstd_code foreign key(student_code) references student(student_code),
constraint fk_ccrs_code foreign key(course_code) references course(course_code)
);

create sequence student_seq;
create sequence course_seq;