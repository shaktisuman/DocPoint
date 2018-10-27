-- Run this script directly in the MySQL server query window.
-- It will automatically create the database and all the database objects.

-- If the database "DRBOOK" already exists, then delete it.
DROP DATABASE IF EXISTS DRBOOK;
-- Create the Database "DRBOOK"
CREATE DATABASE DRBOOK;

-- Set the currently active database to be "DRBOOK"
USE DRBOOK;

CREATE TABLE DRBOOK_ADMIN
(
  Admin_Id 			INT NOT NULL,
  CONSTRAINT pk_drbook_admin PRIMARY KEY (Admin_Id)
);

CREATE TABLE DOC
(
  Doc_Id 			INT NOT NULL AUTO_INCREMENT,
  Name 				VARCHAR(255) NOT NULL,
  Username			VARCHAR(255) UNIQUE,
  Password			VARCHAR(255),
  Specialty			VARCHAR(255),
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
  Patient_Id 		INT NOT NULL AUTO_INCREMENT,
  Name 				VARCHAR(255) NOT NULL,
  Username			VARCHAR(255) UNIQUE NOT NULL,
  Password			VARCHAR(255) NOT NULL,
  Secret_Q			VARCHAR(255) NOT NULL,
  Secret_A			VARCHAR(255) NOT NULL,
  Birthdate			VARCHAR(255) NOT NULL,
  Address			VARCHAR(255),
  City				VARCHAR(255),
  State				VARCHAR(255),
  Medical_Hist		VARCHAR(1000),
  Gender			VARCHAR(255) NOT NULL,
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

INSERT INTO DRBOOK_ADMIN VALUES ('1');

INSERT INTO DOC VALUES ('1', 'John Smith', 'johnsmith@email.com', 'Password01', 'Pediatrician', 'I am a doctor that specializes in treating children.');
INSERT INTO DOC VALUES ('2', 'Sarah Palmer', 'sarahpalmer@email.com', 'Password01',  'ENT', 'I am a doctor that specializes in ear, nose, throat.');

INSERT INTO SLOT VALUES ('1', '540', '600', '1');
INSERT INTO SLOT VALUES ('2', '600', '660', '1');
INSERT INTO SLOT VALUES ('3', '480', '540', '2');

INSERT INTO PATIENT VALUES ('1', 'Linh Truong', 'linh@email.com', 'Password01', 'Secret Q', 'Secret A', '11-11-1990', 'dummy address', 'city', 'state', 'med hist', 'gender');
INSERT INTO PATIENT VALUES ('2', 'Max Chen', 'max@email.com', 'Password01', 'Secret Q', 'Secret A', '11-11-1990', 'dummy address', 'city', 'state', 'med hist', 'gender');
INSERT INTO PATIENT VALUES ('3', 'Nancy Xie', 'nancyX@email.com', 'Password01', 'Secret Q', 'Secret A', '11-11-1990', 'dummy address', 'city', 'state', 'med hist', 'gender');

INSERT INTO APPT VALUES ('1', '2018-09-21', '1', '1', '1');
INSERT INTO APPT VALUES ('2', '2018-09-21', '2', '2', '1');
INSERT INTO APPT VALUES ('3', '2018-09-22', '1', '3', '1');
INSERT INTO APPT VALUES ('4', '2018-09-22', '3', '2', '2');
