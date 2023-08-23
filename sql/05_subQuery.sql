/**
  09
  회사에서 제공해주는 기숙사에 머무를 수 있는 인원의 제한을 위해 부서와 직급, 그리고 현재 거주지를 따져 제 한하려고 한다.
  이에 따라 부서명과 직급명, 직원명 그리고 현재 직원의 주소를 출력하시오
  (부서코드, 직급코드가 아닌 부서명, 직급명으로 출력되어야 한다.)
 */
 select
     (select dname from tdepartment as tdept where tdept.dnumber = templ.dnumber),
     (select rname from trank as tra where tra.rnumber = templ.rnumber) as 직급,
     eaddr as 주소

from temployee as templ;


/**
  10
  회사 내 전 직원들의 평균 생산량보다 한번이라도 많이 생산한 직원들에게는 상여금을 주려한다.
  이에 해당하는 직원명을 출력하시오 (생산량은 tProduction 테이블의 PCount이다.)
 */
 select distinct
     (select ename from temployee as templo where templo.enumber = tprod.enumber)
from tproduction as tprod
where pcount > (select avg(pcount) from tproduction);


/**
  11
  2022년 1월에 반품이 발생한 직원을 확인하여 패널티를 부과하려 한다. 이에 해당하는 직원명을 출력하시오.
 */

select ename from temployee
where enumber in (
    select enumber from tproduction
    where pnumber in (
        select pnumber from torder
        where onumber in (
            select onumber from treturn
            where to_char(rdate, 'yyyy-mm') = '2022-01')
        )
    );


/**
  12
  2021년부터 판매가 시작됨에 따라 지난 1년(20년 1월 1일 ~ 20년 12월 31일) 동안 생산된
  제품들의 제품코드와 총 생산량을 생산량이 많은 순으로 확인하려한다. 위의 조건에 맞춰 출력하시오.
 */

select inumber, sum(pcount)
from tproduction
where to_char(pdate, 'yyyy') = '2020'
group by inumber
order by sum(pcount) desc;






