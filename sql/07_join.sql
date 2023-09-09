/**
  16
  현재까지 입사했던 모든 직원들의 직원코드, 부서명, 직원명, 직급명, 입사일, 퇴사일을 출력하시오
  (부서와 직급의 경우는 코드가 아닌 부서명과 직급명으로 출력하고 입사일과 퇴사일은 연,월,일만 출력되어야한다)
 */

select
    enumber, dept.dname, ename, rank.rname,
    to_char(startdate,'yyyy-mm-dd'), to_char(resignationdate,'yyyy-mm-dd')
from temployee as emp
join tdepartment as dept on emp.dnumber = dept.dnumber
join trank as rank on rank.rnumber = emp.rnumber;


/**
  17
  2021년 1월의 전자기기류 판매금 정산을 위해 전자기기류 제품들의 제품명과 해당 제품의 총 판매량을 출력하세 요.
  (전자기기류의 제품코드는 INumber 번호가 I4로 시작한다.)
 */

select titem.iname,sum(pcount)
from torder
join tproduction on torder.pnumber = tproduction.pnumber
join titem on tproduction.inumber = titem.inumber
where tproduction.inumber like 'I4%' and to_char(torder.odate, 'yyyy-mm') = '2021-01'
group by titem.iname;

/**
  18
  2020년 1월에 만들어진 모든 제품의 생산코드, 생산직원명, 제품명, 생산량, 생산일자를 출력하세요 (단, 정렬은 고려하지 않는다 )
 */
select prod.pnumber, emp.ename, item.iname, prod.pcount, prod.pdate
from tproduction as prod
join temployee emp on prod.enumber = emp.enumber
join titem item on prod.inumber = item.inumber
where to_char(prod.pdate, 'yyyy-mm') = '2020-01';


/**
  19
  2022년 3월 20일 기준으로 현재 판매 가능한 공책의 재고량을 구하시오
  (반품되어 돌아온 공책의 경우 재판매 하지 않는다.)
 */
SELECT tBase.IName AS 제품명, (tBase2.PCount - tBase.OCount) AS 재고량
FROM
    (
        SELECT tit.IName, SUM(tpr.PCount) AS OCount
        FROM tProduction AS tpr
        JOIN tOrder AS tor ON tpr.PNumber = tor.PNumber
        JOIN tItem AS tit on tpr.INumber = tit.INumber
        WHERE tit.IName = '공책' AND tor.ODate < CAST('20220321' AS TIMESTAMP)
        GROUP BY tit.IName
    ) AS tBase
JOIN
    (
        SELECT tit.IName, SUM(tpr.PCount) AS PCount
        FROM tProduction AS tpr
        JOIN tItem AS tit ON tpr.INumber = tit.INumber
        WHERE tit.IName = '공책' AND tpr.PDate < CAST('20220321' AS TIMESTAMP)
        GROUP BY tit.IName ----------- ⑪
    ) AS tBase2
ON tBase.IName = tBase2.IName


/**
    20
    2020년 1월의 제품 별 생산량의 순위를 확인하기 위하여 제품명과 생산량을 순위를 매겨 출력하시오.
    (모든 제품이 출력되어야 하며 공동순위가 있다면 다음 순위는 공동순위의 수 만큼 밀려나고
  생산되지 않은 제품 은 제일 마지막 순위로 결정되어야 한다)
 */

select rank() over(order by prod.sum desc nulls last ) as rank , prod.sum, item.iname
from titem as item
left outer join (
    select sum(pcount) as sum, inumber
    from tproduction
    where to_char(pdate, 'yyyy-mm') = '2020-01'
    group by inumber
) as prod on item.inumber = prod.inumber;



/**
  21
  우리 회사의 고객인 ‘오랜문방구’의 반품제품명, 주문코드, 주문량, 반품량, 반품사유를 출력하세요
 */

select t5.iname, t.onumber, t4.pcount, tre.rcount, t2.rreason
from treturn tre
    join torder t on tre.onumber = t.onumber
    join treturnreason t2 on tre.rrnumber = t2.rrnumber
    join tproduction t4 on t4.pnumber = t.pnumber
    join titem t5 on t5.inumber = t4.inumber
    join (select cnumber from tcustomer cust where cust.cname = '오랜문방구') t3 on t.cnumber = t3.cnumber