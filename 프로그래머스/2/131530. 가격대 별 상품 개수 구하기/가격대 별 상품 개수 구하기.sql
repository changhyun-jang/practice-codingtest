-- 코드를 입력하세요
SELECT truncate(price,-4)as price_group, count(product_id) as PRODUCTS
FROM PRODUCT
group by price_group
order by price_group;