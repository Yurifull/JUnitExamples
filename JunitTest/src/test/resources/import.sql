CREATE SCHEMA junit;
CREATE TABLE junit.films (code varchar(100));

CREATE OR REPLACE FUNCTION junit.findallmovies()
    RETURNS SETOF character varying 
    LANGUAGE 'sql'
    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$SELECT code as code FROM junit.films;$BODY$;

    
INSERT INTO junit.films VALUES ('Bob Esponja');
INSERT INTO junit.films VALUES ('Transformers');
INSERT INTO junit.films VALUES ('Pablo el Escoba');
INSERT INTO junit.films VALUES ('Rapido y Furioso 20');
INSERT INTO junit.films VALUES ('Condorito');
INSERT INTO junit.films VALUES ('Lo que callan los Devs');
INSERT INTO junit.films VALUES ('El Zorro');
INSERT INTO junit.films VALUES ('Lego');
INSERT INTO junit.films VALUES ('Titanic');
INSERT INTO junit.films VALUES ('Regreso al futuro');

    