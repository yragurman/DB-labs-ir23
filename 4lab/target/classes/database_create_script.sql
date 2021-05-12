CREATE DATABASE IF NOT EXISTS gurman_db;
USE gurman_db ;


SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS parking_price;
DROP TABLE IF EXISTS parking_slot;
DROP TABLE IF EXISTS parking;
DROP TABLE IF EXISTS regular_customer;
DROP TABLE IF EXISTS coupon;
DROP TABLE IF EXISTS parking_slot_reservation;
SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE IF NOT EXISTS address(
	id INT NOT NULL AUTO_INCREMENT,
	country VARCHAR(45) NOT NULL,
	city VARCHAR(45) NOT NULL,
	adress_name VARCHAR(60) NOT NULL,
	post_index INT NULL,
PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS customer (
  id INT NOT NULL AUTO_INCREMENT,
  vehicle_number VARCHAR(20) NOT NULL,
  is_regular_customer CHAR(1) NOT NULL,
  contact_number VARCHAR(20) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS parking_price (
  id INT NOT NULL AUTO_INCREMENT,
  morning_price DECIMAL(20) NULL,
  midday_price DECIMAL(20) NULL,
  evening_price DECIMAL(20) NULL,
  all_day_price DECIMAL(20) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS parking_slot (
  id INT NOT NULL AUTO_INCREMENT,
  slot_number INT NOT NULL,
  is_invalid_place CHAR(1) NOT NULL,
  parking_price_id INT NOT NULL,
  is_reserved CHAR(1) NOT NULL,
  time_count_in_minutes INT NOT NULL,
  PRIMARY KEY (id)
 )
ENGINE = InnoDB;

CREATE INDEX fk_parking_slot_parking_price1_idx ON parking_slot(parking_price_id ASC);
ALTER TABLE parking_slot
	ADD CONSTRAINT fk_parking_slot_parking_price1
	FOREIGN KEY (parking_price_id)
	REFERENCES parking_price (id);

CREATE TABLE IF NOT EXISTS parking (
  id INT NOT NULL AUTO_INCREMENT,
  trade_network VARCHAR(45) NOT NULL,
  address_id INT NOT NULL,
  customer_id INT NOT NULL,
  parking_slot_id INT NOT NULL,
  PRIMARY KEY (id)
  )
ENGINE = InnoDB;

CREATE INDEX fk_parking_address1_idx ON parking(address_id ASC);
CREATE INDEX fk_parking_customer1_idx ON parking(customer_id ASC);
CREATE INDEX fk_parking_parking_slot1_idx ON parking(parking_slot_id ASC);
ALTER TABLE parking
	ADD CONSTRAINT fk_parking_address1
    FOREIGN KEY (address_id)
    REFERENCES address (id),
	ADD CONSTRAINT fk_parking_customer1
    FOREIGN KEY (customer_id)
    REFERENCES customer (id),
	ADD CONSTRAINT fk_parking_parking_slot1
    FOREIGN KEY (parking_slot_id)
    REFERENCES parking_slot (id);

CREATE TABLE IF NOT EXISTS regular_customer (
  id INT NOT NULL AUTO_INCREMENT,
  customer_id INT NOT NULL,
  purchase_date VARCHAR(45) NOT NULL,
  start_date VARCHAR(45) NOT NULL,
  duration_in_day INT NOT NULL,
  cost INT NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = InnoDB;

CREATE INDEX fk_regular_customer_customer1_idx ON regular_customer(customer_id ASC);
ALTER TABLE regular_customer
	ADD CONSTRAINT fk_regular_customer_customer1
    FOREIGN KEY (customer_id)
    REFERENCES customer (id);

CREATE TABLE IF NOT EXISTS coupon (
  id INT NOT NULL AUTO_INCREMENT,
  customer_id INT NOT NULL,
  entry_date VARCHAR(45) NOT NULL,
  exit_date VARCHAR(45) NOT NULL,
  parking_slot_id INT NOT NULL,
  PRIMARY KEY (id)
 )
ENGINE = InnoDB;

CREATE INDEX fk_coupon_customer1_idx ON coupon(customer_id ASC);
CREATE INDEX fk_coupon_parking_slot1_idx ON coupon(parking_slot_id ASC);
ALTER TABLE coupon
	ADD CONSTRAINT fk_coupon_customer1
    FOREIGN KEY (customer_id)
    REFERENCES customer (id),
	ADD CONSTRAINT fk_coupon_parking_slot1
    FOREIGN KEY (parking_slot_id)
    REFERENCES parking_slot (id);
    
CREATE TABLE IF NOT EXISTS parking_slot_reservation (
  id INT NOT NULL AUTO_INCREMENT,
  booking_date VARCHAR(45) NOT NULL,
  customer_id INT NOT NULL,
  parking_slot_id INT NOT NULL,
  is_paid CHAR(1) NOT NULL,
  entry_date VARCHAR(45) NOT NULL,
  exit_date VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
 )
ENGINE = InnoDB;

CREATE INDEX fk_parking_slot_reservation_customer1_idx ON parking_slot_reservation (customer_id ASC);
CREATE INDEX fk_parking_slot_reservation_parking_slot1_idx ON parking_slot_reservation(parking_slot_id ASC);
ALTER TABLE parking_slot_reservation
	ADD CONSTRAINT fk_parking_slot_reservation_customer1
    FOREIGN KEY (customer_id)
    REFERENCES customer (id),
	ADD CONSTRAINT fk_parking_slot_reservation_parking_slot1
    FOREIGN KEY (parking_slot_id)
    REFERENCES parking_slot (id);
 
    
    
INSERT INTO address (id, country, city, adress_name, post_index) VALUES
(1,'Ukraine','Kiev','Velyka Vasylkivska,53-55А','03150'),
(2,'Ukraine','Kiev','Повітрофлотський проспект, 80 А','03151'),
(3,'Ukraine','Kiev','Повітрофлотський проспект, 77','02000'),
(4,'Ukraine','Kiev','проспект Науки, 1','03039'),
(5,'Ukraine','Kiev','вул. Антоновича, 176','02000'),
(6,'Ukraine','Kiev','вул. Мельниченка, 1','03150'),
(7,'Ukraine','Odessa','вул.Решільєвська 55','65000'),
(8,'Ukraine','Odessa',' В. Арнаутська, 72/74','65000'),
(9,'UK','London','21 Bryanston St, Marylebone',NULL),
(10,'UK','London','26 Queensway, Bayswater',NULL);


INSERT INTO parking_price (id, morning_price, midday_price, evening_price, all_day_price) VALUES
(1,100,50,150,100),
(2,100,50,150,100),
(3,100,50,150,100),
(4,100,50,150,100),
(5,100,50,150,100),
(6,100,50,150,100),
(7,100,50,150,100),
(8,100,50,150,100),
(9,100,300,500,200),
(10,100,200,400,100);


INSERT INTO customer (id, vehicle_number, is_regular_customer, contact_number) VALUES
(1,'ВЕ8180BB','y','0671675429'),
(2,'ВB8481CH','y','0672671421'),
(3,'ВЕ8120BA','n','0675674426'),
(4,'ВЕ8170ME','y','0675671421'),
(5,'ВЕ8189EX','n','0672673421'),
(6,'ВЕ8181BB','y','0675673121'),
(7,'ВЕ8580BB','n','0679603421'),
(8,'ВH8180BB','y','0675613421'),
(9,'AA1160BA','y','0675673451'),
(10,'AЕ9140BB','n','0675677721');

INSERT INTO parking_slot (id, slot_number,is_invalid_place,parking_price_id,is_reserved,time_count_in_minutes) VALUES
(1,1,'y',1,'n',1440),
(2,2,'y',2,'n',1440),
(3,3,'y',3,'n',1440),
(4,4,'y',4,'n',1440),
(5,5,'n',5,'y',1440),
(6,6,'n',6,'y',1440),
(7,7,'n',7,'n',1440),
(8,8,'n',8,'n',1440),
(9,9,'n',9,'y',1440),
(10,10,'n',10,'n',1440);


INSERT INTO parking (id,trade_network,address_id,customer_id,parking_slot_id) VALUES
(1,'Паркинг Троицкий',1,1,1),
(2,'"СТАДИОН "ПОЛЕТ"',2,2,2),
(3,'АЭРОПОРТ КИЕВ',3,3,3),
(4,'Парковка Рошен',4,4,4),
(5,'Многоуровневый паркинг',5,5,5),
(6,'Автостоянка №18',6,6,6),
(7,'"Chorne More"',7,7,7),
(8,'72/74 Parking',8,8,8),
(9,'Car Park Oxford Street',9,9,9),
(10,'Q-Park Queensway',10,10,10);

INSERT INTO regular_customer (customer_id, purchase_date, start_date, duration_in_day, cost) VALUES
(1,'2020-03-22','2020-03-22',30,2000),
(2,'2020-03-22','2020-03-22',30,3000),
(3,'2020-03-22','2020-03-22',30,2400),
(4,'2020-03-22','2020-03-22',30,5000),
(5,'2020-03-22','2020-03-22',30,9000),
(6,'2020-08-07','2020-08-07',30,1200),
(7,'2020-03-22','2020-03-22',30,7200),
(8,'2020-05-02','2020-05-02',30,2000),
(9,'2020-12-02','2020-12-02',30,2000),
(10,'2020-06-12','2020-06-12',30,1999);


INSERT INTO coupon (customer_id,entry_date,exit_date,parking_slot_id) VALUES
(1,'2020-10-15 12:30:00','2020-10-16 09:00:00',1),
(2,'2020-12-12 12:30:00','2020-12-16 09:00:00',2),
(3,'2020-04-04 12:30:00','2020-04-05 09:00:00',3),
(4,'2020-11-15 12:30:00','2020-11-14 09:00:00',4),
(5,'2020-10-15 12:30:00','2020-10-16 09:00:00',5),
(6,'2020-10-15 12:30:00','2020-10-16 09:00:00',6),
(7,'2020-10-15 12:30:00','2020-10-16 09:00:00',7),
(8,'2020-10-17 12:30:00','2020-10-19 09:00:00',8),
(9,'2020-10-25 12:30:00','2020-11-10 09:00:00',9),
(10,'2020-10-10 12:30:00','2020-10-12 01:00:00',10);


INSERT INTO parking_slot_reservation (id,booking_date,customer_id,parking_slot_id,is_paid,entry_date,exit_date) VALUES
(1,'2020-07-11',1,1,'y','2020-07-11 12:00:00','2020-07-13 12:00:00'),
(2,'2020-06-02',2,2,'y','2020-06-02 12:00:00','2020-06-13 12:00:00'),
(3,'2020-07-11',3,3,'y','2020-07-11 12:00:00','2020-07-13 12:00:00'),
(4,'2020-08-24',4,4,'y','2020-08-25 12:00:00','2020-08-28 12:00:00'),
(5,'2020-07-11',5,5,'y','2020-07-11 12:00:00','2020-07-13 12:00:00'),
(6,'2020-07-11',6,6,'y','2020-07-11 12:00:00','2020-07-13 12:00:00'),
(7,'2020-07-11',7,7,'n','2020-07-11 12:00:00','2020-07-13 12:00:00'),
(8,'2020-07-11',8,8,'n','2020-07-11 12:00:00','2020-07-13 12:00:00'),
(9,'2020-07-11',9,9,'n','2020-07-11 12:00:00','2020-07-13 12:00:00'),
(10,'2020-07-11',10,10,'y','2020-07-11 12:00:00','2020-07-13 12:00:00');
