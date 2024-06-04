INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');

insert into user_tourist_app (id, username, password, email, firstname, lastname, role_id,unstable_user) values (12345, 'seli', '$2a$10$lAddMsBZ1QCXohuzuya0tOrElBmbGT2sAzkVJIHv7FTusHIIok7SC', 'seli@mail.com', 'seli', 'seli', 1,false);
insert into user_tourist_app (id, username, password, email, firstname, lastname, role_id,unstable_user) values (123456, 'admin', '$2a$10$6ZhsT7mosLU02Bw2cBr9dOS1pQEa7XzBZzP0XN/pYI7Ja10XPpnnS', 'admin@mail.com', 'admin', 'admin', 2,false);

