/**
  07
  제품이 한번이라도 주문됐거나, 반품이 한번이라도 발생한 월의 정보를 알아보려고한다.
  위, 조건에 해당하는 월들을 중복을 제거하고 출력하시오.
 */
select to_char(odate, 'mm')from torder
union
select to_char(rdate,'mm') from treturn;


/**
  08
  여태까지 회사에 입사했던 사람들의 총 인원 수와 연도별 입사한 직원 수를 출력하시오.
 */
 select '총 입사원 수', count(*) from temployee
union all
select to_char(startdate,'yyyy') as yyyy, count(*) from temployee
group by to_char(startdate,'yyyy');

SELECT '총 인원 수 :' AS 입사년도, COUNT(tem1.*) AS 입사한_직원_수 FROM tEmployee AS tem1
UNION ALL
SELECT TO_CHAR(tem2.StartDate,'YYYY'), COUNT(tem2.*)
FROM tEmployee AS tem2
GROUP BY TO_CHAR(tem2.StartDate,'YYYY')
