BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `preapt` (
	`_id`	INTEGER,
	`Question`	TEXT,
	`mcq1`	TEXT,
	`mcq2`	TEXT,
	`mcq3`	TEXT,
	`mcq4`	TEXT,
	`correct`	INTEGER,
	`module`	INTEGER,
	PRIMARY KEY(`_id`)
);
INSERT INTO `preapt` (_id,Question,mcq1,mcq2,mcq3,mcq4,correct,module) VALUES (1,'Question1','MCQ1','MCQ2','MCQ3','MCQ4',2,1);
COMMIT;
