-- 코드를 입력하세요
SELECT i.animal_id,i.name
from animal_ins as i
join animal_outs as o
on i.animal_id=o.animal_id
order by datediff(o.DATETIME, i.DATETIME) desc
limit 2;