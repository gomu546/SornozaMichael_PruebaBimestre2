-- database: ../Databases/SornozaMichael_antCiberDron.sqlite

-- 1. LIMPIEZA
DROP VIEW IF EXISTS vwHormiga;
DROP TABLE IF EXISTS SornozaMichael_Hormiga;
DROP TABLE IF EXISTS SornozaMichael_HormigaTipo;
DROP TABLE IF EXISTS SornozaMichael_AlimentoTipo;

-- 2. TABLA ALIMENTO TIPO
CREATE TABLE SornozaMichael_AlimentoTipo (
    SornozaMichael_IdAlimentoTipo INTEGER PRIMARY KEY AUTOINCREMENT,
    SornozaMichael_Nombre         VARCHAR(20) NOT NULL UNIQUE,
    SornozaMichael_Descripcion    VARCHAR(100) NULL,
    SornozaMichael_Estado         VARCHAR(1) NOT NULL DEFAULT 'A',
    SornozaMichael_FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    SornozaMichael_FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);

-- 3. TABLA HORMIGA TIPO
CREATE TABLE SornozaMichael_HormigaTipo (
    SornozaMichael_IdHormigaTipo INTEGER PRIMARY KEY AUTOINCREMENT,
    SornozaMichael_Nombre        VARCHAR(20) NOT NULL UNIQUE,
    SornozaMichael_Descripcion   VARCHAR(100) NULL,
    SornozaMichael_Estado        VARCHAR(1) NOT NULL DEFAULT 'A',
    SornozaMichael_FechaCreacion  DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    SornozaMichael_FechaModifica  DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);

-- 4. TABLA HORMIGA (Persistencia principal)
CREATE TABLE SornozaMichael_Hormiga (
    SornozaMichael_IdHormiga      INTEGER PRIMARY KEY AUTOINCREMENT,
    SornozaMichael_IdHormigaTipo  INTEGER NOT NULL REFERENCES SornozaMichael_HormigaTipo (SornozaMichael_IdHormigaTipo),
    SornozaMichael_IdAlimentoTipo INTEGER NOT NULL REFERENCES SornozaMichael_AlimentoTipo (SornozaMichael_IdAlimentoTipo),
    SornozaMichael_Nombre         VARCHAR(30) NOT NULL,
    SornozaMichael_Descripcion    VARCHAR(200) NULL, 
    SornozaMichael_Estado         VARCHAR(1) NOT NULL DEFAULT 'A', 
    SornozaMichael_FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    SornozaMichael_FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);

-- 5. DATOS MAESTROS (Con descripciones)
INSERT INTO SornozaMichael_AlimentoTipo (SornozaMichael_Nombre, SornozaMichael_Descripcion)
VALUES 
    ('Carnivoro', 'Se alimenta de otros insectos o proteinas animal'),
    ('Herbivoro', 'Se alimenta de plantas, hojas y semillas'),
    ('Omnivoro', 'Alimentacion mixta variada'),
    ('Nectarivoro', 'Se alimenta de nectar y liquidos dulces'),
    ('Insectivoro', 'Dieta basada exclusivamente en insectos');

INSERT INTO SornozaMichael_HormigaTipo (SornozaMichael_Nombre, SornozaMichael_Descripcion)
VALUES 
    ('HLarva', 'Estado inmaduro de la hormiga'),
    ('HSoldado', 'Especializada en la defensa de la colonia'),
    ('HRastreadora', 'Encargada de buscar rutas y comida'),
    ('HReina', 'Unica hembra fertil de la colonia'),
    ('HObrera', 'Realiza tareas de mantenimiento y cuidado'),
    ('HZangano', 'Macho encargado de la reproduccion');

-- 6. VISTA PARA EL REPORTE FINAL
CREATE VIEW vwHormiga AS
SELECT 
    h.SornozaMichael_IdHormiga AS ID,
    h.SornozaMichael_Nombre AS Nombre,
    h.SornozaMichael_Descripcion AS Hormiga_Detalle,
    ht.SornozaMichael_Nombre AS Tipo,
    at.SornozaMichael_Nombre AS Alimento,
    h.SornozaMichael_Estado AS Estado,
    h.SornozaMichael_FechaModifica AS Ultima_Actualizacion
FROM SornozaMichael_Hormiga h
JOIN SornozaMichael_HormigaTipo ht ON h.SornozaMichael_IdHormigaTipo = ht.SornozaMichael_IdHormigaTipo
JOIN SornozaMichael_AlimentoTipo at ON h.SornozaMichael_IdAlimentoTipo = at.SornozaMichael_IdAlimentoTipo;