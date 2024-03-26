select count(a.id) as 'FISH_COUNT'
from fish_info as a
join fish_name_info as b
on a.fish_type = b.fish_type
where b.fish_name = 'BASS'
or b.fish_name = 'SNAPPER';