SELECT b.user_id, b.nickname, (sum(a.price)) as total_sales
from USED_GOODS_BOARD as a
join USED_GOODS_USER as b
on a.WRITER_ID=b.USER_ID 
where status='DONE'
group by a.writer_ID
having sum(a.price)>=700000
order by total_sales 
