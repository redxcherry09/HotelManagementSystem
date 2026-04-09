CREATE DATABASE hotel_management;

USE hotel_management;
drop table users;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    role VARCHAR(20)
);

INSERT INTO users VALUES (1,'admin','admin123','admin');
drop table rooms;
CREATE TABLE rooms (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(20),
    price INT,
    status VARCHAR(20)
);

INSERT INTO rooms (room_type, price, status) VALUES
('Single',1000,'Available'),
('Double',2000,'Available'),
('Single',1200,'Available'),
('Double',2500,'Available');
drop table bookings;
CREATE TABLE bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    room_type VARCHAR(20),
    price INT,
    status VARCHAR(20)
);

show tables;
