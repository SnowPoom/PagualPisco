-- database: ../database/AntBot.sqlite
DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS Clasificacion;
DROP TABLE IF EXISTS AntBot;

CREATE TABLE AntBot(
    IdAntBot         INTEGER PRIMARY KEY AUTOINCREMENT
    ,Estado          TEXT DEFAULT 'A'
    ,FechaCrea       DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica   DATE);   

CREATE TABLE Clasificacion(
    IdClasificacion  INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre          TEXT UNIQUE NOT NULL
    ,Estado          TEXT DEFAULT 'A'
    ,FechaCrea       DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica   DATE );

CREATE TABLE Hormiga(
    IdHormiga        INTEGER PRIMARY KEY AUTOINCREMENT
    ,Codigo          TEXT UNIQUE NOT NULL 
    ,IdClasificacion INTEGER NOT NULL REFERENCES Clasificacion(IdClasificacion) 
    ,IdAntBot        INTEGER NOT NULl REFERENCES AntBot(IdAntBot)
    ,Comio           INTEGER NOT NULL DEFAULT 0
    ,Recogio         INTEGER NOT NULL DEFAULT 0
    ,Estado          TEXT DEFAULT 'A'
    ,FechaCrea       DATETIME NOT NULL DEFAULT (DATETIME('NOW', 'LOCALTIME'))
    ,FechaModifica   DATE );   