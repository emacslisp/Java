create database Test;

CREATE TABLE User (
    ID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    UserName varchar(256),
    Password varchar(256),
    Salt varchar(64),
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    LastLogin DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- password 123456
insert into User(UserName,Password, Salt) values('root', 'e92cf7871e20e87b49f7b765ac8559c4', 'fc0fd160daa4');
insert into User(UserName,Password, Salt) values('java.gdb@gmail.com', 'e92cf7871e20e87b49f7b765ac8559c4', 'fc0fd160daa4');
