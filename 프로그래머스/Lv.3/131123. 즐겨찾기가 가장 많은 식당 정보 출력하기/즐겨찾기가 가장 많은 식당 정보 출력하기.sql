-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info
WHERE (FOOD_TYPE, favorites) in (select FOOD_TYPE, MAX(favorites) from rest_info group by FOOD_TYPE)
order by food_type desc;