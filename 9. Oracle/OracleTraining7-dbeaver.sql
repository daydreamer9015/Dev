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

-- 6-29 날짜 ROUND() - 반올림
-- ROUND(date, format) - 날짜를 지정된 단위로 반올림하는 함수
-- CC - CENTURY, YYYY - YEAR, Q - QUARTER, DDD - DAY, HH - HOUR
SELECT SYSDATE,		-- 현재 시스템 날짜/시간
	ROUND(SYSDATE, 'CC') AS FORMAT_CC,		-- 50년 기준으로 반올림, 50년 기준으로 반올림
	ROUND(SYSDATE, 'YYYY') AS FORMAT_YYYY,	-- 년단위 반올림, 7월 1일 기준
	ROUND(SYSDATE, 'Q') AS FORMAT_Q,		-- 분기 단위 반올림 (2월 16일, 5월 16일, 8월 16일, 11월 16일)
	ROUND(SYSDATE, 'DDD') AS FORMAT_DDD,	-- 일 단위 반올림, 정오(12:00) 기준
	ROUND(SYSDATE, 'HH') AS FORMAT_HH		-- 시간 단위 반올림, 30분 지나면 반올림
FROM DUAL;

-- 6-30 날짜 TRUNC() - 버림
-- TRUNC(date, format) - 날짜를 지정된 단위로 버림(절삭)하는 함수
-- CC - CENTURY, YYYY - YEAR, Q - QUARTER, DDD - DAY, HH - HOUR
SELECT SYSDATE,		-- 현재 시스템 날짜/시간
	TRUNC(SYSDATE, 'CC') AS FORMAT_CC,		-- 50년 기준으로 버림, 50년 기준으로 버림
	TRUNC(SYSDATE, 'YYYY') AS FORMAT_YYYY,	-- 년단위 버림, 7월 1일 기준
	TRUNC(SYSDATE, 'Q') AS FORMAT_Q,		-- 분기 단위 버림 (2월 16일, 5월 16일, 8월 16일, 11월 16일)
	TRUNC(SYSDATE, 'DDD') AS FORMAT_DDD,	-- 일 단위 버림, 정오(12:00) 기준
	TRUNC(SYSDATE, 'HH') AS FORMAT_HH		-- 시간 단위 버림, 30분 지나면 버림
FROM DUAL;

-- 형 변환 함수 (Type Conversion Functions)
-- 6-31 자동 형변환(암시적 변환)
-- 숫자 + 문자(숫자형태) = 자동으로 숫자로 변환
SELECT EMPNO, ENAME, EMPNO + '500'		-- 문자열 '500'이 숫자 500으로 자동 변환 되어 연산됨
FROM EMP
WHERE ENAME = 'SCOTT';

-- 6-32 형 변환 오류
-- 숫자로 변환 불가능한 문자는 에러 발생
SELECT 'ABCD' + EMPNO, EMPNO			-- 실행 시 수치 부적합 오류 발생
FROM EMP
WHERE ENAME = 'SCOTT';

-- 6-33 TO_CHAR - 날짜를 문자로 변환
-- 날짜 포맷 지정
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') AS 현재날짜시간
FROM DUAL;

-- 6-34 TO_CHAR 날짜 포맷 종류
-- TO_CHAR(date, format) - 날짜를 지정된 형식의 문자열로 변환하는 함수
SELECT SYSDATE,				-- 현재 시스템의 날짜/시간
	TO_CHAR(SYSDATE, 'MM') AS MM,		-- 월(숫자)을 두 자리 숫자로 표시(01~12)
	TO_CHAR(SYSDATE, 'MON') AS MON,		-- 월(약어)을 세 자리 문자 약어로 표시 (한글 : 8월)
	TO_CHAR(SYSDATE, 'MONTH') AS MONTH,	-- 월(전체)을 전체 이름으로 표시 (공백 포함 9자리로)
	TO_CHAR(SYSDATE, 'DD') AS DD,		-- 일을 두 자리 숫자로 표시(01~31)
	TO_CHAR(SYSDATE, 'DY') AS DY,		-- 요일을 약어로 표시 (한글 : '수', 영문 : 'WED')
	TO_CHAR(SYSDATE, 'DAY') AS DAY		-- 요일을 전체 이름으로 표시 (공백 포함 9자리로) (한글 : '수요일')
FROM DUAL;

-- 6-37 TO_CHAR 시간 포맷
-- TO_CHAR()로 시간을 다양한 형식으로 표현
-- HH24 : 24시간제, HH12 : 12시간제, AM/PM : 오전/오후
SELECT SYSDATE,
	TO_CHAR(SYSDATE, 'HH24:MI:SS') AS HH24MISS,		-- 00:00:00 ~ 23:59:59
	TO_CHAR(SYSDATE, 'HH12:MI:SS AM') AS HH12MISS,
	TO_CHAR(SYSDATE, 'HH:MI:SS P.M.') AS HHMISS_PM
FROM DUAL;

-- 6-41 TO_NUMBER() - 문자를 숫자로 명시적 변환
-- TO_NUMBER(string, format) - 문자열을 지정된 형식에 맞춰 숫자로 변환
-- 포맷을 지정하여 변환
SELECT TO_NUMBER('1,300', '999,999') - TO_NUMBER('1,500', '999,999')
FROM DUAL;

-- 6-42 TO_DATE() - 문자를 날짜로 변환
-- TO_DATE(string, format) - 문자열을 지정된 형식에 맞춰 날짜로 변환
-- 다양한 날짜 형식을 처리 가능

SELECT
	TO_DATE('2025-08-13', 'YYYY-MM-DD') AS TODATE1,
	TO_DATE('2025/08/13', 'YYYY/MM/DD') AS TODATE2
FROM DUAL;

-- 6-43 TO_DATE()을 WHERE절에서 사용
SELECT *
FROM EMP
WHERE HIREDATE > TO_DATE('1981/06/01', 'YYYY/MM/DD')

-- 6-44 YY, RR
-- YY : 현재 세기 (2000년대)
-- RR : 50년 기준으로 세기 결정 (00~49: 2000년대, 50~99: 1990년대)
-- 연도 2자리 사용시 RR 사용 권장
SELECT TO_CHAR(TO_DATE('49/12/10', 'YY/MM/DD'), 'YYYY-MM-DD') AS YY_YEAR_49,
		-- YY 형식 : 49 -> 현재 세기(2000년대로 해석 => 2049년)
		TO_CHAR(TO_DATE('49/12/10', 'RR/MM/DD'), 'YYYY-MM-DD') AS RR_YEAR_49,
		-- RR 형식 : 49 -> 00~49 범위이므로 2000년대로 해석 => 2049년
		TO_CHAR(TO_DATE('55/12/10', 'YY/MM/DD'), 'YYYY-MM-DD') AS YY_YEAR_55,
		-- YY 형식 : 55 -> 현재 세기(2000년대로 해석 => 2055년)
		TO_CHAR(TO_DATE('55/12/10', 'RR/MM/DD'), 'YYYY-MM-DD') AS RR_YEAR_55
		-- RR 형식 : 55 -> 50~99 범위이므로 1900년대로 해석 => 1955년
FROM DUAL;

-- 입사 기념일 찾기
SELECT
	ENAME,
	HIREDATE,
	TO_CHAR(HIREDATE, 'MM-DD') AS "입사_월일",
	-- 올해 입사기념일 다음 월요일 찾기
	NEXT_DAY(TO_DATE(TO_CHAR(SYSDATE, 'YYYY') || TO_CHAR(HIREDATE, '-MM-DD')),'월요일') AS "올해_입사기념일_다음_월요일"
FROM EMP;