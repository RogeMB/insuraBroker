INSERT INTO EMPLEADO (id_empleado, nombre, apellidos, dni, imagen, fecha_nacimiento, telefono, email, fecha_alta, cargo, salario) 
    VALUES (NEXTVAL('hibernate_sequence'), 'Rogelio', 'Mohigefer Barrera', '11122233Q', '', '1989-06-09', '612312323', 'rogelio@gmail.com', '2020-01-01', 
    'null', 'director', '40550');
INSERT INTO EMPLEADO (id_empleado, nombre, apellidos, dni, imagen, fecha_nacimiento, telefono, email, fecha_alta, cargo, salario)
    VALUES (NEXTVAL('hibernate_sequence'), 'Sergio', 'Jiménez Toledo', '22122122R', '', '1990-07-15', '645894561', 'sergiojimenez@gmail.com', '2020-02-15', 
    'null', 'Gestor', '20350');
INSERT INTO EMPLEADO (id_empleado, nombre, apellidos, dni, imagen, fecha_nacimiento, telefono, email, fecha_alta, cargo, salario) 
    VALUES (NEXTVAL('hibernate_sequence'), 'María', 'Troyano Ballesteros', '31212351A', '', '1993-03-21', '687941358', 'mariatroyano@gmail.com', '2020-03-21',
    'null', 'Asesor', '35000');
INSERT INTO EMPLEADO (id_empleado, nombre, apellidos, dni, imagen, fecha_nacimiento, telefono, email, fecha_alta, cargo, salario) 
    VALUES (NEXTVAL('hibernate_sequence'), 'Eva', 'Reyes Trigo', '75516387J', '', '1998-12-04', '678159753', 'evareyes@gmail.com', '2020-05-09', 
    'null', 'Gestor', '20350');

INSERT INTO CATEGORIA (id_categoria, nombre) VALUES (NEXTVAL('hibernate_sequence'), 'Auto');
INSERT INTO CATEGORIA (id_categoria, nombre) VALUES (NEXTVAL('hibernate_sequence'), 'Hogar');
INSERT INTO CATEGORIA (id_categoria, nombre) VALUES (NEXTVAL('hibernate_sequence'), 'Salud');

INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '1', 'Bronce', '30000', 'Mapfre', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, icono, empresa) 
    VALUES (NEXTVAL('hibernate_sequence'), '1', 'Plata', '50000', 'Mapfre', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, icono, empresa) 
    VALUES (NEXTVAL('hibernate_sequence'), '1', 'Oro', '100000',  'Mapfre', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '2', 'Bronce', '80000', 'Mapfre', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '2', 'Plata', '200000', 'Mapfre', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '2', 'Oro', '500000', 'Mapfre', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '3', 'Bronce', '10000', 'Mapfre', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '3', 'Plata', '30000', 'Mapfre', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '3', 'Oro', '50000', 'Mapfre', 'null');

INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '1', 'Bronce', '25000', 'Allianz', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, icono, empresa) 
    VALUES (NEXTVAL('hibernate_sequence'), '1', 'Plata', '40000', 'Allianz', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, icono, empresa) 
    VALUES (NEXTVAL('hibernate_sequence'), '1', 'Oro', '80000',  'Allianz', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '2', 'Bronce', '70000', 'Allianz', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '2', 'Plata', '180000', 'Allianz', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '2', 'Oro', '450000', 'Allianz', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '3', 'Bronce', '10000', 'Allianz', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '3', 'Plata', '20000', 'Allianz', 'null');
INSERT INTO SEGUROS (id_seguro, id_categoria, tipo, cantidad_asegurada, empresa, icono) 
    VALUES (NEXTVAL('hibernate_sequence'), '3', 'Oro', '40000', 'Allianz', 'null');





ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;