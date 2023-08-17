-- Select, Where, Order by
/*
 01
 문구생산부와 가구생산부의 직원정보를 확인하려한다.
위에 해당하는 직원들의 직원명과 입사일을 입사일이 빠른 순서대로 출력하세요.
(문구생산부의 DNumber는 'D1001', 가구생산부는 'D2001'이며 입사일은 연,월,일까지만 출력되어야 한다)
 */

select ename as 직원명, to_char(startdate,'yyyy-mm-dd') as 입사일
from temployee
where dnumber in ('D1001', 'D2001')
order by startdate asc;


/*
    02
    2020년 크리스마스부터 입사일이 만 2년이 넘어가는 사람에게 보너스를 지급하려고 한다.
    위 조건에 해당하는 직원의 직원명과 입사일을 출력하시오.
    (단, 정렬은 고려하지 않는다)
 */

select ename, startdate
from temployee
where startdate < cast('2020-12-25' as timestamp) - cast('2 year' as interval);

