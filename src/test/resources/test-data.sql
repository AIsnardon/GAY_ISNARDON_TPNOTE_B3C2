insert INTO COMPTE_BANCAIRE values('FR7630001007941234567890185','Azerty', 'BOUSFRPP',1);
insert INTO COMPTE_BANCAIRE values('FR7630004000031234567890143','toto', 'BOUSFRPP',1);
insert INTO COMPTE_BANCAIRE values('FR7630006000011234567890189','toto', 'HSBCFRPP',0);

insert into CLIENT values(default);
insert into CLIENT values(default);

insert into PERSONNE_PHYSIQUE values (1,'cathy', 'cathou','1990-08-12');
insert into CLIENT  (nom) values (2,'toto cathou','123456789');

insert INTO ASSURANCE (dateSouscription,dateAnniversaire,datePrelevement) values ('2017-02-15','2017-02-10','2017-02-18');

insert INTO ASSURANCE_AUTO values (1,'AD-226-ZE','50');

insert INTO ASSURANCE (typeAssurance) values ('Auto');

INSERT INTO CLIENT_ASSURANCE(idClient, idAssurance)
      values ((SELECT idClient from PERSONNE_PHYSIQUE where nom='cathy' and prenom = 'cathou'),
              (SELECT idAssurance from ASSURANCE_AUTO where immatriculation='AD-226-ZE'));

INSERT INTO COMPTE_CLIENT (idClient, iban) VALUES ((SELECT idClient from PERSONNE_PHYSIQUE where nom='cathy' and prenom = 'cathou'),'FR7630001007941234567890185');