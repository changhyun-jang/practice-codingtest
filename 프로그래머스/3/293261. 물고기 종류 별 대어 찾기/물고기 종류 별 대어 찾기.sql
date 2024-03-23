select a.id as ID, b.fish_name as FISH_NAME, a.length as LENGTH
from fish_info as a
join fish_name_info as b
on a.fish_type = b.fish_type
where (a.length, a.fish_type) in (select max(length) as length, fish_type
                  from fish_info
                  group by fish_type)
order by a.id;