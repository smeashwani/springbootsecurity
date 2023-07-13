-- User user/pass
-- generate password https://www.browserling.com/tools/bcrypt

INSERT INTO users (username, password, enabled)values ('user','$2a$10$6DQ.N2S60E/oW7Z88iFYieWMj8QC4h/f61PqJnHy/IXreZXzyYPQq',1);

INSERT INTO authorities (username, authority) values ('user', 'ROLE_USER');