select e.name from employee e

where e.id in(select e2.managerid FROM employee e2

group by e2.managerid

having count(e2.managerid)>=5 )

and e.managerid is null
