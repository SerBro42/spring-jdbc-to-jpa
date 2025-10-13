create table person
(
    id integer not null auto_increment,
    birth_date timestamp,
    location varchar(255),
    name varchar(255),
    primary key (id)
);


INSERT INTO PERSON 
(NAME, LOCATION, BIRTH_DATE ) 
VALUES('Snow White', 'Cottage of the Seven Dwarves',sysdate());
INSERT INTO PERSON 
(NAME, LOCATION, BIRTH_DATE ) 
VALUES('Cinderella', 'Austrian Royal Palace',sysdate());
INSERT INTO PERSON
    (NAME,LOCATION,BIRTH_DATE)
VALUES ('Ariel', 'Probably Atlantis', CURRENT_TIMESTAMP);
INSERT INTO PERSON
    (NAME,LOCATION,BIRTH_DATE)
VALUES ('Belle', 'The Beast`s castle', CURRENT_TIMESTAMP);
INSERT INTO PERSON
    (NAME,LOCATION,BIRTH_DATE)
VALUES ('Vlad Tepes', 'Wallachia', CURRENT_TIMESTAMP);

drop table person;
drop table person_seq;

select * from person;