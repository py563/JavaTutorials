delimiter $$

Drop function maxOrderCustomer $$

CREATE FUNCTION maxOrderCustomer() returns varchar(100)
BEGIN 
	declare maxCustNum numeric;
	declare maxOrders numeric;
	declare maxCustName varchar(100);
	
	SELECT count(orderNumber) as no_of_orders, o.customerNumber 
	into maxOrders,maxCustNum 
	from orders as o join 
		(SELECT sum(amount) as all_payments, customerNumber 
		from payments group by customerNumber) as p 
	on o.customerNumber=p.customerNumber
	group by o.customerNumber 
	order by no_of_orders desc, p.all_payments desc limit 1;
	
	select customerName into maxCustName 
	from customers 
	where customerNumber = maxCustNum;

	return maxCustName;
END$$

delimiter ;
select maxOrderCustomer();