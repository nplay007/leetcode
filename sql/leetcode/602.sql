select ids as id, count as num
from
(
    select ids, count(*) as count
    from
    (
	select requester_id as ids from request_accepted
	union all
	select accepter_id from request_accepted
    ) as tbl1
    group by ids
) as tbl2
order by count desc
limit 1;