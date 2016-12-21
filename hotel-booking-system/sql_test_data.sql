insert into testdb.city(name) values('Bengaluru');
insert into testdb.city(name) values('Mysore');
insert into testdb.city(name) values('Dharwad');
insert into testdb.city(name) values('Ballari');
insert into testdb.city(name) values('Raichur');

insert into testdb.hotel(name,phone,address,cityid) values('Hotel1','9999999','address1',1);
insert into testdb.hotel(name,phone,address,cityid) values('Hotel2','9999999','address2',2);
insert into testdb.hotel(name,phone,address,cityid) values('Hotel3','9999999','address3',3);
insert into testdb.hotel(name,phone,address,cityid) values('Hotel4','9999999','address4',4);
insert into testdb.hotel(name,phone,address,cityid) values('Hotel5','9999999','address5',5);

insert into testdb.room(roomtype,bookingId, hotelId) values('AC',null,2);
insert into testdb.room(roomtype,bookingId, hotelId) values('Non-AC',null,2);
insert into testdb.room(roomtype,bookingId, hotelId) values('Non-AC',null,2);
insert into testdb.room(roomtype,bookingId, hotelId) values('Non-AC',null,2);
insert into testdb.room(roomtype,bookingId, hotelId) values('Non-AC',null,2);
select * from testdb.city;
select * from testdb.hotel;
select * from testdb.room;