DROP DATABASE IF EXISTS FacturaElectronica_2;
CREATE DATABASE FacturaElectronica_2;
DROP TABLE IF EXISTS FacturaElectronica_2.detalles,
    FacturaElectronica_2.facturas,
    FacturaElectronica_2.clientes,
    FacturaElectronica_2.producto,
    FacturaElectronica_2.proveedorActividad,
    FacturaElectronica_2.usuarios,
    FacturaElectronica_2.actividad;
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
    (tipo_cedula in ('JUR','FIS','EXT') );

alter table usuarios add constraint aprobado_ck Check
    (aprobado in ('APR','ESP','REC', 'REV', '') );
create table actividad(
                          id_actividad int NOT null,
                          descripcion varchar(550) DEFAULT NULL,
                          PRIMARY KEY(id_actividad)
);

create table proveedor_actividad (  -- tabla intermedia entre actividad y el proveedor
                                     idproveedoractividad INT NOT NULL AUTO_INCREMENT,
                                     id_usuario varchar(20) not null ,
                                     id_actividad int NOT NULL,
                                     PRIMARY KEY (idproveedoractividad),
                                     UNIQUE INDEX idproveedoractividad_UNIQUE (idproveedoractividad ASC) VISIBLE
);




create table producto(
                         id_producto INT AUTO_INCREMENT PRIMARY KEY,
                         id_actividad int NOT null,
                         nombre varchar(80) not null,
                         codigo varchar(10) not null,
                         descripcion varchar(505) not null,
                         precio FLOAT not null,
                         proveedor_p varchar(20) not null
);

create table clientes (
                          id_cliente INT AUTO_INCREMENT PRIMARY KEY,
                          identificacion_c varchar(20) not null,  -- esto login
                          nombre_c varchar(100) not null,
                          correo varchar(25) not null,
                          telefono INTEGER not null,
                          proveedor_c varchar(20) not null
);

CREATE TABLE facturas (
                          id_factura INT AUTO_INCREMENT PRIMARY KEY,
                          identificacion_usuario VARCHAR(20) NOT NULL,  -- id del proveedor
                          identificacion_cliente INT NOT NULL,  -- al que esta relacionada la factura
                          valor_total FLOAT NOT NULL,
                          fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE detalles (
                          id_detalle INT AUTO_INCREMENT PRIMARY KEY,
                          num_detalle INT NOT NULL,
                          id_fac_detalle INT NOT NULL,
                          codigo_producto INT NOT NULL,
                          cantidad INT NOT NULL,
                          descripcion_detalle VARCHAR(100) NOT NULL,
                          valor_producto FLOAT NOT NULL
);



alter table usuarios add constraint usuarios_pk primary key (id_usuario);


alter table proveedor_actividad add foreign key(id_usuario) references usuarios(id_usuario);
alter table proveedor_actividad add foreign key(id_actividad) references actividad(id_actividad);


alter table producto add foreign key (proveedor_p) references usuarios(id_usuario);
alter table producto add foreign key (id_actividad) references actividad(id_actividad);

alter table clientes add foreign key (proveedor_c) references usuarios(id_usuario);

alter table facturas add foreign key (identificacion_usuario) references usuarios(id_usuario);
alter table facturas add foreign key (identificacion_cliente) references clientes(id_cliente);

alter table detalles add foreign key (id_fac_detalle) references facturas(id_factura);
alter table detalles add foreign key (codigo_producto) references producto(id_producto);





alter table producto add constraint precio_ck Check
    (precio > 0 );

alter table clientes add constraint telefono_ck Check
    (telefono > 0 );



insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula,aprobado) values ('1','pedrito','123','PRO','FIS','APR');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('2','Ashly','1','PRO','EXT', 'APR');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('4','Mauricio','1','PRO','JUR', 'ESP');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('5','Jairo','1','PRO','FIS', 'REC');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('6','Daniel','1','PRO','JUR', 'REV');
insert into usuarios (id_usuario,nombre,contrasenia,tipo,tipo_cedula, aprobado) values ('7','Andrey','1','PRO','FIS', 'ESP');
insert into usuarios (id_usuario,nombre,contrasenia,tipo, aprobado) values ('3','Juana','123','ADM','APR');

insert into actividad (id_actividad, descripcion) values ('69200', 'servicios profesionales');
insert into actividad (id_actividad, descripcion) values ('62010', 'Software, prueba y soporte');

insert into producto ( id_actividad, codigo, nombre, descripcion, precio,proveedor_p) values ('69200','001','Queque seco', 'Un muy buen queque seco',1500,'1');
insert into producto ( id_actividad, codigo, nombre, descripcion, precio,proveedor_p) values ('62010','002','Queque mojado', 'Esta mojado',2000,'1');

insert into clientes ( identificacion_c, nombre_c, correo,telefono,proveedor_c) values ('gvega','Gabriel Vega','gvega@gmail.com',11111111,'1');
insert into clientes ( identificacion_c, nombre_c, correo,telefono,proveedor_c) values ('123','Cesar','cesar@gmail.com',11111111,'2');
insert into clientes ( identificacion_c, nombre_c, correo,telefono,proveedor_c) values ('111','Pepe','pepe@gmail.com',22222,'2');
insert into clientes ( identificacion_c, nombre_c, correo,telefono,proveedor_c) values ('555','Juana','juana@gmail.com',333333,'2');


INSERT INTO facturas (identificacion_usuario, identificacion_cliente, valor_total) VALUES ('1', 1, 450);
INSERT INTO facturas (identificacion_usuario, identificacion_cliente, valor_total) VALUES ('2', 2, 300);
INSERT INTO facturas (identificacion_usuario, identificacion_cliente, valor_total) VALUES ('1', 1, 4000);
INSERT INTO facturas (identificacion_usuario, identificacion_cliente, valor_total) VALUES ('2', 2, 3232);
INSERT INTO facturas (identificacion_usuario, identificacion_cliente, valor_total) VALUES ('3', 1, 213);
#
#
INSERT INTO actividad (id_actividad, descripcion) VALUES
                                                      ('62521', 'Servicios de venta al por menor de frutas y vegetales, prestados a comisión o por contrato'),
                                                      ('62553', 'Servicios de venta al por menor de juegos y juguetes, prestados a comisión o por contrato (bienes que son propiedad de otros)'),
                                                      ('47610', 'Discos, cintas u otros medios físicos de audio musical'),
                                                      ('88167', 'Servicios de elaboración de comidas y platos preparados'),
                                                      ('21111', 'Carne de res, fresca o refrigerada'),
                                                      ('21121', 'Carne de pollo, fresca o refrigerada'),

                                                      ('84391', 'Servicios de juegos en línea (on-line), n.c.p.'),
                                                      ('38961', 'Pinturas, dibujos y pasteles; grabados, estampas y litografías originales; esculturas y estatuas originales, de cualquier material'),
                                                      ('88906', 'Servicios de fabricación de juegos y juguetes'),
                                                      ('92912', 'Servicios de educación deportiva y recreativa'),
                                                      ('92919', 'Servicios de educación y capacitación, n.c.p.');

# INSERT INTO proveedorActividad (id_usuario, id_actividad) VALUES
#                                                               ('2222222222', 21111),
#                                                               ('2222222222', 21121),
#                                                               ('111', 47610),
#                                                               ('111', 88167);




select * from usuarios;
select * from facturas;
select * from producto;
select * from clientes;
select * from detalles;
select * from actividad;
select * from proveedor_actividad;

# ALTER TABLE producto DROP FOREIGN KEY producto_ibfk_2;
# ALTER TABLE actividad MODIFY COLUMN id_actividad varchar(255);
# ALTER TABLE producto ADD CONSTRAINT producto_ibfk_2 FOREIGN KEY (id_actividad) REFERENCES actividad(id_actividad);
# #
# DELETE FROM detalles;
# DELETE FROM facturas;
# DELETE FROM producto;
# DELETE FROM clientes;
# DELETE FROM usuarios;
# DELETE FROM actividad;
# ALTER TABLE detalles AUTO_INCREMENT = 1;
# ALTER TABLE facturas AUTO_INCREMENT = 1;
# ALTER TABLE clientes AUTO_INCREMENT = 1;
