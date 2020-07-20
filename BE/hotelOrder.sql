/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/20 14:53:37                           */
/*==============================================================*/

create database hotelOrder;

drop table if exists checkin_order;

drop table if exists checkout_order;

drop table if exists guest;

drop table if exists room;

drop table if exists room_type;

drop table if exists staff;

/*==============================================================*/
/* Table: checkin_order                                         */
/*==============================================================*/
create table checkin_order
(
   o_id                 int(10) not null,
   s_id                 varchar(20) not null,
   g_id                 varchar(20) not null,
   r_id                 varchar(8) not null,
   checkin_date         datetime not null,
   money                int not null,
   deposit              int,
   remarks              text,
   primary key (o_id)
);

alter table checkin_order comment '������';

/*==============================================================*/
/* Table: checkout_order                                        */
/*==============================================================*/
create table checkout_order
(
   id                   int(10) not null,
   s_id                 varchar(20) not null,
   g_id                 varchar(20) not null,
   r_id                 varchar(8) not null,
   checkout_date        datetime not null,
   returnmoney          int,
   remarks              text,
   primary key (id)
);

alter table checkout_order comment '�˷���';

/*==============================================================*/
/* Table: guest                                                 */
/*==============================================================*/
create table guest
(
   g_id                 varchar(20) not null,
   g_name               varchar(20) not null,
   g_gender             char(2) not null,
   birthday             date,
   card_number          varchar(20) not null,
   phone                char(11),
   remarks              text,
   primary key (g_id),
   check (g_gender IN ('��','Ů'))
);

alter table guest comment '�ͻ���Ϣ';

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
   r_id                 varchar(8) not null,
   t_id                 varchar(10) not null,
   state                char(4) not null,
   remarks              text,
   primary key (r_id)
);

alter table room comment '�ͷ���';

/*==============================================================*/
/* Table: room_type                                             */
/*==============================================================*/
create table room_type
(
   t_id                 varchar(10) not null,
   type                 char(6) not null,
   price                int not null default 160,
   total                int not null default 100,
   surplus              int not null default 100,
   capacity             int not null,
   remarks              text,
   primary key (t_id)
);

alter table room_type comment '���ͱ�';

/*==============================================================*/
/* Table: staff                                                 */
/*==============================================================*/
create table staff
(
   s_id                 varchar(20) not null,
   s_name               varchar(20) not null,
   s_gender             char(2) not null,
   phone                char(11),
   address              varchar(50),
   birthday             date,
   e_mail               varchar(20) not null,
   password             varchar(30) not null,
   remarks              text,
   primary key (s_id),
   check (s_gender IN ('��','Ů'))
);

alter table checkin_order add constraint FK_Reference_2 foreign key (s_id)
      references staff (s_id) on delete restrict on update restrict;

alter table checkin_order add constraint FK_Reference_3 foreign key (g_id)
      references guest (g_id) on delete restrict on update restrict;

alter table checkin_order add constraint FK_Reference_4 foreign key (r_id)
      references room (r_id) on delete restrict on update restrict;

alter table checkout_order add constraint FK_Reference_5 foreign key (s_id)
      references staff (s_id) on delete restrict on update restrict;

alter table checkout_order add constraint FK_Reference_6 foreign key (g_id)
      references guest (g_id) on delete restrict on update restrict;

alter table checkout_order add constraint FK_Reference_7 foreign key (r_id)
      references room (r_id) on delete restrict on update restrict;

alter table room add constraint FK_Reference_1 foreign key (t_id)
      references room_type (t_id) on delete restrict on update restrict;

INSERT INTO staff(s_id, s_name, s_gender, phone, address, birthday, e_mail, PASSWORD,remarks)
VALUES('0001', 'admin', '��', '10086', 'xxx', '2000-01-01', '@admin.com', 'admin', '���������¼Ա����Ϣ��ƥ��id������������ʶ���¼');


INSERT INTO staff(s_id, s_name, s_gender, phone, address, birthday, e_mail, PASSWORD,remarks)
VALUES('0001', 'admin', '��', '10086', 'xxx', '2000-01-01', '@admin.com', 'admin', '���������¼Ա����Ϣ��ƥ��id������������ʶ���¼');


INSERT INTO room_type(t_id, TYPE, price, capacity,remarks)
VALUES('000A','���˼�' ,120, 1, 'һ�ŵ��˴�'), ('000B', '˫�˼�', 140, 2, '���ŵ��˴�'),
 ('000C', '���˼�', 160, 3, '���ŵ��˴�'), ('000D', '�׼�', 200, 2, '���ҺͿ���'),
 ('000E', '������', 300, 2, 'xxx'),('000F', '�����', 200, 2, 'FFF');


INSERT INTO room(r_id, t_id, state)
VALUES('10001', '000A', '�ѳ���'),
('10002', '000B', 'δ����'),
('10003', '000C', 'δ����');

