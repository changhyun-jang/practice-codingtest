SELECT year(b.sales_date) as YEAR, month(b.sales_date) as MONTH, count(distinct(b.user_id)) as PUCHASED_USERS,ROUND(count(distinct(b.user_id)) / (select COUNT(user_id) from user_info where year(joined)=2021),1) as PUCHASED_RATIO
from user_info as a
join online_sale as b
on a.user_id=b.user_id
where year(joined)=2021
group by YEAR, MONTH
order by MONTH;
