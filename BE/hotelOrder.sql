/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/30 13:49:40                           */
/*==============================================================*/


DROP TABLE IF EXISTS orders;

DROP TABLE IF EXISTS room;

DROP TABLE IF EXISTS staff;

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
CREATE TABLE orders
(
   orderID              INT NOT NULL AUTO_INCREMENT,
   guestID              VARCHAR(20) NOT NULL,
   NAME                 VARCHAR(20),
   phone                VARCHAR(13),
   roomID               VARCHAR(10) NOT NULL,
   roomtype             INT NOT NULL,
   ordertime            DATETIME,
   preintime            DATETIME,
   intime               DATETIME,
   preouttime           DATETIME,
   outtime              DATETIME,
   total                INT,
   price                INT,
   overtime             BOOL,
   orderState           INT NOT NULL,
   PRIMARY KEY (orderID)
);

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
CREATE TABLE room
(
   roomID               VARCHAR(10) NOT NULL,
   roomtype             INT NOT NULL,
   price                INT NOT NULL,
   numberofpeople       INT NOT NULL,
   FLOOR                INT NOT NULL,
   AREA                 VARCHAR(10) NOT NULL,
   includebrk           BOOL NOT NULL,
   STATUS               INT NOT NULL,
   PRIMARY KEY (roomID)
);

/*==============================================================*/
/* Table: staff                                                 */
/*==============================================================*/
CREATE TABLE staff
(
   staffID              VARCHAR(20) NOT NULL,
   NAME                 VARCHAR(20) NOT NULL,
   phone                VARCHAR(13) NOT NULL,
   PASSWORD             VARCHAR(20) NOT NULL,
   PRIMARY KEY (staffID)
);

ALTER TABLE orders ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (roomID)
      REFERENCES room (roomID) ON DELETE RESTRICT ON UPDATE RESTRICT;



INSERT INTO staff(staffID, NAME, phone, PASSWORD)
VALUES("admin", "aaa", "123", "admin"),("staff", "bbb", "321", "staff");

INSERT INTO room(roomID, roomtype, price, numberofpeople, FLOOR, AREA, includebrk, STATUS)
VALUES("101", 1, 80, 2, 1, 50, 1, 0),("102", 2, 50, 1, 1, 50, 1, 0);
