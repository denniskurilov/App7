--DROP TABLE APP.EMPLOYEE;
--DROP SEQUENCE APP.SQ_EMPLOYEE;



CREATE TABLE APP.EMPLOYEE (
    ID              NUMBER NOT NULL,
    FIRST_NAME      VARCHAR2(30 CHAR),
    LAST_NAME       VARCHAR2(30 CHAR),
    AGE             NUMBER,
    IS_ACTIVE       NUMBER(1),
    EMAIL           VARCHAR2(50 CHAR)
);



CREATE UNIQUE INDEX APP.IDX_EMPLOYEE_ID ON APP.EMPLOYEE(ID);



ALTER TABLE APP.EMPLOYEE ADD (
    CONSTRAINT PK_EMPLOYEE
    PRIMARY KEY (ID)
    USING INDEX APP.IDX_EMPLOYEE_ID
);



CREATE SEQUENCE APP.SQ_EMPLOYEE
    START WITH 1
    MAXVALUE 999999999999999999
    NOCACHE;



CREATE OR REPLACE TRIGGER APP.TR_EMPLOYEE
BEFORE INSERT
ON APP.EMPLOYEE
REFERENCING NEW AS New
FOR EACH ROW
DECLARE
BEGIN
  SELECT SQ_EMPLOYEE.NEXTVAL INTO :NEW.ID FROM DUAL;
END;



INSERT INTO EMPLOYEE (
    FIRST_NAME,
    LAST_NAME,
    AGE,
    IS_ACTIVE,
    EMAIL
)
SELECT 'William', 'Smith',    38, 1, 'william.smith@gmail.com'     FROM dual UNION ALL
SELECT 'Jack',    'Jones',    23, 1, 'jack.jones@gmail.com'        FROM dual UNION ALL
SELECT 'George',  'Williams', 19, 1, 'george.williams@hotmail.com' FROM dual UNION ALL
SELECT 'Thomas',  'Brown',    65, 1, 'thomas.brown@gmail.com'      FROM dual UNION ALL
SELECT 'James',   'Taylor',   52, 1, 'james.taylor@gmail.com'      FROM dual UNION ALL
SELECT 'Michael', 'Johnson',  41, 0, 'michael.johnson@yahoo.com'   FROM dual UNION ALL
SELECT 'David',   'Miller',   29, 1, 'david.miller@gmail.com'      FROM dual UNION ALL
SELECT 'Robert',  'Davis',    47, 1, 'robert.davis@outlook.com'    FROM dual UNION ALL
SELECT 'Daniel',  'Wilson',   33, 0, 'daniel.wilson@gmail.com'     FROM dual UNION ALL
SELECT 'Andrew',  'Clark',    56, 1, 'andrew.clark@gmail.com'      FROM dual;
COMMIT;
