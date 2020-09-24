CREATE TABLE [dbo].[equipment] (
	id INT IDENTITY (1, 1) NOT NULL,
	descricao VARCHAR (255),
	CONSTRAINT pk_equipment PRIMARY KEY (id)
);