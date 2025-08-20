-- JOIN LAB
/*
 * - Oracle 전통 방식 : WHERE절에 JOIN 조건과 필터 조건 함께
 * - ANSI 표준 방식 : ON절에 JOIN 조건, WHERE 절에 필터 조건 분리
 * - 외부 조인 표기 : Oracle (+) vs LEFT/RIGHT JOIN
 * - 자체 조인
 * - 비등가 조인
 */

-- 1. DALLAS에서 근무하는 모든 사원의 사번, 이름, 직무, 부서명을 조회하시오.

-- ORACLE 전통 방식(방언)
SELECT EMPNO, ENAME, JOB, DNAME
FROM EMP E, DEPT D			-- EMP와 DEPT 테이블을 조인 (별칭 사용)
WHERE E.DEPTNO = D.DEPTNO	-- 조인 조건
AND D.LOC = 'DALLAS'		-- 필터 조건
ORDER BY E.EMPNO;

-- ANSI 표준 방식
SELECT EMPNO, ENAME, JOB, DNAME
FROM EMP E
JOIN DEPT D ON E.DEPTNO = D.DEPTNO	-- JOIN ~ ON으로 조인 조건 명시
WHERE D.LOC = 'DALLAS'				-- 조인 후 필터 조건 적용
ORDER BY E.EMPNO;

-- 2. 급여 등급별 사원 현황

/*
 * 급여 등급이 3등급인 사원들의 이름, 급여, 부서명을 조회하시오.
 * 힌트 : 3개 테이블 조인 필요
 */
-- ORACLE
SELECT ENAME, SAL, DNAME
FROM EMP E, DEPT D, SALGRADE S		-- 3개 테이블 조인
WHERE E.DEPTNO = D.DEPTNO			-- 조인조건1 : EMP-DEPT
AND E.SAL BETWEEN S.LOSAL AND S.HISAL -- 조인조건2 : 급여가 등급범위내 (비등가조인)
AND S.GRADE = 3			-- 필터조건 : 3등급만
ORDER BY E.DEPTNO;

-- ANSI
SELECT ENAME, SAL, DNAME
FROM EMP E
JOIN DEPT D ON E.DEPTNO = D.DEPTNO		-- 첫번째 조인: EMP-DEPT
JOIN SALGRADE S ON SAL BETWEEN S.LOSAL AND S.HISAL	-- 두번째 조인 : 급여범위
WHERE S.GRADE = 3		-- 3등급만 필터링
ORDER BY E.SAL			-- 급여순 정렬










