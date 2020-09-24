CREATE TABLE [dbo].[employee] (
	id INT IDENTITY (1, 1) NOT NULL,
	name varchar(255) NOT NULL,
	id_role INT NOT NULL,
	CONSTRAINT pk_employee PRIMARY KEY (id),
	CONSTRAINT fk_role FOREIGN KEY (id_role) REFERENCES role(id)
);