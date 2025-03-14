WITH CTE AS (

    SELECT customer_id AS "ids", row_number() over(order by customer_id) as rn from Customers

)

Select rn as ids from CTE where ids != rn
