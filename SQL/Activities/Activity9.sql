
-- Activity9 

create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);
 
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;


Write an SQL statement to know which salesman are working for which customer.

select  s.salesman_name, customer_name from salesman s, customers c
 where s.salesman_id=c.salesman_id ;

Write an SQL statement to make a list of customers in ascending order with a salesman that 
have a grade less than 300.

select  s.salesman_name, customer_name, c.grade from customers c 
left outer join  salesman s on  s.salesman_id=c.salesman_id and c.grade<300 
order by c.customer_id ;

Write an SQL statement to find the list of customers who appointed a salesman who gets a
 commission of more than 12%.

select  s.salesman_name, customer_name, s.commission from customers c 
inner join  salesman s on  s.salesman_id=c.salesman_id and s.commission>12 
order by c.customer_id ;


Write an SQL statement to find the following details of an order - order number, order date,
 purchase amount of order, which customer gives the order and which salesman works for that
  customer and commission rate they get for the order.

  
select o.ORDER_NO , o.ORDER_DATE ,o.PURCHASE_AMOUNT , c.customer_name ,
 s.salesman_name, s.commission
from orders o , customers c, salesman s
 where o.customer_id=c.customer_id and o.salesman_id=s.salesman_id;
