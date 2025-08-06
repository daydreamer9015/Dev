-- desc : 테이블 컬럼명, 데이터 타입, NULL 허용 여부 등 구조 확인하는 명령어(Oracle 전용)
desc emp;                   -- 사원 정보 테이블
select * from emp;      -- 모든 컬럼(*), 모든 행 조회

desc dept;          -- 부서 정보 테이블
SELECT * FROM dept;     --  SQL은 대소문자 구분 안 함(관례: 키워드는 대문자)

DESC salgrade;          -- 급여 등급 테이블
select * from salgrade;     -- 급여 등급별 최소/최대 급여 구간 정보

-- 2. 기본 SELECT 문법
-- 특정 컬럼만 선택 조회

select * from emp
order by empno;

select * from emp
order by sal desc;

select * from emp
order by empno desc;

-- emp 테이블의 전체 열을 부서번호(오름차순)와 급여(내림차순)로 정렬하기

select * from emp
order by deptno, sal desc;

select * from emp
where deptno = 30;