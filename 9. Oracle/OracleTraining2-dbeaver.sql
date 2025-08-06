-- 5. 조건절(WHERE) 기본

-- 단일 조건 (특정 부서 직원만 조회)
SELECT *
FROM EMP
WHERE DEPTNO = 30;		-- 부서 번호가 30인 행만 필터링

-- 부서 번호가 30이고 영업사원인 직원만 출력하시오.
SELECT *
FROM EMP
WHERE DEPTNO = 30 AND JOB = 'SALESMAN';		-- AND 연산자 (모든 조건이 참이어야 참)

-- 부서 번호가 30이거나 직책이 CLERK인 직원을 출력하시오.
SELECT *
FROM EMP
WHERE DEPTNO = 30 OR JOB = 'CLERK';			-- OR 연산자 (조건 중 하나라도 참이면 참)

-- 연봉이 3600인 직원을 출력하시오
SELECT *
FROM EMP
WHERE SAL*12 = 36000;

-- 급여가 3000 이상인 직원을 출력하시오.
SELECT *
FROM EMP
WHERE SAL >= 3000;

-- 이름이 'F' 이상인 직원들을 출력하시오.
SELECT *
FROM EMP
WHERE ENAME >= 'F';

-- 이름이 'FORZ' 이하인 직원을 출력하시오.
SELECT *
FROM EMP
WHERE ENAME <= 'FORZ';

-- 같지 않음
SELECT * FROM EMP WHERE SAL != 3000;	-- != 연산자 (일반적)
SELECT * FROM EMP WHERE SAL <> 3000;	-- <> 연산자 (표준SQL에 해당됨)
SELECT * FROM EMP WHERE SAL ^= 3000;	-- ^= 연산자 (ORACLE 전용)
SELECT * FROM EMP WHERE NOT SAL = 3000; -- NOT 연산자 사용

-- IN 연산자
SELECT * FROM EMP
WHERE JOB IN ('MANAGER', 'SALESMAN', 'CLERK');

-- NOT IN 연산자
SELECT * FROM EMP
WHERE JOB NOT IN ('MANAGER', 'SALESMAN', 'CLERK');		-- 지정된 값과 모두 다른 결과만 출력

-- AND 연산자
SELECT * FROM EMP
WHERE JOB != 'MANAGER' AND JOB <> 'SALESMAN' AND JOB ^= 'CLERK';

-- 핵심 보직('MANAGER', 'ANALYST', 'PRESIDENT')이면서 급여가 2000 이상인 직원을 급여 내림차순으로 정렬하여 조회하시오.
SELECT * FROM EMP
WHERE JOB IN ('MANAGER', 'ANALYST', 'PRESIDENT') AND SAL >= 2000 ORDER BY SAL DESC;

-- 영업팀('SALESMAN', 'MANAGER', 'PRESIDENT')과 관련된 모든 직원을 조회하시오. (직책 오름차순, 급여 내림차순)
SELECT ENAME, JOB, SAL, NVL(COMM, 0) AS COMM FROM EMP
WHERE JOB IN ('SALESMAN', 'MANAGER', 'PRESIDENT') ORDER BY JOB, SAL DESC;

-- 10번과 30번 부서 직원만 조회하시오. (부서번호, 이름 순으로 정렬하시오)
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
WHERE DEPTNO IN (10, 30) ORDER BY DEPTNO, ENAME;

-- 급여가 정확히 1250, 1500, 3000인 직원을 조회하시오.(급여 순으로 정렬)
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
WHERE SAL IN (1250, 1500, 3000) ORDER BY SAL;

-- 상사가 7698, 7839, 7902인 직원을 조회하시오. (상사, 이름 순으로 정렬)
SELECT ENAME, JOB, DEPTNO, SAL, MGR FROM EMP
WHERE MGR IN (7698, 7839, 7902) ORDER BY MGR, ENAME;

-- 영업관련('SALESMAN', 'MANAGER') 직종이면서 급여가 1500 이상인 직원을 조회하시오. (연봉 내림차순으로 정렬)
SELECT ENAME, JOB, SAL, NVL(COMM, 0) AS COMM, SAL + NVL(COMM,0) AS TOTAL FROM EMP
WHERE JOB IN ('SALESMAN', 'MANAGER') AND SAL >= 1500 ORDER BY TOTAL DESC;

-- 20번, 30번 부서의 MANAGER와 ANALYST만 조회하시오. (부서번호, 직책으로 정렬)
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
WHERE DEPTNO IN (20, 30) AND JOB IN ('MANAGER', 'ANALYST') ORDER BY DEPTNO, JOB;