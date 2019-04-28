Select E1.Name as Employee
from Employee E1, Employee E2
where E1.managerId = E2.Id and E1.salary > E2.salary;