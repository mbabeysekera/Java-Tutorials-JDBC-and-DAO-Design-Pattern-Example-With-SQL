DROP DATABASE IF EXISTS sql_students;
CREATE DATABASE sql_students;
USE sql_students;

CREATE TABLE students (
	indexNo  INT NOT NULL AUTO_INCREMENT,
    std_firstname VARCHAR(50) NOT NULL,
    std_secondname VARCHAR(50) NOT NULL,
    std_marks INT(5) NOT NULL,
    PRIMARY KEY (indexNo)
);
INSERT INTO students VALUES (1, 'Buddhika', 'Abeysekera', 95);
INSERT INTO students VALUES (2, 'Lasitha', 'Madhawa', 85);
INSERT INTO students VALUES (3, 'Gaayan', 'Tharindra', 80);
INSERT INTO students VALUES (4, 'Isuru', 'Kasun', 75);
INSERT INTO students VALUES (5, 'Sandaru', 'Daminda', 80);
INSERT INTO students VALUES (6, 'Pradeep', 'Jayasinghe', 65);

CREATE TABLE std_sports (
	indexNo INT NOT NULL AUTO_INCREMENT,
    std_firstname VARCHAR(50) NOT NULL,
    std_secondname VARCHAR(50) NOT NULL,
    sportName VARCHAR(20) NOT NULL,
    PRIMARY KEY (indexNo)
);
INSERT INTO std_sports VALUES (1, 'Buddhika', 'Abeysekera', 'Karate');
INSERT INTO std_sports VALUES (2, 'Lasitha', 'Madhawa', 'Volley Ball');
INSERT INTO std_sports VALUES (3, 'Gaayan', 'Tharindra', 'Cricket');
INSERT INTO std_sports VALUES (4, 'Isuru', 'Kasun', 'Cricket');
INSERT INTO std_sports VALUES (5, 'Sandaru', 'Daminda', 'Atheletics');
INSERT INTO std_sports VALUES (6, 'Pradeep', 'Jayasinghe', 'Cricket');

CREATE TABLE std_BMI (
	indexNo INT NOT NULL AUTO_INCREMENT,
    height DECIMAL(4, 2) NOT NULL DEFAULT 0.00,
    weight DECIMAL(4, 2)  NOT NULL DEFAULT 0.00,
    BMI DECIMAL(4, 2)  NOT NULL DEFAULT 0.00,
    PRIMARY KEY (indexNo)
);
INSERT INTO std_BMI VALUES (1, 1.77, 80, 0.00);
INSERT INTO std_BMI VALUES (2, 1.75, 70, 0.00);
INSERT INTO std_BMI VALUES (3, 1.70, 80, 0.00);
INSERT INTO std_BMI VALUES (4, 1.72, 50, 0.00);
INSERT INTO std_BMI VALUES (5, 1.70, 50, 0.00);
INSERT INTO std_BMI VALUES (6, 1.71, 50, 0.00);

UPDATE std_BMI SET BMI = weight / height WHERE indexNo BETWEEN 1 AND 6;