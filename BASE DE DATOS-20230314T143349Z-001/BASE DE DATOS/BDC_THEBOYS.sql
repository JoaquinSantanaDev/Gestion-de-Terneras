--------------------------------------------------------
-- Archivo creado  - martes-noviembre-29-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_FECHA_NTO
--------------------------------------------------------

   CREATE SEQUENCE  "BDC_THEBOYS"."SEQ_FECHA_NTO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ODS_FECHA_NTO
--------------------------------------------------------

   CREATE SEQUENCE  "BDC_THEBOYS"."SEQ_ODS_FECHA_NTO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ODS_PESO_AL_NACER
--------------------------------------------------------

   CREATE SEQUENCE  "BDC_THEBOYS"."SEQ_ODS_PESO_AL_NACER"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_PESO_AL_NACER
--------------------------------------------------------

   CREATE SEQUENCE  "BDC_THEBOYS"."SEQ_PESO_AL_NACER"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_RAZA
--------------------------------------------------------

   CREATE SEQUENCE  "BDC_THEBOYS"."SEQ_RAZA"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_TIPO_PARTO
--------------------------------------------------------

   CREATE SEQUENCE  "BDC_THEBOYS"."SEQ_TIPO_PARTO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table DT_FECHA_NTO
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."DT_FECHA_NTO" 
   (	"ID_FECHA" NUMBER, 
	"FECHA_NTO" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DT_PESO_AL_NACER
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."DT_PESO_AL_NACER" 
   (	"ID_PESO_AL_NACER" NUMBER, 
	"PESO_AL_NACER" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DT_RAZA
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."DT_RAZA" 
   (	"ID_RAZA" NUMBER, 
	"DSC_RAZA" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DT_TERNERAS
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."DT_TERNERAS" 
   (	"FECHA_NTO" NUMBER, 
	"PESO_AL_NACER" NUMBER, 
	"RAZA" NUMBER, 
	"TIPO_PARTO" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DT_TIPO_PARTO
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."DT_TIPO_PARTO" 
   (	"ID_TIP_PARTO" NUMBER, 
	"TIPO_PARTO" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table HT_TERNERAS
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."HT_TERNERAS" 
   (	"FECHA_NTO" NUMBER, 
	"PESO_AL_NACER" NUMBER, 
	"RAZA" NUMBER, 
	"TIPO_PARTO" NUMBER, 
	"CONTADOR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ODS_FECHA_NTO
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."ODS_FECHA_NTO" 
   (	"ID_FECHA" NUMBER, 
	"FECHA_NTO" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ODS_PESO_AL_NACER
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."ODS_PESO_AL_NACER" 
   (	"ID_PESO_AL_NACER" NUMBER, 
	"PESO_AL_NACER" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ODS_TERNERAS
--------------------------------------------------------

  CREATE TABLE "BDC_THEBOYS"."ODS_TERNERAS" 
   (	"FECHA_NTO" DATE, 
	"PESO_AL_NACER" NUMBER, 
	"RAZA" VARCHAR2(100 BYTE), 
	"TIPO_PARTO" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for View PARTO_POR_ESTACION
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BDC_THEBOYS"."PARTO_POR_ESTACION" ("CONTADOR", "RAZA", "ESTACION") AS 
  SELECT DISTINCT COUNT (H.CONTADOR) AS CONTADOR, A.DSC_RAZA AS RAZA, B.FECHA_NTO AS ESTACION
FROM HT_TERNERAS H
INNER JOIN DT_RAZA A
ON H.RAZA = A.ID_RAZA
INNER JOIN DT_FECHA_NTO B
ON H.FECHA_NTO = B.ID_FECHA
WHERE DSC_RAZA IS NOT NULL
GROUP BY A.DSC_RAZA, B.FECHA_NTO
ORDER BY CONTADOR DESC
;
--------------------------------------------------------
--  DDL for View V_PARTO_POR_ESTACION
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BDC_THEBOYS"."V_PARTO_POR_ESTACION" ("TIPODEPARTO") AS 
  SELECT H.TIPO_PARTO AS TIPODEPARTO
FROM HT_TERNERAS H
INNER JOIN ODS_FECHA_NTO F
ON H.FECHA_NTO = F.ID_FECHA
INNER JOIN ODS_TIPO_PARTO T
ON H.TIPO_PARTO = T.ID_TIP_PARTO
WHERE f.fecha_nto = 'INVIERNO'
;
--------------------------------------------------------
--  DDL for View V_TERNERAS
--------------------------------------------------------

  CREATE OR REPLACE FORCE NONEDITIONABLE VIEW "BDC_THEBOYS"."V_TERNERAS" ("ESTACION", "PARTO") AS 
  SELECT H.FECHA_NTO AS ESTACION,H.TIPO_PARTO AS PARTO 
FROM HT_TERNERAS H
INNER JOIN ODS_FECHA_NTO F
ON H.FECHA_NTO = F.ID_FECHA
INNER JOIN ODS_TIPO_PARTO T
ON H.TIPO_PARTO = T.ID_TIP_PARTO
WHERE H.RAZA=1
;
REM INSERTING into BDC_THEBOYS.DT_FECHA_NTO
SET DEFINE OFF;
Insert into BDC_THEBOYS.DT_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('1','OTO�O');
Insert into BDC_THEBOYS.DT_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('2','PRIMVERA');
Insert into BDC_THEBOYS.DT_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('3','INVIERNO');
Insert into BDC_THEBOYS.DT_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('4','VERANO');
REM INSERTING into BDC_THEBOYS.DT_PESO_AL_NACER
SET DEFINE OFF;
Insert into BDC_THEBOYS.DT_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('1','ALTO');
Insert into BDC_THEBOYS.DT_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('2','BAJO');
REM INSERTING into BDC_THEBOYS.DT_RAZA
SET DEFINE OFF;
Insert into BDC_THEBOYS.DT_RAZA (ID_RAZA,DSC_RAZA) values ('1','Hereforf');
Insert into BDC_THEBOYS.DT_RAZA (ID_RAZA,DSC_RAZA) values ('3','Shorthorn');
Insert into BDC_THEBOYS.DT_RAZA (ID_RAZA,DSC_RAZA) values ('4','Aberdeen Angus');
Insert into BDC_THEBOYS.DT_RAZA (ID_RAZA,DSC_RAZA) values ('6','Hereford');
REM INSERTING into BDC_THEBOYS.DT_TERNERAS
SET DEFINE OFF;
Insert into BDC_THEBOYS.DT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (null,null,null,null);
REM INSERTING into BDC_THEBOYS.DT_TIPO_PARTO
SET DEFINE OFF;
Insert into BDC_THEBOYS.DT_TIPO_PARTO (ID_TIP_PARTO,TIPO_PARTO) values ('1','Natural');
Insert into BDC_THEBOYS.DT_TIPO_PARTO (ID_TIP_PARTO,TIPO_PARTO) values ('2','Ces�rea');
REM INSERTING into BDC_THEBOYS.HT_TERNERAS
SET DEFINE OFF;
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('2','1','1','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','2','1','1','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','1','1','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','1','1','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','1','1','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','1','1','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','2','2','1','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','2','2','1','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','1','3','1','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','1','3','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('4','1','3','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('4','1','3','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('1','1','4','1','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('1','1','4','1','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('1','1','4','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','2','5','1','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('1','1','6','2','1');
Insert into BDC_THEBOYS.HT_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR) values ('3','1','6','2','1');
REM INSERTING into BDC_THEBOYS.ODS_FECHA_NTO
SET DEFINE OFF;
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('1','INVIERNO');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('2','INVIERNO');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('3','INVIERNO');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('4','OTO�O');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('5','INVIERNO');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('6','INVIERNO');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('7','VERANO');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('8','OTO�O');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('9','PRIMVERA');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('10',null);
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('11','OTO�O');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('12',null);
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('13','OTO�O');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('14','INVIERNO');
Insert into BDC_THEBOYS.ODS_FECHA_NTO (ID_FECHA,FECHA_NTO) values ('15','INVIERNO');
REM INSERTING into BDC_THEBOYS.ODS_PESO_AL_NACER
SET DEFINE OFF;
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('1','BAJO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('2','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('3','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('4','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('5','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('6','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('7','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('8','BAJO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('9','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('10','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('11','BAJO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('12','ALTO');
Insert into BDC_THEBOYS.ODS_PESO_AL_NACER (ID_PESO_AL_NACER,PESO_AL_NACER) values ('13','ALTO');
REM INSERTING into BDC_THEBOYS.ODS_TERNERAS
SET DEFINE OFF;
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (null,null,null,null);
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('12/11/21','DD/MM/RR'),'22','4','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('11/11/21','DD/MM/RR'),'45','Hereforf','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('18/11/21','DD/MM/RR'),'6',' ','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('10/11/21','DD/MM/RR'),'45','Hereford','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('11/11/21','DD/MM/RR'),'50','Hereforf','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('10/11/21','DD/MM/RR'),'450','Hereforf','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('11/11/21','DD/MM/RR'),'45','Hereforf','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('10/11/21','DD/MM/RR'),'2','Hereforf','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('25/09/21','DD/MM/RR'),'444','Shorthorn','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('03/10/21','DD/MM/RR'),'56','Shorthorn','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('13/11/21','DD/MM/RR'),'2',' ','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('15/08/21','DD/MM/RR'),'50','Hereford','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('22/01/21','DD/MM/RR'),'45','Hereford','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('11/08/21','DD/MM/RR'),'55','Aberdeen Angus','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('06/07/21','DD/MM/RR'),'52','Aberdeen Angus','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('01/09/21','DD/MM/RR'),'49','Aberdeen Angus','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('01/02/21','DD/MM/RR'),'57','Shorthorn','Natural');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('03/03/21','DD/MM/RR'),'52','Shorthorn','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('03/03/21','DD/MM/RR'),'52','Shorthorn','Ces�rea');
Insert into BDC_THEBOYS.ODS_TERNERAS (FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO) values (to_date('25/11/21','DD/MM/RR'),'70','Hereforf','Ces�rea');
--------------------------------------------------------
--  DDL for Index DT_FECHA_NTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BDC_THEBOYS"."DT_FECHA_NTO_PK" ON "BDC_THEBOYS"."DT_FECHA_NTO" ("ID_FECHA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index DT_PESO_AL_NACER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BDC_THEBOYS"."DT_PESO_AL_NACER_PK" ON "BDC_THEBOYS"."DT_PESO_AL_NACER" ("ID_PESO_AL_NACER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index DT_RAZA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BDC_THEBOYS"."DT_RAZA_PK" ON "BDC_THEBOYS"."DT_RAZA" ("ID_RAZA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index DT_TIPO_PARTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BDC_THEBOYS"."DT_TIPO_PARTO_PK" ON "BDC_THEBOYS"."DT_TIPO_PARTO" ("ID_TIP_PARTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger T_FECHA_NTO_SEQ
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BDC_THEBOYS"."T_FECHA_NTO_SEQ" 
BEFORE INSERT
ON "DT_FECHA_NTO"
FOR EACH ROW
BEGIN 
    SELECT SEQ_FECHA_NTO.NEXTVAL
    INTO :NEW.ID_FECHA
    FROM DUAL;
END T_FECHA_NTO_SEQ;
/
ALTER TRIGGER "BDC_THEBOYS"."T_FECHA_NTO_SEQ" ENABLE;
--------------------------------------------------------
--  DDL for Trigger T_ODS_FECHA_NTO_SEQ
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BDC_THEBOYS"."T_ODS_FECHA_NTO_SEQ" 
BEFORE INSERT
ON "ODS_FECHA_NTO"
FOR EACH ROW
BEGIN 
    SELECT SEQ_ODS_FECHA_NTO.NEXTVAL
    INTO :NEW.ID_FECHA
    FROM DUAL;
END T_ODS_FECHA_NTO_SEQ;
/
ALTER TRIGGER "BDC_THEBOYS"."T_ODS_FECHA_NTO_SEQ" ENABLE;
--------------------------------------------------------
--  DDL for Trigger T_ODS_PESO_AL_NACER_SEQ
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BDC_THEBOYS"."T_ODS_PESO_AL_NACER_SEQ" 
BEFORE INSERT
ON "ODS_PESO_AL_NACER"
FOR EACH ROW
BEGIN 
    SELECT SEQ_ODS_PESO_AL_NACER.NEXTVAL
    INTO :NEW.ID_PESO_AL_NACER
    FROM DUAL;
END T_ODS_PESO_AL_NACER_SEQ;
/
ALTER TRIGGER "BDC_THEBOYS"."T_ODS_PESO_AL_NACER_SEQ" ENABLE;
--------------------------------------------------------
--  DDL for Trigger T_PESO_AL_NACER_SEQ
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BDC_THEBOYS"."T_PESO_AL_NACER_SEQ" 
BEFORE INSERT
ON "DT_PESO_AL_NACER"
FOR EACH ROW
BEGIN 
    SELECT SEQ_PESO_AL_NACER.NEXTVAL
    INTO :NEW.ID_PESO_AL_NACER
    FROM DUAL;
END T_PESO_AL_NACER_SEQ;
/
ALTER TRIGGER "BDC_THEBOYS"."T_PESO_AL_NACER_SEQ" ENABLE;
--------------------------------------------------------
--  DDL for Trigger T_RAZA_SEQ
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BDC_THEBOYS"."T_RAZA_SEQ" 
BEFORE INSERT
ON "DT_RAZA"
FOR EACH ROW
BEGIN 
    SELECT SEQ_RAZA.NEXTVAL
    INTO :NEW.ID_RAZA
    FROM DUAL;
END T_RAZA_SEQ;
/
ALTER TRIGGER "BDC_THEBOYS"."T_RAZA_SEQ" ENABLE;
--------------------------------------------------------
--  DDL for Trigger T_TERNERAS_SEQ
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "BDC_THEBOYS"."T_TERNERAS_SEQ" 
BEFORE INSERT
ON "DT_TIPO_PARTO" 
FOR EACH ROW
BEGIN 
    SELECT SEQ_TIPO_PARTO.NEXTVAL
    INTO :NEW.ID_TIP_PARTO
    FROM DUAL;
END T_TERNERAS_SEQ;
/
ALTER TRIGGER "BDC_THEBOYS"."T_TERNERAS_SEQ" ENABLE;
--------------------------------------------------------
--  DDL for Procedure P_DWH_DT_FECHA_NTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BDC_THEBOYS"."P_DWH_DT_FECHA_NTO" 
IS 
BEGIN
MERGE INTO DT_FECHA_NTO a
USING
(SELECT DISTINCT FECHA_NTO FROM ODS_TERNERAS WHERE FECHA_NTO IS NOT NULL) b 
ON 
(a.FECHA_NTO = b.FECHA_NTO)
WHEN NOT MATCHED THEN INSERT (FECHA_NTO)
VALUES 
(F_ESTACIONES(b.FECHA_NTO)) 
;
COMMIT;
END P_DWH_DT_FECHA_NTO;

/
--------------------------------------------------------
--  DDL for Procedure P_DWH_DT_PESO_AL_NACER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BDC_THEBOYS"."P_DWH_DT_PESO_AL_NACER" 
IS 
BEGIN
MERGE INTO DT_PESO_AL_NACER a
USING
(SELECT DISTINCT PESO_AL_NACER FROM ODS_TERNERAS WHERE PESO_AL_NACER IS NOT NULL) b 
ON 
(a.PESO_AL_NACER = b.PESO_AL_NACER)
WHEN NOT MATCHED THEN INSERT (PESO_AL_NACER)
VALUES 
(F_RANGO_PESO(b.PESO_AL_NACER)) 
;
COMMIT;
END P_DWH_DT_PESO_AL_NACER;

/
--------------------------------------------------------
--  DDL for Procedure P_DWH_ODS_FECHA_NTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BDC_THEBOYS"."P_DWH_ODS_FECHA_NTO" 
IS 
BEGIN
MERGE INTO DT_FECHA_NTO a
USING
(SELECT DISTINCT FECHA_NTO FROM ODS_FECHA_NTO WHERE FECHA_NTO IS NOT NULL) b 
ON 
(a.FECHA_NTO = b.FECHA_NTO)
WHEN NOT MATCHED THEN INSERT (FECHA_NTO)
VALUES 
(b.FECHA_NTO) 
;
COMMIT;
END P_DWH_ODS_FECHA_NTO;

/
--------------------------------------------------------
--  DDL for Procedure P_DWH_ODS_PESO_AL_NACER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BDC_THEBOYS"."P_DWH_ODS_PESO_AL_NACER" 
IS 
BEGIN
MERGE INTO DT_PESO_AL_NACER a
USING
(SELECT DISTINCT PESO_AL_NACER FROM ODS_PESO_AL_NACER WHERE PESO_AL_NACER IS NOT NULL) b 
ON 
(a.PESO_AL_NACER = b.PESO_AL_NACER)
WHEN NOT MATCHED THEN INSERT (PESO_AL_NACER)
VALUES 
(b.PESO_AL_NACER) 
;
COMMIT;
END P_DWH_ODS_PESO_AL_NACER;

/
--------------------------------------------------------
--  DDL for Procedure P_DWH_ODS_RAZA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BDC_THEBOYS"."P_DWH_ODS_RAZA" 
IS 
BEGIN
MERGE INTO DT_RAZA a
USING
(SELECT DISTINCT RAZA FROM ODS_TERNERAS WHERE RAZA IS NOT NULL ) b 
ON 
(a.DSC_RAZA = b.RAZA)
WHEN NOT MATCHED THEN INSERT (DSC_RAZA)
VALUES 
(b.RAZA) 
;
COMMIT;
END P_DWH_ODS_RAZA;

/
--------------------------------------------------------
--  DDL for Procedure P_DWH_ODS_TIPO_PARTO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BDC_THEBOYS"."P_DWH_ODS_TIPO_PARTO" 
IS 
BEGIN
MERGE INTO DT_TIPO_PARTO a
USING
(SELECT DISTINCT TIPO_PARTO FROM ODS_TERNERAS WHERE TIPO_PARTO IS NOT NULL) b 
ON 
(a.TIPO_PARTO = b.TIPO_PARTO)
WHEN NOT MATCHED THEN INSERT (TIPO_PARTO)
VALUES 
(b.TIPO_PARTO) 
;
COMMIT;
END P_DWH_ODS_TIPO_PARTO;

/
--------------------------------------------------------
--  DDL for Procedure P_HT_TERNERAS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "BDC_THEBOYS"."P_HT_TERNERAS" 
IS 
BEGIN
DELETE FROM HT_TERNERAS;
INSERT INTO HT_TERNERAS
(FECHA_NTO,PESO_AL_NACER,RAZA,TIPO_PARTO,CONTADOR)
SELECT 
AA.ID_FECHA,
BB.ID_PESO_AL_NACER,
CC.ID_RAZA,
DD.ID_TIP_PARTO,
1 CONTADOR
FROM ODS_TERNERAS T
LEFT OUTER JOIN DT_FECHA_NTO AA
ON AA.FECHA_NTO = F_ESTACIONES(T.FECHA_NTO)
LEFT OUTER JOIN DT_PESO_AL_NACER BB
ON BB.PESO_AL_NACER = F_RANGO_PESO(T.PESO_AL_NACER)
LEFT OUTER JOIN DT_RAZA CC
ON CC.DSC_RAZA = T.RAZA
LEFT OUTER JOIN Dt_TIPO_PARTO DD
ON DD.TIPO_PARTO = T.TIPO_PARTO
;
END P_HT_TERNERAS;

/
--------------------------------------------------------
--  DDL for Function F_ESTACIONES
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BDC_THEBOYS"."F_ESTACIONES" (FECHA DATE)
RETURN VARCHAR
IS 
BEGIN
RETURN
(
CASE
    WHEN TO_CHAR(FECHA,'MM') >='03' AND TO_CHAR(FECHA,'MM') <='06' THEN
        CASE
            WHEN TO_CHAR(FECHA,'DD')>'22'
                THEN 'OTO�O'   
                ELSE 'VERANO'
        END   
    WHEN TO_CHAR(FECHA,'MM') >='06' AND TO_CHAR(FECHA,'MM') <='09' THEN
        CASE
            WHEN TO_CHAR(FECHA,'DD')>'22'
                THEN 'INVIERNO'    
                ELSE 'OTO�O'
        END        
    WHEN TO_CHAR(FECHA,'MM') >='09' AND TO_CHAR(FECHA,'MM') <='12' THEN
        CASE
            WHEN TO_CHAR(FECHA,'DD')>'22'
                THEN 'PRIMVERA'
                ELSE 'INVIERNO'
        END        
    WHEN TO_CHAR(FECHA,'MM') >='12' AND TO_CHAR(FECHA,'MM') <='06' THEN
        CASE
            WHEN TO_CHAR(FECHA,'DD')>'22'
                THEN 'VERANO'   
                ELSE 'PRIMAVERA'
        END    
END
);
END F_ESTACIONES;

/
--------------------------------------------------------
--  DDL for Function F_RANGO_PESO
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE FUNCTION "BDC_THEBOYS"."F_RANGO_PESO" (PESO NUMBER)
RETURN VARCHAR
IS 
BEGIN 
RETURN
(
CASE
WHEN PESO<30 
    THEN 'BAJO'
WHEN PESO>30 and PESO<32
    THEN 'PROMEDIO'
WHEN PESO>32 
    THEN 'ALTO'  
END
);
END F_RANGO_PESO;

/
--------------------------------------------------------
--  Constraints for Table DT_PESO_AL_NACER
--------------------------------------------------------

  ALTER TABLE "BDC_THEBOYS"."DT_PESO_AL_NACER" MODIFY ("ID_PESO_AL_NACER" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."DT_PESO_AL_NACER" MODIFY ("PESO_AL_NACER" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."DT_PESO_AL_NACER" ADD CONSTRAINT "DT_PESO_AL_NACER_PK" PRIMARY KEY ("ID_PESO_AL_NACER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ODS_PESO_AL_NACER
--------------------------------------------------------

  ALTER TABLE "BDC_THEBOYS"."ODS_PESO_AL_NACER" MODIFY ("ID_PESO_AL_NACER" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."ODS_PESO_AL_NACER" MODIFY ("PESO_AL_NACER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DT_FECHA_NTO
--------------------------------------------------------

  ALTER TABLE "BDC_THEBOYS"."DT_FECHA_NTO" MODIFY ("ID_FECHA" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."DT_FECHA_NTO" MODIFY ("FECHA_NTO" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."DT_FECHA_NTO" ADD CONSTRAINT "DT_FECHA_NTO_PK" PRIMARY KEY ("ID_FECHA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DT_TIPO_PARTO
--------------------------------------------------------

  ALTER TABLE "BDC_THEBOYS"."DT_TIPO_PARTO" MODIFY ("ID_TIP_PARTO" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."DT_TIPO_PARTO" MODIFY ("TIPO_PARTO" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."DT_TIPO_PARTO" ADD CONSTRAINT "DT_TIPO_PARTO_PK" PRIMARY KEY ("ID_TIP_PARTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DT_RAZA
--------------------------------------------------------

  ALTER TABLE "BDC_THEBOYS"."DT_RAZA" MODIFY ("ID_RAZA" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."DT_RAZA" MODIFY ("DSC_RAZA" NOT NULL ENABLE);
  ALTER TABLE "BDC_THEBOYS"."DT_RAZA" ADD CONSTRAINT "DT_RAZA_PK" PRIMARY KEY ("ID_RAZA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
