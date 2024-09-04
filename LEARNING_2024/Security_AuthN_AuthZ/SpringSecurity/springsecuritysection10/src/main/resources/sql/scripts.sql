

use easybank;

create table users(
    id int not null auto_increment,
	username varchar(55) unique not null,
    password varchar(55) not null,
	enabled int not null,
    primary key(id)
);

CREATE INDEX username_index ON users(username);

create table authorities (
	id int not null auto_increment,
	username varchar(55) not null,
	authority varchar(55) not null,
	foreign key(username) references users(username),
    primary key (id)
);

insert into users values ( null,'abhi','12345',1);
insert into authorities values(null,'abhi','read');

create table customers(
 id int not null auto_increment,
 email varchar(50) not null,
 pwd varchar(50) not null,
 role varchar(50) not null,
 primary key(id));