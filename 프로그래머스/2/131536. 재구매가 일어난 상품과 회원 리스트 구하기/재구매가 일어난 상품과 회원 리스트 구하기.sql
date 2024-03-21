SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
group by user_id, product_id
having count(product_id)>=2
order by USER_ID asc ,PRODUCT_ID desc