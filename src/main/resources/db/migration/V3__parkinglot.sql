create table parkinglot(
	parkingLotId varchar(255) primary key,
	capacity int not null,
	availablePositionCount int not null,
	parkingboyID int not null
);