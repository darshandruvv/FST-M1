
-- Activity7

--Write an SQL statement to find the total purchase amount of all orders.
select sum(PURCHASE_AMOUNT) from orders;

--Write an SQL statement to find the average purchase amount of all orders.
select avg(PURCHASE_AMOUNT) from orders;

--Write an SQL statement to get the maximum purchase amount of all the orders.
select max(PURCHASE_AMOUNT) from orders;

--Write an SQL statement to get the minimum purchase amount of all the orders.
select min(PURCHASE_AMOUNT) from orders;

--Write an SQL statement to find the number of salesmen listed in the table.
select count( distinct SALESMAN_ID) from orders;
