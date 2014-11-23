CREATE TABLE "USUARIO" (
    "IDUSUARIO" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    "NOMBRE" VARCHAR(45) not null,
    "CONTRASENA" VARCHAR(45) not null
   
);

CREATE TABLE "COMENTARIO" (
    "IDCOMENTARIO" INTEGER not null primary key,
    "CONTENIDO" VARCHAR(100) not null,
    "ANO" VARCHAR(45) not null,
    "USUARIO" INTEGER not null,
    FOREIGN KEY (USUARIO) references USUARIO (IDUSUARIO)
   
    
);
CREATE TABLE "PELICULA" (
    "IDPELICULA" INTEGER not null primary key,
    "NOMBRE" VARCHAR(45) not null,
    "ANO" VARCHAR(45) not null,
    "DESCRIPCION" VARCHAR(45)

);