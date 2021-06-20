create database SpringDB;

drop table USER;
CREATE TABLE IF NOT EXISTS User (
  Id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  UserName VARCHAR(128),
  Password VARCHAR(128),
  Roles VARCHAR(1024),
  Active BOOLEAN default true,
  CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
  INDEX(UserName)
) engine=InnoDB;

insert into User(UserName, Password, Roles) values('Admin', '123456', 'ADMIN,USER'); 