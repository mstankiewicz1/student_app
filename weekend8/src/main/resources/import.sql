insert into student_details (id, pesel, phone_no) values (1, '12332200987', '123123123');
insert into address (id, apart_no, city, street_name, street_no, zip_code) values (1, '222', 'Aleje Jerozolimskie', 'Warszawa', '52', '22-222');
insert into student (id, address_id, name, student_details_id, surname) values (1, 1, 'Janek', 1, 'Kowalski');

insert into student_details (id, pesel, phone_no) values (2, '22332200987', '888777666');
insert into address (id, apart_no, city, street_name, street_no, zip_code) values (2, '222', 'Aleje Jerozolimskie', 'Warszawa', '52', '22-222');
insert into student (id, address_id, name, student_details_id, surname) values (2, 2, 'Basia', 2, 'Nowak');




insert into course (id, name, date_from, date_to, price, capacity) values (1, 'Kurs Java', TO_DATE('10-03-2017', 'DD-MM-YYYY'), TO_DATE('08-07-2017', 'DD-MM-YYYY'), 5000.00, 10);
insert into course (id, name, date_from, date_to, price, capacity) values (2, 'Kurs CSS', TO_DATE('12-03-2017', 'DD-MM-YYYY'), TO_DATE('08-09-2017', 'DD-MM-YYYY'), 1000.00, 10);

insert into role(id, name) VALUES (1, 'ROLE_USER');
insert into role(id, name) VALUES (2, 'ROLE_ADMIN');

