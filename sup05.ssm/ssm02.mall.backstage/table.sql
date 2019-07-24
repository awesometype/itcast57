-- product
drop table if exists product;
CREATE TABLE product
(
    id            varchar(64) PRIMARY KEY,
    productNum    VARCHAR(50) NOT NULL,
    productName   VARCHAR(50),
    cityName      VARCHAR(50),
    DepartureTime date,
    productPrice  FLOAT,
    productDesc   VARCHAR(500),
    productStatus INTEGER,
    CONSTRAINT product UNIQUE (id, productNum)
);
insert into product (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('676C5BD1D35E429A8C2E114939C5685A', 'itcast-002', '北京三日游', '北京',
        str_to_date('2018-10-10 10:10:00', '%Y-%m-%d %H:%i:%s'), 1200, '不错的旅行', 1);
insert into product (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('12B7ABF2A4C544568B0A7C69F36BF8B7', 'itcast-003', '上海五日游', '上海',
        str_to_date('2018-04-25 14:30:00', '%Y-%m-%d %H:%i:%s'), 1800, '魔都我来了', 0);
insert into product (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('9F71F01CB448476DAFB309AA6DF9497F', 'itcast-001', '北京三日游', '北京',
        str_to_date('2018-10-10 10:10:00', '%Y-%m-%d %H:%i:%s'), 1200, '不错的旅行', 1);


-- members 会员
CREATE TABLE member
(
    id       varchar(64) PRIMARY KEY,
    NAME     VARCHAR(40),
    nickname VARCHAR(40),
    phoneNum VARCHAR(40),
    email    VARCHAR(40)
);
insert into member (id, name, nickname, phonenum, email)
values ('E61D65F673D54F68B0861025C69773DB', '张三', '小三', '18888888888', 'zs@163.com');

-- traveller
CREATE TABLE traveller
(
    id              varchar(64) PRIMARY KEY,
    NAME            VARCHAR(40),
    sex             VARCHAR(40),
    phoneNum        VARCHAR(40),
    credentialsType INT,
    credentialsNum  VARCHAR(100),
    travellerType   INT
);
insert into traveller (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('3FE27DF2A4E44A6DBC5D0FE4651D3D3E', '张龙', '男', '13333333333', 0, '123456789009876543', 0);
insert into traveller (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('EE7A71FB6945483FBF91543DBE851960', '张小龙', '男', '15555555555', 0, '987654321123456789', 1);


-- orders
CREATE TABLE orders
(
    id          varchar(64) PRIMARY KEY,
    orderNum    VARCHAR(64) NOT NULL UNIQUE,
    orderTime   date,
    peopleCount INT,
    orderDesc   VARCHAR(500),
    payType     INT,
    orderStatus INT,
    productId   varchar(64),
    memberId    varchar(64),
    FOREIGN KEY (productId) REFERENCES product (id),
    FOREIGN KEY (memberId) REFERENCES member (id)
);
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '12345', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '54321', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('2FF351C4AC744E2092DCF08CFD314420', '67890', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '98765', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('E4DD4C45EED84870ABA83574A801083E', '11111', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', '22222', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55F9AF582D5A4DB28FB4EC3199385762', '33333', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', '44444', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into orders (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('3081770BC3984EF092D9E99760FDABDE', '55555', str_to_date('02-03-2018 12:00:00', '%d-%m-%Y %H:%i:%s'), 2, '没什么',
        0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');

-- oder_traveller
CREATE TABLE order_traveller
(
    orderId     varchar(64),
    travellerId varchar(64),
    PRIMARY KEY (orderId, travellerId),
    FOREIGN KEY (orderId) REFERENCES orders (id),
    FOREIGN KEY (travellerId) REFERENCES traveller (id)
);
insert into order_traveller (orderid, travellerid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into order_traveller (orderid, travellerid)
values ('2FF351C4AC744E2092DCF08CFD314420', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into order_traveller (orderid, travellerid)
values ('3081770BC3984EF092D9E99760FDABDE', 'EE7A71FB6945483FBF91543DBE851960');
insert into order_traveller (orderid, travellerid)
values ('55F9AF582D5A4DB28FB4EC3199385762', 'EE7A71FB6945483FBF91543DBE851960');
insert into order_traveller (orderid, travellerid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into order_traveller (orderid, travellerid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', 'EE7A71FB6945483FBF91543DBE851960');
insert into order_traveller (orderid, travellerid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into order_traveller (orderid, travellerid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', 'EE7A71FB6945483FBF91543DBE851960');
insert into order_traveller (orderid, travellerid)
values ('E4DD4C45EED84870ABA83574A801083E', 'EE7A71FB6945483FBF91543DBE851960');

-- users
CREATE TABLE users
(
    id       varchar(64) PRIMARY KEY,
    email    VARCHAR(64) UNIQUE NOT NULL,
    username VARCHAR(64),
    PASSWORD VARCHAR(64),
    phoneNum VARCHAR(64),
    STATUS   INT
);

-- role
CREATE TABLE role
(
    id       varchar(64) PRIMARY KEY,
    roleName VARCHAR(64),
    roleDesc VARCHAR(64)
);

-- user_role
CREATE TABLE users_role
(
    userId varchar(64),
    roleId varchar(64),
    PRIMARY KEY (userId, roleId),
    FOREIGN KEY (userId) REFERENCES users (id),
    FOREIGN KEY (roleId) REFERENCES role (id)
);

-- permission
CREATE TABLE permission
(
    id             varchar(64) PRIMARY KEY,
    permissionName VARCHAR(64),
    url            VARCHAR(64)
);

-- role_permission
CREATE TABLE role_permission
(
    permissionId varchar (64),
    roleId varchar (64),
    PRIMARY KEY (permissionId, roleId),
    FOREIGN KEY (permissionId) REFERENCES permission (id),
    FOREIGN KEY (roleId) REFERENCES role (id)
);