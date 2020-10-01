CREATE DATABASE tracker_db;
\c tracker_db;

CREATE TABLE role(
	id SERIAL PRIMARY KEY,
	role VARCHAR(30)
);
CREATE TABLE rules(
	id SERIAL PRIMARY KEY,
	right VARCHAR(30)
);
CREATE TABLE role_rules(
	id SERIAL PRIMARY KEY,
	role_id INT REFERENCES role(id),
	rules_id INT REFERENCES rules(id)
);
CREATE TABLE users(
	id SERIAL PRIMARY KEY,
	login VARCHAR(30),
	password VARCHAR(20),
	role_id INT REFERENCES role(id)
);
CREATE TABLE item_categories(
	id SERIAL PRIMARY KEY,
	categorie VARCHAR(50)
);
CREATE TABLE item_status(
	id SERIAL PRIMARY KEY,
	status VARCHAR(50)
);
CREATE TABLE item(
	id SERIAL PRIMARY KEY,
	description VARCHAR(500),
	author INT REFERENCES users(id),
	categories_id INT REFERENCES item_categories(id),
	status_id INT REFERENCES item_status(id)
);
CREATE TABLE item_comments(
	id SERIAL PRIMARY KEY,
	comment VARCHAR(500),
	item_id INT REFERENCES item(id)
);
CREATE TABLE attached_item(
	id SERIAL PRIMARY KEY,
	attach VARCHAR(500),
	item_id INT REFERENCES item(id)
);

INSERT INTO role(role) VALUES('Administrator');
INSERT INTO role(role) VALUES('User');

INSERT INTO rules(right) VALUES('Create');
INSERT INTO rules(right) VALUES('Updeate');
INSERT INTO rules(right) VALUES('Read');
INSERT INTO rules(right) VALUES('Delete');

INSERT INTO users(login, password, role_id) VALUES('slk', '12345', '1');
INSERT INTO users(login, password, role_id) VALUES('qwer', '32165', '2');
INSERT INTO users(login, password, role_id) VALUES('tony', '789456', '2');

INSERT INTO item_categories(categorie) VALUES('Check');
INSERT INTO item_categories(categorie) VALUES('Worker');

INSERT INTO item_status(status) VALUES('Work');
INSERT INTO item_status(status) VALUES('Made');

INSERT INTO item(description, author, categories_id, status_id) VALUES('Сheck computer operation', '2', '2', '1');
INSERT INTO item(description, author, categories_id, status_id) VALUES('Update of programms', '2', '1', '2');

INSERT INTO item_comments(comment, item_id) VALUES('Computer is gentle to repair', '1');
INSERT INTO item_comments(comment, item_id) VALUES('Updated succsesfull', '2');

INSERT INTO attached_item(attach, item_id) VALUES('error.txt', '1');
INSERT INTO attached_item(attach, item_id) VALUES('Image.jpg', '2');