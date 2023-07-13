-- User user/pass
-- generate password https://www.browserling.com/tools/bcrypt

INSERT INTO users (id,username, password, enabled)values (1,'user','$2a$10$6DQ.N2S60E/oW7Z88iFYieWMj8QC4h/f61PqJnHy/IXreZXzyYPQq',1);

INSERT INTO authorities (id,username, authority) values (1,'user', 'ROLE_USER');