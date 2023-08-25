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