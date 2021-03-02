drop database if exists seeds;
drop user if exists svc_seeds;
create user svc_seeds password 'secret';
create database seeds;
grant all privileges on database seeds to svc_seeds;