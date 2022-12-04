DROP TABLE location IF EXISTS;

CREATE TABLE location(id bigint AUTO_INCREMENT  PRIMARY KEY, code VARCHAR(255) NOT NULL UNIQUE, name VARCHAR(255));

INSERT INTO location(code,name) VALUES('STORE_1','Supermarket Store 1');
INSERT INTO location(code,name) VALUES('FLOOR_1','Supermarket Floor 1');

DROP TABLE vendor IF EXISTS;

CREATE TABLE vendor(id bigint AUTO_INCREMENT  PRIMARY KEY, code VARCHAR(255) NOT NULL UNIQUE, name VARCHAR(255));

INSERT INTO vendor(code,name) VALUES('V1','Vendor 1');
INSERT INTO vendor(code,name) VALUES('V2','Vendor 2');

DROP TABLE item IF EXISTS;

CREATE TABLE item(id bigint AUTO_INCREMENT  PRIMARY KEY, name VARCHAR(255) NOT NULL UNIQUE,
vendor_id bigint NOT NULL, creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO item(name,vendor_id) VALUES('SKU1',1);
INSERT INTO item(name,vendor_id) VALUES('SKU2',1);

DROP TABLE stock_transaction IF EXISTS;

CREATE TABLE stock_transaction(id bigint AUTO_INCREMENT  PRIMARY KEY,
transaction_type VARCHAR(255) CHECK( transaction_type IN ('receipts','releases','returns') ),
source bigint NULL,
target bigint NULL,
vendor_transfer BOOLEAN DEFAULT false,
transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer) VALUES('returns',1,1,true);
INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer) VALUES('receipts',1,2,false);
INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer) VALUES('releases',2,1,false);

INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer) VALUES('returns',2,1,true);
INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer) VALUES('receipts',2,1,false);
INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer) VALUES('releases',1,2,false);

INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer,transaction_date) VALUES('returns',1,1,true,'2022-10-10');
INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer,transaction_date) VALUES('receipts',1,2,true,'2022-11-10');
INSERT INTO stock_transaction(transaction_type,source,target,vendor_transfer,transaction_date) VALUES('releases',2,1,false,'2022-11-10');


DROP TABLE transaction_detail IF EXISTS;

CREATE TABLE transaction_detail(id bigint AUTO_INCREMENT  PRIMARY KEY,
transaction_id bigint AUTO_INCREMENT,
item_id bigint,
quantity bigint);

INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(1,1,10);
INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(2,2,20);
INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(3,2,20);

INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(4,2,50);
INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(5,1,22);
INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(6,1,22);


INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(7,1,500);
INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(8,1,400);
INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(9,1,200);
INSERT INTO transaction_detail(transaction_id,item_id,quantity) VALUES(10,1,200);