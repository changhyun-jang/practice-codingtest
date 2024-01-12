-- 코드를 입력하세요
SELECT month(start_date) as Month, car_id, count(history_id) as Records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where start_date between '2022-08-01' and '2022-10-31'and 
car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date between '2022-08-01' and '2022-10-31'group by car_id having count(history_id)>=5)
group by Month, car_id
having Records>0
order by Month, car_id desc;