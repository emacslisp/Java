drop table USER;
CREATE TABLE IF NOT EXISTS User (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  userName VARCHAR(128),
  password VARCHAR(128),
  roles VARCHAR(1024),
  active BOOLEAN default true,
  CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
  INDEX(UserName)
) engine=InnoDB;

insert into User(UserName, Password, Roles) values('Admin', '123456', 'ADMIN,USER'); 