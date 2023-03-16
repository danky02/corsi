truncate table admin;
truncate table professor;
truncate table student;
truncate table course;

insert into admin values('Mario', 'Rossi', 'mrrossi', 666420);
insert into admin values('Mario', 'Verdi', 'mrverdi', 666777);

insert into professor values('Luigi', 'Bianchi', '#', 1);
insert into professor values('Maria', 'Verdi', '#', 2);
insert into professor values('Teresa', 'Gialli', '#', 3);

insert into student values('Babbo', 'Natale', 	11, 1);
insert into student values('Giovanni', 'Verga', 12, 0);
insert into student values('Dante', 'Alighieri',13, 1);

insert into course values(1, 'Java for dummies', '10-OCT-23', '11-OCT-23', 1999, '', 'A69', 3);
insert into course values(2, 'C# for dummies', '15-NOV-23', '22-NOV-23', 1555, '', 'A33', 1);
insert into course values(3, 'Academy di Giava', '2-DEC-23', '12-DEC-23', 1222, '', 'A22', 2);

insert into student_course values(11, 1);
insert into student_course values(11, 2);
insert into student_course values(11, 3);
insert into student_course values(12, 1);
insert into student_course values(13, 1);

commit