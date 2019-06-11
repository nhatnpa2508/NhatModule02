CREATE TABLE Table_Teacher
(Teacher_id int NOT Null,
Teacher_first_name varchar(20) NOT NULL,
Teacher_last_name varchar(20) NOT NULL,
Teacher_Subject char(10) NOT NULL,
Teacher_Address varchar(20) NOT NULL,
Teacher_Birthday date,
Teacher_Class varchar(5) NOT NULL,
CONSTRAINT Table_Teacher_PK PRIMARY KEY (Teacher_id)
);
CREATE TABLE Table_Class
(Homeroom_teacher VARCHAR(30) NOT NULL DEFAULT 'TBD',
Grade int not null ,
Class_id char(2) NOT NULL ,
Subclass char(2) NOT NULL,
CONSTRAINT suppliers_pk PRIMARY KEY (Homeroom_teacher)
);

ALTER TABLE Table_Class
ADD Class_size int not null,
after Subclass;
ALTER TABLE Table_Teacher
ADD Teacher_Level char(2) NOT NULL,
AFTER Teacher_last_name;
ALTER TABLE Table_Teacher
ADD Teacher_Age char(2) NOT NULL,
AFTER Teacher_last_name;

ALTER TABLE Table_Teacher
ADD Teacher_Class varchar(5) NULL,
AFTER Teacher_Birthday;

ALTER TABLE Table_Teacher
  DROP COLUMN Teacher_Birthday;

	sp_rename ‘Table_Teacher.Teacher_Subject’, ‘Table_Teacher.Teacher_SubjectKind’, ‘COLUMN’;