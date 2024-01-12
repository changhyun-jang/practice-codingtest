-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/',a.BOARD_ID,'/',b.FILE_ID,b.FILE_NAME,b.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD as a
join USED_GOODS_FILE  as b
on a.BOARD_ID=b.BOARD_ID
where views=(select max(views) 
             from USED_GOODS_BOARD as a
             join USED_GOODS_FILE  as b
             on a.BOARD_ID=b.BOARD_ID)
order by b.FILE_ID desc
