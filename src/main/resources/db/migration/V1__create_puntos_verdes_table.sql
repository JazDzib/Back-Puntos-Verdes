CREATE TABLE puntos_verdes(
      id BIGSERIAL PRIMARY KEY,
      nombre VARCHAR(50),
      descripcion varchar(300),
      latitud NUMERIC(10,6),
      longitud NUMERIC(10,6),
      direccion VARCHAR(300),
      tipo_residuo VARCHAR(50),
      imagen_url VARCHAR(300)
)