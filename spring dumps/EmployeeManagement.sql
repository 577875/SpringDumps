CREATE DATABASE transfer_management;

use  transfer_management;

create table location_details( location_name varchar(10) primary key, number_of_seats int);

create table employee_details( employee_id int primary key,
employee_name varchar(10),role varchar(30),location_name varchar(10), foreign key(location_name)
references location_details(location_name));


insert into location_details values('Chennai',10);
insert into location_details values('Coimbatore',15);
insert into location_details values('Bangalore',30);
insert into location_details values('Kolkata',5);

insert into location_details values('Mumbai',20);
insert into employee_details values(1000,'Ranjit','Developer','Chennai');
insert into employee_details values(1001,'Amit','Senior Developer','Coimbatore');
insert into employee_details values(1002,'Srija','Technical Lead','Bangalore');
insert into employee_details values(1003,'Kumar','Tester','Kolkata');
insert into employee_details values(1004,'Ragav','Developer','Mumbai');

commit;