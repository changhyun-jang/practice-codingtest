SELECT car_id, max(case when '2022-10-16'between date_format(start_date,'%Y-%m-%d')and date_format(end_date,'%Y-%m-%d') then '대여중' else '대여 가능' end) as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
group by car_id
order by car_id desc;