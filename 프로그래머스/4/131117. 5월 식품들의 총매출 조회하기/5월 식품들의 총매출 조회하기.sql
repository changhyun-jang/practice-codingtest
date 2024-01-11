-- 코드를 입력하세요
SELECT a.product_id, a.product_name, (SUM(b.amount)*a.price) as total_sales
from food_product as a
join food_order as b
on a.product_id = b.product_id
where year(b.produce_date)=2022 and month(b.produce_date)=05
group by a.product_id
order by total_sales desc, a.product_id asc;
