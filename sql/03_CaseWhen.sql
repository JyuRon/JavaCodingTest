/**
  06
  판매 가능한 제품들의 재고 파악을 위해 2020년 2월에 생산된 양을 확인하려하는데 우선 문구류 제품들을 먼저 파악하려 한다.
  해당 제품명과 제품들의 총 생산량을 출력하시오.
  (문구류의 제품코드(INumber)는 I100(1~5)이며 1번은 가위, 2번은 풀, 3번은 공책, 4번은 볼펜, 5번은 지우개이다, ex - I1001 = 가위)
 */

 select
     case inumber
        when 'I1001' then '가위'
        when 'I1002' then '풀'
        when 'I1003' then '공책'
        when 'I1004' then '볼팬'
        when 'I1005' then '지우개'
    end  as item
         , sum(pcount)
from tproduction
where to_char(pdate, 'yyyy-mm') = '202002'
and substring(inumber, 1, 4) = 'I100'
group by inumber;

