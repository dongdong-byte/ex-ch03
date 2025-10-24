

use testdb;

create database testdb2;
use testdb2;

create table student(
                        id bigint primary key auto_increment ,
                        name varchar(200) not null comment '이름',
                        email varchar(200)  comment '이메일',
                        age int not null  comment '나이',
                        createAt timestamp null  default  current_timestamp(),
                        updateAt timestamp null default current_timestamp() on update current_timestamp()


);
select id, name, email, age, createAt, updateAt from student where id = '';

insert into student(name, email, age, createAt, updateAt) VALUE
    ('','','',now(),now());

update student set name='',email='',age='',updateAt=now() where id='';

delete from student
where id='';