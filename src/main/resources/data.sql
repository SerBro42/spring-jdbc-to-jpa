create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

INSERT INTO PERSON
    (ID,NAME,LOCATION,BIRTH_DATE)
VALUES (10001, 'Pepe', 'Orxeta', CURRENT_TIMESTAMP);
INSERT INTO PERSON
    (ID,NAME,LOCATION,BIRTH_DATE)
VALUES (10002, 'Gonzalo', 'Bilbao', CURRENT_TIMESTAMP);
INSERT INTO PERSON
    (ID,NAME,LOCATION,BIRTH_DATE)
VALUES (10003, 'Ignacio', 'Pamplona', CURRENT_TIMESTAMP);