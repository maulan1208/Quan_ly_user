DROP DATABASE IF EXISTS Final_examRo37;
CREATE DATABASE Final_examRo37;
use Final_examRo37;

DROP TABLE IF EXISTS `Group`;
create table `Group` (
	id INT PRIMARY KEY AUTO_INCREMENT ,
	group_name VARCHAR(50) NOT NULL,
	`member` INT UNSIGNED NOT NULL DEFAULT 0,
	creator VARCHAR(50),
	created_date DATETIME DEFAULT NOW()
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	id						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username				VARCHAR(50) NOT NULL UNIQUE KEY,
    group_id 			INT NOT NULL,
    
    FOREIGN KEY(group_id) REFERENCES `Group`(id)
);

INSERT INTO `Group`(	`group_name`, 		`member`, 		creator			, 		created_date) 
VALUES
						(N'Fresher Java'	, 	1	,	'Dall Wenn'			, 			'2020-03-05'),
						(N'Fresher Python'	, 	3	,	'Mallorie Sancto'	, 			NOW() 		),
						(N'Fresher C#'		, 	4	,	'Travus Hovenden'	, 			'2020-03-08'),
						(N'VTI Academy'		, 	5	,	'Ninette Simioli'	, 			'2020-03-10'),
						(N'Railway EPD1'	, 	6	,	'Yovonnda Kuhnke'	, 			NOW()		),
						(N'Fresher C++'		, 	7	,	'Frederik Foulkes'	, 			NOW()		),
						(N'Fresher Js'		, 	1	,	'Tallie Page'		, 			'2020-04-09');

insert into Account (username, group_id) values ('fgaller0', 7);
insert into Account (username, group_id) values ('jdemeis1', 1);
insert into Account (username, group_id) values ('caubrey2', 2);
insert into Account (username, group_id) values ('nnacci3', 14);
insert into Account (username, group_id) values ('tmilksop4', 5);
insert into Account (username, group_id) values ('vshearstone5', 18);
insert into Account (username, group_id) values ('ujordeson6', 19);
insert into Account (username, group_id) values ('ythyng7', 20);
insert into Account (username, group_id) values ('eboag8', 9);
insert into Account (username, group_id) values ('hmartinon9', 18);