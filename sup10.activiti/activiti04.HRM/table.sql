CREATE TABLE `co_company`
(
    `id`                   varchar(40)  NOT NULL COMMENT 'ID',
    `name`                 varchar(255) NOT NULL COMMENT '公司名称',
    `manager_id`           varchar(255) NOT NULL COMMENT '企业登录账号ID',
    `version`              varchar(255)          DEFAULT NULL COMMENT '当前版本',
    `renewal_date`         datetime              DEFAULT NULL COMMENT '续期时间',
    `expiration_date`      datetime              DEFAULT NULL COMMENT '到期时间',
    `company_area`         varchar(255)          DEFAULT NULL COMMENT '公司地区',
    `company_address`      text COMMENT '公司地址',
    `business_license_id`  varchar(255)          DEFAULT NULL COMMENT '营业执照-图片ID',
    `legal_representative` varchar(255)          DEFAULT NULL COMMENT '法人代表',
    `company_phone`        varchar(255)          DEFAULT NULL COMMENT '公司电话',
    `mailbox`              varchar(255)          DEFAULT NULL COMMENT '邮箱',
    `company_size`         varchar(255)          DEFAULT NULL COMMENT '公司规模',
    `industry`             varchar(255)          DEFAULT NULL COMMENT '所属行业',
    `remarks`              text COMMENT '备注',
    `audit_state`          varchar(255)          DEFAULT NULL COMMENT '审核状态',
    `state`                tinyint(2)   NOT NULL DEFAULT '1' COMMENT '状态',
    `balance`              double       NOT NULL COMMENT '当前余额',
    `create_time`          datetime     NOT NULL COMMENT '创建时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `co_department`
(
    `id`          varchar(40)  NOT NULL,
    `company_id`  varchar(255) NOT NULL COMMENT '企业ID',
    `parent_id`   varchar(255) DEFAULT NULL COMMENT '父级部门ID',
    `name`        varchar(255) NOT NULL COMMENT '部门名称',
    `code`        varchar(255) NOT NULL COMMENT '部门编码',
    `category`    varchar(255) DEFAULT NULL COMMENT '部门类别',
    `manager_id`  varchar(255) DEFAULT NULL COMMENT '负责人ID',
    `city`        varchar(255) DEFAULT NULL COMMENT '城市',
    `introduce`   text COMMENT '介绍',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `manager`     varchar(40)  DEFAULT NULL COMMENT '部门负责人',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `bs_user`
(
    `id`                 varchar(40)  NOT NULL COMMENT 'ID',
    `mobile`             varchar(40)  NOT NULL COMMENT '手机号码',
    `username`           varchar(255) NOT NULL COMMENT '用户名称',
    `password`           varchar(255) DEFAULT NULL COMMENT '密码',
    `enable_state`       int(2)       DEFAULT '1' COMMENT '启用状态 0是禁用，1是启用',
    `create_time`        datetime     DEFAULT NULL COMMENT '创建时间',
    `department_id`      varchar(40)  DEFAULT NULL COMMENT '部门ID',
    `time_of_entry`      datetime     DEFAULT NULL COMMENT '入职时间',
    `form_of_employment` int(1)       DEFAULT NULL COMMENT '聘用形式',
    `work_number`        varchar(20)  DEFAULT NULL COMMENT '工号',
    `form_of_management` varchar(8)   DEFAULT NULL COMMENT '管理形式',
    `working_city`       varchar(16)  DEFAULT NULL COMMENT '工作城市',
    `correction_time`    datetime     DEFAULT NULL COMMENT '转正时间',
    `in_service_status`  int(1)       DEFAULT NULL COMMENT '在职状态 1.在职 2.离职',
    `company_id`         varchar(40)  DEFAULT NULL COMMENT '企业ID',
    `company_name`       varchar(40)  DEFAULT NULL,
    `department_name`    varchar(40)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_user_phone` (`mobile`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

create table `bs_role`
(
    `id`                 varchar(40)  NOT NULL COMMENT 'ID',
    `name`               varchar(40)  NOT NULL COMMENT '角色名称',
    `description`        varchar(255) NOT NULL COMMENT '角色描述',
    `companyId`          varchar(40)  DEFAULT NULL COMMENT '企业id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;



