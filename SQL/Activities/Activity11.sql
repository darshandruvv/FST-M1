
-- Activity11
Write a query that produces the name and number of each salesman and each customer 
with more than one current order. Put the results in alphabetical order.

select customer_id, customer_name from customers a
where 1<(select count(*) from orders b where a.customer_id = b.customer_id)
union
select salesman_id, salesman_name from salesman a
where 1<(select count(*) from orders b where a.salesman_id = b.salesman_id)
order by customer_name;

Write a query to make a report of which salesman produce the largest and smallest 
orders on each date. Also add a column that shows "highest on" and "lowest on" values.

select a.salesman_id, a.salesman_name, o.order_no, 'highest on', o.order_date, o.purchase_amount from salesman a, orders o
where a.salesman_id=o.salesman_id
and o.purchase_amount=(select max(purchase_amount) from orders c where c.order_date = o.order_date)
union
select a.salesman_id, a.salesman_name, o.order_no, 'lowest on', o.order_date, o.purchase_amount from salesman a, orders o
where a.salesman_id=o.salesman_id
and o.purchase_amount=(select min(purchase_amount) from orders c where c.order_date = o.order_date)
order by order_date;
