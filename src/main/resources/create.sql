DROP TABLE IF EXISTS ORDERS;
CREATE TABLE ORDER (
ID int primary key,
product varchar(25),
data timestamp
ingredients varchar(2000)
);

DROP TABLE IF EXISTS INGREDIENT;
CREATE TABLE INGREDIENT (
ID int primary key,
ingredient varchar(250),
);