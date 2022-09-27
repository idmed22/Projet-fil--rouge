/*Seed TABLE Users:*/
INSERT INTO public.users(id,nom,prenom,email,sexe,tel,user_name,password,ville,roles)
VALUES (1,'Mohamed','idlmhor','med@health.ma','Male','0600000000','medID','password','Agadir','DOCTOR'),
       (2,'Anas','Alpha','anas@health.ma','Male','0601000000','anasAl','password','Agadir','PHARMACIEN'),
       (3,'Ayoub','Beta','ayoub@health.ma','Male','0602000000','auoubBt','password','Agadir','CHEFLABO'),
       (4,'Patient-1','one','patient-1@health.ma','Male','0602000000','patientOne','password','Agadir','PATIENT'),

/*Seed TABLE Doctors:*/
INSERT INTO public.doctors(id,specialite)
VALUES(1,'Cardiologists'),
      (2,''),
      (3,'');


/*Seed TABLE ChefLabo:*/
INSERT INTO public.chef_laboratoire(id)
VALUES(1),
      (2);

/*Seed TABLE Pharmacien:*/
INSERT INTO public.pharmacien(id)
VALUES (1),
       (2);

/*Seed TABLE Patients:*/

INSERT INTO public.patients(id,cin,adresse,date_naissance,chef_laboratoire_id,doctors_id,pharmacien_id)
VALUES (1,'JK345','Agadir Center',2000-02-02,1,1,1),
       (2,'JK345','Agadir Center',2000-02-02,1,1,1),
       (3,'JK345','Agadir Center',2000-02-02,1,1,1),
       (4,'JK345','Agadir Center',2000-02-02,1,1,1);

/*Seed TABLE Rendez_vous:*/

INSERT INTO public.rendez_vous (id,date,heure,valider)
VALUES (1,2022-09-08,09:00,false),
       (2,2022-09-08,09:00,false),
       (3,2022-09-08,09:00,false);


/*Seed TABLE Ordonnance:*/

INSERT INTO public.ordonnance (id,date, heure,description,patients_id)
VALUES (1,2022-09-08,09:00,'first ordonnance',1);





     
