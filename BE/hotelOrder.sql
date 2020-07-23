/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/23 16:57:40                           */
/*==============================================================*/


drop table if exists Orders;

drop table if exists Room;

drop table if exists Staff;

/*==============================================================*/
/* Table: Orders                                                */
/*==============================================================*/
create table Orders
(
   orderID              int not null auto_increment,
   guestID              varchar(20) not null,
   name                 varchar(20),
   phone                varchar(13),
   roomID               varchar(10) not null,
   roomtype             varchar(10) not null,
   ordertime            date,
   preintime            date,
   intime               date,
   preouttime           date,
   outtime              date,
   total                varchar(13),
   price                int,
   overtime             char(5),
   orderState           int not null,
   primary key (orderID)
);

/*==============================================================*/
/* Table: Room                                                  */
/*==============================================================*/
create table Room
(
   roomID               varchar(10) not null,
   roomtype             int not null,
   price                int not null,
   numberofpeople       int not null,
   floor                int not null,
   area                 varchar(10) not null,
   includebrk           varchar(10) not null,
   status               int not null,
   primary key (roomID)
);

/*==============================================================*/
/* Table: Staff                                                 */
/*==============================================================*/
create table Staff
(
   staffID              varchar(20) not null,
   name                 varchar(20) not null,
   phone                varchar(13) not null,
   password             varchar(20) not null,
   primary key (staffID)
);

alter table Orders add constraint FK_Reference_1 foreign key (roomID)
      references Room (roomID) on delete restrict on update restrict;

