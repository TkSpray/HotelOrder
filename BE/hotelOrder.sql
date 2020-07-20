/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/20 22:12:00                           */
/*==============================================================*/

CREATE DATABASE hotelordr;

DROP TABLE IF EXISTS guest;

DROP TABLE IF EXISTS room;

DROP TABLE IF EXISTS room_order;

DROP TABLE IF EXISTS room_type;

DROP TABLE IF EXISTS staff;

/*==============================================================*/
/* Table: guest                                                 */
/*==============================================================*/
CREATE TABLE guest
(
   g_id                 VARCHAR(20) NOT NULL,
   g_name               VARCHAR(20) NOT NULL,
   g_gender             CHAR(2) NOT NULL,
   phone                CHAR(11) NOT NULL,
   remarks              TEXT,
   PRIMARY KEY (g_id),
   CHECK (g_gender IN ('男','女'))
);

ALTER TABLE guest COMMENT '客户信息';

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
CREATE TABLE room
(
   r_id                 VARCHAR(8) NOT NULL,
   t_id                 CHAR(10) NOT NULL,
   FLOOR                INT NOT NULL,
   state                CHAR(4) NOT NULL,
   remarks              TEXT,
   PRIMARY KEY (r_id)
);

ALTER TABLE room COMMENT '客房表';

/*==============================================================*/
/* Table: room_order                                            */
/*==============================================================*/
CREATE TABLE room_order
(
   o_id                 INT(10) NOT NULL,
   g_id                 VARCHAR(20) NOT NULL,
   r_id                 VARCHAR(8) NOT NULL,
   p_intime             DATETIME,
   in_time              DATETIME,
   p_outtime            DATETIME,
   out_time             DATETIME,
   money                INT,
   deposit              INT,
   o_state              CHAR(20) NOT NULL,
   remarks              TEXT,
   PRIMARY KEY (o_id)
);

ALTER TABLE room_order COMMENT '订单表';

/*==============================================================*/
/* Table: room_type                                             */
/*==============================================================*/
CREATE TABLE room_type
(
   t_id                 CHAR(10) NOT NULL,
   TYPE                 CHAR(10) NOT NULL,
   price                INT NOT NULL DEFAULT 160,
   total                INT NOT NULL DEFAULT 100,
   surplus              INT NOT NULL DEFAULT 100,
   breakfast            CHAR(10) NOT NULL,
   c_people             INT NOT NULL,
   AREA                 CHAR(10) NOT NULL DEFAULT '50平米',
   remarks              TEXT,
   PRIMARY KEY (t_id)
);

ALTER TABLE room_type COMMENT '类型表';

/*==============================================================*/
/* Table: staff                                                 */
/*==============================================================*/
CREATE TABLE staff
(
   s_id                 VARCHAR(20) NOT NULL,
   s_name               VARCHAR(20) NOT NULL,
   s_gender             CHAR(2) NOT NULL,
   phone                CHAR(11),
   address              VARCHAR(50),
   e_mail               VARCHAR(20) NOT NULL,
   PASSWORD             VARCHAR(30) NOT NULL,
   remarks              TEXT,
   PRIMARY KEY (s_id),
   CHECK (s_gender IN ('男','女'))
);

ALTER TABLE room ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (t_id)
      REFERENCES room_type (t_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE room_order ADD CONSTRAINT FK_Reference_3 FOREIGN KEY (g_id)
      REFERENCES guest (g_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE room_order ADD CONSTRAINT FK_Reference_4 FOREIGN KEY (r_id)
      REFERENCES room (r_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

