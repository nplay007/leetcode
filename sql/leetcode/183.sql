Select A.Name as Customers from Customers A
Where A.ID Not In (select B.CustomerId from Orders B)


SELECT A.Name as Customers from Customers A
LEFT JOIN Orders B on  A.Id = B.CustomerId
WHERE B.CustomerId is NULL