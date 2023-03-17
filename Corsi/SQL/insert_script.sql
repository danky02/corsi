truncate table admin cascade;
truncate table student cascade;
truncate table professor cascade;
truncate table course cascade;

insert into admin values('Mario', 'Rossi', 'mrrossi', 666420);
insert into admin values('Mario', 'Verdi', 'mrverdi', 666777);

insert into professor values('Luigi', 'Bianchi', '#', 1);
insert into professor values('Maria', 'Verdi', '#', 2);
insert into professor values('Teresa', 'Gialli', '#', 3);

insert into student values('Gabriele', 'D''annunzio', student_seq.nextval, 1);
insert into student values('Giovanni', 'Verga', student_seq.nextval, 0);
insert into student values('Dante', 'Alighieri', student_seq.nextval, 1);

insert into course values(course_seq.nextval, 'Java for dummies', '10-OCT-23', '11-OCT-23', 1999, '', 'A69', 3);
insert into course values(course_seq.nextval, 'C# for dummies', '15-NOV-23', '22-NOV-23', 1555, '', 'A33', 1);
insert into course values(course_seq.nextval, 'Academy di Java', '2-DEC-23', '12-DEC-23', 1222, '', 'A22', 2);
insert into course values(course_seq.nextval, 'Academy di Oracle', '12-DEC-23', '16-DEC-23', 1222, '', 'A21', 2);
insert into course values(course_seq.nextval, 'Academy di JS', '12-DEC-23', '18-DEC-23', 1222, '', 'A21', 1);
insert into course values(course_seq.nextval, 'Academy di JQuery', '12-DEC-23', '14-DEC-23', 1222, '', 'A21', 3);

insert into student_course values(1, 1);
insert into student_course values(1, 2);
insert into student_course values(1, 3);
insert into student_course values(2, 3);
insert into student_course values(2, 1);
insert into student_course values(3, 1);

insert into COURSE_COMMENT values(1, 1, 'Commento');
insert into COURSE_COMMENT values(2, 2, 'Commento');
insert into COURSE_COMMENT values(3, 3, 'Commento');

commit