-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-04-2019 a las 10:51:46
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `megatheater-app`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('luis', 'EDITOR'),
('marisol', 'GERENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banners`
--

CREATE TABLE `banners` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `archivo` varchar(250) NOT NULL,
  `status` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `banners`
--

INSERT INTO `banners` (`id`, `titulo`, `fecha`, `archivo`, `status`) VALUES
(1, 'Estreno - Kong La Isla Calavera', '2019-04-01', 'slide1.jpg', 'Inactivo'),
(2, 'Proximo Mes - La bella y la bestia', '2019-04-02', 'slide2.jpg', 'Inactivo'),
(3, 'Ya esta aquí - Spider Man, de regreso a casa', '2017-07-28', 'slide3.jpg', 'Activo'),
(4, 'Por fin ha llegado el día - Cars 3 ', '2017-07-29', 'slide4.jpg', 'Activo'),
(5, 'El rey arturo de regreso', '2019-03-29', 'slide7INGJD8EV.jpg', 'Activo'),
(6, 'Un golpe con estilo', '2019-03-29', 'slide5YHHO2FP8.jpg', 'Activo'),
(8, 'Alien la revancha', '2019-04-01', 'slide6BD2ROUVS.jpg', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `id` int(11) NOT NULL,
  `director` varchar(100) DEFAULT NULL,
  `actores` varchar(255) DEFAULT NULL,
  `sinopsis` text,
  `trailer` varchar(255) DEFAULT NULL COMMENT 'URL del video en Youtube\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalles`
--

INSERT INTO `detalles` (`id`, `director`, `actores`, `sinopsis`, `trailer`) VALUES
(1, 'Jordan Vogt-Roberts', 'Samuel L. Jackson,Tom Hiddleston,Brie Larson,Toby Kebbell', 'Kong: La Isla Calavera reimagina el origen del mÃ?Â­tico Kong en una irresistible aventura original del director Jordan Vogt-Roberts. En la pelÃ?Â­cula, un diverso equipo de exploradores es reunido para aventurarse en el interior de una isla del PacÃ?Â­fico Ã¢??tan bella como traicioneraÃ¢?? que no aparece en los mapas, sin saber que estÃ?Â¡n invadiendo los dominios del mÃ?Â­tico Kong.', 'https://www.youtube.com/embed/86jhW2gPc84'),
(2, 'Daniel Espinosa', 'Jake Gyllenhaal, Ryan Reynolds, Rebecca Ferguson', 'Seis miembros de la tripulaciÃ³n de la EstaciÃ³n Espacial Internacional que estÃ¡n a punto de lograr uno de los descubrimientos mÃ¡s importantes en la historia humana: la primera evidencia de vida extraterrestre en Marte. A medida que el equipo comienza a investigar y sus mÃ©todos tienen consecuencias inesperadas, la forma viviente demostrarÃ¡ ser mÃ¡s inteligente de lo que cualquiera esperaba.', 'https://www.youtube.com/embed/_cq1XIVXdjU'),
(3, 'Bill Condon', 'Dan Stevens,Emma Watson,Luke Evans', 'LA BELLA Y LA BESTIA, de Disney, es una adaptación de acción real de la película animada, que revive a los queridos personajes del clásico cuento de Disney para una audiencia contemporánea, manteniendo la música original e incorporando varias nuevas canciones.', 'https://www.youtube.com/embed/4D8N06nx9rs'),
(4, 'Oriol Paulo', 'Mario Casas, Bárbara Lennie, José Coronado, Ana Wagener', 'Adrián Doria, un joven y exitoso empresario, despierta en la habitación de un hotel junto al cadáver de su amante. Acusado de asesinato, decide contratar los servicios de Virginia Goodman, la mejor preparadora de testigos del país. En el transcurso de una noche, asesora y cliente trabajarán para encontrar una duda razonable que le libre de la cárcel.', 'https://www.youtube.com/embed/sOxy2gtPY7A'),
(5, 'Dean Israelite', 'Bryan Cranston, Elizabeth Banks, Becky G, Dacre Montgomery', 'Cinco adolescentes deben convertirse en algo extraordinario al enterarse que su pueblo, Angel Grove, y el mundo estÃ¡n a punto de ser aniquilados por una amenaza extraterrestre. Escogidos por el destino, nuestros hÃ©roes pronto descubren que son los Ãºnicos que pueden salvar el planetaâ?¦pero para hacerlo, deberÃ¡n superar sus problemas de la vida real y, antes que sea demasiado tarde, unirse como los PowerRangers.', 'https://www.youtube.com/embed/gemUEi0XMTg'),
(6, 'F. Gary Gray', 'Dwayne Johnson,Michelle Rodriguez,Charlize Theron,Jason Statham,Vin Diesel', 'Justo cuando Dom y Letty celebran su luna de miel, Brian y Mia se han retirado del juego y el resto del equipo se ha desintegrado en busca de una vida comun y corriente; una misteriosa mujer intentara seducir a Dom para convencerlo de regresar a la vida criminal que tanto lo acecha, traicionando a quienes lo rodean y enfrentandose a retos nunca antes vistos.', 'https://www.youtube.com/embed/3KuazYQ1JuE'),
(7, 'James Gunn', 'Dave Bautista,Bradley Cooper,Zoe Saldana,Vin Diesel,Chris Pratt', 'Ambientada en el nuevo contexto sonoro de \"Awesome Mixtape #2\", GUARDIANES DE LA GALAXIA VOL. 2, de Marvel, continua las aventuras del equipo en su travesia por los confines del cosmos. Los Guardianes deberan luchar para mantener unida a su nueva familia mientras intentan resolver el misterio del verdadero linaje de Peter Quill. Viejos rivales se convertiran en nuevos aliados y los personajes favoritos de los comics clasicos acudiran en ayuda de nuestros heroes a medida que el Universo Cinematografico de Marvel continua expandiendose.', 'https://www.youtube.com/embed/bBTtlcJwjSo'),
(9, 'yukihiro matsumoto', 'nobody', 'lorem ipsum dolor sit amet', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `sala` varchar(100) NOT NULL,
  `precio` double NOT NULL DEFAULT '0',
  `idPelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`id`, `fecha`, `hora`, `sala`, `precio`, `idPelicula`) VALUES
(111, '2019-03-28', '18:00:00', 'Premium', 120, 1),
(112, '2019-03-28', '20:00:00', 'Sala 2', 120, 1),
(113, '2019-03-28', '00:00:21', 'Premium', 200, 1),
(114, '2019-03-29', '17:00:00', 'Premium', 200, 1),
(115, '2019-03-29', '18:30:00', 'Sala 2', 150, 1),
(116, '2019-03-30', '18:30:00', 'Sala 1', 120, 1),
(117, '2019-03-29', '18:00:00', 'Sala 3', 150, 2),
(118, '2019-03-29', '10:00:00', 'Sala 1', 210, 2),
(119, '2019-03-30', '17:00:00', 'Premium', 210, 2),
(120, '2019-03-31', '10:00:00', 'Premium', 200, 3),
(121, '2019-03-30', '21:30:00', 'Premium', 200, 4),
(122, '2019-04-02', '18:30:00', 'Premium', 200, 4),
(123, '2019-04-03', '21:30:00', 'Sala 2', 120, 1),
(124, '2019-04-02', '10:00:00', 'Premium', 120, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticias`
--

CREATE TABLE `noticias` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `detalle` text NOT NULL,
  `status` enum('Activa','Inactiva') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `noticias`
--

INSERT INTO `noticias` (`id`, `titulo`, `fecha`, `detalle`, `status`) VALUES
(1, 'Bob Esponja: tercera pelicula y temporada 12 y 13', '2019-03-29', '<p><strong><span style=\"color: #ff0000;\">Nickelodeon y productor de SpongeBob Square Pants confirman temporada 12 de 52 episodios y tercera pel&iacute;cula pr&oacute;ximamente. </span></strong></p>\r\n<p><strong>&iexcl;Calamardo est&aacute; enojado!Bob Esponja: tercera pel&iacute;cula y temporada 12</strong></p>\r\n<p>Nickelodeon y productor de SpongeBob Square Pants confirman temporada 12 de 52 episodios y tercera pel&iacute;cula pr&oacute;ximamente. &iexcl;Calamardo est&aacute; enojado!.</p>\r\n<p>A lado de cierta Pi&ntilde;a (debajo del mar), Calamardo debe estar de muy mal humor, pues hay Bob Esponja para rato... &iexcl;y por partida doble!. Por un lado, Vincent Waller (The Ren &amp; Stimpy Show), artista, productor, escritor y supervisor creativo de SpongeBob Squarepants anunci&oacute; con un divertido dibujo desde su cuenta de Twitter que, antes de que se estrene siquiera la temporada 11 de la serie animada, se ha confirmado ya la n&uacute;mero 12, &iexcl;que constar&aacute; de 52 episodios (recuerden que cada emisi&oacute;n consta de 2 aventuras)!</p>', 'Activa'),
(2, 'Julia Roberts protagonizara. The Bookseller', '2017-10-23', '<p>La novela de Cynthia Swanson <span style=\"color: #0000ff;\"><strong>The Bookseller</strong></span> ser&aacute; llevada al cine con <span style=\"color: #0000ff;\">Julia Roberts (Los Pitufos: La aldea Escondida)</span> como protagonista.<br /><br />La historia est&aacute; ambientada en los sesenta y su protagonista es una mujer soltera, Kitty Miller, que lleva una librer&iacute;a. Sue&ntilde;a con una vida alternativa en la que ha encontrado el amor y est&aacute; casada y con hijos, pero la l&iacute;nea que separa realidad y ficci&oacute;n comienza a estar demasiado dispersa para que la distinga.<br /><br />Seg&uacute;n informa <span style=\"color: #ff0000;\"><strong>Moviehole</strong></span> Roberts tambi&eacute;n producir&aacute; la pel&iacute;cula junto a Lisa Gillan y Marisa Yeres Hill.</p>', 'Activa'),
(3, 'Rosamund Pike sera Marie Curie en la nueva serie de HBO', '2019-03-29', '<p><strong>Rosamund Pike</strong> (<span style=\"color: #008000;\">Un Reino Unido</span>) dar&aacute; vida a la famosa cient&iacute;fica Marie Curie en la pel&iacute;cula de Studiocanal <strong>Radioactiv</strong>. Se trata de una adaptaci&oacute;n de la biograf&iacute;a escrita por Lauren Redniss, que se centra en el romance entre Marie y Pierre Curie y en el descubrimiento de la radiactividad.<br /><br />Seg&uacute;n informa <span style=\"color: #008000;\"><strong>Premiere</strong></span> el proceso de casting para los papeles de Pierre y de Paul Langevin, su joven amante, ya ha comenzado.<br /><br />Marjane Satrapi dirigir&aacute; a partir de un gui&oacute;n de Jack Thorne. Tim Bevan, Eric Fellner y Paul Webster producir&aacute;n la pel&iacute;cula.</p>', 'Inactiva'),
(4, 'Julianne Moore sera Gloria', '2017-10-25', '<p><strong><span style=\"color: #0000ff;\">Julianne Moore</span></strong> <span style=\"color: #808080;\">(Kingsman: El C&iacute;rculo de Oro)</span> protagonizar&aacute; el remake de FilmNation de la pel&iacute;cula chilena <em><strong>Gloria</strong></em>.<br /><br />Sebastian Lelio, director de la pel&iacute;cula original, escribir&aacute; el gui&oacute;n del remake, que todav&iacute;a no tiene t&iacute;tulo.<br /><br />Moore ser&aacute; Gloria, una mujer de 58 a&ntilde;os que est&aacute; sola en la vida. Para compensar el vac&iacute;o, llena sus d&iacute;as de actividades y por las noches busca el amor en el mundo de las fiestas para solteros adultos, donde solo consigue perderse en una serie de aventuras sin sentido. Esta fr&aacute;gil felicidad en la que vive se altera cuando conoce a Rodolfo, un hombre de 65 a&ntilde;os, recientemente separado, que se obsesiona con ella. Gloria comienza un romance, pero &eacute;ste se complica por la enfermiza dependencia de Rodolfo hacia sus hijos y su ex mujer. Esta relaci&oacute;n, a la que Gloria se entrega porque intuye que podr&iacute;a ser la &uacute;ltima, acabar&aacute; por hacerla estrellarse contra la cruel realidad del mundo. Gloria deber&aacute; reconstruirse para enfrentar con nuevas fuerzas su definitiva entrada a la vejez.<br /><br />Seg&uacute;n <span style=\"color: #008000;\"><strong>The Hollywood Reporter</strong> </span>Juan de Dios Larrain y Pablo Larrain producir&aacute;n la cinta, que comenzar&aacute; a rodarse a finales de mes.</p>', 'Activa'),
(5, 'Esta es una nueva Noticia', '2019-03-29', '<p><strong>pepe peca pica papas</strong></p>\r\n<ul>\r\n<li>pica papas pepe pecas</li>\r\n<li>pica papas pepe pecas x2</li>\r\n</ul>', 'Activa'),
(6, 'Otra noticia de pepe', '2019-03-29', '<p><strong>pepe peca pica papas</strong></p>\r\n<ul>\r\n<li>pica papas pepe pecas</li>\r\n<li>pica papas pepe pecas x2</li>\r\n<li>pica papas pepe pecas x3</li>\r\n<li>pica papas pepe pecas x4</li>\r\n</ul>', 'Activa'),
(7, 'Nueva serie sobre gears of war en 2020', '2019-03-29', '<p>pica papas pepe pecas x2pica papas pepe pecas x2pica papas pepe pecas x2pica papas pepe pecas x2pica papas pepe pecas x2</p>\r\n<p>&nbsp;</p>\r\n<p><strong><em>pica papas pepe pecas x2</em></strong></p>', 'Activa'),
(9, 'Una nueva noticia x2', '2019-03-29', '<p>lorem ipsum dolor sit amet</p>', 'Activa'),
(10, 'Rosamund Pike sera Marie Curie en la nueva serie de HBO', '2019-04-01', '<p>sdsdf saf sdf&nbsp; sdfs</p>\r\n<p>s</p>\r\n<p>sdf</p>\r\n<p>&nbsp;fsd</p>\r\n<p>f sd</p>\r\n<p>fsd</p>\r\n<p>fd s</p>\r\n<p>fsd</p>', 'Activa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `duracion` int(11) NOT NULL,
  `clasificacion` enum('A','B','C') NOT NULL,
  `genero` varchar(45) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `fechaEstreno` date NOT NULL,
  `status` enum('Activa','Inactiva') NOT NULL DEFAULT 'Activa',
  `idDetalle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `titulo`, `duracion`, `clasificacion`, `genero`, `imagen`, `fechaEstreno`, `status`, `idDetalle`) VALUES
(1, 'Kong La Isla Calavera', 118, 'B', 'Accion', 'kong.png', '2017-10-18', 'Activa', 1),
(2, 'Life: Vida Inteligente', 104, 'B', 'Drama', 'estreno5FIUNV101.png', '2017-10-19', 'Activa', 2),
(3, 'La Bella y La Bestia', 132, 'A', 'Infantil', 'bella.png', '2017-10-20', 'Activa', 3),
(4, 'Contratiempo', 106, 'B', 'Thriller', 'contratiempo.png', '2017-10-22', 'Activa', 4),
(5, 'Power Rangers', 120, 'B', 'Aventura', 'power-rangers.png', '2017-10-21', 'Inactiva', 5),
(7, 'Rapidos y Furiosos 8', 136, 'B', 'Accion', 'estreno9ZH9DG2O0.png', '2017-10-23', 'Activa', 6),
(8, 'Guardianes de la Galaxia Vol 2', 136, 'B', 'Accion', 'estreno10ZOLT94ER.png', '2017-10-19', 'Activa', 7),
(10, 'En un rincon del mundo', 100, 'B', 'Accion', 'estreno13Y5E6QKY.png', '2019-04-23', 'Activa', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE `perfiles` (
  `username` varchar(100) NOT NULL,
  `perfil` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`username`, `perfil`) VALUES
('eduardo', 'GERENTE'),
('marisol', 'EDITOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('luis', '{noop}luis123', 1),
('marisol', '{noop}mari123', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `username` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `password` varchar(250) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`username`, `nombre`, `apellidos`, `email`, `telefono`, `status`, `password`, `created_at`) VALUES
('eduardo', 'Eduardo', 'Rasgado', 'eduardo.rasgado@hotmail.com', '917237212', 1, '{noop}gabagabahey', '2019-04-03 00:00:00'),
('marisol', 'Marisol', 'Melendez', 'marisol_melendez@gmail.com', '4421223432', 1, '{noop}mari123', '2019-04-03 02:36:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `authorities`
--
ALTER TABLE `authorities`
  ADD UNIQUE KEY `authorities_idx_1` (`username`,`authority`);

--
-- Indices de la tabla `banners`
--
ALTER TABLE `banners`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Horarios_Peliculas1_idx` (`idPelicula`);

--
-- Indices de la tabla `noticias`
--
ALTER TABLE `noticias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Peliculas_Detalles1_idx` (`idDetalle`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD UNIQUE KEY `usuarios.username` (`username`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`username`) USING BTREE,
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `banners`
--
ALTER TABLE `banners`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- AUTO_INCREMENT de la tabla `noticias`
--
ALTER TABLE `noticias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `fk_Horarios_Peliculas1` FOREIGN KEY (`idPelicula`) REFERENCES `peliculas` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD CONSTRAINT `fk_Peliculas_Detalles1` FOREIGN KEY (`idDetalle`) REFERENCES `detalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
