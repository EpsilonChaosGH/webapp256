CREATE TABLE pers_group (
    id BIGINT NOT NULL PRIMARY KEY,
    groupName VARCHAR NOT NULL
);

CREATE TABLE pers_product (
    id BIGINT NOT NULL PRIMARY KEY,
    productName VARCHAR NOT NULL,
    group_id BIGINT NOT NULL REFERENCES pers_group (id)
);

CREATE SEQUENCE pers_product_seq;
CREATE SEQUENCE pers_group_seq;

