/*Script to create truyum database*/
create database if not exists truyum;

/*Script to use the truyum database*/
use truyum;

/*Script to create table user*/
create table if not exists user(
us_id int primary key not null auto_increment,
us_name varchar(100));

/*Script to create table menu_item*/
create table if not exists menu_item(
me_id int primary key not null auto_increment,
me_name varchar(100),
me_price float(8,2),
me_active varchar(3),
me_date_of_launch date,
me_category varchar(45),
me_free_delivery varchar(3));

/*Script to create table cart*/
create table if not exists cart(
ct_id int primary key not null auto_increment,
ct_us_id int,
ct_pr_id int,
foreign key(ct_us_id) references user(us_id),
foreign key(ct_pr_id) references menu_item(me_id));