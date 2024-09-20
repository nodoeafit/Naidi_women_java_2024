--Create Database estramipyme;

CREATE TABLE "Logs" (
  "id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  "fechaCreacionLog" timestamp,
  "descripcionLog" varchar(256),
  "stackError" text
);

CREATE TABLE "Rol" (
  "id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  "nombreRol" varchar(256),
  "fechaCreacionRol" timestamp,
  "isActiveRol" BIT
);

CREATE TABLE "User" (
  "id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  "docId" varchar(50),
  "nombreUsuario" varchar(256),
  "apellidoUsuario" varchar(256),
  "correo" varchar(256),
  "contrasena" varchar(256),
  "telefono" varchar(30),
  "direccion" varchar(256),
  "fechaNacimiento" timestamp,
  "isPyme" BIT,
  "isActiveUser" BIT
);

CREATE TABLE "RolUser" (
  "id" int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  "idUser" int,
  "idRol" int,
  "isActive" BIT
);

CREATE INDEX "descripcionLog_index" ON "Logs" ("descripcionLog");
CREATE INDEX "nombreRol_index" ON "Rol" ("nombreRol");
CREATE INDEX "apellidoUsuario_index" ON "User" ("apellidoUsuario");
CREATE INDEX "correo_index" ON "User" ("correo");
CREATE INDEX "idRolUser_index" ON "RolUser" ("id");
CREATE INDEX "idUser_index" ON "RolUser" ("idUser");

ALTER TABLE "RolUser" ADD FOREIGN KEY ("id") REFERENCES "User" ("id");
ALTER TABLE "RolUser" ADD FOREIGN KEY ("id") REFERENCES "Rol" ("id");


INSERT INTO 
  "Rol" (
    "nombreRol", 
    "fechaCreacionRol", 
    "isActiveRol"
  )
VALUES
  ('Admin',CURRENT_TIMESTAMP,'1'),
  ('Usuario',CURRENT_TIMESTAMP,'1'),
  ('Colaborador',CURRENT_TIMESTAMP,'1');