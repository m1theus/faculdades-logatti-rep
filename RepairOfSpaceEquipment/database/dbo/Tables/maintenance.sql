CREATE TABLE [dbo].[maintenance] (
	id INT IDENTITY (1, 1) NOT NULL,
	id_equipment INT NOT NULL,
	id_employeer INT NOT NULL,
	descricao VARCHAR (50),
	CONSTRAINT pk_maintenance PRIMARY KEY (id),
	CONSTRAINT fk_equipment FOREIGN KEY (id_equipment) REFERENCES equipment(id),
	CONSTRAINT fk_employee FOREIGN KEY (id_employeer) REFERENCES employee(id)
);