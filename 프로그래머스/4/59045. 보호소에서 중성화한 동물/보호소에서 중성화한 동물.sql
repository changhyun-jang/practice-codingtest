SELECT a.animal_id, a.animal_type,a.name
from animal_ins as a
join animal_outs as b
on a.animal_id = b.animal_id
where left(a.sex_upon_intake,5)!=left(b.sex_upon_outcome,5)
