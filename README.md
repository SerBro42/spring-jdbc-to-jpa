# spring-jdbc-to-jpa

**********************************
The JDBC URL must have the following value:
~~~~~~~~~~~
jdbc:h2:mem:testdb
~~~~~~~~~~~
If it has a different value, most likely 'jdbc:h2:~/test', change it manually in the JDBC URL field in the web form.
***********************************
All DDL Table Creations and data updates should be done in 'schema.sql'
~~~~~~~~~~~~
create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);
 
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(10003,  'Pieter', 'Amsterdam',sysdate());
~~~~~~~~~~~~
**********************
The function sysdate() is not supported in H2. Instead, we use CURRENT_TIMESTAMP (for timestamp-type data).
~~~~~~~~~~~
INSERT INTO PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
VALUES (10001, 'Pepe', 'Orxeta', CURRENT_TIMESTAMP);
~~~~~~~~~~~~
********************************
The queryForObject() method, as shown in the course, is currently deprecated. Instead of writing it like this:
~~~~~~~~~~~~
public Person findById(int id) {
    return jdbcTemplate.queryForObject(
        "select * from person where id=?", 
        new Object[]{id}, 
        new BeanPropertyRowMapper<Person>(Person.class)
    );
}
~~~~~~~~~~~~
Write it like this:
~~~~~~~~~~~~
public Person findById(int id) {
    return jdbcTemplate.queryForObject(
        "select * from person where id=?", 
        new BeanPropertyRowMapper<>(Person.class),
        id
    );
}
~~~~~~~~~~~~
********************
# JPA
When implementing JPA, bear in mind that the javax library has been replaced with jakarta.
*******************
# JPA incident
When transitioning from JDBC to JPA, the findById() function returned a null result. In order to fix this issue, the following line was added to application.properties:
~~~~~~~~~~~~~~
spring.jpa.hibernate.ddl-auto=update
~~~~~~~~~~~~~~
***************************
# Databases
Until now, we have been using H2, an in-memory database.

In order to setup a MySQL database for example, follow this link:
https://github.com/in28minutes/spring-master-class/blob/master/04-spring-jdbc-to-jpa/readme.md

*****************************
# H2 to MySQL

Migrated from H2 embedded database to MySQL. All connection data are in application.properties.

# MySQL setup
- Install MySQL https://dev.mysql.com/doc/en/installing.html
    - More details - http://www.mysqltutorial.org/install-mysql/
    - Trouble Shooting - https://dev.mysql.com/doc/refman/en/problems.html

- Startup the Server (as a service). You will most likely need admin privileges for this.

- Go to command prompt (or terminal)
- Execute following commands to create a database and a user
~~~~~~~~~~~~
mysql --user=user_name --password 
create database person_example;
create user 'personuser'@'localhost' identified by 'YOUR_PASSWORD';
grant all on person_example.* to 'personuser'@'localhost';
~~~~~~~~~~~~

Execute sql queries to create the table and insert the data. The complete list of queries can be found in the file mysql_connection.sql
