CREATE TABLE "logs" (
  "id_logs" int NOT NULL,
  "descripcion" nvarchar(256),
  "stack_error" nvarchar(max),
  "fecha" datetime,
  PRIMARY KEY ("id_logs")
);

CREATE TABLE "roles" (
  "id_roles" int NOT NULL,
  "nombre_rol" nvarchar(256),
  "isActive_rol" bit,
  PRIMARY KEY ("id_roles")
);

CREATE TABLE "users" (
  "id_users" int UNIQUE NOT NULL,
  "docId" nvarchar(50),
  "nombre" nvarchar(256),
  "apellido" nvarchar(256),
  "correo" nvarchar(256),
  "contrasena" nvarchar(256),
  "telefono" nvarchar(30),
  "direccion" nvarchar(256),
  "fechaNacimiento" date,
  "isPyme" bit,
  "isActive_user" bit,
  PRIMARY KEY ("id_users", "correo")
);

CREATE TABLE "RolUser" (
  "id_roluser" int UNIQUE NOT NULL,
  "id_users" int,
  "id_roles" int
);

CREATE INDEX "index_lastname" ON "users" ("apellido");

ALTER TABLE "RolUser" ADD FOREIGN KEY ("id_users") REFERENCES "users" ("id_users");

ALTER TABLE "RolUser" ADD FOREIGN KEY ("id_roles") REFERENCES "roles" ("id_roles");
