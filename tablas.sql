CREATE TABLE empresas(
  nombre varchar(50) NOT NULL,
  nit int NOT NULL,
  telefono int NOT NULL,
  direccion varchar(100) NOT NULL,
  correo varchar(100) NOT NULL
);

CREATE TABLE Usuarios(
  id_usuario int NOT NULL,
  nombre varchar(100) NOT NULL,
  correo varchar(100) NOT NULL,
  contraseña varchar(15) NOT NULL,
  rol char NOT NULL,
  empresa_nit int NOT NULL
);

CREATE TABLE Proyectos(
  id_proyecto int NOT NULL,
  nombre varchar(50) NOT NULL,
  empresa_nit int NOT NULL
);

CREATE TABLE Historias(
  id_historia int NOT NULL,
  descripcion varchar(200) NOT NULL,
  id_proyecto int NOT NULL,
  estado varchar(20) NOT NULL
);

CREATE TABLE Tickets(
  id_ticket int NOT NULL,
  descripcion varchar(50) NOT NULL,
  id_historia int NOT NULL,
  estado varchar(20) NOT NULL,
  comentarios varchar(200)
);

ALTER TABLE Empresas ADD CONSTRAINT PK_Empresas PRIMARY KEY(nit);
ALTER TABLE Usuarios ADD CONSTRAINT PK_Usuarios PRIMARY KEY(id_usuario);
ALTER TABLE Proyectos ADD CONSTRAINT PK_Proyectos PRIMARY KEY(id_proyecto);
ALTER TABLE Historias ADD CONSTRAINT PK_Historias PRIMARY KEY(id_historia);
ALTER TABLE Tickets ADD CONSTRAINT PK_Tickets PRIMARY KEY(id_ticket);

ALTER TABLE Empresas ADD CONSTRAINT UK_EmpresasN UNIQUE(nombre);
ALTER TABLE Empresas ADD CONSTRAINT UK_EmpresasT UNIQUE(telefono);
ALTER TABLE Empresas ADD CONSTRAINT UK_EmpresasD UNIQUE(direccion);
ALTER TABLE Empresas ADD CONSTRAINT UK_EmpresasC UNIQUE(correo);
ALTER TABLE Usuarios ADD CONSTRAINT UK_Usuarios UNIQUE(correo);

ALTER TABLE Usuarios ADD CONSTRAINT FK_UsuariosEmpresas
FOREIGN KEY(empresa_nit) REFERENCES Empresas(nit);

ALTER TABLE Proyectos ADD CONSTRAINT FK_ProyectosEmpresas
FOREIGN KEY(empresa_nit) REFERENCES Empresas(nit);

ALTER TABLE Historias ADD CONSTRAINT FK_HistoriasProyectos
FOREIGN KEY(id_proyecto) REFERENCES Proyectos(id_proyecto);

ALTER TABLE Tickets ADD CONSTRAINT FK_TicketsHistorias
FOREIGN KEY(id_historia) REFERENCES Historias(id_historia);

