 INSERT INTO roles(name) VALUES('ROLE_USER');
 INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
 INSERT INTO roles(name) VALUES('ROLE_ADMIN');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER1','niranjanthapa@gmail.com','Niranjan','Thapa','','$2a$10$d/4XH0CIbbUN0UtJhk7mT.jCFb/peVBIUgaQmg/G0Q2kkTQrBJUki','9810314784','using','niranjan','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER2','robinkarki@gmail.com','Rabindra','Karki','Jung','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9810314484','using','robin','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER3','ravikhadka@gmail.com','Ravi','Khadka','','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9810313784','using','ravi','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER4','prabeshkhati@gmail.com','Prabesh','Chettri','Khati','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9810313284','using','prabesh','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER5','abhisekhKhadka@gmail.com','ABhisekh','Khadka','','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9810214384','using','abhisekh','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER6','prashannathapa@gmail.com','prashanna','Thapa','','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9810224784','using','prashanna','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER7','nimasherpa@gmail.com','nima','sherpa','tsering','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9814314484','using','tseringnima','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER9','nabinshiwakoti@gmail.com','nabin','shiwakoti','Khati','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9814313284','using','nabin','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER11','nishanbade@gmail.com','nishan','bade','','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9814314784','using','nishan','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER13','rupashresthagmail.com','rupa','shrestha','','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9814313784','using','rupa','true','true');
insert into customer (user_id,email,first_name,last_name,middle_name,password,phone_number,status,username,enabled,locked)  values ('CUSTOMER15','sudikshyatwayana@gmail.com','sudikshya','twayana','','$2a$10$YfrGSaiDIaIcwWP78wsWiuTlwabcaO5BCPj.Iryf0m4XdidTTjaaK','9814214384','using','sudikshya','true','true');


insert into airline_company(airline_company_id,name,Address,email,phone_number,contract_date,contract_status) values('Company1','Buddha AirLines','kathmandu,Nepal','buddhaair@gmail.com','9850124567','2020-12-20','STAND');
insert into airline_company(airline_company_id,name,Address,email,phone_number,contract_date,contract_status) values('Company2','Nepal Airlines','kathmandu,Nepal','nepalairlines@gmail.com','9820154567','2020-12-20','STAND');
insert into airline_company(airline_company_id,name,Address,email,phone_number,contract_date,contract_status) values('Company3','Yeti AIrlines','kathmandu,Nepal','yetiairlines@gmail.com','9812125567','2020-12-20','STAND');
insert into airline_company(airline_company_id,name,Address,email,phone_number,contract_date,contract_status) values('Company4','Tara Air','kathmandu,Nepal','taraair@gmail.com','9810121557','2020-12-20','STAND');
insert into airline_company(airline_company_id,name,Address,email,phone_number,contract_date,contract_status) values('Company5','Shree Airlines','kathmandu,Nepal','shreeairlines@gmail.com','9810424568','2020-12-20','STAND');

insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC1','23 mins','Kathmandu','KTM-PKR','AVAILABLE','Pokhara');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC2','45 mins','Kathmandu','KTM-BTW','AVAILABLE','Butwal');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC3','40 mins','Kathmandu','KTM-BGJ','AVAILABLE','Birgunj');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC4','60 mins','Kathmandu','KTM-BHD','AVAILABLE','Bhadrapur');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC5','75 mins','Kathmandu','KTM-SKT','AVAILABLE','Surkhet');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC6','45 mins','Kathmandu','KTM-BRT','AVAILABLE','Biratnagar');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC7','23 mins','Pokhara','PKR-KTM','AVAILABLE','kathmandu');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC8','40 mins','Birgunj','BGJ-kTM','AVAILABLE','kathmandu');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC9','48 mins','Biratnagar','BRT-KTM','AVAILABLE','kathmandu');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC10','75 mins','Surkhet','SKT-KTM','AVAILABLE','kathmandu');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC11','45 mins','Butwal','BTW-KTM','AVAILABLE','kathmandu');
insert into sector(sector_id,duration,take_off_from,sector_code,status,landing_to) values('SEC12','60 mins','Bhadrapur','BHD-KTM','AVAILABLE','kathmandu');

insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt1','2022-3-26','10:30','UA247',89,'AVAILABLE','Company1','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt2','2022-3-26','9:30','UA248',89,'AVAILABLE','Company1','SEC2');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt3','2022-3-26','11:30','UA249',89,'AVAILABLE','Company1','SEC3');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt4','2022-3-26','11:00','UA250',89,'AVAILABLE','Company1','SEC4');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt5','2022-3-26','12:30','UA251',89,'AVAILABLE','Company1','SEC5');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt6','2022-3-26','13:00','UA252',89,'AVAILABLE','Company1','SEC6');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt7','2022-3-26','18:30','UA253',89,'AVAILABLE','Company1','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt8','2022-3-26','18:30','UA254',89,'AVAILABLE','Company1','SEC8');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt9','2022-3-26','18:30','UA255',89,'AVAILABLE','Company1','SEC9');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt10','2022-3-26','18:30','UA256',89,'AVAILABLE','Company1','SEC10');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt11','2022-3-26','18:30','UA257',89,'AVAILABLE','Company1','SEC11');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt12','2022-3-26','18:30','UA258',89,'AVAILABLE','Company1','SEC12');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt13','2022-3-26','10:00','UA259',89,'AVAILABLE','Company1','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt14','2022-3-26','07:00','UA260',89,'AVAILABLE','Company1','SEC2');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt15','2022-3-26','08:30','UA261',89,'AVAILABLE','Company1','SEC3');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt16','2022-3-26','09:00','UA262',89,'AVAILABLE','Company1','SEC4');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt17','2022-3-26','09:15','UA263',89,'AVAILABLE','Company1','SEC5');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt18','2022-3-26','09:45','UA264',89,'AVAILABLE','Company1','SEC6');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt19','2022-3-26','14:30','UA265',89,'AVAILABLE','Company1','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt20','2022-3-26','14:30','UA266',89,'AVAILABLE','Company1','SEC8');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt21','2022-3-26','14:30','UA267',89,'AVAILABLE','Company1','SEC9');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt22','2022-3-26','14:30','UA268',89,'AVAILABLE','Company1','SEC10');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt23','2022-3-26','14:30','UA269',89,'AVAILABLE','Company1','SEC11');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt24','2022-3-26','14:30','UA270',89,'AVAILABLE','Company1','SEC12');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt25','2022-3-26','07:30','UA271',89,'AVAILABLE','Company1','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt26','2022-3-26','08:30','UA272',89,'AVAILABLE','Company1','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt27','2022-3-26','14:30','UA273',89,'AVAILABLE','Company1','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt28','2022-3-26','18:30','UA274',89,'AVAILABLE','Company1','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt29','2022-3-26','17:30','UA275',89,'AVAILABLE','Company1','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt30','2022-3-26','16:30','UA276',89,'AVAILABLE','Company1','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt31','2022-3-26','15:30','UA278',89,'AVAILABLE','Company1','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt32','2022-3-26','16:30','UA279',89,'AVAILABLE','Company1','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt33','2022-3-26','17:30','UA280',89,'AVAILABLE','Company1','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt34','2022-3-26','19:30','UA281',89,'AVAILABLE','Company1','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt35','2022-3-26','11:30','UA282',89,'AVAILABLE','Company1','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt36','2022-3-26','12:30','UA283',89,'AVAILABLE','Company1','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt37','2022-3-26','14:30','UA321',89,'AVAILABLE','Company2','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt38','2022-3-26','14:30','UA322',89,'AVAILABLE','Company2','SEC2');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt39','2022-3-26','14:30','UA284',89,'AVAILABLE','Company2','SEC3');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt40','2022-3-26','14:30','UA285',89,'AVAILABLE','Company2','SEC4');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt41','2022-3-26','14:30','UA286',89,'AVAILABLE','Company2','SEC5');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt42','2022-3-26','14:30','UA287',89,'AVAILABLE','Company2','SEC6');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt43','2022-3-26','14:30','UA288',89,'AVAILABLE','Company2','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt44','2022-3-26','14:30','UA290',89,'AVAILABLE','Company2','SEC8');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt45','2022-3-26','14:30','UA292',89,'AVAILABLE','Company2','SEC9');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt46','2022-3-26','14:30','UA293',89,'AVAILABLE','Company2','SEC10');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt47','2022-3-26','14:30','UA294',89,'AVAILABLE','Company2','SEC11');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt48','2022-3-26','14:30','UA295',89,'AVAILABLE','Company2','SEC12');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt49','2022-3-26','14:30','UA296',89,'AVAILABLE','Company2','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt50','2022-3-26','14:30','UA297',89,'AVAILABLE','Company2','SEC2');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt51','2022-3-26','14:30','UA298',89,'AVAILABLE','Company2','SEC3');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt52','2022-3-26','14:30','UA299',89,'AVAILABLE','Company2','SEC4');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt53','2022-3-26','14:30','UA301',89,'AVAILABLE','Company2','SEC5');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt54','2022-3-26','14:30','UA302',89,'AVAILABLE','Company2','SEC6');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt55','2022-3-26','14:30','UA303',89,'AVAILABLE','Company2','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt56','2022-3-26','14:30','UA320',89,'AVAILABLE','Company2','SEC8');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt57','2022-3-26','14:30','UA304',89,'AVAILABLE','Company2','SEC9');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt58','2022-3-26','14:30','UA305',89,'AVAILABLE','Company2','SEC10');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt59','2022-3-26','14:30','UA306',89,'AVAILABLE','Company2','SEC11');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt60','2022-3-26','14:30','UA307',89,'AVAILABLE','Company2','SEC12');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt61','2022-3-26','14:30','UA308',89,'AVAILABLE','Company2','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt62','2022-3-26','14:30','UA309',89,'AVAILABLE','Company2','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt63','2022-3-26','14:30','UA310',89,'AVAILABLE','Company2','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt64','2022-3-26','14:30','UA311',89,'AVAILABLE','Company2','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt65','2022-3-26','14:30','UA312',89,'AVAILABLE','Company2','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt66','2022-3-26','14:30','UA313',89,'AVAILABLE','Company2','SEC1');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt67','2022-3-26','14:30','UA314',89,'AVAILABLE','Company2','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt68','2022-3-26','14:30','UA315',89,'AVAILABLE','Company2','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt69','2022-3-26','14:30','UA316',89,'AVAILABLE','Company2','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt70','2022-3-26','14:30','UA317',89,'AVAILABLE','Company2','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt71','2022-3-26','14:30','UA318',89,'AVAILABLE','Company2','SEC7');
insert into flight(id,departure_date,departure_time,flight_code,number_of_available_seats,status,company_id,sector_id) values('fgt72','2022-3-26','14:30','UA319',89,'AVAILABLE','Company2','SEC7');

insert into ticket(id,price,status,ticket_code) values(1,2000,'AVAILABLE','TKT1');
insert into ticket(id,price,status,ticket_code) values(2,2500,'AVAILABLE','TKT2');
insert into ticket(id,price,status,ticket_code) values(3,3000,'AVAILABLE','TKT3');
insert into ticket(id,price,status,ticket_code) values(4,3500,'AVAILABLE','TKT4');
insert into ticket(id,price,status,ticket_code) values(5,4000,'AVAILABLE','TKT5');
insert into ticket(id,price,status,ticket_code) values(6,4500,'AVAILABLE','TKT6');
insert into ticket(id,price,status,ticket_code) values(7,5000,'AVAILABLE','TKT7');
insert into ticket(id,price,status,ticket_code) values(8,5500,'AVAILABLE','TKT8');
insert into ticket(id,price,status,ticket_code) values(9,6000,'AVAILABLE','TKT9');
insert into ticket(id,price,status,ticket_code) values(10,6500,'AVAILABLE','TKT10');
insert into ticket(id,price,status,ticket_code) values(11,7000,'AVAILABLE','TKT11');
insert into ticket(id,price,status,ticket_code) values(12,8000,'AVAILABLE','TKT12');
insert into ticket(id,price,status,ticket_code) values(13,10000,'AVAILABLE','TKT13');
insert into ticket(id,price,status,ticket_code) values(14,12000,'AVAILABLE','TKT14');

insert into flight_ticket values('ft1','fgt1',1);
insert into flight_ticket values('ft2','fgt1',2);
insert into flight_ticket values('ft3','fgt1',3);
insert into flight_ticket values('ft4','fgt1',4);
insert into flight_ticket values('ft5','fgt7',1);
insert into flight_ticket values('ft6','fgt7',2);
insert into flight_ticket values('ft7','fgt7',3);
insert into flight_ticket values('ft8','fgt7',4);
insert into flight_ticket values('ft9','fgt37',1);
insert into flight_ticket values('ft10','fgt37',2);
insert into flight_ticket values('ft11','fgt37',3);
insert into flight_ticket values('ft12','fgt37',4);
insert into flight_ticket values('ft13','fgt43',1);
insert into flight_ticket values('ft14','fgt43',2);
insert into flight_ticket values('ft15','fgt43',3);
insert into flight_ticket values('ft16','fgt43',4);
insert into flight_ticket values('ft17','fgt25',1);
insert into flight_ticket values('ft18','fgt25',2);
insert into flight_ticket values('ft19','fgt25',3);
insert into flight_ticket values('ft20','fgt25',4);
insert into flight_ticket values('ft21','fgt26',1);
insert into flight_ticket values('ft22','fgt26',2);
insert into flight_ticket values('ft23','fgt26',3);
insert into flight_ticket values('ft24','fgt26',4);
insert into flight_ticket values('ft25','fgt27',1);
insert into flight_ticket values('ft26','fgt27',2);
insert into flight_ticket values('ft27','fgt27',3);
insert into flight_ticket values('ft28','fgt27',4);
insert into flight_ticket values('ft29','fgt28',1);
insert into flight_ticket values('ft30','fgt28',2);
insert into flight_ticket values('ft31','fgt28',3);
insert into flight_ticket values('ft32','fgt28',4);
insert into flight_ticket values('ft37','fgt29',1);
insert into flight_ticket values('ft38','fgt29',2);
insert into flight_ticket values('ft39','fgt29',3);
insert into flight_ticket values('ft40','fgt29',4);
insert into flight_ticket values('ft41','fgt30',1);
insert into flight_ticket values('ft42','fgt30',2);
insert into flight_ticket values('ft43','fgt30',3);
insert into flight_ticket values('ft44','fgt30',4);
insert into flight_ticket values('ft45','fgt31',1);
insert into flight_ticket values('ft46','fgt31',2);
insert into flight_ticket values('ft47','fgt31',3);
insert into flight_ticket values('ft48','fgt31',4);
insert into flight_ticket values('ft49','fgt32',1);
insert into flight_ticket values('ft50','fgt32',2);
insert into flight_ticket values('ft51','fgt32',3);
insert into flight_ticket values('ft52','fgt32',4);
insert into flight_ticket values('ft53','fgt33',1);
insert into flight_ticket values('ft54','fgt33',2);
insert into flight_ticket values('ft55','fgt33',3);
insert into flight_ticket values('ft56','fgt33',4);
insert into flight_ticket values('ft57','fgt34',1);
insert into flight_ticket values('ft58','fgt34',2);
insert into flight_ticket values('ft59','fgt34',3);
insert into flight_ticket values('ft60','fgt34',4);
insert into flight_ticket values('ft61','fgt35',1);
insert into flight_ticket values('ft62','fgt35',2);
insert into flight_ticket values('ft63','fgt35',3);
insert into flight_ticket values('ft64','fgt35',4);
insert into flight_ticket values('ft65','fgt36',1);
insert into flight_ticket values('ft66','fgt36',2);
insert into flight_ticket values('ft67','fgt36',3);
insert into flight_ticket values('ft68','fgt36',4);
insert into flight_ticket values('ft69','fgt61',2);
insert into flight_ticket values('ft70','fgt61',3);
insert into flight_ticket values('ft71','fgt61',4);
insert into flight_ticket values('ft72','fgt61',5);
insert into flight_ticket values('ft73','fgt62',5);
insert into flight_ticket values('ft74','fgt62',4);
insert into flight_ticket values('ft75','fgt62',3);
insert into flight_ticket values('ft76','fgt62',6);
insert into flight_ticket values('ft77','fgt63',4);
insert into flight_ticket values('ft78','fgt63',5);
insert into flight_ticket values('ft79','fgt63',6);
insert into flight_ticket values('ft80','fgt63',7);
insert into flight_ticket values('ft83','fgt64',1);
insert into flight_ticket values('ft84','fgt64',2);
insert into flight_ticket values('ft85','fgt64',3);
insert into flight_ticket values('ft86','fgt64',4);
insert into flight_ticket values('ft87','fgt65',1);
insert into flight_ticket values('ft88','fgt65',2);
insert into flight_ticket values('ft89','fgt65',3);
insert into flight_ticket values('ft90','fgt65',4);
insert into flight_ticket values('ft91','fgt66',1);
insert into flight_ticket values('ft92','fgt66',2);
insert into flight_ticket values('ft93','fgt66',3);
insert into flight_ticket values('ft94','fgt66',4);
insert into flight_ticket values('ft95','fgt67',1);
insert into flight_ticket values('ft96','fgt67',2);
insert into flight_ticket values('ft97','fgt67',3);
insert into flight_ticket values('ft98','fgt67',4);
insert into flight_ticket values('ft99','fgt68',1);
insert into flight_ticket values('ft100','fgt68',2);
insert into flight_ticket values('ft101','fgt68',3);
insert into flight_ticket values('ft102','fgt68',4);
insert into flight_ticket values('ft103','fgt69',1);
insert into flight_ticket values('ft104','fgt69',2);
insert into flight_ticket values('ft105','fgt69',3);
insert into flight_ticket values('ft106','fgt69',4);
insert into flight_ticket values('ft107','fgt70',1);
insert into flight_ticket values('ft108','fgt70',2);
insert into flight_ticket values('ft109','fgt70',3);
insert into flight_ticket values('ft110','fgt70',4);
insert into flight_ticket values('ft111','fgt71',1);
insert into flight_ticket values('ft112','fgt71',2);
insert into flight_ticket values('ft113','fgt71',3);
insert into flight_ticket values('ft114','fgt71',4);
insert into flight_ticket values('ft115','fgt72',1);
insert into flight_ticket values('ft116','fgt72',2);
insert into flight_ticket values('ft117','fgt72',3);
insert into flight_ticket values('ft118','fgt72',4);

insert into et_user_role values('CUSTOMER2',1);
insert into et_user_role values('CUSTOMER3',1);
insert into et_user_role values('CUSTOMER4',1);
insert into et_user_role values('CUSTOMER5',1);
insert into et_user_role values('CUSTOMER6',1);
insert into et_user_role values('CUSTOMER7',1);
insert into et_user_role values('CUSTOMER9',1);
