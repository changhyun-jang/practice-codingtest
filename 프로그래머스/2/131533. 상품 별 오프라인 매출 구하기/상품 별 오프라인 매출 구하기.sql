-- 코드를 입력하세요
SELECT a.product_code,(SUM(b.sales_amount)*a.price) as SALES
from product as a
join offline_sale as b
on a.product_id=b.product_id
group by a.product_id
order by SALES desc, a.product_code asc ;
