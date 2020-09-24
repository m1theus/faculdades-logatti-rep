CREATE TABLE [dbo].[role] (
	id INT IDENTITY (1, 1) NOT NULL,
	description VARCHAR(100) NOT NULL,
	CONSTRAINT pk_role PRIMARY KEY (id)
);