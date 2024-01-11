-- 코드를 입력하세요
SELECT a.category, sum(b.sales) as  TOTAL_SALES
from book as a
join book_sales as b
on a.book_id = b.book_id
where year(b.sales_date)=2022 and month(b.sales_date)=01
group by a.category
order by a.category
