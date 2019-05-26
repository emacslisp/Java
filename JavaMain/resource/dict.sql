-- database for dict project

Create database dict;

CREATE TABLE IF NOT EXISTS Dict (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  word VARCHAR(80),
  dict_cn TEXT,
  dict_org TEXT,
  CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP
  INDEX(name)
) engine=InnoDB;
