/**
    03
    생산량 조정을 위해 2020년 2월의 총 생산량을 알려고 한다.
    해당 월에 생산된 제품들의 코드와 해당 제품들의 총 생산량을 출력하시오.
 */

select inumber, sum(pcount)
from tproduction
where pdate between cast('2020-02-01' as timestamp) and  cast('2020-02-28' as timestamp)
group by inumber;


/**
    04
    가구류 제품들의 선호도 조사를 위하여 고객들이 가구류 제품들의 주문을 몇 번 했는지 고객코드별로 출력하시 오.
    (가구류의 생산코드는 P2~로 시작한다)
 */
select cnumber, count(pnumber)
from torder
where substring(pnumber,1,2) = 'P2'   --- substring(startIndex, length)
group by cnumber;


/**
    05
    2020년 1월의 성실직원을 뽑기 위해 성실직원의 기준인 생산량 500개 이상을 달성한 인원들의 직원코드와
    총 생산량을 출력하시오.
 */
 select enumber, sum(pcount)
from tproduction
where pdate between cast('2020-01-01' as timestamp) and cast('2020-01-31' as timestamp)
group by enumber
having sum(pcount) >= 500
;