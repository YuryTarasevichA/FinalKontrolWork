CREATE DATABASE FriendsOfHuman;
USE FriendsOfHuman;

CREATE TABLE Animals (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    birth_date DATE
);

CREATE TABLE Horses (
    id INT PRIMARY KEY,
    animal_id INT,
    command VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

CREATE TABLE Donkeys (
    id INT PRIMARY KEY,
    animal_id INT,
    command VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

CREATE TABLE Camels (
    id INT PRIMARY KEY,
    animal_id INT,
    command VARCHAR(50),
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

INSERT INTO Animals (id, name, birth_date) VALUES
(1, 'Horse1', '2010-05-15'),
(2, 'Horse2', '2012-08-20'),
(3, 'Donkey1', '2013-01-10'),
(4, 'Donkey2', '2014-03-25'),
(5, 'Camel1', '2011-11-30'),
(6, 'Camel2', '2015-07-05');

INSERT INTO Horses (id, animal_id, command) VALUES
(1, 1, 'Jumping'),
(2, 2, 'Racing');

INSERT INTO Donkeys (id, animal_id, command) VALUES
(1, 3, 'Carrying loads'),
(2, 4, 'Working in fields');

INSERT INTO Camels (id, animal_id, command) VALUES
(1, 5, 'Transporting goods'),
(2, 6, 'Tourism rides');

CREATE TABLE Equines AS
SELECT *
FROM Horses
UNION ALL
SELECT *
FROM Donkeys;

CREATE TABLE YoungAnimals AS
SELECT a.*, 
    TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
FROM Animals a
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) > 1
AND TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) < 3;

CREATE TABLE AllAnimals AS
SELECT 'Horses' AS animal_type, h.id AS id, h.animal_id, h.command, a.name, a.birth_date
FROM Horses h
JOIN Animals a ON h.animal_id = a.id
UNION ALL
SELECT 'Donkeys' AS animal_type, d.id AS id, d.animal_id, d.command, a.name, a.birth_date
FROM Donkeys d
JOIN Animals a ON d.animal_id = a.id
UNION ALL
SELECT 'Camels' AS animal_type, c.id AS id, c.animal_id, c.command, a.name, a.birth_date
FROM Camels c
JOIN Animals a ON c.animal_id = a.id;







































