-- 날짜 함수
-- 6-23 SYSDATE - 현재 날짜/시간
-- 날짜에 숫자를 더하거나 빼면 일(DAY) 단위로 계산
SELECT
	SYSDATE AS NOW,
	SYSDATE -1 AS YESTERDAY,
	SYSDATE +1 AS TOMORROW
FROM DUAL;

-- 6-24 ADD_MONTHS() - 월 단위 날짜 계산
-- 정확한 월 계산이 필요할 때 사용(윤년 등 자동 처리)
SELECT
	SYSDATE AS NOW,
	ADD_MONTHS(SYSDATE, 3)	-- 지금 기준으로 3개월 후
FROM DUAL;

-- 6-25 입사 10년차 날짜 계산
-- 120개월 = 10년
SELECT EMPNO, ENAME, HIREDATE,
	ADD_MONTHS(HIREDATE, 120) AS WORK10YEARS
FROM EMP;

-- 6-26 근속 40년 이상 직원 찾기
-- 40년 = 480개월
/*
 * 입사일 + 40년 < 현재 날짜
 * ADD_MONTHS(HIREDATE, 480)	SYSDATE 	
 */

SELECT EMPNO, ENAME, HIREDATE, SYSDATE
FROM EMP
WHERE ADD_MONTHS(HIREDATE, 480) < SYSDATE;		-- 입사 40년 지난 직원

-- 6-27 MONTH_BETWEEN() - 두 날짜 사이의 개월 수
/*
 * MONTHS_BETWEEN(날짜1, 날짜2) 
 * 	- 날짜1에서 날짜2를 뺀 개월 수를 반환
 * 	- 날짜1이 미래면 양수, 과거면 음수
 */
SELECT
	EMPNO, ENAME, HIREDATE, SYSDATE,
	MONTHS_BETWEEN(HIREDATE, SYSDATE) AS MONTH1,		-- 음수
	MONTHS_BETWEEN(SYSDATE, HIREDATE) AS MONTH2,		-- 양수(근속 개월)
	TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS MONTH3
FROM EMP;

-- 6-28 NEXT_DAY() - 다음 특정 요일 날짜 반환
-- LAST_DAY() - 해당 월의 마지막 날짜 반환
SELECT
	SYSDATE,
	NEXT_DAY(SYSDATE, '월요일'),		-- 다음 월요일 날짜
	LAST_DAY(SYSDATE)				-- 이번 달 마지막 날
FROM DUAL;