/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/24 20:42:31                           */
/*==============================================================*/


drop table if exists orders;

drop table if exists room;

drop table if exists staff;

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
   orderID              int not null auto_increment,
   guestID              varchar(20) not null,
   name                 varchar(20),
   phone                varchar(13),
   roomID               varchar(10) not null,
   roomtype             int not null,
   ordertime            date,
   preintime            date,
   intime               date,
   preouttime           date,
   outtime              date,
   total                int,
   price                int,
   overtime             bool,
   orderState           int not null,
   primary key (orderID)
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
   roomID               varchar(10) not null,
   roomtype             int not null,
   price                int not null,
   numberofpeople       int not null,
   floor                int not null,
   area                 varchar(10) not null,
   includebrk           bool not null,
   status               int not null,
   primary key (roomID)
);

/*==============================================================*/
/* Table: staff                                                 */
/*==============================================================*/
create table staff
(
   staffID              varchar(20) not null,
   name                 varchar(20) not null,
   phone                varchar(13) not null,
   password             varchar(20) not null,
   primary key (staffID)
);

alter table orders add constraint FK_Reference_1 foreign key (roomID)
      references room (roomID) on delete restrict on update restrict;

INSERT staff(staffID, NAME, phone, PASSWORD)
VALUES('admin', 'aaa', 123, 'admin'),('staff', 'aaa', 321, 'staff');

INSERT room(roomID, roomtype, price, numberofpeople, FLOOR, AREA, includebrk, STATUS)
VALUES(101, 1, 100, 4, 1, 80, 1, 0),(102, 2, 120, 2, 1, 80, 1, 0);
