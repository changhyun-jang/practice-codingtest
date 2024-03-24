select year(YM) as year, ROUND(AVG(pm_val1),2) as 'PM10', ROUND(AVG(pm_val2),2) as 'PM2.5'
from air_pollution
group by year(YM), location2 
having location2 = '수원'
order by year asc;