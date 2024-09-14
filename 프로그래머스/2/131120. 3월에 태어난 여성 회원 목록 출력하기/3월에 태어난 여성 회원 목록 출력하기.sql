select mp.MEMBER_ID, mp.MEMBER_NAME, mp.GENDER, date_format(mp.DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
from MEMBER_PROFILE mp
where mp.GENDER = 'W' and month(mp.DATE_OF_BIRTH) = 3 and mp.TLNO is not null
order by mp.MEMBER_ID asc;