CREATE TABLE usuarios(

     id BIGSERIAL PRIMARY KEY,
     nombre VARCHAR(50),
     correo VARCHAR(50),
     contrasenia VARCHAR(300),
    rol_usuario VARCHAR (50)

)