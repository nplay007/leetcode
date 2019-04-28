Select wt1.Id 
from Weather wt1, Weather wt2
where wt1.Temperature > wt2.Temperature
and TO_DAYS(wt1.DATE) - TO_DAYS(wt2.DATE) = 1