with cte1 as(

    select e.*,d.id as d_id,d.name as department from employee e join  department d on e.departmentid=d.id

),

cte2 as(

   select c.*,dense_rank() over(partition by departmentid order by salary desc) as rk from cte1 c

)

select department as "Department",name as "Employee",salary as "salary" from cte2 where rk=1 order by name desc;

