/**
  rank : 1 2 2 4 5
  dense_rank : 1 2 2 3 3 4
  row_number : 1 2 3 4 5 6

  partition by 생략가능
  문법 : rank() over(partition by column order by column)
 */

/**
  13
  회사 내 우수직원을 생산량이 많은 직원을 기준으로 하여 상위 10명까지 뽑아 상여금을 주려한다.
  이에 해당하는 직원들의 직원코드와 총 생산량을 상위 10명까지 순위를 매겨 출력하시오.
  (만약 공동순위(ex. 공동 1등)가 있다면 다음 순위는 중복 된 순위의 수 만큼 떨어진다.)
 */
select enumber, sum(pcount), rank() over (order by sum(pcount) desc)
from tproduction
group by enumber
limit 10;
;

/**
  14
  현재 판매하는 제품들 중 장농의 인기가 많아져 판매 가능한 장농의 재고를 확인하기 위하여
  장농 생산이력을 전부 출력하되 생산량이 높은순서대로 생산한 직원의 코드와 제품코드, 생산량을 순위를 매겨 출력하시오.
  (공동 순위가 나오지 않게 출력 해야 하며 또한 동률일경우 직원코드(ENumber)가 작은 코드가 우선순위를 가지 도록 한다, 장농의 제품코드는 I2003번이다)
 */

 select
     enumber,pnumber ,pcount,
     row_number() over (partition by inumber order by pcount desc, enumber) as rank
 from tproduction
 where inumber = 'I2003'
 ;