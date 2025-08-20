-- ORACLE 제약 조건(CONSTRAINTS) 쿼리

-- 14-1 NOT NULL 제약 조건을 가진 테이블 생성
CREATE TABLE TABLE_NOTNULL(
    LOGIN_ID VARCHAR2(20) NOT NULL,     -- 로그인 ID: 필수 입력
    LOGIN_PWD VARCHAR2(20) NOT NULL,    -- 로그인 패스워드 : 필수 입력
    TEL VARCHAR2(20)
);

DESC TABLE_NOTNULL;

-- 14-2 제약조건 위반 테스트
INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD, TEL)
VALUES ('TEST_ID_01', NULL, '010-1234-5678');        -- SQL 오류: ORA-01400

-- 14-3 : 제약조건 준수한 데이터 입력
INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD)
VALUES ('TEST_ID_01', '1234' ); 

SELECT * FROM TABLE_NOTNULL;

-- 14-4 이미 저장된 데이터의 필수 항목을 NULL로 변경
UPDATE TABLE_NOTNULL
SET LOGIN_PWD = NULL            -- NOT NULL 컬럼을 NULL로 업데이트 시도
WHERE LOGIN_ID = 'TEST_ID_01';

-- 14-5 시스템 제약 조건에 대한 정보 조회
-- 현재 사용자가 소유한 모든 제약 조건 정보 조회
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME               -- 테이블 이름
FROM USER_CONSTRAINTS;

-- 14-6 명시적 제약조건 이름 지정
-- 제약조건에 의미 있는 이름을 부여하여 테이블을 생성하시오.
CREATE TABLE TABLE_NOTNULL2 (
    LOGIN_ID VARCHAR2(20) CONSTRAINT TBLNN2_LGNID_NN NOT NULL,       -- 명명 규칙 : 테이블명_컬럼명_타입
    LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLNN2_LGNPW_NN NOT NULL,  -- 제약조건 이름을 명시적으로 지정
    TEL VARCHAR2(20)
);

-- 제약조건 이름 확인
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME               -- 테이블 이름
FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_NOTNULL%';

-- 14-7 ALTER TABLE로 TEL 컬럼에 NOT NULL 제약조건 추가
-- 이미 NULL 값이 있는 컬럼에 NOT NULL 제약조건을 추가 이슈
ALTER TABLE TABLE_NOTNULL
MODIFY (TEL NOT NULL);          -- SQL 오류 : ORA-01407 : 기존 NULL 값이 있어서 실패

-- 14-8 NULL 값을 업데이트 후 컬럼 TEL에 제약조건 추가 준비
-- TEL 컬럼의 NULL 값을 채운 후 NOT NULL 제약조건을 추가하시오.
UPDATE TABLE_NOTNULL
SET TEL = '010-1234-5678'       -- NULL 값을 실제 값으로 업데이트
WHERE LOGIN_ID = 'TEST_ID_01';

SELECT * FROM TABLE_NOTNULL;

-- 14-9 ALTER TABLE로 NOT NULL 제약조건 추가
-- NULL 값이 없는 컬럼에 NOT NULL 제약조건을 추가하시오.
ALTER TABLE TABLE_NOTNULL
MODIFY (TEL NOT NULL);      -- NULL 값이 없어서 제약조건 추가가 가능함
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME               -- 테이블 이름
FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_NOTNULL2';

-- 14-10 ALTER TABLE로 명시적 제약조건 이름과 함께 제약조건 추가
-- 제약조건 이름을 지정하면서 NOT NULL 제약조건을 추가하시오.
ALTER TABLE TABLE_NOTNULL2
MODIFY (TEL CONSTRAINT TBBNN_TEL_NN NOT NULL);      -- 제약조건 이름 지정

-- 14-11 테이블 구조 확인
DESC TABLE_NOTNULL2;

-- 14-12 제약조건 이름 변경
-- 기존 제약조건의 이름을 더 적절한 이름으로 변경하시오.
ALTER TABLE TABLE_NOTNULL2
RENAME CONSTRAINT TBBNN_TEL_NN TO TBLNN2_TEL_NN;            -- 일관된 명명 규칙 적용
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME               -- 테이블 이름
FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_NOTNULL2';

-- 14-13 제약조건 삭제
-- 더이상 필요없는 제약조건을 삭제하시오.
ALTER TABLE TABLE_NOTNULL2
DROP CONSTRAINT TBLNN2_TEL_NN;      -- 제약조건 삭제

DESC TABLE_NOTNULL2;

-- 14-14 UNIQUE 제약 조건을 가지는 테이블 생성
CREATE TABLE TABLE_UNIQUE (
    LOGIN_ID VARCHAR2(20) UNIQUE,       -- 중복 불가, NULL은 허용
    LOGIN_PWD VARCHAR2(20) NOT NULL,    -- 필수 입력
    TEL VARCHAR2(20)
);

DESC TABLE_UNIQUE;

-- 14-15 UNIQUE 제약조건 정보 조회
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME               -- 테이블 이름
FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_UNIQUE';

-- 14-16 UNIQUE 제약조건 테스트 - 첫번째 데이터 입력
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL)
VALUES ('TEST_ID_01', 'PWD01', '010-1234-5678');

SELECT * FROM TABLE_UNIQUE;

-- 14-17 UNIQUE 제약조건 위반 테스트
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL)
VALUES ('TEST_ID_01', 'PWD01', '010-1234-5678');        --  ORA-00001 : 무결성 제약조건

-- 14-18 다른 ID로 입력 (UNIQUE 제약조건 준수)
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL)
VALUES ('TEST_ID_02', 'PWD01', '010-1234-5678');

SELECT * FROM TABLE_UNIQUE;

-- 14-19 UNIQUE 제약조건 컬럼에 NULL을 입력할 수 있음 -- UNIQUE는 NULL 허용
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL)
VALUES (NULL, 'PWD01', '010-1234-5678');

SELECT * FROM TABLE_UNIQUE;

-- 14-20 NULL 값을 이미 존재하는 값으로 업데이트 시 어떻게
UPDATE TABLE_UNIQUE
SET LOGIN_ID = 'TEST_ID_01'             -- 이미 존재하는 값
WHERE LOGIN_ID IS NULL;               -- ORA-00001 : 무결성 제약조건에 위배

-- 14-21 명시적 이름의 UNIQUE 제약조건
CREATE TABLE TABLE_UNIQUE2 (
    LOGIN_ID VARCHAR2(20) CONSTRAINT TBLUNG2_LGNID_UNQ UNIQUE,       -- 중복 불가, NULL은 허용
    LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLUNG2_LGNPW_NN NOT NULL,    -- 필수 입력
    TEL VARCHAR2(20)
);

-- 14-22 
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME               -- 테이블 이름
FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

-- 14-29 PRIMARY KEY 제약조건을 가진 테이블 생성
CREATE TABLE TABLE_PK(
    LOGIN_ID VARCHAR2(20) PRIMARY KEY,      -- NOT NULL + UNIQUE + 인덱스 자동 생성
    LOGIN_PWD VARCHAR2(20) NOT NULL,        -- 필수 입력
    TEL VARCHAR2(20)
);

DESC TABLE_PK;

-- 14-30 PRIMARY KEY 제약조건 정보 조회
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME               -- 테이블 이름
FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_PK%';

-- 14-32 명시적 이름의 PRIMARY KEY 제약조건
CREATE TABLE TABLE_PK2 (
    LOGIN_ID VARCHAR2(20) CONSTRAINT TBLPK2_LGNID_UNQ PRIMARY KEY,       -- 중복 불가, NULL은 허용
    LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLPK2_LGNPW_NN NOT NULL,    -- 필수 입력
    TEL VARCHAR2(20)
);

DESC TABLE_PK2;

-- 14-33 첫번째 데이터 입력
INSERT INTO TABLE_PK2(LOGIN_ID, LOGIN_PWD, TEL)
VALUES('TEST_ID_01', 'PWD01', '010-1234-5678');

SELECT * FROM TABLE_PK2;

-- 14-34 PRIMARY KEY 중복값 입력
INSERT INTO TABLE_PK2(LOGIN_ID, LOGIN_PWD, TEL)
VALUES('TEST_ID_01', 'PWD01', '010-1234-5678');             -- ORA-00001 무결성 제약조건

-- 14-35 PRIMARY KEY에 NULL을 입력
INSERT INTO TABLE_PK2(LOGIN_ID, LOGIN_PWD, TEL)     -- SQL 오류 : ORA-01400 PRIMARY KEY에 NULL값 입력 불가
VALUES(NULL, 'PWD01', '010-1234-5678');

-- 14-36 PRIMARY KEY 컬럼 생략 시도
INSERT INTO TABLE_PK(LOGIN_PWD, TEL)                 -- SQL 오류 : ORA-01400 PRIMARY KEY에 NULL값 입력 불가
VALUES('PWD01', '010-1234-5678');

-- 14-37 EMP, DEPT 테이블의 FOREIGN KEY 제약조건
-- 참조 관계 확인
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME,               -- 테이블 이름
            R_OWNER,                   -- 참조되는 테이블의 소유자
            R_CONSTRAINT_NAME   -- 참조되는 PRIMARY KEY 제약조건 이름
FROM USER_CONSTRAINTS
WHERE TABLE_NAME IN ('EMP', 'DEPT');

-- 14-38 FOREIGN KEY 위반 데이터 입력하기
-- 존재하지 않는 부서번호로 직원을 등록하면
-- ORA-02291 : 무결성 제약조건(SCOTT.FK_DEPTNO)이 위배되었습니다- 부모 키가 없습니다
INSERT INTO SCOTT.EMP
(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES(9999, '홍길동', 'CLERK', '7788', TO_DATE('2017/04/30', 'YYYY/MM/DD'), 1200, NULL, 50);

-- 14-39 FOREIGN KEY를 위한 부모 테이블 생성
-- 부서 정보를 저장할 부모 테이블 생성
CREATE TABLE DEPT_FK (
    DEPTNO NUMBER(2) CONSTRAINT DEPTFK_DEPTNO_PK PRIMARY KEY,       -- 부모 키
    DNAME VARCHAR2(14),         -- 
    LOC VARCHAR2(13)
);

DESC DEPT_FK;

-- 14-40 FOREIGN KEY를 가진 자식 테이블 생성
-- DEPT_FK 테이블을 참조하는 EMP_FK 테이블 생성
CREATE TABLE "EMP_FK"
   ("EMPNO" NUMBER(4,0) CONSTRAINT "EMPFK_EMPNO_PK" PRIMARY KEY,
	"ENAME" VARCHAR2(10), 
	"JOB" VARCHAR2(9), 
	"MGR" NUMBER(4,0), 
	"HIREDATE" DATE, 
	"SAL" NUMBER(7,2), 
	"COMM" NUMBER(7,2), 
	"DEPTNO" NUMBER(2,0) CONSTRAINT "EMPFK_DEPTNO_FK" REFERENCES DEPT_FK (DEPTNO)       -- 외래 키 생성
	 );

DESC EMP_FK;

-- 14-41 부모 테이블에 데이터가 없을 때 자식 테이블 데이터 입력
INSERT INTO EMP_FK
VALUES(9999, 'TEST_NAME', 'TEST_JOB', NULL, TO_DATE('2001/01/01', 'YYYY/MM/DD'), 3000, NULL, 30);
-- ORA-02291: 무결성 제약조건(SCOTT.EMPFK_DEPTNO_FK)이 위배되었습니다- 부모 키가 없습니다
-- EMP_FK 테이블(자식 테이블)에 새로운 직원 데이터를 입력하려고 시도
-- 입력하려는 데이터의 DEPTNO 값이 30
-- 하지만 부모 테이블(DEPT_FK 테이블)에 DEPTNO = 30인 부서가 존재하지 않음 (아직 데이터를 안 넣었음!)
-- "부모 키가 없습니다": 참조하려는 부모 테이블의 키 값(DEPTNO=30)이 존재하지 않음
-- 즉, 외부키로 쓰려면, 그 키의 부모 테이블의 키값이 먼저 있어야함!
-- 14-42 부모 테이블에 데이터 입력
-- 먼저 부모 테이블(DEPT_FK)에 부서 정보를 입력

INSERT INTO DEPT_FK
VALUES(10, 'TEST_DNAME', 'TEST_LOC');       -- 부모 테이블에 먼저 입력

SELECT * FROM DEPT_FK;

-- 14-43 부모 테이블에 존재하는 DEPTNO로 등록        -- 부모 키가 존재함
INSERT INTO EMP_FK
VALUES(9999, 'TEST_NAME', 'TEST_JOB', NULL, TO_DATE('2001/01/01', 'YYYY/MM/DD'), 3000, NULL, 10);

SELECT * FROM EMP_FK;

-- 14-44 참조되는 부모 데이터 삭제 시도
-- 자식 테이블에서 참조하고 있는 부모 데이터를 삭제하면?
-- ORA-02292: 무결성 제약조건(SCOTT.EMPFK_DEPTNO_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다
-- 자식 레코드가 존재하여 삭제 불가
DELETE FROM DEPT_FK
WHERE DEPTNO = 10;

-- CHECK
-- 14-45
CREATE TABLE TABLE_CHECK (
    LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK_LOGINID_PK PRIMARY KEY,
    LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLCK_LOGINPW_CK CHECK (LENGTH(LOGIN_PWD) > 3),  -- 조건식 
    TEL VARCHAR2(20)
    );
    
DESC TABLE_CHECK;

-- 14-46 CHECK 제약조건 위반 테스트
-- 3자리 이하의 비밀번호 입력하면 어떻게 되는지 확인
INSERT INTO TABLE_CHECK
VALUES ('TEST_ID', '123', '010-1234-5678');

-- 14-47 4자리 이상의 비밀번호로 데이터를 입력
INSERT INTO TABLE_CHECK
VALUES('TEST_ID', '1234', '010-1234-5678');

SELECT * FROM TABLE_CHECK;

-- 14-48 생성된 CHECK 제약조건 확인하기
SELECT OWNER,                       -- 제약조건 소유자
            CONSTRAINT_NAME,     -- 제약조건 이름
            CONSTRAINT_TYPE,       -- 제약조건 타입 (C: CHECK/NOT NULL)
            TABLE_NAME               -- 테이블 이름
FROM USER_CONSTRAINTS
WHERE TABLE_NAME LIKE 'TABLE_CHECK%';

-- 14-49 DEFAULT 값을 가진 테이블 생성
CREATE TABLE TABLE_DEFAULT (
    LOGIN_ID VARCHAR2(20) CONSTRAINT TBLDF_LOGINID_PK PRIMARY KEY,
    LOGIN_PWD VARCHAR2(20) DEFAULT '1234',  -- 기본값 설정
    TEL VARCHAR2(20)
 );

-- 14-50 DEFAULT 값 테스트
-- NULL을 명시적으로 입력한 경우
INSERT INTO TABLE_DEFAULT VALUES ('TEST_ID', NULL, '010-1234-5678');

-- 컬럼을 생략한 경우
INSERT INTO TABLE_DEFAULT(LOGIN_ID, TEL) VALUES ('TEST_ID2', '010-1234-5678');

SELECT * FROM TABLE_DEFAULT;










