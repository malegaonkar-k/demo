CREATE SCHEMA DEMOKESHAV AUTHORIZATION sa; 

SET SCHEMA DEMOKESHAV;

CREATE TABLE User( 
   user_id INT NOT NULL,
   user_name VARCHAR(50) NOT NULL
);

INSERT INTO USER VALUES (1, 'Ramesh'); 

ALTER TABLE USER ADD USER_PASSWORD VARCHAR;

