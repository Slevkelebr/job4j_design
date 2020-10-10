create table devices(
                        id serial primary key,
                        name varchar(255),
                        price float
);

create table people(
                       id serial primary key,
                       name varchar(255)
);

create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int references people(id)
);
insert into devices (name, price) VALUES ('Phone', 324.2);
insert into devices (name, price) VALUES ('PC', 15242.25);
insert into devices (name, price) VALUES ('Printer', 11548.00);
insert into devices (name, price) VALUES ('Xbox', 25445.45);
insert into devices (name, price) VALUES ('PS3', 28249.45);

insert into people (name) values ('Serg');
insert into people (name) values ('Piter');
insert into people (name) values ('Tim');
insert into people (name) values ('Jon');
insert into people (name) values ('Kate');
insert into people (name) values ('Sima');
insert into people (name) values ('Sandra');

insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (1, 2);
insert into devices_people (device_id, people_id) values (1, 3);
insert into devices_people (device_id, people_id) values (1, 4);
insert into devices_people (device_id, people_id) values (1, 5);
insert into devices_people (device_id, people_id) values (1, 6);
insert into devices_people (device_id, people_id) values (1, 7);
insert into devices_people (device_id, people_id) values (2, 6);
insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (2, 1);
insert into devices_people (device_id, people_id) values (3, 4);
insert into devices_people (device_id, people_id) values (3, 3);
insert into devices_people (device_id, people_id) values (4, 5);
insert into devices_people (device_id, people_id) values (5, 7);