-- 코드를 입력하세요
SELECT year(b.sales_date) as Year, month(b.sales_date) as Month, a.gender, count(distinct(b.user_id))as USERS
from user_info as a
join online_sale as b
on a.user_id = b.user_id
WHERE a.gender is not null
group by Year,Month, a.gender
order by Year,Month, a.gender;