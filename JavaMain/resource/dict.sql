-- database for dict project

Create database dict;

drop table dictionary;
CREATE TABLE IF NOT EXISTS dictionary (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  word VARCHAR(80),
  dict_cn TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  dict_org TEXT CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
  INDEX(word)
) engine=InnoDB;
