drop database sapphire_inventory;

create database sapphire_inventory;

use sapphire_inventory;

-- CREACION DE LAS TABLAS

create table usuario (

id_usuario int primary key auto_increment not null,
nombres_usuario varchar (30) not null,
apellidos_usuario varchar (30) not null,
tipo_documento int not null,
numero_documento_usuario varchar(15) not null,
usuario varchar (50) not null unique,
contraseña varchar (30) not null,
telefono_usuario varchar (13) not null,
rol_usuario boolean not null

);

create table producto (

id_producto int primary key auto_increment not null,
marca_producto varchar (40),
estado boolean not null,
nombre_producto varchar (50) not null,
descripcion_producto varchar (500) not null,
cantidad_producto int not null,
medida int not null,
id_categoria int not null,
imagen mediumblob not null

);

create table proveedor (

id_proveedor int primary key not null auto_increment,
nombre_proveedor varchar (30) not null,
telefono_proveedor varchar (13) not null,
correo_proveedor varchar (50) not null

);

create table salida (

id_salida int primary key auto_increment not null,
fecha_hora_salidaa datetime not null

);

create table detalle_salida (

id_detalle_salida int primary key not null auto_increment unique,
precio_item_vendido int not null,
cantidad_item_vendido int not null,
id_salida int not null,
id_producto int not null

);

create table item (

id_item int primary key auto_increment not null,
precio_venta int not null,
cantidad_item int not null,
id_producto int not null,
id_entrada int not null

);

create table entrada (

id_entrada int primary key auto_increment unique not null,
fecha_entrada datetime not null,
id_proveedor int not null

);

create table categoria (

id_categoria int primary key auto_increment not null,
nombre_categoria varchar (40),
descripcion_categoria varchar (100),
imagen mediumblob not null

);

-- RELACIONES ENTRE TABLAS

alter table item
add constraint item_entrada
foreign key (id_entrada)
references entrada (id_entrada);

alter table detalle_salida
add constraint detalle_salida_producto
foreign key (id_producto)
references producto (id_producto);

alter table detalle_salida
add constraint detalle_salida_dalida
foreign key (id_salida)
references  salida (id_salida);

alter table item
add constraint producto_item
foreign key (id_producto)
references  producto (id_producto);

alter table producto
add constraint producto_categoria
foreign key (id_categoria)
references  categoria (id_categoria);

alter table entrada
add constraint entrada_proveedor
foreign key (id_proveedor)
references  proveedor (id_proveedor);

-- PROCEDIMIENTOS ALMACENADOS DE USUARIO

create procedure create_usuario (create_nombres_usuario varchar (30), create_apellidos_usuario varchar (30), create_tipo_documento int, create_numero_documento_usuario varchar(15), create_usuario varchar (50), create_contraseña varchar (30), create_telefono_usuario varchar (13), create_rol_usuario varchar (15))
insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario)
values (create_nombres_usuario, create_apellidos_usuario, create_tipo_documento, create_numero_documento_usuario, create_usuario, create_contraseña, create_telefono_usuario, create_rol_usuario);

create procedure read_usuario () 
select * from usuario;

create procedure read_usuario_especifico (id_recibido int) 
select * from usuario where id_usuario = id_recibido;

create procedure delete_usuario (id_usuario_recibido int)
delete from usuario where id_usuario = id_usuario_recibido;

CREATE PROCEDURE update_nombres_usuario (update_id_usuario int, update_nombres_usuario varchar (30))
UPDATE usuario
SET nombres_usuario = update_nombres_usuario
WHERE id_usuario = update_id_usuario;

CREATE PROCEDURE update_apellidos_usuario (update_id_usuario int, update_apellidos_usuario varchar (30))
UPDATE usuario
SET apellidos_usuario = update_apellidos_usuario
WHERE id_usuario = update_id_usuario;

CREATE PROCEDURE update_tipo_documento_usuario (update_id_usuario int, update_tipo_documento_usuario int)
UPDATE usuario
SET tipo_documento = update_tipo_documento_usuario
WHERE id_usuario = update_id_usuario;

CREATE PROCEDURE update_numero_documento_usuario (update_id_usuario int, update_numero_documento_usuario varchar (15))
UPDATE usuario
SET numero_documento_usuario = update_numero_documento_usuario
WHERE id_usuario = update_id_usuario;

CREATE PROCEDURE update_usuario_usuario (update_id_usuario int, update_usuario_usuario varchar (50))
UPDATE usuario
SET usuario = update_usuario_usuario
WHERE id_usuario = update_id_usuario;

CREATE PROCEDURE update_contraseña_usuario (update_id_usuario int, update_contraseña_usuario varchar (30))
UPDATE usuario
SET contraseña = update_contraseña_usuario
WHERE id_usuario = update_id_usuario;

CREATE PROCEDURE update_telefono_usuario (update_id_usuario int, update_telefono_usuario varchar (13))
UPDATE usuario
SET telefono_usuario = update_telefono_usuario
WHERE id_usuario = update_id_usuario;

CREATE PROCEDURE update_rol_usuario (update_id_usuario int, update_rol_usuario tinyint)
UPDATE usuario
SET rol_usuario = update_rol_usuario
WHERE id_usuario = update_id_usuario;

-- PROCEDIMIENTOS ALMACENADOS DE PRODUCTO

CREATE PROCEDURE CREATE_PRODUCTO (create_marca_producto varchar (40), create_estado_producto boolean, create_nombre_producto varchar(50), create_descripcion_producto varchar(500), create_cantidad_producto int, create_medida_producto int, create_categoria_producto varchar(30), create_imagen mediumblob)
INSERT INTO producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria, imagen)
VALUES (create_marca_producto, create_estado_producto, create_nombre_producto, create_descripcion_producto, create_cantidad_producto, create_medida_producto, create_categoria_producto, create_imagen);

create procedure read_producto () 
select * from producto;

create procedure read_productos_categoria (id_categoria_recibido int) 
select * from producto where id_categoria = id_categoria_recibido;

CREATE PROCEDURE update_marca_producto (update_id_producto int, update_marca_producto varchar (40))
UPDATE PRODUCTO
SET  marca_producto = update_marca_producto
WHERE id_producto = update_id_producto;

CREATE PROCEDURE update_medida_producto (update_id_producto int, update_medida_producto int)
UPDATE PRODUCTO
SET  medida = update_media_producto
WHERE id_producto = update_id_producto;

CREATE PROCEDURE update_nombre_producto (update_id_producto int, update_nombre_producto varchar (50))
UPDATE producto
SET nombre_producto = update_nombre_producto
WHERE id_producto = update_id_producto;

CREATE PROCEDURE update_descripcion_producto (update_id_producto int, update_descripcion_producto varchar (500))
UPDATE producto
SET descripcion_producto = update_descripcion_producto
WHERE id_producto = update_id_producto;

CREATE PROCEDURE update_estado_producto (update_id_producto int, update_estado boolean)
UPDATE producto
SET estado = update_estado
WHERE id_producto = update_id_producto;

CREATE PROCEDURE update_cantidad_producto (update_id_producto int, update_cantidad_producto int)
UPDATE producto
SET cantidad_producto = update_cantidad_producto
WHERE id_producto = update_id_producto;

CREATE PROCEDURE update_id_categoria (update_id_producto int, update_id_categoria int)
UPDATE producto
SET id_categoria = update_id_categoria
WHERE id_producto = update_id_producto;

-- PROCEDIMIENTOS ALMACENADOS DE CATEGORIA

create procedure create_categoria (create_nombre_categoria varchar (40), create_descripcion_categoria varchar (100), create_imagen mediumblob)
insert into categoria (nombre_categoria, descripcion_categoria, imagen)
values (create_nombre_categoria, create_descripcion_categoria, create_imagen);

create procedure read_categoria ()
select * from categoria;

create procedure delete_categoria (id_categoria_recibido int)
delete from categoria where id_categoria = id_categoria_recibido;

-- PROCEDIMIENTOS ALMACENADOS PROVEEDOR

create procedure read_proveedores ()
select * from proveedor;

create procedure delete_proveedor (id_proveedor_recibido int)
delete from proveedor where id_proveedor = id_proveedor_recibido;

create procedure create_proveedor (create_nombre_proveedor varchar (30), create_telefono_proveedor varchar (13), create_correo_proveedor varchar (50))
insert into proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor)
values (create_nombre_proveedor, create_telefono_proveedor, create_correo_proveedor);

-- PROCEDIMIENTOS ALMACENADOS SALIDA

delimiter //
CREATE PROCEDURE create_salida ()
BEGIN
    INSERT INTO salida (fecha_hora_salidaa) VALUES (NOW()); 
    
    SELECT LAST_INSERT_ID() AS id_salida;  -- Devuelve el ID generado
END;
 //
 
-- PROCEDIMIENTOS ALMACENADOS DETALLE_SALIDA

create procedure create_detalle_salida (create_precio_item_vendido int, create_cantidad_item_vendido int, create_id_salida int, create_id_producto int)
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto)
values (create_precio_item_vendido, create_cantidad_item_vendido, create_id_salida, create_id_producto);

-- INSERTS A LA TABLA PROVEEDOR

INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("start", 123456789, "start@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("cielo", 432167584, "cielo@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("pañalera valentina", 651890543, "pañaleravalentina@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("hugguies", 009684321, "hugguies@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("pequeñin", 864211337, "pequñin@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("jhonson", 112233445, "jhonson@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("hp", 577388855, "hpcolombia@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("intel", 177955370, "intel123@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("samgsumg", 665527890, "samsumgss@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("big hit", 6788994, "hybelabels@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("sm towm", 43366889, "smenterteament@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("aji no moto", 098765432, "ajinomoto@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("toei animation", 558899333, "toeianimation@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("doña rosita", 114477229, "rositadiaz@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("pokemon company", 669944200, "pokemoncompany@email.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("Juan", 319583726, "Juanito1111@gmail.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("David", 319523786, "David1111@gmail.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("Miguel", 310673479, "Miguel@gmail.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("John", 319720003, "John13@gmail.com");
INSERT INTO proveedor (nombre_proveedor, telefono_proveedor, correo_proveedor) values ("Diana", 319703816, "Diana123@gmail.com");

select*from proveedor;

-- INSERTS A LA TABLA ITEM

insert into item (precio_venta, cantidad_item, id_producto, id_entrada) select 1000, cantidad_producto, id_producto, 1 from producto where nombre_producto = "arroz diana integral";
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) select 5000, cantidad_producto, id_producto, 2 from producto where nombre_producto = "mirado";
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) select 8000, cantidad_producto, id_producto, 3 from producto where nombre_producto = "yogurt griego fresa";
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) select 5000, cantidad_producto, id_producto, 1 from producto where nombre_producto = "arroz diana integral";
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) select 1000, cantidad_producto, id_producto, 2 from producto where nombre_producto = "mirado";
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) select 3000, cantidad_producto, id_producto, 5 from producto where nombre_producto = "quesillo";
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) select 500, cantidad_producto, id_producto, 6 from producto where nombre_producto = "cebolla cabezona roja";
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) values (3000, 3, 1, 3);
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) values (2000, 6, 2, 2);
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) values (500, 9, 3, 3);
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) values (6000, 12, 4, 4);
insert into item (precio_venta, cantidad_item, id_producto, id_entrada) values (200, 15, 5, 5);

select * from item;

-- INSERTS A LA TABLA USUARIO

insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario) values ("yoongi", "min", 3, 55555555, "yoongi@gmail.com", "yoongi", 555555555, 0);
insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario) values ("Juan", "Martínez", 2, 98765432, "juan87", "miclave123", 987654321, "empleado");
insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario) values ("Ana", "López", 3, 55555555, "ana555", "123456ana", 555555555, "administrador");
insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario) values ("Brayan", "Alfonso", 1, 103736374, "Brayis123", "BrayisA123", 319638167, "Empleado");
insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario) values ("Laura", "Vega", 1, 10333629, "Lala123", "LalaV123", 319681289, "Empleado");
insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario) values ("Hector", "Veltran", 1, 103732903, "Hecter123", "HecterV123", 319681234, "Empleado");
insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario) values ("Maria", "Lozano", 1, 103389021, "Mafe123", "MafeL123", 319631210, "Empleado");
insert into usuario (nombres_usuario, apellidos_usuario, tipo_documento, numero_documento_usuario, usuario, contraseña, telefono_usuario, rol_usuario) values ("Sebastian", "Rondon", 1, 103395600, "Sebas123", "SebasR123", 313892394, "Empleado");

select * from usuario;

-- INSERTS A LA TABLA PRODUCTO

insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("diana", 1, "arroz diana integral", "arroz diana integral premiun por libra", 14, "unidad", 5);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("lapiz glaceon", 1, "mirado", "lapiz para escribir con forma de glaceon", 24, "unidad", 7);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("alpina", 1, "yogurt griego fresa", "delicioso yogurt griego con sabor a fresa x 120ml", 32, "unidad", 2);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("alpina", 1, "quesillo", "quesillo alpina x 500 gr", 12, "unidad", 2);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "cebolla cabezona roja", "cebolla roja x libras", 20, "kilogramo", 3);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "cebolla larga", "cebolla larga x libras", 20, "kilogramo", 3);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "papa sabanera", "papa sabanera x libras", 8, "bulto", 3);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("diana", 1, "frijol bola roja", "frijol bola roja x libra", 17, "unidad", 5);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("diana", 1, "garbanzo", "garbanzo por libra", 24, "unidad", 5);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("aseito", 1, "escoba azul", "escoba azul de cerdas blandas", 9, "unidad", 7);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("aseito", 1, "trapero redondo", "trapero  redondo blaco y negro", 9, "unidad", 7);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("3d", 1, "detergente 3d eucalipto", "bolsa de detergente 3d eucalipto x 1000gr", 15, "unidad", 7);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("fab", 1, "fab ultra concentrado", "fab liquido ultra concentrado x 400ml", 12, "unidad", 7);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("ariel", 1, "ariel liquido", "jabon ariel liquido por 1l", 20, "unidad", 7);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("gatitox", 1, "arena para gatos", "arena para gatos por bulto", 3, "bultos", 11);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "Manzana", "Manzana fresca y deliciosa", 100, "unidades", 2);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "Banana", "Banana madura y nutritiva", 150, "manojos", 2);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "Zanahoria", "Zanahoria fresca y crujiente", 120, "kilogramos", 3);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "Lechuga", "Lechuga verde y saludable", 80, "unidad", 3);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "Pollo", "Pechuga de pollo sin hueso", 50, "kilogramos", 10);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values (null, 1, "Res", "Filete de res de alta calidad", 30, "kilogramos", 10);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("Harina Co", 1, "Harina de trigo", "Harina de trigo para hornear", 200, "kilogramos", 4);
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("Diana", 1, "Arroz", "Arroz Diana", "3", "unidad", "1");
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("Margarita", 1, "Papas Tomate", "Papas sabor Tomate", "6", "unidad", "9");
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("Trululu", 1, "Gomitas", "Gomas en forma de Osos", "9", "unidad", "9");
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("Coca-Cola", 1, "Coca-Cola", "Coca-Cola grande", "12", "unidad", "9");
insert into producto (marca_producto, estado, nombre_producto, descripcion_producto, cantidad_producto, medida, id_categoria) values ("Chao", 1, "Mentas", "Mentas Chao", "15", "unidad", "9");

select * from producto;

-- INSERTS A LA TABLA DETALLE_SALIDA

insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (5000, 2, 1, 3);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (2500, 5, 2, 7);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (1000, 10, 3, 9);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (15000, 1, 4, 12);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (8000, 3, 5, 8);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (4500, 4, 6, 1);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (1500, 8, 7, 5);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (2000, 2, 8, 3);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (3000, 6, 9, 4);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (5000, 20, 10, 8);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (1000, 3, 11, 12);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (7000, 2, 12, 14);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (8000, 15, 13, 15);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (6000, 4, 14, 13);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values (1800, 7, 15, 1);
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values ("3000", "3", "1", "1");
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values ("2000", "6", "2", "2");
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values ("500", "9", "3", "3");
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values ("6000", "12", "4", "4");
insert into detalle_salida (precio_item_vendido, cantidad_item_vendido, id_salida, id_producto) values ("200", "15", "5", "5");

select * from detalle_salida;

-- INSERTS A LA TABLA SALIDA

insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-08-16 10:30:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2022-12-25 15:00:00", 2);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2021-04-05 08:45:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-02-14 18:20:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2022-06-30 12:00:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-01-01 00:00:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2022-09-10 09:15:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2021-11-20 21:30:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-03-08 16:05:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2022-05-15 14:45:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-07-07 08:00:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2022-10-03 11:10:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2021-12-31 23:59:59", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-04-22 05:30:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-04-22 05:30:00", 1);
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-08-21-10-30-24", "1");
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-08-21-10-35-20", "2");
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-08-21-11-30-54", "3");
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-08-21-11-56-08", "4");
insert into salida (fecha_hora_salidaa, id_usuario) values ("2023-08-21-12-12-12", "5");

select * from salida;

-- INSERTS A LA TABLA CATEGORIA

insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("lacteos", "aqui hay lacteos" , "");
insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("frutas", "aqui hay frutas", "");
insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("verduras", "aqui hay verduras", "");
insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("harinas", "aqui hay harinas");
insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("grano", "aqui hay granos");
insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("papeleria", "aqui hay papeleria");
insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("aseo", "aqui hay de aseo");
insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("hortalizas", "aqui hay hortalizas ");
insert into categoria (nombre_categoria, descripcion_categoria, imagen) values ("paquetes procesados", "aqui hay papitas y comida chatarra");
insert into categoria (nombre_categoria, descripcion_categoria) values ("carnes", "aqui hay carnes de animales ");
insert into categoria (nombre_categoria, descripcion_categoria) values ("mascotas", "cositas para tus mascoticas");
insert into categoria (nombre_categoria, descripcion_categoria) values ("Arroz", "Arroz blanco");
insert into categoria (nombre_categoria, descripcion_categoria) values ("Papas", "Paquete de papas");

select * from categoria;

-- INSERTS A LA TABLA ENTRADA

insert into entrada (fecha_entrada, id_proveedor) values ("2023-09-20 14:30:00", 1);
insert into entrada (fecha_entrada, id_proveedor) values ("2022-11-10 09:00:00", 4);
insert into entrada (fecha_entrada, id_proveedor) values ("2021-07-18 16:45:00", 2);
insert into entrada (fecha_entrada, id_proveedor) values ("2023-03-05 21:10:00", 5);
insert into entrada (fecha_entrada, id_proveedor) values ("2022-05-28 11:30:00", 7);
insert into entrada (fecha_entrada, id_proveedor) values ("2023-01-15 08:20:00", 8);
insert into entrada (fecha_entrada, id_proveedor) values ("2022-10-02 13:15:00", 1);
insert into entrada (fecha_entrada, id_proveedor) values ("2021-12-12 19:45:00", 4);
insert into entrada (fecha_entrada, id_proveedor) values ("2023-04-08 10:55:00", 6);
insert into entrada (fecha_entrada, id_proveedor) values ("2022-06-14 17:30:00", 2);
insert into entrada (fecha_entrada, id_proveedor) values ("2023-08-07 06:25:00", 7);
insert into entrada (fecha_entrada, id_proveedor) values ("2022-02-25 12:40:00", 9);
insert into entrada (fecha_entrada, id_proveedor) values ("2021-11-01 22:15:00", 1);
insert into entrada (fecha_entrada, id_proveedor) values ("2023-05-10 07:50:00", 4);
insert into entrada (fecha_entrada, id_proveedor) values ("2022-03-22 18:05:00", 2);
insert into entrada (fecha_entrada, id_proveedor) values ("2023-08-15-06-30-12", "1");
insert into entrada (fecha_entrada, id_proveedor) values ("2023-08-15-07-30-22", "2");
insert into entrada (fecha_entrada, id_proveedor) values ("2023-08-15-08-30-24", "3");
insert into entrada (fecha_entrada, id_proveedor) values ("2023-08-15-09-30-30", "4");
insert into entrada (fecha_entrada, id_proveedor) values ("2023-08-15-10-30-01", "5");

select * from entrada;