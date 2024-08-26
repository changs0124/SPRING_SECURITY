DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS ROLE;
DROP TABLE IF EXISTS USER_ROLES;
CREATE TABLE USER (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE not null,
    password VARCHAR(255) not null,
    name VARCHAR(255) not null
);

CREATE TABLE ROLE (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE not null
);
INSERT INTO ROLE
    VALUES  (DEFAULT, 'ROLE_USER'),
            (DEFAULT, 'ROLE_MANAGER'),
            (DEFAULT, 'ROLE_ADMIN');

CREATE TABLE USER_ROLES (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT not null,
    role_id BIGINT not null
);
