insert INTO COMPTE_BANCAIRE values('FR7630001007941234567890185','Azerty', 'BOUSFRPP',1,1);
insert INTO COMPTE_BANCAIRE values('FR7630004000031234567890143','toto', 'BOUSFRPP',1,2);
insert INTO COMPTE_BANCAIRE values('FR7630006000011234567890189','toto', 'HSBCFRPP',0,2);

insert into CLIENT values(1);
insert into CLIENT values(2);

insert into PERSONNE_PHYSIQUE values (1,'cathy', 'cathou','1990-08-12');
insert into PERSONNE_MORALE values (2,'toto cathou','123456789');

insert INTO ASSURANCE (dateSouscription,dateAnniversaire,datePrelevement) values ('2017-02-15','2017-02-10','2017-02-18');

insert INTO ASSURANCE_AUTO values (1,'AD-226-ZE','50');

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      values ((SELECT idClient from PERSONNE_PHYSIQUE where nom='cathy' and prenom = 'cathou'),
              (SELECT idAssurance from ASSURANCE_AUTO where immatriculation='AD-226-ZE'));
