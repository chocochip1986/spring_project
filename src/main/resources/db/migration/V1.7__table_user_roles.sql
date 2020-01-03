CREATE SEQUENCE shop_owner."USER_ROLES_SEQ"
    START WITH 10000
    INCREMENT BY 1
    MINVALUE 10000
    MAXVALUE 1000000
    NOCYCLE
    CACHE 2
;

CREATE SEQUENCE shop_owner."ROLE_SEQ"
    START WITH 10000
    INCREMENT BY 1
    MINVALUE 10000
    MAXVALUE 1000000
    NOCYCLE
    CACHE 2
;

CREATE TABLE shop_owner."ROLE"
(
    "ID" NUMBER(19,0) NOT NULL,
    "ROLE_NAME" VARCHAR(255) NOT NULL,
    "CREATED_AT" TIMESTAMP(6) NOT NULL,
    "UPDATED_AT" TIMESTAMP(6) NOT NULL,
    "DELETED_AT" TIMESTAMP(6),
    PRIMARY KEY ("ID")
);

CREATE TABLE shop_owner."USER_ROLES"
(
    "ID" NUMBER(19,0) NOT NULL,
    "ROLE_ID" NUMBER(19,0) NOT NULL,
    "USER_ID" NUMBER(19,0) NOT NULL,
    "CREATED_AT" TIMESTAMP(6) NOT NULL,
    "UPDATED_AT" TIMESTAMP(6) NOT NULL,
    "DELETED_AT" TIMESTAMP(6),
    "EXPIRY_DATE" TIMESTAMP(6),
    PRIMARY KEY ("ID"),
    CONSTRAINT fk_role FOREIGN KEY ("ROLE_ID") REFERENCES "ROLE"("ID"),
    CONSTRAINT fk_user FOREIGN KEY ("USER_ID") REFERENCES "USER"("ID")
);

ALTER TABLE shop_owner."USER"
    ADD "DELETED_AT" TIMESTAMP(6);

