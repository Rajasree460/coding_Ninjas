 with cte as

     (

    select genre , (domestic + worldwide - budget) as netprofit

    from IMDB i join earning e on e.movie_id = i.movie_id 

    join genre g on g.movie_id = e.movie_id

    where title like '%2012)' order by genre),

  cte1 as

  (  select genre , max(netprofit)over(partition by genre range between unbounded preceding and unbounded following) as net_profit

    from cte

    where genre is not null)    

select genre,round(avg(net_profit),1) as net_profit 

from cte1 

group by genre order by genre
