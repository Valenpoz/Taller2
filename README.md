 ACM GiWeb - Java Backend Spring
# Proyecto Final
## Gestion Hotelera API Rest

Este sistema tiene como objetivo permitir la administración 
integral de un hotel, incluyendo la gestión de usuarios (clientes, empleados, 
administrador), habitaciones, reservas, pagos, facturación y más.



## Integrantes

- Valentina Parra Ordoñez

- Andres Pescador Castro

- Walter Alejandro Suárez



## 📋 Requisitos Previos
- Java 21
- PostgreSQL (o Docker para usar el compose provisto)  
- Maven  
- Spring Boot 
## Configuración 
- src/main/resources/application.properties
```http
spring.application.name=gestionhotel
spring.datasource.url=jdbc:postgresql://localhost:5432/gestionHotelera 
spring.datasource.username=postgres
spring.datasource.password=password1
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Endpoins 


### 📌 Listado de Endpoints

### Administrador

| Método | Endpoint                        | Descripción                                 |
|--------|---------------------------------|----------------------------------------------|
| `GET`  | `/`                             | Obtiene todos los administradores.           | 
| `GET`  | `/{id}`                         | Obtiene un administrador por ID.             | 
| `POST` | `/`                             | Crea un nuevo administrador.                 | 
| `PUT`  | `/{id}`                         | Actualiza un administrador existente.        | 
| `DELETE` | `/{id}`                       | Elimina un administrador.                    |

### Uso

```json
  {
    "id": 123,
    "primerNombre": "Carlos",
    "segundoNombre": "Andrés",
    "primerApellido": "pez",
    "segundoApellido": "López",
    "correo": "carlos@hotel.com",
    "telefono": "+3001234567"
  }
```
## Administrador General

| Método | Endpoint                         | Descripción                                |
|--------|----------------------------------|--------------------------------------------|
| GET    | /api/administradores             | Lista todos los administradores generales  |
| GET    | /api/administradores/{id}        | Obtiene un administrador por su ID         |
| POST   | /api/administradores             | Crea un nuevo administrador general        |
| PUT    | /api/administradores/{id}        | Actualiza los datos de un administrador    |
| DELETE | /api/administradores/{id}        | Elimina un administrador por su ID         |

### Uso
```json
{
  "id": 1,
  "correo": "admin1@ejemplo.com",
  "telefono": "3111234567",
  "primerNombre": "Carlos",
  "segundoNombre": "Andres",
  "primerApellido": "Pez",
  "segundoApellido": "Castro"
}
```
## Clientes 

| Método | Endpoint                   | Descripción                             |
|--------|----------------------------|-----------------------------------------|
| GET    | /api/clientes              | Lista todos los clientes                |
| GET    | /api/clientes/{id}         | Obtiene un cliente por su ID            |
| POST   | /api/clientes              | Crea un nuevo cliente                   |
| PUT    | /api/clientes/{id}         | Actualiza los datos de un cliente       |
| DELETE | /api/clientes/{id}         | Elimina un cliente por su ID            |

### Uso

```json
{
  "id": 10,
  "primerNombre": "Laura",
  "segundoNombre": "Marcela",
  "primerApellido": "Gómez",
  "segundoApellido": "Martinez",
  "cedula": 1020304050,
  "direccion": "Cra 20 #45-67, Bogotá"
}
```
## Empleados
| Método | Endpoint                    | Descripción                              |
|--------|-----------------------------|------------------------------------------|
| GET    | /api/empleados              | Lista todos los empleados                |
| GET    | /api/empleados/{id}         | Obtiene un empleado por su ID            |
| POST   | /api/empleados              | Crea un nuevo empleado                   |
| PUT    | /api/empleados/{id}         | Actualiza los datos de un empleado       |
| DELETE | /api/empleados/{id}         | Elimina un empleado por su ID            |

### Uso

```json
{
  "id": 5,
  "correo": "empleado5@hotel.com",
  "telefono": "3005557890",
  "primerNombre": "walter",
  "segundoNombre": "Alejandro",
  "primerApellido": "Suarez",
  "segundoApellido": "García"
}

```
## Facturas

| Método | Endpoint                  | Descripción                                   |
|--------|---------------------------|-----------------------------------------------|
| GET    | /api/facturas             | Lista todas las facturas                      |
| GET    | /api/facturas/{id}        | Obtiene una factura por su ID                 |
| POST   | /api/facturas             | Crea una nueva factura                        |
| PUT    | /api/facturas/{id}        | Actualiza los datos de una factura            |
| DELETE | /api/facturas/{id}        | Elimina una factura por su ID                 |


### Uso

```json
{
  "id": 1001,
  "fechaEmision": "2025-07-03T14:30:00",
  "valorTotal": 450000,
  "reservaEntity": {
    "id": 501
  },
  "pagoEntity": {
    "id": 301
  }
}
```


| Método | Endpoint                      | Descripción                                      |
|--------|-------------------------------|--------------------------------------------------|
| GET    | /api/habitaciones             | Lista todas las habitaciones                     |
| GET    | /api/habitaciones/{id}        | Obtiene los datos de una habitación específica   |
| POST   | /api/habitaciones             | Crea una nueva habitación                        |
| PUT    | /api/habitaciones/{id}        | Actualiza los datos de una habitación            |
| DELETE | /api/habitaciones/{id}        | Elimina una habitación                           |

### Uso

```json
{
  "numeroHabitacion": 101,
  "precioDia": 150000,
  "disponible": true,
  "hotelEntity": {
    "id": 1
  },
  "tipoHabitacionEntity": {
    "id": 2
  }
}
```
### Hoteles

| Método | Endpoint                 | Descripción                             |
|--------|--------------------------|-----------------------------------------|
| GET    | /api/hoteles             | Lista todos los hoteles                 |
| GET    | /api/hoteles/{id}        | Obtiene los datos de un hotel específico|
| POST   | /api/hoteles             | Crea un nuevo hotel                     |
| PUT    | /api/hoteles/{id}        | Actualiza los datos de un hotel         |
| DELETE | /api/hoteles/{id}        | Elimina un hotel por su ID              |

### Uso

```json
{
  "nombre": "Hotel El Paraíso",
  "ciudad": "Medellín",
  "telefono": "6041234567",
  "correo": "info@elparaiso.com",
  "direccion": "Calle 45 #67-89, Medellín"
}
```
## Pagos
| Método | Endpoint                  | Descripción                              |
|--------|---------------------------|------------------------------------------|
| GET    | /api/pagos                | Lista todos los pagos registrados        |
| GET    | /api/pagos/{id}           | Obtiene un pago específico por su ID     |
| POST   | /api/pagos                | Registra un nuevo pago                   |
| PUT    | /api/pagos/{id}           | Actualiza los datos de un pago           |
| DELETE | /api/pagos/{id}           | Elimina un pago por su ID                |

### Uso
```json
{
  "id": 9001,
  "fecha": "2025-07-03T16:15:00",
  "metodoPago": "Tarjeta de crédito",
  "pagoTotal": 450000,
  "reservaEntity": {
    "id": 501
  }
}
```

## Reservas 
| Método | Endpoint                    | Descripción                                       |
|--------|-----------------------------|---------------------------------------------------|
| GET    | /api/reservas               | Lista todas las reservas                          |
| GET    | /api/reservas/{id}          | Obtiene una reserva por su ID                     |
| POST   | /api/reservas               | Crea una nueva reserva                            |
| PUT    | /api/reservas/{id}          | Actualiza los datos de una reserva                |
| DELETE | /api/reservas/{id}          | Elimina una reserva por su ID                     |

### Uso
```json
{
  "fechaInicio": "2025-07-10T14:00:00",
  "fechaFinal": "2025-07-13T12:00:00",
  "cantidadDias": 3,
  "estado": true,
  "fechaReserva": "2025-07-03T11:30:00",
  "habitacionEntity": { "id": 7 },
  "clienteEntity": { "id": 2001 }
}
```
## Habitaciones
| Método | Endpoint                         | Descripción                                |
|--------|----------------------------------|--------------------------------------------|
| GET    | /api/tipo-habitaciones           | Lista todos los tipos de habitación        |
| GET    | /api/tipo-habitaciones/{id}      | Consulta un tipo de habitación específico  |
| POST   | /api/tipo-habitaciones           | Crea un nuevo tipo de habitación           |
| PUT    | /api/tipo-habitaciones/{id}      | Actualiza un tipo de habitación            |
| DELETE | /api/tipo-habitaciones/{id}      | Elimina un tipo de habitación              |


### Uso
```json
{
  "nombre": "Suite",
  "cantidad": 5,
  "hotelEntity": {
    "id": 3
  }
}
```
## Usuarios

Método | Endpoint                 | Descripción
-------|--------------------------|-----------------------------------
GET    | /api/usuarios            | Lista todos los usuarios
GET    | /api/usuarios/{id}       | Consulta un usuario específico
POST   | /api/usuarios            | Crea un nuevo usuario
PUT    | /api/usuarios/{id}       | Actualiza un usuario existente
DELETE | /api/usuarios/{id}       | Elimina un usuario

### Uso
```json
{
  "id": 10,
  "nombreUsuario": "valentina123",
  "contrasena": "passwordSegura",
  "rol": "CLIENTE",
  "clienteEntity": {
    "id": 5
  },
  "empleadoEntity": null,
  "administradorGeneralEntity": null,
  "administradorEntity": null
}
```


# Script
```

CREATE TABLE administrador (
    id_administrador integer NOT NULL,
    primer_nombre character varying(50) NOT NULL,
    segundo_nombre character varying(50),
    primer_apellido character varying(50) NOT NULL,
    segundo_apellido character varying(50),
    correo character varying(100) NOT NULL,
    telefono character varying(10) NOT NULL
);


CREATE TABLE administrador_general (
    id_administrador_general integer NOT NULL,
    correo character varying(100) NOT NULL,
    telefono character varying(10) NOT NULL,
    primer_nombre character varying(50) NOT NULL,
    segundo_nombre character varying(50),
    primer_apellido character varying(50) NOT NULL,
    segundo_apellido character varying(50)
);


CREATE TABLE cliente (
    id_cliente integer NOT NULL,
    primer_nombre character varying(50) NOT NULL,
    segundo_nombre character varying(50),
    primer_apellido character varying(50) NOT NULL,
    segundo_apellido character varying(50),
    cedula integer NOT NULL,
    direccion character varying(150) NOT NULL
);


CREATE TABLE empleado (
    id_empleado integer NOT NULL,
    correo character varying(100),
    telofono character varying(10) NOT NULL,
    primer_nombre character varying(50) NOT NULL,
    segundo_nombre character varying(50),
    primer_apellido character varying(50) NOT NULL,
    segundo_apellido character varying(50)
);


CREATE TABLE factura (
    id_factura integer NOT NULL,
    fk_id_reserva integer,
    fk_id_pago integer,
    fecha_emision integer,
    valor_total integer
);


CREATE TABLE habitacion (
    id_habitacion integer NOT NULL,
    numero_habitacion integer NOT NULL,
    fk_id_tipo_habitacion integer,
    precio_dia integer NOT NULL,
    disponible boolean,
    fk_id_hotel integer
);


CREATE TABLE hotel (
    id_hotel integer NOT NULL,
    nombre character varying(30) NOT NULL,
    ciudad character varying(20) NOT NULL,
    telefono character varying(10) NOT NULL,
    correo character varying(100) NOT NULL,
    direccion character varying(200) NOT NULL
);


CREATE TABLE pago (
    id_pago integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    fk_id_reserva integer,
    metodo_pago character varying(20),
    pago_total integer
);


CREATE TABLE reserva (
    id_reserva integer NOT NULL,
    fecha_inicio timestamp without time zone,
    fecha_final timestamp without time zone,
    cantidad_dias integer,
    estado boolean,
    fecha_reserva timestamp without time zone,
    fk_id_habitacion integer,
    fk_id_cliente integer
);


CREATE TABLE tipo_habitacion (
    id_tipo_habitacion integer NOT NULL,
    fk_id_hotel integer,
    nombre character varying(100),
    cantidad integer
);


CREATE TABLE usuario (
    id_usuario integer NOT NULL,
    nombre_usuario character varying(255) NOT NULL,
    contrasena character varying(255) NOT NULL,
    rol character varying(30) NOT NULL,
    fk_id_cliente integer,
    fk_id_empleado integer,
    fk_id_administrador_general integer,
    fk_id_administrador integer
);


ALTER TABLE ONLY administrador_general
    ADD CONSTRAINT administrador_general_pkey PRIMARY KEY (id_administrador_general);


ALTER TABLE ONLY administrador
    ADD CONSTRAINT administrador_pkey PRIMARY KEY (id_administrador);


ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_cedula_key UNIQUE (cedula);


ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);


ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (id_empleado);


ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (id_factura);


ALTER TABLE ONLY habitacion
    ADD CONSTRAINT habitacion_numero_habitacion_key UNIQUE (numero_habitacion);


ALTER TABLE ONLY habitacion
    ADD CONSTRAINT habitacion_pkey PRIMARY KEY (id_habitacion);


ALTER TABLE ONLY hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (id_hotel);


ALTER TABLE ONLY pago
    ADD CONSTRAINT pago_pkey PRIMARY KEY (id_pago);



ALTER TABLE ONLY reserva
    ADD CONSTRAINT reserva_pkey PRIMARY KEY (id_reserva);



ALTER TABLE ONLY tipo_habitacion
    ADD CONSTRAINT tipo_habitacion_pkey PRIMARY KEY (id_tipo_habitacion);



ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_nombre_usuario_key UNIQUE (nombre_usuario);



ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);



ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk_id_administrador FOREIGN KEY (fk_id_administrador) REFERENCES administrador(id_administrador);


ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk_id_administrador_general FOREIGN KEY (fk_id_administrador_general) REFERENCES administrador_general(id_administrador_general);



ALTER TABLE ONLY reserva
    ADD CONSTRAINT fk_id_cliente FOREIGN KEY (fk_id_cliente) REFERENCES cliente(id_cliente);


ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk_id_cliente FOREIGN KEY (fk_id_cliente) REFERENCES cliente(id_cliente);



ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk_id_empleado FOREIGN KEY (fk_id_empleado) REFERENCES empleado(id_empleado);



ALTER TABLE ONLY reserva
    ADD CONSTRAINT fk_id_habitacion FOREIGN KEY (fk_id_habitacion) REFERENCES habitacion(id_habitacion);


ALTER TABLE ONLY tipo_habitacion
    ADD CONSTRAINT fk_id_hotel FOREIGN KEY (fk_id_hotel) REFERENCES hotel(id_hotel);



ALTER TABLE ONLY habitacion
    ADD CONSTRAINT fk_id_hotel FOREIGN KEY (fk_id_hotel) REFERENCES hotel(id_hotel);



ALTER TABLE ONLY factura
    ADD CONSTRAINT fk_id_pago FOREIGN KEY (fk_id_pago) REFERENCES pago(id_pago);


ALTER TABLE ONLY factura
    ADD CONSTRAINT fk_id_reserva FOREIGN KEY (fk_id_reserva) REFERENCES reserva(id_reserva);


ALTER TABLE ONLY pago
    ADD CONSTRAINT fk_id_reserva FOREIGN KEY (fk_id_reserva) REFERENCES reserva(id_reserva);



ALTER TABLE ONLY habitacion
    ADD CONSTRAINT fk_id_tipo_habitacion FOREIGN KEY (fk_id_tipo_habitacion) REFERENCES tipo_habitacion(id_tipo_habitacion);

```

