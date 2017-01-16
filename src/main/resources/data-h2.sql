SET @TEASER = 'it amet, consectetur adipiscing elit. Vivamus quis blandit eros.';
SET @TEASER2 = 'Lorem adipiscing elit. Vivamus quis blandit eros.';

insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,0,52,CURRENT_TIMESTAMP,'3',@TEASER,'zop','ok');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,2,72,CURRENT_TIMESTAMP,'4',@TEASER2,'zop','sam');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,4,12,CURRENT_TIMESTAMP,'1',@TEASER,'podp','sam');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,5,29,CURRENT_TIMESTAMP,'3E',@TEASER,'costam','ok');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,17,33,CURRENT_TIMESTAMP,'5',@TEASER2,'wyrywanie zebow','ok');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,7,66,CURRENT_TIMESTAMP,'2E',@TEASER2,'zop','sam');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,8,04,CURRENT_TIMESTAMP,'1',@TEASER,'eutanazja','sam');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,3,102,CURRENT_TIMESTAMP,'3E',@TEASER2,'lobotomia','ok');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,11,7,CURRENT_TIMESTAMP,'1E',@TEASER,'costam','wspol');
--insert into Patients(id,evidential_Number,patient_Age,registered_Date,asa_Factor,treatment_Type,anesthesia_Technique,supervision_Type) values (null,6,17,CURRENT_TIMESTAMP,'2',@TEASER2,'rodzaj','ok');

insert into users(id,login,password,role) values (null,'admin','dupa2','1');
insert into users(id,login,password,role) values (null,'kaja','kajak','2');