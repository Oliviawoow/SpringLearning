DO $$
DECLARE
    n int8 := 10;
    DECLARE words text[] := (string_to_array('Oprea ' 
    || 'Popescu ' 
    || 'Petru ' 
    || 'Anghel ' 
    || 'Tanase', ' '));
    DECLARE word_options text[] := (string_to_array('olivia maria magdalena sabina razvan alex andrei petre', ' '));
BEGIN
    CREATE EXTENSION pgcrypto;
    CREATE EXTENSION pg_trgm;
    CREATE TABLE students (
        id serial NOT NULL,
        nume text NOT NULL,
        prenume text NOT NULL,
        zi_nastere timestamptz NOT NULL,
        clasa int4 NOT NULL,
        media int4 NOT NULL,
        CONSTRAINT students_pkey PRIMARY KEY (id )
    );
    CREATE INDEX idx_date_value_asc ON students USING btree (zi_nastere);
    CREATE INDEX idx_date_value_desc ON students USING btree (zi_nastere DESC);
    CREATE INDEX idx_number_integer ON students USING btree (clasa);
    CREATE INDEX idx_number_long ON students USING btree (media);
    CREATE INDEX idx_text_like ON students USING gin (lower(nume) gin_trgm_ops);
    CREATE INDEX idx_text_option ON students USING btree (prenume);
    INSERT INTO students (nume, prenume, zi_nastere, clasa, media)
    WITH series AS (
        SELECT
            generate_series AS value
        FROM
            generate_series(1, n))
    SELECT
    upper(words[random() * (array_length(words, 1) - 1) + 1]) AS nume,
    upper(word_options[random() * (array_length(word_options, 1) - 1) + 1]) AS prenume,
    (now() + (random() * (now() - (now() + '10 years')))) AS zi_nastere,
    (floor(random() * 10))::int4 AS clasa,
    (floor(random() * 10))::int4 AS media
FROM
    series AS a;
END
$$;
