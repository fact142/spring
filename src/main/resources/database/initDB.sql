create table users (
    id serial PRIMARY KEY,
    name varchar(40),
    birthdate date,
    email varchar(100)
);