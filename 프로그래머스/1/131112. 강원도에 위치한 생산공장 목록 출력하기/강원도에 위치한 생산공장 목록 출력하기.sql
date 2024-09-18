select ff.FACTORY_ID, ff.FACTORY_NAME, ff.ADDRESS
from FOOD_FACTORY ff
where ff.ADDRESS like '강원%'
order by ff.FACTORY_ID asc;