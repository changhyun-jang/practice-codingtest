-- 코드를 작성해주세요
select route, concat(round(sum(D_BETWEEN_DIST),1),'km') as total_distance, concat(round(avg(d_between_dist),2),'km') as average_distance
from subway_distance
group by route
order by 1 desc;