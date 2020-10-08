CREATE TABLE type(
	id serial primary key,
	name varchar(30)
);

CREATE TABLE product(
	id serial primary key,
	name varchar(30),
	type_id int references type(id),
	expired_date date,
	price int
);

INSERT INTO type(name) values('CЫР');
INSERT INTO type(name) values('МОЛОКО');
INSERT INTO type(name) values('МОРОЖЕННОЕ');


INSERT INTO product(name, type_id, expired_date, price) values('Сливочный сыр', 1, '25-10-2020', '100');
INSERT INTO product(name, type_id, expired_date, price) values('Пармезан', 1, '06-11-2020', '200');
INSERT INTO product(name, type_id, expired_date, price) values('Молочный Фермер', 2, '12-10-2020', '80');
INSERT INTO product(name, type_id, expired_date, price) values('Белое Облако', 2, '10-11-2020', '95');
INSERT INTO product(name, type_id, expired_date, price) values('Сливочное мороженное от Белки', 3, '12-10-2020', '40');


