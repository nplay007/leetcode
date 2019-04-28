select t2.Name as Department, t1.Name as Employee, t1.Salary
from Employee as t1, Department as t2
where t1.DepartmentId = t2.Id
and (t1.DepartmentId , t1.Salary) in (
select DepartmentId , max(salary) as Salary
from Employee
group by DepartmentId
)