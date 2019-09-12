CREATE TABLE films (code char(5));


INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');
INSERT INTO films VALUES ('llego');

CREATE OR REPLACE FUNCTION findAllMovies()
RETURNS setof films language sql as $$
    select *
    from films;
$$;