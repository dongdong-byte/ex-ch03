show databases ;

create  database testdb;

use testdb;

show  tables ;

create table student(
                        id BIGINT auto_increment primary key ,
                        name varchar(100) not null ,
                        email varchar(100),
                        age int,
                        create_at timestamp default  current_timestamp,
                        update_at timestamp default current_timestamp on update  current_timestamp


);

select  * from testdb.student;

insert into testdb.student(name, email, age) VALUE

    ('김철수','kim@example.com',20),
    ('이영희','kim2@example.com',25),
    ('박민수','kim3@example.com',27);

select * from testdb.student order by id desc;

insert into testdb.student(name, email, age) VALUE

    ('화이팅','kim4@example.com',46);


update  student
set  name= #{name},
email = #{email},
age = #{age},
update_at =now()
where id = "";

delete from student where id = ;
