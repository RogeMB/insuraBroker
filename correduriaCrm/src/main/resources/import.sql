INSERT INTO CATEGORIA (id_categoria, nombre) VALUES (NEXTVAL('hibernate_sequence'), 'Auto');
INSERT INTO CATEGORIA (id_categoria, nombre) VALUES (NEXTVAL('hibernate_sequence'), 'Hogar');
INSERT INTO CATEGORIA (id_categoria, nombre) VALUES (NEXTVAL('hibernate_sequence'), 'Salud');

INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '1', 'Bronce', 30000, 350,'Mapfre');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '1', 'Plata', 50000, 500, 'Mapfre');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '1', 'Oro', 100000, 850, 'Mapfre');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '2', 'Bronce', 80000, 180, 'Mapfre');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '2', 'Plata', 200000, 250, 'Mapfre');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '2', 'Oro', 500000, 350, 'Mapfre');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '3', 'Bronce', 1000, 380, 'Mapfre');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '3', 'Plata', 30000, 610, 'Mapfre');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '3', 'Oro', 50000, 920, 'Mapfre');

INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '1', 'Bronce', 25000, 300, 'Allianz');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '1', 'Plata', 40000, 450, 'Allianz');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '1', 'Oro', 80000, 780, 'Allianz');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '2', 'Bronce', 70000, 170, 'Allianz');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '2', 'Plata', 180000, 230, 'Allianz');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '2', 'Oro', 450000, 310, 'Allianz');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '3', 'Bronce', 10000, 385, 'Allianz');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '3', 'Plata', 20000, 500, 'Allianz');
INSERT INTO SEGURO (id_seguro, id_categoria, tipo, cantidad_asegurada, precio, empresa) VALUES (NEXTVAL('hibernate_sequence'), '3', 'Oro', 40000, 750, 'Allianz');


INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Charisse', 'Cicchitello Romani', '11111020V', '1981-02-08', '644274264' , 'cicchitello0@gmail.com', 'Mujer', '2022-01-22', true);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Marsha', 'Roswarne Gómez', '14314326M', '1988-07-07', '642928815' , 'mroswarne1@gmail.com', 'Mujer', '2021-08-14', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Lindie', 'Forlonge Martín', '13023813N', '1982-04-18', '605435540' , 'lforlonge2@gmail.com', 'Mujer', '2020-04-17', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Nicoli', 'Warland Cabezas', '20221137H', '1956-05-28', '603460515' , 'nwarland3@gmail.com', 'Mujer', '2020-04-23', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Elwin', 'Coopman Nadir', '19039203B', '1987-01-30', '631110877' , 'ecoopman4@gmail.com', 'Hombre', '2020-02-16', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Yale', 'Lody Gisel', '84269417H', '1975-05-21', '617282233' , 'ylody5@gmail.com', 'Hombre', '2020-08-03', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Brandy', 'Chessel Jujui', '19836169F', '1960-11-22', '632377125' , 'bchessel6@gmail.com', 'Hombre', '2020-03-05', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Dene', 'Allcroft Trejano', '12417985K', '1957-05-18', '610515273' , 'dallcroft7@gmail.com', 'Hombre', '2021-01-09', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'María', 'Crosscombe Maren', '16272494W', '1983-09-09', '693291484' , 'dcrosscombe8@gmail.com', 'Mujer', '2021-07-24', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Alyda', 'Barthod Gómez', '98322292L', '1980-02-23', '635919999' , 'abarthod9@gmail.com', 'Mujer', '2020-12-11', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Hartley', 'Loades Dimas', '41691261F', '1962-07-06', '678418018' , 'hloadesa@gmail.com', 'Hombre', '2021-05-14', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Bevian', 'Cuniam Tomares', '36912619F', '1987-09-14', '645235707' , 'bcuniamb@gmail.com', 'Hombre', '2021-05-13', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Laina', 'Scallan Sevilla', '49120325E', '1974-11-03', '625382996' , 'loscallanc@gmail.com', 'Mujer', '2021-06-20', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Morie', 'Feldbau Toledo', '15525086E', '1963-06-27', '623946725' , 'mfeldbaud@gmail.com', 'Hombre', '2021-05-05', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Marven', 'Wormell Hijen', '75070719T', '1988-01-01', '610031036' , 'mwormelle@gmail.com', 'Hombre', '2021-08-27', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Cherlyn', 'McNaught Jijen', '16821410W', '1991-12-10', '610593883' , 'cmcnaughtf@gmail.com', 'Mujer', '2020-05-22', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Vannie', 'Carnall Tijuana', '79853823W', '1959-05-02', '647648866' , 'vcarnallg@gmail.com', 'Mujer', '2020-01-30', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Torrin', 'Abbott Monin', '51825214H', '1975-02-23', '646968798' , 'tabbotth@gmail.com', 'Hombre', '2020-05-23', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Adlai', 'Gerrill Calci', '17613810A', '1971-03-17', '657537231' , 'agerrilli@gmail.com', 'Hombre', '2020-10-04', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Janek', 'Woodyatt Morat', '63371248J', '1956-03-01', '698668382' , 'jwoodyattj@gmail.com', 'Hombre', '2020-11-01', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Ana', 'Keefe Zamora', '44114354V', '1983-01-19', '699580279' , 'hokeefek@gmail.com', 'Mujer', '2021-08-24', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Eulalie', 'McLenahan Mazapa', '23824181Q', '1971-06-08', '624448519' , 'emclenahanl@gmail.com', 'Mujer', '2020-01-31', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Giustina', 'Izkovitz Valenzuela', '31421522G', '1965-06-18', '645186615' , 'gizkovitzm@gmail.com', 'Mujer', '2021-05-09', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Manolo', 'Takos Oro', '71979179Y', '1988-09-30', '656379562' , 'mtakosn@gmail.com', 'Hombre', '2021-07-07', false);
INSERT INTO CLIENTE (id_cliente, nombre, apellidos, dni, fecha_nacimiento, telefono, email, genero, fecha_alta, es_premium) VALUES (NEXTVAL('cliente_sequence'), 'Mario', 'Blessed Laciega', '08216623B', '1999-05-25', '674430710' , 'mblessedo@gmail.com', 'Hombre', '2022-02-18', false);


INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '17', '4', 'Rogelio', '2020-01-30', false, 423.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '22', '5', 'Rogelio', '2020-01-31', false, 605, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '5', '6', 'Rogelio', '2020-02-16', false, 1028.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '7', '7', 'Sergio', '2020-03-05', false, 217.8, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '3', '8', 'Sergio', '2020-04-17', false, 302.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '4',  '9', 'María', '2020-04-23', false, 423.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '16', '10', 'María', '2020-05-22', false, 459.8, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '18', '11', 'María', '2020-05-23', false, 738.1, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '6', '12', 'Sergio', '2020-08-03', false, 1113.2, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '19', '13', 'Eva', '2020-10-04', false, 363, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '20', '14', 'Eva', '2020-11-01', false, 544.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '10', '15', 'Rogelio', '2020-12-11', false, 943.8, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '8',  '16', 'Eva', '2021-01-09', false, 205.7, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '14', '17', 'Eva', '2021-05-05', false, 278.3, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '23', '18', 'María', '2021-05-09', false, 375.1, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '12', '19', 'Rogelio', '2021-05-13', false, 465.85, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '11', '20', 'Sergio', '2021-05-14', false, 605, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '13', '21', 'Sergio', '2021-06-20', true, 907.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '24', '4', 'Eva', '2021-07-07', true, 423.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '9', '13', 'Sergio', '2021-07-24', true,  363, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '2', '14', 'María', '2021-08-14', true, 544.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '21', '14', 'Sergio', '2021-08-24', true, 544.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '15', '7', 'Eva', '2021-08-27', true, 217.8, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '1', '8', 'María', '2022-01-22', true,  302.5, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '25', '11', 'Eva', '2022-02-18', true, 738.1, 0);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '1', '5', 'Sergio', '2022-03-02', true, 453.75, 25);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '2', '17', 'María', '2022-03-11', true, 208.73, 25);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '24', '19', 'Eva', '2022-04-28', true, 349.39, 25);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '9', '18', 'Rogelio', '2022-05-13', true, 281.33, 25);
INSERT INTO VENTA (id_venta, id_cliente, id_seguro, empleado, fecha_venta, es_activo, precio_venta, descuento) VALUES (NEXTVAL('hibernate_sequence'), '1', '11', 'Sergio', '2022-05-19', true, 479.77, 35);


ALTER SEQUENCE hibernate_sequence RESTART WITH 500;
