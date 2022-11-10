use id;

-- create table Information (
-- personID int,
-- Name varchar(10),
-- age varchar(6)
-- );

-- Alter table Information add subjects varchar(50);


-- insert into Information (personID, Name, age,subjects) values( 1000, "A", "30", " Tamil");
-- insert into Information (personID, Name, age,subjects) values( 1001, "B", "35", "English");
-- insert into Information (personID, Name, age subjects) values( 1002, "C", "23", "Science");
-- insert into Information (personID, Name, age,subjects) values( 1003, "D", "78", "Social Science");
-- insert into Information (personID, Name, age,subjects) values( 1004, "E", "90", "English");
-- insert into Information (personID, Name, age,subjects) values( 1005, "F", "100", "Computer");
-- insert into Information (personID, Name, age,subjects) values( 1006, "G", "10", "Math");


-- update Information set subjects = "Tamil" where personID = 1000;
-- update Information set subjects = "English" where personID = 1001;
-- update Information set subjects = "Math" where personID = 1002;
-- update Information set subjects = "Computer Science" where personID = 1003;
-- update Information set subjects = "Science" where personID = 1004;
-- update Information set subjects = "Social Science" where personID = 1006;

-- create table Info (personID int not null primary key, Name varchar(20), subject varchar(20));
-- insert into Info(personID, Name, subject) values( 1000, "A", " Tamil");
-- insert into Info (personID, Name, subject) values( 1001, "B", "English");
-- insert into Info (personID, Name, subject) values( 1002, "C", "Science");
-- insert into Info (personID, Name, subject) values( 1003, "D", "Social Science");
-- insert into Info (personID, Name, subject) values( 1004, "E", "English");
-- insert into Info (personID, Name, subject) values( 1005, "F", "Computer");
-- insert into Info (personID, Name, subject) values( 1006, "G", "Math");

-- create table personage (ID int, foreign key(ID) references Info(personID) on delete cascade on update cascade,age int);
-- insert into personage (ID, age) values(1001,30);
-- insert into personage (ID, age) values(1002,40);
-- insert into personage (ID, age) values(1003,30);
-- insert into personage (ID, age) values(1004,60);
-- insert into personage (ID, age) values(1006,10);

Select info.personId,info.Name, info.subject,personage.age from info,personage where info.personID = '1001' ;
