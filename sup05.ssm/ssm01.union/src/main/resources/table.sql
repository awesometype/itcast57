create database eesy_ssm;

use eesy_ssm;
drop table if exists account;
create table account (
    id int not null auto_increment,
    name varchar(64),
    money double,
    primary key (id)
);