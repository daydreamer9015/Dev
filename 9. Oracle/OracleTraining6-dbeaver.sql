-- 2. 숫자 함수
-- 6-19 ROUND() : 반올림 함수
-- 양수 : 소수점 이하 자리수, 음수 : 정수 자리수

SELECT
	ROUND(1234.5678) AS ROUND,		-- 소수점 첫째자리에서 반올림
	ROUND(1234.5678, 0) AS ROUND_0,
	ROUND(1234.5678, 1) AS ROUND_1,	-- 소수점 첫째자리까지 표시
	ROUND(1234.5678, 2) AS ROUND_2,	-- 소수점 둘째자리까지 표시
	ROUND(1234.5678, -1) AS ROUND_MINUS1,	-- 첫째자리에서 반올림
	ROUND(1234.5678, -2) AS ROUND_MINUS2	-- 둘째자리에서 반올림
FROM DUAL;

-- 6-20 TRUNC() : 버림 함수
-- 양수 : 소수점 이하 자리수, 음수 : 정수 자리수
SELECT
	TRUNC(1234.5678) AS TRUNC,		-- 소수점 첫째자리에서 버림
	TRUNC(1234.5678, 0) AS TRUNC,
	TRUNC(1234.5678, 1) AS TRUNC_1,	-- 소수점 첫째자리까지 표시
	TRUNC(1234.5678, 2) AS TRUNC_2,	-- 소수점 둘째자리까지 표시
	TRUNC(1234.5678, -1) AS TRUNC_MINUS1,	-- 첫째 자리에서 버림
	TRUNC(1234.5678, -2) AS TRUNC_MINUS2	-- 둘째 자리에서 버림
FROM DUAL;

-- 6-21 CEIL() 올림 / FLOOR() 내림
-- CEIL() : 해당 수보다 큰 가장 가까운 정수
-- FLOOR() : 해당 수보다 작은 가장 가까운 정수
SELECT
	CEIL(3.14),
	FLOOR(3.14),
	CEIL(-3.14),
	FLOOR(-3.14)
FROM DUAL;

-- 6-22 MOD() : 나머지 연산
SELECT
	MOD(15, 6),
	MOD(10, 2),
	MOD(11, 2)
FROM DUAL;

-- 연봉 협상 및 급여 계산
SELECT
	ENAME AS "사원명",
	SAL AS "현재 급여",
	SAL * 1.073 AS "7.3% 인상_원본",
	ROUND(SAL * 1.073, -1) AS "10원단위_반올림",
	ROUND(SAL * 1.073, -2) AS "100원단위_반올림",
	ROUND(SAL * 1.073, -3) AS "1000원단위_반올림",
	TRUNC(SAL * 1.073, -2) AS "100원단위_버림"
FROM EMP;