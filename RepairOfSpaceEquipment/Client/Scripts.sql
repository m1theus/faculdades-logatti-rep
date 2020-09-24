CREATE TABLE [dbo].[equipment] (
	id INT IDENTITY (1, 1) NOT NULL,
	descricao VARCHAR (255),
	CONSTRAINT pk_equipment PRIMARY KEY (id)
);

CREATE TABLE [dbo].[role] (
	id INT IDENTITY (1, 1) NOT NULL,
	description VARCHAR(100) NOT NULL,
	CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE [dbo].[employee] (
	id INT IDENTITY (1, 1) NOT NULL,
	name varchar(255) NOT NULL,
	id_role INT NOT NULL,
	CONSTRAINT pk_employee PRIMARY KEY (id),
	CONSTRAINT fk_role FOREIGN KEY (id_role) REFERENCES role(id)
);

CREATE TABLE [dbo].[maintenance] (
	id INT IDENTITY (1, 1) NOT NULL,
	id_equipment INT NOT NULL,
	id_employeer INT NOT NULL,
	descricao VARCHAR (50),
	CONSTRAINT pk_maintenance PRIMARY KEY (id),
	CONSTRAINT fk_equipment FOREIGN KEY (id_equipment) REFERENCES equipment(id),
	CONSTRAINT fk_employee FOREIGN KEY (id_employeer) REFERENCES employee(id)
);

insert into role(description) VALUES ('Cargo 1');
insert into role(description) VALUES ('Cargo 2');
insert into role(description) VALUES ('Cargo 3');
insert into role(description) VALUES ('Cargo 4');
insert into role(description) VALUES ('Cargo 5');