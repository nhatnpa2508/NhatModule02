/*
select * from customer;

select customerNumber, contactlastname, contactFirstName, phone, city from customer;

select customerNumber, contactlastname, contactFirstName, phone, city from customer
where contactFirstName = 'Peter' and city = 'Melbourne';

select customerNumber, contactlastname, contactFirstName, phone, city from customer
where contactFirstName like '%A%';

select customerNumber, contactlastname, contactFirstName, phone, city from customer
where customerNumber between 103 and 125;

select customerNumber, contactlastname, contactFirstName, phone, city, country from customer
where country in ('USA','France','Spain');

select customerNumber, contactlastname, contactFirstName, phone, city, country from customer
where country in ('USA','France');

select customerNumber, contactlastname, contactFirstName, phone, city, country from customer
order by contactFirstName asc;

select customernumber, contactlastname, contactfirstname, phone, city 
from customers 
order by contactfirstname desc;

select count(country) as 'Số khách hàng ở France'
from mydb.`customer`
where country = 'France';
*/
/*
insert into mydb.customer (customernumber, customername, contactfirstname, contactlastname, phone, addressline1, city, country) 
values (501, 'AgileLead', 'Lan', 'Tran', '0978822683', 'Ham Nghi', 'Ha Noi', 'Viet Nam' ); */
/*select * from mydb.customer
where customerNumber = 501;
*/
/*update customer
set customername = 'Baane Mini Imports'
where customernumber = 103 ;
delete  from customer
where city = 'Nantes';*/
select * from customer
where city = 'Nantes';
