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