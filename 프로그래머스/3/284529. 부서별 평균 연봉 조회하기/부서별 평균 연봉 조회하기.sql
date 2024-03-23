select a.dept_id, b.DEPT_NAME_EN, a.AVG_SAL
from (select dept_id, round(avg(sal),0) as AVG_SAL
      from HR_EMPLOYEES 
      group by dept_id) as a
join HR_DEPARTMENT as b
on a.dept_id = b.dept_id
order by a.AVG_SAL desc;
