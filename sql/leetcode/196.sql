delete p1 from Person p1, Person p2
where p1.Email = p2.Email
and p1.id > p2.id


delete from Person where Id not in ( select A.Id from (select min(Id) as Id from Person GROUP BY Email) A )