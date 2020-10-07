-- Даны две таблицы department and employees.
-- Отношение one-to-many. В таблицах только поле name.

-- 1. Создать таблицы и заполнить их начальными данными.

CREATE TABLE departments (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE employees (
	employees_id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	department_id INT REFERENCES departments(id)
);

INSERT INTO departments(name)
VALUES ('Верхний'), ('Средний'), ('Нижний');

INSERT INTO employees(name, department_id)
VALUES ('Василий', 1), ('Сергей', 2), ('Петр', 3),
('Антон', 2), ('Евгений', 1), ('Илья', 3), ('Юлия', null);

-- 2. Выполнить запросы с left, right, full, cross соединениями

SELECT * FROM employees e
LEFT JOIN departments d
ON e.department_id = d.id;

SELECT * FROM departments d
RIGHT JOIN employees e
ON d.id = e.department_id;

SELECT * FROM departments d
FULL JOIN employees e
ON d.id = e.department_id;

SELECT * FROM departments d
CROSS JOIN employees e;

-- 3. Используя left join найти работников, которые не относятся ни к одну из департаментов.

SELECT * FROM employees e
LEFT JOIN departments d
ON e.department_id = d.id
WHERE  e.department_id IS NULL;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат. 

SELECT * FROM employees e
LEFT JOIN departments d
ON e.department_id = d.id;

SELECT * FROM departments d
RIGHT JOIN employees e
ON d.id = e.department_id;

-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары

CREATE TABLE teens(
id SERIAL PRIMARY KEY,
name VARCHAR (20),
gender CHAR (1)
);

INSERT INTO teens(name, gender)
VALUES ('Jon', 'M'), ('Kate', 'F'), ('Tim', 'M'), ('Jessika', 'F'), ('Man', 'M'), ('Mari', 'F');

SELECT t1.name, concat(t1.gender, t2.gender) as pol, t2.name FROM teens t1 CROSS JOIN teens t2
WHERE t1.gender <> t2.gender;

