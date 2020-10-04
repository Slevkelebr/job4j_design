create database my_db;
create table persons(
  id serial primary key,
  name varchar(255),
  birthDate date,
  married bool
  );

insert into persons(name, birthdate, married) VALUES ('Tim', '1/8/1991', true);

update persons set married = false;