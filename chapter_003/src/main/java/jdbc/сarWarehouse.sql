-- Задача. Создать структур данных в базе.
-- Таблицы.
   -- Кузов. Двигатель, Коробка передач.
-- Создать структуру Машина. Машина не может существовать без данных из п.1.
-- Заполнить таблицы через insert.

CREATE DATABASE car_catalog;
\c car_catalog

CREATE TABLE car_body(
                         id SERIAL PRIMARY KEY,
                         name VARCHAR (100)
);

CREATE TABLE engine(
                       id SERIAL PRIMARY KEY,
                       name VARCHAR (100)
);

CREATE TABLE gearbox(
                        id SERIAL PRIMARY KEY,
                        name VARCHAR (100)
);

CREATE TABLE car(
                    id serial PRIMARY KEY,
                    brand_name VARCHAR(20),
                    model_name VARCHAR(40),
                    id_body INT REFERENCES car_body(id),
                    id_engine INT REFERENCES engine(id),
                    id_gearbox INT REFERENCES gearbox(id)
);

INSERT INTO car_body (name)
VALUES ('Body BMW 328i'), ('Body BMW 550d'), ('Body BMW X1M');

INSERT INTO car_body (name)
VALUES ('Body TOYOTA Corolla'), ('Body TOYOTA Camry'), ('Body TOYOTA Prius');

INSERT INTO car_body (name)
VALUES ('Body Hyundai i30'), ('Body Hyundai Solaris'), ('Body Hyundai i20');

INSERT INTO engine (name)
VALUES ('Engine BMW 328i'), ('Engine BMW 550d'), ('Engine BMW X1M');

INSERT INTO engine (name)
VALUES ('Engine TOYOTA Corolla'), ('Engine TOYOTA Camry'), ('Engine TOYOTA Prius');

INSERT INTO engine (name)
VALUES ('Engine Hyundai i30'), ('Engine Hyundai Solaris'), ('Engine Hyundai i20');

INSERT INTO gearbox (name)
VALUES ('Transmission BMW 328i'), ('Transmission BMW 550d'), ('Transmission BMW X1M');

INSERT INTO gearbox (name)
VALUES ('Transmission TOYOTA Corolla'), ('Transmission TOYOTA Camry'), ('Transmission TOYOTA Prius');

INSERT INTO gearbox (name)
VALUES ('Transmission Hyundai i30'), ('Transmission Hyundai Solaris'), ('Transmission Hyundai i20');

INSERT INTO car (brand_name, model_name, id_body, id_engine, id_gearbox)
VALUES ('BMW', '328i', 1, 1, 1), ('BMW', '550d', 2, 2, 2), ('BMW', 'X1M', 3, 3, 3);

INSERT INTO car (brand_name, model_name, id_body, id_engine, id_gearbox)
VALUES ('TOYOTA', 'Corolla', 4, 4, 4), ('TOYOTA', 'Camry', 5, 5, 5), ('TOYOTA', 'Prius', 6, 6, 6);

INSERT INTO car (brand_name, model_name, id_body, id_engine, id_gearbox)
VALUES ('Hyundai', 'i30', 7, 7, 7), ('Hyundai', 'Solaris', 8, 8, 8), ('Hyundai', 'i20', 9, 9, 9);

INSERT INTO car_body (name)
VALUES ('Body Lada Vesta'), ('Body Honda CR-V'), ('Body UAZ Patriot');

INSERT INTO engine (name)
VALUES ('Engine Audi A5 '), ('Engine BMW 720'), ('Engine VW Polo');

INSERT INTO gearbox (name)
VALUES ('Transmission VW Tuareg'), ('Transmission Audi A3'), ('Transmission Ford Focus');

-- Создать SQL запросы:
-- 1. Вывести список всех машин и все привязанные к ним детали.

SELECT c.brand_name, c.model_name, cb.name, e.name, g.name FROM car c
INNER JOIN car_body cb ON c.id_body = cb.id
INNER JOIN engine e ON c.id_engine = e.id
INNER JOIN gearbox g ON c.id_gearbox = g.id;

-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

SELECT body.name FROM car_body body
LEFT JOIN car ON body.id = car.id_body
WHERE car.id_body IS NULL;

SELECT e.name FROM engine e
LEFT JOIN car ON e.id = car.id_engine
WHERE car.id_engine IS NULL;

SELECT g.name FROM gearbox AS g
LEFT JOIN car ON g.id = car.id_gearbox
WHERE car.id_gearbox IS NULL;
