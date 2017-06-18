/* Script proyecto final 2017 */
/* Alejandro Macías Alcázar */


PRAGMA foreign_keys = ON;


DROP TABLE IF EXISTS LIBROS;

CREATE TABLE LIBROS
(
ISBN            TEXT PRIMARY KEY,
TITULO          TEXT NOT NULL,
AUTORES         TEXT,
TEMATICAS       TEXT NOT NULL
);



DROP TABLE IF EXISTS EJEMPLARES;

CREATE TABLE EJEMPLARES
(
ID_EJEMPLAR     INTEGER,
ISBN            TEXT,
EDITORIAL       TEXT,
EDICION         INTEGER,

CONSTRAINT FK_EJEMPLAR FOREIGN KEY (ISBN)
           REFERENCES LIBROS,
CONSTRAINT PK_EJEMPLAR PRIMARY KEY (ID_EJEMPLAR, ISBN)
);



DROP TABLE IF EXISTS SOCIOS;

CREATE TABLE SOCIOS
(
DNI             TEXT PRIMARY KEY,
NOMBRE          TEXT NOT NULL,
APELLIDOS       TEXT NOT NULL,
FECHA_ALTA      TEXT DEFAULT (STRFTIME('%Y-%m-%d', (SUBSTR(DATETIME(CURRENT_TIMESTAMP, 'localtime'), 1, 10)))) 
);



DROP TABLE IF EXISTS PRESTAMOS;

CREATE TABLE PRESTAMOS
(
FECHA_PRESTAMO  TEXT DEFAULT (STRFTIME('%Y-%m-%d', (SUBSTR(DATETIME(CURRENT_TIMESTAMP, 'localtime'), 1, 10)))),
DNI             TEXT,
ISBN            TEXT,
ID_EJEMPLAR     INTEGER,
FECHA_DEVUELTO  TEXT DEFAULT NULL,

CONSTRAINT FK_PRESTAMOS_SOCIOS FOREIGN KEY (DNI)
           REFERENCES SOCIOS,

CONSTRAINT FK_PRESTAMOS_EJEMPLARES FOREIGN KEY (ID_EJEMPLAR, ISBN)
           REFERENCES EJEMPLARES,

CONSTRAINT PK_PRESTAMOS PRIMARY KEY (DNI, ISBN, ID_EJEMPLAR, FECHA_PRESTAMO)
);

/*
CREATE TRIGGER CAMBIAR_FECHA AFTER INSERT ON SOCIOS
BEGIN
    UPDATE SOCIOS
    SET FECHA_ALTA = STRFTIME('%Y-%m-%d', (SUBSTR(DATETIME(CURRENT_TIMESTAMP, 'localtime'), 1, 10)))
END;
*/


/*
.read libros.sql
.read ejemplares.sql
.read socios.sql
.read prestamos.sql
*/


/*
 * 1. Añadir .read de los sql del mokaroo para que no reviente todo.
 * 2. Hacer que se introduzca automáticamente el ID_EJEMPLAR al crearlo
 *    desde java (el máximo id + 1).
 */








