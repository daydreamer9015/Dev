DESC emp;

SELECT EMPNO, ENAME, DEPTNO		-- 사원번호, 이름, 부서번호만 조회
FROM EMP;						-- FROM절은 항상 필수


-- DISTINCT : 중복 행 제거(제거하지 않으면 메모리 사용량 증가)
SELECT DISTINCT DEPTNO 		-- 중복되는 부서번호 제거하고 조회 
FROM EMP;					-- 결과 : 각각 한번씩만 조회됨

-- 두 컬럼 조합에서 중복 제거 전
SELECT JOB, DEPTNO			-- 직책과 부서번호의 모든 조합 표시 (일반적인 조회방법)
FROM EMP;					-- 중복 포함된 결과 (총 14)

-- 두 컬럼 조합에서 중복 제거 후
SELECT DISTINCT JOB, DEPTNO		-- (직책, 부서번호) 조합 단위로 중복 제거
FROM EMP;						-- 중복 제거된 결과 (총 9) 예) (CLERK, 20)이 여러 개면 하나만 표시

SELECT ALL JOB, DEPTNO			-- ALL은 기본값(중복 포함) - 생략 가능함
FROM EMP;						-- DISTINCT의 반대 개념 = ALL

-- 3. 산술 연산과 컬럼 별칭(ALIAS)

-- 산술 연산 : +, -, *, / 사용 가능
SELECT ENAME, SAL, COMM, SAL*12+COMM AS ANNUAL_SAL		-- 연봉 계산(월급*12+커미션)
FROM EMP;												-- NULL과 계산하면 결과도 NULL


-- 해결 : COMM이 NULL이면 0으로 대체해서 계산
-- NVL(컬럼, 대체값)
-- NVL2(컬럼, NULL 아닐 때 값, NULL일 때 값)
-- COALESCE(값1, 값2, 값3....) - 여러 개 중 NULL이 아닌 첫번째 값

SELECT ENAME,
		SAL,
		COMM,
		NVL(COMM, 0) AS COMM2,			-- NULL을 0으로 변경한 값 확인
		SAL*12+NVL(COMM,0) AS ANNUAL_SAL	-- 연봉 계산
FROM EMP;

-- COMM이 NULL인 사람 확인하기
SELECT ENAME, COMM
FROM EMP;

-- 잘못된 방법
SELECT ENAME, COMM
FROM EMP
WHERE COMM = NULL;		-- NULL은 =로 비교할 수 있는 값이 아님. 그러므로 연산 불가

-- 올바른 방법
SELECT ENAME, COMM
FROM EMP
WHERE COMM IS NULL;

-- NULL이 아닌 데이터 찾기
-- COMM이 있는 사원들을 출력하시오
SELECT ENAME, JOB, SAL, COMM
FROM EMP
WHERE COMM IS NOT NULL;

-- COMM이 0인 사람만 출력하시오
SELECT ENAME, JOB, SAL, COMM
FROM EMP
WHERE COMM = 0;

-- NULL인 사람만 출력하시오
SELECT ENAME, JOB, SAL, COMM
FROM EMP
WHERE COMM IS NULL;

-- NULL을 0으로 바꿔서 출력
SELECT ENAME,
		COMM AS "원래값",
		NVL(COMM, 0) AS "NULL 처리 후"
FROM EMP;

-- 보너스를 주는데 COMM이 있으면 그 COMM을 주고 없으면 보너스(월급의 10%)를 받음
SELECT ENAME,
		SAL,
		COMM,
		NVL(COMM, SAL*0.1) AS BONUS
FROM EMP;

-- 모든 사원의 이름과 커미션을 출력하시오.(단, NULL은 0으로 표시하기)
SELECT ENAME, NVL(COMM, 0) AS COMMISSION
FROM EMP;

-- NVL2()
SELECT ENAME, NVL2(COMM, COMM, 0) COMMISSION FROM EMP;
SELECT ENAME, NVL2(COMM, '보너스 있음', '보너스 없음') COMMISSION FROM EMP;

-- COALESCE()
SELECT ENAME, COALESCE(COMM, 0) FROM EMP;

-- 4. 정렬(ORDER BY)

-- 기본적으로 오름차순 정렬(ASC) : 즉 생략 가능
-- 급여 컬럼 기준으로 오름차순 정렬하시오
SELECT *
FROM EMP
ORDER BY SAL ASC;

-- 내림차순 정렬
SELECT &
FROM EMP
ORDER BY SAL DESC;		-- 급여 기준 내림차순 정렬(큰 값부터)

-- 다중 정렬(첫번째 조건이 같으면 두번째 조건 적용)
-- 부서번호 오름순, 급여 내림순
SELECT *
FROM EMP
ORDER BY DEPTNO ASC, SAL DESC;