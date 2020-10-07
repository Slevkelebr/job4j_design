-- В системе заданы таблицы
-- product(id, name, type_id, expired_date, price)
-- type(id, name)
-- Задание.

-- 1. Написать запрос получение всех продуктов с типом "СЫР"

SELECT product.name, type.name
FROM product INNER JOIN type
ON product.type_id = type.id
WHERE type.name = 'СЫР';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM product WHERE name LIKE '%мороженное%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT name, expired_date FROM product
WHERE extract(month FROM expired_date) = 11;

-- 4. Написать запрос, который выводит самый дорогой продукт.
SELECT * FROM product
WHERE price = (SELECT MAX(price) from product);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT count(product.name)
FROM product INNER JOIN type
ON product.type_id = type.id
WHERE type.name = 'СЫР';

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT product.name, type.name
FROM product INNER JOIN type
ON product.type_id = type.id
WHERE type.name = 'СЫР' or type.name = 'МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT t.name FROM type  t
INNER JOIN product p ON p.type_id = t.id
GROUP BY t.name HAVING count(t.name) < 10;

-- 8. Вывести все продукты и их тип.
SELECT product.name, type.name
FROM product INNER JOIN type
ON product.type_id = type.id;