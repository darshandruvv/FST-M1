SELECT DISTINCT(salesman_id) from ORDERS;

SELECT order_no,order_date from orders
order by order_date asc;

SELECT order_no,purchase_amount from orders
order by purchase_amount desc;

SELECT * FROM ORDERS
WHERE purchase_amount < 500;

SELECT * FROM ORDERS
WHERE purchase_amount BETWEEN 1000 AND 2000;