SHOW DATABASES;
USE testdb;
 SHOW TABLES;
 
 CREATE TABLE student(
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 NAME VARCHAR(100) NOT NULL,
 email VARCHAR(100),
 age INT,
 create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 
 
 );
 
 SELECT  * FROM student ; 
 
 -- 셈플데이터
 INSERT INTO student(NAME,email,age) values
 ('김철수','kim@example.com',20),
 ('이영희','kim2@example.com',30),
 ('박민수','kim3@example.com',40);