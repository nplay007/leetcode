Select DISTINCT L1.Num as ConsecutiveNums from Logs L1, Logs L2, Logs L3 
where L2.Id = L1.Id + 1 and L3.Id = L2.Id + 1 
and L1.Num = L2.Num and L2.Num = L3.Num