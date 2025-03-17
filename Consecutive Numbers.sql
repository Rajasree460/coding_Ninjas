select num as ConsecutiveNums from

(select num, count(*) from

(select *, lag(num, 1, num) over() as compare_num,

num - lag(num, 1, num) over() as difference_compare_num

from logs) b

where difference_compare_num = 0

group by num, compare_num

Having count(*) >= 3) b;
