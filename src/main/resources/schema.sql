DROP TABLE IF EXISTS users, authorities;
CREATE TABLE users (
  id INT not null,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);
  
CREATE TABLE authorities (
  id INT not null,
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (id) REFERENCES users(id)
);