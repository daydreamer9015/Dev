-- 뷰 (VIEW)
-- 13-14 뷰 생성 권한 부여 (SYSTEM 계정에서 실행)
-- C:\Users\admin>sqlplus sys/oracle as sysdba
-- SQL> grant create view to scott;

-- 13-15 뷰 생성
-- 20번 부서 직원 정보만 선택적으로 보여주는 논리적 테이블 생성
CREATE VIEW VW_EMP20
AS (SELECT EMPNO, ENAME, JOB, DEPTNO
        FROM EMP
        WHERE DEPTNO = 20);             -- 20번 부서만 필터링
        
-- 13-16, 17 생성된 뷰 확인
SELECT * FROM VW_EMP20;

-- 13-18 뷰 삭제
DROP VIEW VW_EMP20;

-- 13-20 ROWNUM 기본 사용
SELECT ROWNUM,          -- 행 번호
            E.*
FROM EMP E;

-- 13-21 ROWNUM, ORDER BY 사용시 이슈
-- ORDER BY 전에 ROWNUM이 먼저 적용되고 그 뒤에 ORDER BY가 들어가게 되어 ROWNUM이 섞이는 이슈가 발생함
SELECT ROWNUM,      -- ROWNUM이 먼저 부여된 후 정렬되므로 순서가 뒤섞임
            E.*
FROM EMP E
ORDER BY SAL DESC;      -- ROWNUM이 뒤섞임

-- 13-22 ORDER BY가 먼저 적용되도록 서브쿼리 사용하여 정렬 후 ROWNUM 부여
SELECT ROWNUM,
            E.*         -- 정렬 후 행 번호
FROM (SELECT *
            FROM EMP E
            ORDER BY SAL DESC) E;       -- 서브 쿼리에서 먼저 정렬
            
-- 13-23 WITH 절을 사용한 ROWNUM 부여
-- WITH절 : 임시 결과 집합을 정의 (가독성 향상)
WITH E AS (SELECT * FROM EMP ORDER BY SAL DESC)     -- 임시 테이블 E 정의
SELECT ROWNUM, E.*
FROM E;

-- 13-24 TOP-N 쿼리 (상위 5명)
-- ROWNUM을 사용한 상위 N개 레코드 추출
SELECT ROWNUM,
            E.*         -- 정렬 후 행 번호
FROM (SELECT *
            FROM EMP E
            ORDER BY SAL DESC) E       -- 서브 쿼리에서 먼저 정렬
WHERE ROWNUM <= 5;

-- SEQUENCE 
-- 13-26 SEQUENCE 생성 권한 부여 (SYSTEM 계정에서 실행)
-- SQL> GRANT CREATE SEQUENCE TO SCOTT;

-- 13-27 테이블 구조 복사
--DROP TABLE DEPT_SEQUENCE;
CREATE TABLE DEPT_SEQUENCE
AS SELECT *
    FROM DEPT
    WHERE 1<> 1;                -- 거짓 조건 : 구조만 복사

-- 13-28 시퀀스 생성
--DROP SEQUENCE SEQ_DEPT_SEQUENCE; -- 삭제할 때 사용
CREATE SEQUENCE SEQ_DEPT_SEQUENCE
INCREMENT BY 10             -- 10씩 증가
START WITH 10                 -- 시작값 10
MAXVALUE 1000                   -- 최대값 90
MINVALUE 0                     -- 최소값 0
NOCYCLE                          -- 최대값 도달 시 순환하지 않음
CACHE 2;                          -- 메모리에 2개씩 미리 생성

-- 13-29 시퀀스 정보 확인
SELECT * FROM user_sequences;

-- 13-30 시퀀스를 사용한 데이터 입력
-- NEXTVAL : 다음 시퀀스 값 반환 (값 증가함)
INSERT INTO DEPT_SEQUENCE (DEPTNO, DNAME, LOC)
VALUES (SEQ_DEPT_SEQUENCE.NEXTVAL, 'DATABASE', 'SEOUL');

SELECT * FROM DEPT_SEQUENCE ORDER BY DEPTNO;

-- 13-31 현재 시퀀스 값 확인
-- CURRVAL : 현재 시퀀스 값 반환 (값이 증가하지 않음)
SELECT SEQ_DEPT_SEQUENCE.CURRVAL
FROM DUAL;

-- 13-32 추가 데이터 입력
INSERT INTO DEPT_SEQUENCE (DEPTNO, DNAME, LOC)
VALUES (SEQ_DEPT_SEQUENCE.NEXTVAL, 'DATABASE', 'SEOUL');

SELECT * FROM DEPT_SEQUENCE ORDER BY DEPTNO;

-- 13-33 시퀀스 수정
-- ALTER SEQUENCE 시퀀스 속성 변경 (START WITH는 변경 불가)




















