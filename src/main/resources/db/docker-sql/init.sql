drop database if exists meal_planner;
drop user if exists svc_seeds;
create user svc_seeds password 'secret';
create database meal_planner;
grant all privileges on database meal_planner to svc_seeds;