insert into person(id, firstName, lastName) values(1, 'John', 'Doe');
insert into person(id, firstName, lastName) values(2, 'Jane', 'Doe');

insert into passenger(id, firstName, dateOfBirth, lastName, ssn, frequantFlyerMiles, version) values(3, 'Nicolas', now(), 'Quartier', '123-456-789', 1000, 2);
insert into passenger(id, firstName, dateOfBirth, lastName, ssn, frequantFlyerMiles, version) values(4, 'Reinout', now(), 'Claeys', '987-654-321', 2000, 1);
insert into passenger(id, firstName, dateOfBirth, lastName, ssn, frequantFlyerMiles, version) values(5, 'Theo', now(), 'Test', '159-753-258', 2500, 1);
insert into passenger(id, firstName, dateOfBirth, lastName, ssn, frequantFlyerMiles, version) values(5, 'Fien', now(), 'Test', '159-753-258', 2500, 1);

insert into employee(lastName, ssn, firstName, frequantFlyerMiles) values('Quartier', '123-456-789', 'Nicolas', 1000);
insert into employee(lastName, ssn, firstName, frequantFlyerMiles) values('Claeys', '987-654-321', 'Nicolas', 1000);

insert into flight(id, number, departureTime, arrivelTime, airlineCompany, DTYPE) values(1, '123',  now(), now(), 'Quartier Airlines', 'DomesticFlight');
insert into flight(id, number, departureTime, arrivelTime, airlineCompany, DTYPE) values(3, '789',  now(), now(), 'Quartier Airlines', 'DomesticFlight');
insert into flight(id, number, departureTime, arrivelTime, airlineCompany, DTYPE) values(2,'456', now(), now(), 'Quartier Airlines', 'Flight');


