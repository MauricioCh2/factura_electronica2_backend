DROP DATABASE IF EXISTS FacturaElectronica_2;
CREATE DATABASE FacturaElectronica_2;
USE FacturaElectronica_2;

create table usuarios (  -- Proveedor y Administrador
                          id_usuario varchar(20) not null,
                          nombre varchar(100) not null,
                          contrasenia varchar(30) not null,
                          tipo varchar(5) not null, -- PROV o ADM
                          tipo_cedula varchar(5),  -- Juridico, Persona
                          aprobado varchar(5) not null   --
);
alter table usuarios add constraint tipo_ck Check
    (tipo in ('PRO','ADM') );

alter table usuarios add constraint tipo_cedula_ck Check
    (tipo_cedula in ('JUR','FIS','') );

alter table usuarios add constraint aprobado_ck Check
    (aprobado in ('APR','ESP','REC', 'REV' '') );

create table productos(
                          id_producto INT AUTO_INCREMENT PRIMARY KEY,
                          nombre varchar(30) not null,
                          codigo varchar(20) not null,
                          descripcion varchar(30) not null,
                          precio FLOAT not null,
                          proveedor_p varchar(20) not null
);

create table clientes (
                          id_cliente INT AUTO_INCREMENT PRIMARY KEY,
                          identificacion_c varchar(20) not null,  -- esto login
                          nombre_c varchar(30) not null,
                          correo varchar(20) not null,
                          telefono INTEGER not null,
                          proveedor_c varchar(20) not null
);

CREATE TABLE facturas (
                          id_factura INT AUTO_INCREMENT PRIMARY KEY,
                          identificacion_usuario VARCHAR(20) NOT NULL,  -- id del proveedor
                          identificacion_cliente INT NOT NULL,  -- al que esta relacionada la factura
                          fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE detalles (
                          id_detalle INT AUTO_INCREMENT PRIMARY KEY,
                          id_fac_detalle INT NOT NULL,
                          codigo_producto INT NOT NULL,
                          cantidad INT NOT NULL,
                          descripcion_detalle VARCHAR(100) NOT NULL,
                          valor_final FLOAT NOT NULL
);

alter table usuarios add constraint usuarios_pk primary key (id_usuario);

alter table productos add foreign key (proveedor_p) references usuarios(id_usuario);
alter table clientes add foreign key (proveedor_c) references usuarios(id_usuario);

alter table facturas add foreign key (identificacion_usuario) references usuarios(id_usuario);
alter table facturas add foreign key (identificacion_cliente) references clientes(id_cliente);

alter table detalles add foreign key (id_fac_detalle) references facturas(id_factura);
alter table detalles add foreign key (codigo_producto) references productos(id_producto);





alter table productos add constraint precio_ck Check
    (precio > 0 );

alter table clientes add constraint telefono_ck Check
    (telefono > 0 );



insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula,aprobado) values ('1','pedrito','123','PRO','FIS','APR');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('2','Ashly','1','PRO','FIS', 'APR');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('4','Mauricio','1','PRO','JUR', 'ESP');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('5','Jairo','1','PRO','FIS', 'REC');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('6','Daniel','1','PRO','JUR', 'REV');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('7','Andrey','1','PRO','FIS', 'ESP');
insert into usuarios (id_usuario,nombre,contrasenia,tipo, aprobado) values ('3','Juana','123','ADM','APR');


insert into productos ( codigo, nombre, descripcion, precio,proveedor_p) values ('001','Queque seco', 'Un muy buen queque seco',1500,'1');
insert into productos ( codigo, nombre, descripcion, precio,proveedor_p) values ('002','Queque mojado', 'Esta mojado',2000,'1');

insert into clientes ( identificacion_c, nombre_c, correo,telefono,proveedor_c) values ('gvega','Gabriel Vega','gvega@gmail.com',11111111,'1');
insert into clientes ( identificacion_c, nombre_c, correo,telefono,proveedor_c) values ('123','Cesar','cesar@gmail.com',11111111,'2');
insert into clientes ( identificacion_c, nombre_c, correo,telefono,proveedor_c) values ('111','Pepe','pepe@gmail.com',22222,'2');
insert into clientes ( identificacion_c, nombre_c, correo,telefono,proveedor_c) values ('555','Juana','juana@gmail.com',333333,'2');


INSERT INTO facturas (identificacion_usuario, identificacion_cliente) VALUES ('1', 1);
INSERT INTO facturas (identificacion_usuario, identificacion_cliente) VALUES ('2', 2);
INSERT INTO facturas (identificacion_usuario, identificacion_cliente) VALUES ('1', 3);
INSERT INTO facturas (identificacion_usuario, identificacion_cliente) VALUES ('2', 4);


# insert into detalles (id_fac_detalle, codigo_producto, cantidad, descripcion_detalle, valor_final) values (5, 1, 2, 'Queque seco', 3000.0);
# insert into detalles (id_fac_detalle, codigo_producto, cantidad, descripcion_detalle, valor_final) values (6, 2, 1, 'Queque mojado', 2000.0);



select * from usuarios;
select * from facturas;