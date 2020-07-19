CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `gerencia` (
  `idgerencia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idgerencia`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=latin1;

CREATE TABLE `departamento` (
  `iddepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `presta_servicio` tinyint(4) NOT NULL,
  `idgerencia` int(11) NOT NULL,
  PRIMARY KEY (`iddepartamento`),
  KEY `fk_depto_gerencia_idx` (`idgerencia`),
  CONSTRAINT `fk_depto_gerencia` FOREIGN KEY (`idgerencia`) REFERENCES `gerencia` (`idgerencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

CREATE TABLE `encargado` (
  `idencargado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `iddepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idencargado`),
  KEY `fk_encargado_departamento_idx` (`iddepartamento`),
  CONSTRAINT `fk_encargado_departamento` FOREIGN KEY (`iddepartamento`) REFERENCES `departamento` (`iddepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE `requerimiento` (
  `idrequerimiento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `id_depto_origen` int(11) NOT NULL,
  `id_depto_asignado` int(11) NOT NULL,
  PRIMARY KEY (`idrequerimiento`),
  KEY `fk_requerimiento_depto_origen_idx` (`id_depto_origen`),
  KEY `fk_req_depto_asignado_idx` (`id_depto_asignado`),
  CONSTRAINT `fk_req_depto_asignado` FOREIGN KEY (`id_depto_asignado`) REFERENCES `departamento` (`iddepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_req_depto_origen` FOREIGN KEY (`id_depto_origen`) REFERENCES `departamento` (`iddepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO gerencia (nombre)
VALUES ('Logística'),
('Administración'),
('Comercial'),
('TIC');

INSERT INTO departamento (nombre, presta_servicio, idgerencia)
VALUES ('Recepción', 0, 1), 
('Despacho', 0, 1),
('Inventario', 0, 1),
('Compras', 1, 1),
('Cajas', 0, 2), 
('Prevención', 0, 2),
('Servicio al Consumidor', 0, 2),
('Venta a Empresas', 0, 3), 
('Venta al Detalle', 0, 3),
('Soporte Técnico', 1, 4),
('Redes y Comunicación', 1, 4),
('Desarrollo', 0, 4),
('Testing', 0, 4);

INSERT INTO encargado (nombre, apellido, iddepartamento)
VALUES ('Bill', 'Gates', 4),
('Jack', 'Ma', 1),
('Jeff', 'Bezos', 1),
('Mark', 'Zuckerberg', 4),
('Steve', 'Jobs', 1),
('Elon', 'Musk', 4),
('Zhang', 'Yiming', 4);


INSERT INTO gerencia
VALUES (123,'ena');