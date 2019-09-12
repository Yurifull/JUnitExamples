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

CREATE OR REPLACE FUNCTION findAllMovies() RETURNS refcursor AS $$
    DECLARE
      ref refcursor;                                                     -- Declare a cursor variable
    BEGIN
      OPEN ref FOR SELECT code FROM films;   -- Open a cursor
      RETURN ref;                                                       -- Return the cursor to the caller
    END;
    $$ LANGUAGE plpgsql;