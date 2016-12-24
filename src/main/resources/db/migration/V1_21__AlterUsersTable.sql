
alter table users add column first_name varchar(64) not null default '';
alter table users add column last_name varchar(64) not null default '';
alter table users add column email_address varchar(256) not null default '';

