DROP DATABASE IF EXISTS pos_spring;
CREATE DATABASE IF NOT EXISTS pos_spring;
USE pos_spring;

CREATE TABLE customer(
	id varchar(4),
	name varchar(50) not null,
	address varchar(60) not null,
	tp int(10) not null,
	CONSTRAINT PRIMARY KEY (id)
);


