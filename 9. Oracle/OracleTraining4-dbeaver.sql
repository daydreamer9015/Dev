-- 6-1 대소문자 변환 함수
SELECT ENAME,
UPPER(ENAME),	-- 대문자로
LOWER(ENAME),	-- 소문자로
INITCAP(ENAME)	-- 첫글자만 대문자
FROM EMP;

-- 6-2 대소문자 구분없이 검색하기
-- 사용자가 'SCOTT', 'Scott', 'scott' 어떻게 입력해도 찾을 수 있음
SELECT * FROM EMP WHERE UPPER(ENAME) = UPPER('SCOTT');

-- 6-3 대소문자 구분없이 부분 검색
-- 이름에 SCOTT이 포함된 모든 직원 검색
SELECT * FROM EMP WHERE UPPER(ENAME) LIKE UPPER('%SCOTT%');

-- 6-4 LENGTH() 문자열 길이 구하기
SELECT ENAME, LENGTH(ENAME) FROM EMP;

-- 6-5 다섯글자 이상의 이름을 가진 직원을 조회하시오.
SELECT ENAME, LENGTH(ENAME) FROM EMP WHERE LENGTH(ENAME) >= 5;		-- 글자수가 5 이상인 경우만

-- 이름의 세번째 글자가 A인 직원의 이름과 이름의 길이를 조회하시오.
SELECT ENAME, LENGTH(ENAME) AS NAME_LENGTH FROM EMP WHERE ENAME LIKE '__A%' ORDER BY ENAME;

-- 6-6 한글과 영문의 바이트 길이 차이 (DUAL : 더미 테이블)
SELECT LENGTH('한글'),	-- 문자 개수
	LENGTHB('한글')		-- 바이트 수 (UTF-8 기준) : 한글은 문자 1개 당 3바이트, 영어는 문자 1개 당 1바이트
FROM DUAL;

-- 6-7 SUBSTR() - 문자열 자르기 (부분 추출)
-- SUBSTR(문자열, 시작위치, 길이)
-- 시작 위치는 1부터 시작(주의 : 시작점이 0이 아님)
SELECT JOB,
	SUBSTR(JOB, 1, 2),
	SUBSTR(JOB, 3, 2),
	SUBSTR(JOB, 4)
FROM EMP;

-- 6-8 SUBSTR() 음수 인덱스 사용
-- 음수를 사용하면 뒤에서부터 계산
SELECT JOB,
	SUBSTR(JOB, -LENGTH(JOB)),	-- 맨 뒤에서 전체 길이만큼 자름 = 전체
	SUBSTR(JOB, -LENGTH(JOB), 2),	-- 맨 뒤에서 전체 길이 위치부터 2글자
	SUBSTR(JOB, -3)		-- 뒤에서 3번째 글자부터 끝까지
FROM EMP;

-- 사원명의 첫 글자와 마지막 글자를 추출하여 약어를 만드시오.
SELECT ENAME AS "사원명",
	LENGTH(ENAME) AS "이름 길이",
	SUBSTR(ENAME, 1, 1) AS "첫 글자",
	SUBSTR(ENAME, -1, 1) AS "마지막 글자",
	SUBSTR(ENAME, 1, 1) || SUBSTR(ENAME, -1, 1) AS "약어"		-- || : 문자열 결합
FROM EMP;

-- 6-9 INSTR() - 문자 위치 찾기
-- 특정 문자가 처음 나타나는 위치를 반환 (없으면 0)
-- INSTR(문자열, 찾을 문자) : 기본 형태(첫번째 위치 반환)
-- INSTR(문자열, 찾을 문자, 시작 위치) : 특정 위치부터 검색
-- INSTR(문자열, 찾을 문자, 시작 위치, N번째) : N번째 출현 위치 반환
-- INSTR(문자열, 찾을 문자, -1) : 뒤에서부터 검색
SELECT INSTR('HELLO, ORACLE!', 'L') AS INSTR_1,		-- 첫번째 L의 위치
	INSTR('HELLO, ORACLE!', 'L', 5) AS INSTR_2,		-- 5번째 이후 첫 L의 위치
	INSTR('HELLO, ORACLE!', 'L', 2, 2) AS INSTR_3	-- 2번째부터 시작해서 2번째 L의 위치
FROM DUAL;

-- 6-10 INSTR을 WHERE절에서 사용
-- 이름에 'S'가 포함된 직원을 찾으시오
SELECT *
FROM EMP
WHERE INSTR(ENAME, 'S') > 0;

-- 6-11 LIKE
-- 위와 동일한 결과
SELECT *
FROM EMP
WHERE ENAME LIKE '%S%';

-- 
SELECT LOWER(ENAME) || '@gmail.com' AS "이메일",		-- 이메일 생성
	INSTR(LOWER(ENAME) || '@gmail.com', '@') AS "@위치",	-- @기호의 위치 찾기
	SUBSTR(LOWER(ENAME) || '@gmail.com', 1, INSTR(LOWER(ENAME) || '@gmail.com', '@') - 1) AS "아이디",	-- @ 앞부분 추출
	SUBSTR(LOWER(ENAME) || '@gmail.com', INSTR(LOWER(ENAME) || '@gmail.com', '@') + 1) AS "도메인"		-- @ 뒷부분 추출
FROM EMP
WHERE ROWNUM <= 5;		-- 가상의 행 수

-- 6-12 : REPLACE() - 문자 치환
-- REPLACE(원본, 찾을 문자, 바꿀 문자)
-- 세번째 매개변수 생략 시 해당 문자는 제거됨
SELECT '010-1234-5678' AS REPLACE_BEFORE,
	REPLACE('010-1234-5678', '-', ' '),		-- '-'를 공백으로
	REPLACE('010-1234-5678', '-')			-- '-'를 제거
FROM DUAL;

SELECT '010-1234-5678' AS "하이픈 형식",
	REPLACE('010-1234-5678', '-', '') AS "하이픈 제거",
	REPLACE('010.1234.5678', '.', '') AS ". 제거",
	REPLACE('010 1234 5678', ' ', '') AS "공백 제거"
FROM DUAL;

-- 실행 결과를 단계별로 진행
SELECT ENAME AS "원본",
	REPLACE(ENAME, 'S', '*') AS "STEP 1 : S->*",
	REPLACE(REPLACE(ENAME, 'S', '*'), 'A', '#') AS "STEP 2 : A->#",
	REPLACE(REPLACE(REPLACE(ENAME, 'S', '*'), 'A', '#'), 'E', '@') AS "STEP 3 : E->@ FINALE"
FROM EMP
WHERE ENAME IN ('SMITH', 'ALLEN', 'JAMES', 'JONES');

-- REPLACE() 중첩 사용
SELECT ENAME AS "원본",
	REPLACE(REPLACE(REPLACE(ENAME, 'S', '*'), 'A', '#'), 'E', '@') AS "암호화 된 이름"
FROM EMP
WHERE ENAME IN ('SMITH', 'ALLEN', 'JAMES', 'JONES');

-- WITH절로 임시 테이블 만들기
/*
 * WITH 절은 복잡한 쿼리문을 간단하게 만들어주는 "임시 테이블"
	- 쿼리 실행 중에만 존재하는 가상의 테이블
	- 복잡한 쿼리를 단계별로 나누어 작성 가능
	- 가독성이 좋아지고 유지 보수가 쉬워짐
	- 서브 쿼리를 여러 번 사용할 때 효율적임

	- 기본 구조
		WITH 임시테이블명 AS (
			SELECT문
		)
		SELECT * FROM 임시테이블명;
*/
-- 가장 간단한 WITH절
WITH SIMPLE_DEMO AS (		-- 이 SIMPLE_DEMO 자체가 임시 테이블이 됨
	SELECT 'Hello' AS GREETING, 'World' AS TARGET FROM DUAL
)
SELECT * FROM SIMPLE_DEMO;

-- EMP 테이블로 기본 WITH절 사용하기
WITH HIGH_SALARY AS (
	SELECT * FROM EMP WHERE SAL >= 2000
)
SELECT * FROM HIGH_SALARY;

-- REPLACE() 중첩을 WITH절로 개선하기
-- 원본 (복잡한 중첩)

SELECT
	ENAME,
	REPLACE(REPLACE(REPLACE(ENAME, 'S', '*'), 'A', '#'), 'E', '@') AS RESULT
FROM EMP;

-- WITH절로 개선
WITH
	step1 AS (
		SELECT ENAME, REPLACE(ENAME, 'S', '*') AS NAME_MODIFIED
		FROM EMP
	),
	step2 AS (
		SELECT ENAME, REPLACE(NAME_MODIFIED, 'A', '#') AS NAME_MODIFIED
		FROM step1
	),
	step3 AS (
		SELECT ENAME, REPLACE(NAME_MODIFIED, 'E', '@') AS FINAL_NAME
		FROM step2
	),
	step4 AS (
		SELECT ENAME, REPLACE(FINAL_NAME, 'I', '!') AS REAL_FINAL_NAME
		FROM step3
	)
SELECT 
	ENAME AS "원본",
	REAL_FINAL_NAME AS "암호화 이름"
FROM step4;

-- 중첩된 REPLACE()를 변수처럼 이해하기
WITH step_by_step AS (
	SELECT ENAME AS "원본",
		REPLACE(ENAME, 'S', '*') AS "STEP 1 : S->*",
		REPLACE(REPLACE(ENAME, 'S', '*'), 'A', '#') AS "STEP 2 : A->#",
		REPLACE(REPLACE(REPLACE(ENAME, 'S', '*'), 'A', '#'), 'E', '@') AS "STEP 3 : E->@ FINALE"
	FROM EMP
)
SELECT * FROM step_by_step;

-- 6-15 CONCAT() - 문자열 연결 (|| 연산자와 동일)
-- CONCAT() 함수는 두 개만 연결 가능하고 ||는 여러 개 연결 가능함
SELECT CONCAT(EMPNO, ENAME),		-- '사번이름' 연결
	CONCAT(EMPNO, CONCAT(' : ', ENAME))	-- '사번:이름' 연결
FROM EMP
WHERE ENAME = 'SCOTT';

-- CONCAT()
SELECT CONCAT(CONCAT(CONCAT('[', DEPTNO), '] '), ENAME) AS "CONCAT 방식"
FROM EMP
WHERE ROWNUM <= 3;

-- || 연산자 사용(더 간단함)
SELECT '[' || DEPTNO || '] ' || ENAME AS "파이프 방식"
FROM EMP
WHERE ROWNUM <= 3;

-- 6-13 LPAD() / RPAD() - 문자열 채우기
-- LPAD() : 왼쪽에 채움
-- RPAD() : 오른쪽에 채움
-- 주로 고정 길이 포맷 맞추거나 마스킹 처리에 사용
SELECT 'Oracle',
	LPAD('Oracle', 10, '#')	AS LPAD_1,	-- 총 10자리, 왼쪽을 #으로
	RPAD('Oracle', 10, '*') AS RPAD_1,	-- 총 10자리, 오른쪽을 *로
	LPAD('Oracle', 10) AS LPAD_2,		-- 채울 문자 생략 시 공백
	RPAD('Oracle', 10) AS RPAD_2
FROM DUAL;

-- 6-14 개인정보 마스킹 처리
SELECT RPAD('971225-', 14, '*') AS RPAD_JMNO,
	RPAD('010-1234-', 13, '*') AS RPAD_PHONE
FROM DUAL;

-- 카드번호
SELECT '1234-5678-9012-3456' AS "원본카드번호",
	SUBSTR('1234-5678-9012-3456', 1, 4) || '-'
	|| RPAD('*', 4, '*') || '-'
	|| RPAD('*', 4, '*') || '-'
	|| SUBSTR('1234-5678-9012-3456', -4)
	AS "마스킹 결과"
FROM DUAL;

-- 사원 정보를 정제하여 출력하시오.
SELECT RPAD(LPAD(ROWNUM, 3, '0'), 5) AS NO,
	RPAD(UPPER(SUBSTR(ENAME, 1, 1)) || LOWER(SUBSTR(ENAME, 2)), 10) AS "이름",
	RPAD(REPLACE(JOB, 'MAN', 'MGR'), 12) AS "직무"
FROM EMP;

/*
 * 6-16
 * - TRIM([옵션] [제거할문자] FROM 원본문자열)
 * 		- 옵션 3가지
 * 			- LEADING : 앞쪽(왼쪽)에서만 제거
 * 			- TRAILING : 뒤쪽(오른쪽)에서만 제거
 * 			- BOTH	   : 양쪽에서 제거 (기본값) 
 */

-- 기본 TRIM(옵션없음)
SELECT 
	TRIM('          HELLO          ') AS RESULT1,
	TRIM('*******HELLO********') AS RESULT2		-- 공백이 없어서 변화가 없음
FROM DUAL;

-- 옵션만 있는 TRIM
SELECT
	-- LEADING FROM: 앞쪽 공백만 제거
	TRIM(LEADING FROM '   HELLO  ') AS LEADING_RESULT,
	-- TRAILING FROM: 뒤쪽 공백만 제거
	TRIM(TRAILING FROM '   HELLO  ') AS TRAILING_RESULT,
	-- BOTH FROM: 양쪽 공백 제거
	TRIM(BOTH FROM '   HELLO  ') AS BOTH_RESULT
FROM DUAL;

-- 
SELECT 
	'원본: [' ||'  Hello  ' || ']' AS "원본 문자열",
	'TRIM: [' || TRIM(LEADING FROM '  Hello  ') || ']' AS "앞쪽(왼쪽) 제거",
	'TRIM: [' || TRIM(TRAILING FROM '  Hello  ') || ']' AS "뒤쪽(오른쪽) 제거",
	'TRIM: [' || TRIM(BOTH FROM '  Hello  ') || ']' AS "양쪽 제거"
FROM DUAL;

-- 특정 문자 제거
SELECT
	-- 기본 TRIM()은 공백만 제거
	TRIM('***HELLO***') AS "기본 TRIM",		-- 변화 없음
	-- 특정 문자를 지정하여 제거
	TRIM('*' FROM '***HELLO***') AS "별표 제거",
	TRIM(LEADING '*' FROM '***HELLO***') AS "앞 별표 제거",
	TRIM(TRAILING '*' FROM '***HELLO***') AS "뒤 별표 제거",
	TRIM(BOTH '*' FROM '***HELLO***') AS "양쪽 별표 제거"
FROM DUAL;

-- 다양한 TRIM 활용
SELECT
	'   HELLO   ' AS "원본",
	TRIM('   HELLO    ') AS "양쪽_공백제거",
	LTRIM('   HELLO   ') AS "왼쪽만_제거",
	RTRIM('   HELLO   ') AS "오른쪽만_제거",
	TRIM('*' FROM '****HELLO****') AS "별표_제거"
FROM DUAL;