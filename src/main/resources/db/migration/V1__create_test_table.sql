create table if not exists users  (
	id bigint PRIMARY KEY,
	user_name varchar(50) unique not null,
	first_name varchar(50) not null,
	last_name varchar(50),
	email varchar(50),
	phone varchar(12)
);

create sequence if not exists user_seq;
alter table users alter column id set default nextval('user_seq');
--drop sequence user_seq cascade;

insert into users (user_name, first_name , last_name, email, phone) values
('jonny', 'John', 'Doe', 'email@email.com', '+79881455623' );
insert into users (user_name, first_name , last_name, email, phone) values
('jane', 'Jane', 'Dodo', 'email2@email.com', '+79774854512' );
insert into users (user_name, first_name , last_name, email, phone) values
('vitya', 'Victor', 'An', 'an@email.com', '+79664521357' );

