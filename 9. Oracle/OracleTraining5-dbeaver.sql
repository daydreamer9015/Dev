-- 1. 사원 이름을 다양한 형태로 출력하시오.
SELECT ENAME AS "원본 이름",
	UPPER(ENAME) AS "대문자로_출력하기",
	LOWER(ENAME) AS "소문자로_출력하기",
	INITCAP(ENAME) AS "공식문서용_출력하기"
FROM EMP
WHERE DEPTNO = 20;

-- 2. 사용자가 'scott', 'SCOTT', 'Scott'
SELECT *
FROM EMP
WHERE UPPER(ENAME) = UPPER('SCOTT');
-- WHERE LOWER(ENAME) = LOWER('SCOTT');

-- 3. 이름에 'A'가 들어가는 사원을 출력하시오. (대소문자 무관)
SELECT ENAME, JOB
FROM EMP
WHERE UPPER(ENAME) LIKE '%A%';