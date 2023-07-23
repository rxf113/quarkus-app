create sequence fruit_sequence start with 1 increment by 1;
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Mango','Spring');
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Strawberry','Spring');
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Orange','Winter');
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Lemon','Winter');
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Blueberry','Summer');
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Banana','Summer');
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Watermelon','Summer');
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Apple','Fall');
INSERT INTO Fruit(id,name,season) VALUES (nextval('fruit_sequence'),'Pear','Fall');


INSERT INTO Person(id, name) VALUES ('110', 'rxf113');

create sequence cat_sequence start with 1 increment by 1;
INSERT INTO Cat(id, name, person_id) VALUES (nextval('cat_sequence'), 'feimao', '110');
INSERT INTO Cat(id, name, person_id) VALUES (nextval('cat_sequence'), 'benmao', '110');