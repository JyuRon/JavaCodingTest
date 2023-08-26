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

/**
  15
  부서별로 연령의 평균을 파악하기 위해서 각 부서마다 속해있는 직원들의 나이로 출생연도를 알아보려한다.
  이를 위해 부서명, 직원명, 출생연도를 출력하되 각 부서의 직원들을 출생연도가 빠른 순으로 순위를 매겨라.
  (공동순위는 동일하게 부여하고 그 다음 순위는 공동 순위 다음 번호로 순위가 출력되어야 하며 출생연도는 tEmplyee의 ERRN의 앞 2자리로 비교하여 출력할 수 있다.
  D1001 부서는 문구생산부, D2001은 가구생산부, D3001은 액세서리생산부, D4001은 전자기기생산부, D5001은 음료생산부이다.)
 */

 select
     case dnumber
         when 'D1001' then '문구생산부'
         when 'D2001' then '가구생산부'
         when 'D3001' then '액세서리생산부'
         when 'D4001' then '전자기기생산부'
         when 'D5001' then '음료생산부이다'
         else '부서없음'
     end as 부서명 ,
     ename as 직원명,
     subString(errn,1,2) as 출생년도,
     dense_rank() over (partition by dnumber order by subString(errn,1,2))
from temployee;

