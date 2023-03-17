DELETE student_course;
DELETE course;
DELETE professor;
DELETE student;

INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('John', 'Smith', 'PhD in Computer Science', 1001);
INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('Alice', 'Johnson', 'Master in Data Analytics', 1002);
INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('David', 'Lee', 'PhD in Artificial Intelligence', 1003);
INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('Emily', 'Davis', 'Master in Database Management', 1004);
INSERT INTO professor (professor_name, professor_surname, professor_cv, professor_code) VALUES ('Michael', 'Wilson', 'PhD in Computer Science', 1005);

INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (101, 'Intro to Computer Science', TO_DATE('2022-09-05', 'yyyy-mm-dd'), TO_DATE('2022-12-15', 'yyyy-mm-dd'), 2000.00, NULL, 'Room A', 1001);
INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (102, 'Data Structures and Algorithms', TO_DATE('2023-01-09', 'yyyy-mm-dd'), TO_DATE('2023-04-21', 'yyyy-mm-dd'), 2500.00, 'This course requires knowledge of programming basics.', 'Room B', 1002);
INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (103, 'Introduction to AI', TO_DATE('2023-09-04', 'yyyy-mm-dd'), TO_DATE('2023-12-14', 'yyyy-mm-dd'), 3000.00, NULL, 'Room C', 1003);
INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (104, 'Database Management Systems', TO_DATE('2024-01-08', 'yyyy-mm-dd'), TO_DATE('2024-04-19', 'yyyy-mm-dd'), 2200.00, 'This course covers SQL and NoSQL databases.', 'Room D', 1004);
INSERT INTO course (course_code, course_name, start_date, end_date, course_cost, course_comments, course_room, professor_code) VALUES (105, 'Web Development', TO_DATE('2024-09-02', 'yyyy-mm-dd'), TO_DATE('2024-12-12', 'yyyy-mm-dd'), 2800.00, NULL, 'Room E', 1005);

INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Sarah', 'Johnson', 2001, 1);
INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Ryan', 'Lee', 2002, 0);
INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Emma', 'Smith', 2003, 1);
INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Oliver', 'Davis', 2004, 0);
INSERT INTO student (student_name, student_surname, student_code, educational_background) VALUES ('Sophia', 'Brown', 2005, 0);

INSERT INTO student_course (student_code, course_code) VALUES (2001, 101);
INSERT INTO student_course (student_code, course_code) VALUES (2002, 101);
INSERT INTO student_course (student_code, course_code) VALUES (2002, 102);
INSERT INTO student_course (student_code, course_code) VALUES (2003, 102);
INSERT INTO student_course (student_code, course_code) VALUES (2004, 103);
INSERT INTO student_course (student_code, course_code) VALUES (2005, 103);

commit