/*Script to insert data into menu_item table-TYUC001*/
insert into menu_item values(default,'Sandwich',99.00,'Yes','2017-03-15','Main Course','Yes'),(default,'Burger',129.00,'Yes','2017-12-23','Main Course','No'),(default,'Pizza',149.00,'Yes','2018-08-21','Main Course','No'),(default,'French Fries',57.00,'No','2017-07-02','Starters','Yes'),(default,'Chocolate Brownie',32.00,'Yes','2022-11-02', 'Dessert','No');

/*Script to fetch data from menu_item table-TYUC001*/
select * from menu_item;

/*Script to fetch data from menu_item table-TYUC002*/
select me_name,me_free_delivery,me_price,me_category,me_active from menu_item where me_date_of_launch <= now() and me_active='Yes';

/*Script to fetch data from menu_item table-TYUC003*/
select me_name,me_free_delivery,me_price,me_category,me_active from menu_item where me_id=1;

/*Script to fetch data from menu_item table-TYUC003*/
update menu_item set me_name='cake',me_free_delivery='No',me_price=100.00,me_category='Desserts' where me_id=1;

/*Script to fetch data from menu_item table-TYUC004*/
insert into user values(default,'Meena'),(default,'Monisha');

/*Script to fetch data from menu_item table-TYUC004*/
insert into cart values(default,1,null),(default,2,1),(default,2,2),(default,2,3);

/*Script to fetch data from menu_item table-TYUC005*/
SELECT menu_item.me_id AS 'Id', menu_item.me_name AS 'Name', menu_item.me_free_delivery AS 'Free Delivery', menu_item.me_price AS 'Price', menu_item.me_category AS 'Category'
FROM menu_item INNER JOIN cart ON menu_item.me_id = cart.ct_pr_id WHERE cart.ct_us_id = 2;

/*Script to fetch data from menu_item table-TYUC005*/
SELECT SUM(menu_item.me_price) FROM menu_item INNER JOIN cart ON menu_item.me_id = cart.ct_pr_id WHERE cart.ct_us_id = 2;

/*Script to fetch data from menu_item table-TYUC006*/
delete from cart where ct_us_id=2 and  ct_pr_id=2;
