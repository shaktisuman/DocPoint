/*
 *    File name: create-docpoint-data-for-MySQL.sql
 *       Author: Max Chen
 *    Last Edit: 2018-09-21
 *  Description: This file is made for DocPoint Project
 */

-- Run this script directly in the MySQL server query window.
-- It will automatically create the database and all the database objects.

-- If the database "DOCPOINT" already exists, then delete it.
DROP DATABASE IF EXISTS DOCPOINT;
-- Create the Database "DOCPOINT"
CREATE DATABASE DOCPOINT;

-- Set the currently active database to be "DOCPOINT"
USE DOCPOINT;

CREATE TABLE DOCPOINT_ADMIN
(
  Admin_Id 			INT NOT NULL,
  CONSTRAINT pk_docpoint_admin PRIMARY KEY (Admin_Id)
);

CREATE TABLE DOC
(
  Doc_Id 			INT NOT NULL,
  Name 				VARCHAR(25) NOT NULL,
  UserName			VARCHAR(50) UNIQUE,
  PassWord			VARCHAR(50),
  Specialty			VARCHAR(50),
  Info				VARCHAR(1000),
  CONSTRAINT pk_doc PRIMARY KEY (Doc_Id)
);

CREATE TABLE SLOT
(
  Slot_Id			INT NOT NULL AUTO_INCREMENT,
  Start_T	 		INT NOT NULL,
  End_T	 			INT NOT NULL,
  Doc_Id 			INT NOT NULL,
  CONSTRAINT pk_slot PRIMARY KEY (Slot_Id),
  CONSTRAINT fk_slot_doc FOREIGN KEY (Doc_Id) REFERENCES Doc(Doc_Id)
);

CREATE TABLE PATIENT
(
  Patient_Id 		INT NOT NULL,
  Name 				VARCHAR(25) NOT NULL,
  UserName			VARCHAR(50) UNIQUE,
  PassWord			VARCHAR(50),
  Info				VARCHAR(1000),
  Secret_Q			VARCHAR(50),
  Secret_A			VARCHAR(50),
  CONSTRAINT pk_patient PRIMARY KEY (Patient_Id)
);

CREATE TABLE APPT
(
  Appt_Id			INT NOT NULL AUTO_INCREMENT,
  Appt_Date			DATE NOT NULL,
  Slot_Id 			INT NOT NULL,
  Patient_Id		INT NOT NULL,
  Doc_Id			INT NOT NULL,
  CONSTRAINT pk_appt PRIMARY KEY (Appt_Id),
  CONSTRAINT fk_appt_slot FOREIGN KEY (Slot_Id) REFERENCES Slot(Slot_Id),
  CONSTRAINT fk_appt_patient FOREIGN KEY (Patient_Id) REFERENCES Patient(Patient_Id),
  CONSTRAINT fk_appt_doc FOREIGN KEY (Doc_Id) REFERENCES Doc(Doc_Id)
);

INSERT INTO DOCPOINT_ADMIN VALUES ('1');

INSERT INTO DOC VALUES ('2', 'John Smith', 'johnsmith@email.com', 'password', 'Pediatrician', 'I am a doctor that specializes in treating children.');
INSERT INTO DOC VALUES ('3', 'Sarah Palmer', 'sarahpalmer@email.com', 'password',  'ENT', 'I am a doctor that specializes in ear, nose, throat.');

INSERT INTO SLOT VALUES ('1', '540', '600', '2');
INSERT INTO SLOT VALUES ('2', '600', '660', '2');
INSERT INTO SLOT VALUES ('3', '480', '540', '3');

INSERT INTO PATIENT VALUES ('4', 'Linh Truong', 'linh@emailcom', 'password',  'This is my info for Linh', 'Secret Q', 'Secret A');
INSERT INTO PATIENT VALUES ('5', 'Max Chen', 'max@email.com', 'password',  'This is my info for Max', 'Secret Q', 'Secret A');
INSERT INTO PATIENT VALUES ('6', 'Nancy Xie', 'nancyX@email.com', 'password',  'This is my info for Nancy', 'Secret Q', 'Secret A');

INSERT INTO APPT VALUES ('1', '2018-09-21', '1', '4', '2');
INSERT INTO APPT VALUES ('2', '2018-09-21', '2', '5', '2');
INSERT INTO APPT VALUES ('3', '2018-09-22', '1', '6', '2');
INSERT INTO APPT VALUES ('4', '2018-09-22', '3', '5', '3');
