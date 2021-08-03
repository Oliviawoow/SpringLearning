DO $$
DECLARE
    n int8 := 100;
    DECLARE words text[] := (string_to_array('lorem ipsum dolor sit amet consectetur adipiscing elit ' 
    || 'etiam sed odio egestas magna ultricies mattis non quis sapien aenean congue nunc in ' 
    || 'ullamcorper pharetra diam ante varius enim rhoncus tincidunt metus risus nec leo curabitur ' 
    || 'aliquam nulla lobortis orci malesuada rhoncus eleifend nulla luctus cras id semper lectus ' 
    || 'eget pellentesque quam vivamus velit nibh consectetur eget laoreet non hendrerit at ' 
    || 'lectus duis iaculis ut augue ut vulputate donec ultrices viverra est nec placerat ipsum ' 
    || 'volutpat sed suspendisse id ex sit amet lectus euismod malesuada mollis vitae nibh ' 
    || 'vestibulum eget cursus felis vel pulvinar justo etiam et velit a lacus blandit dictum ' 
    || 'praesent interdum euismod ex sed condimentum est mollis sit amet phasellus bibendum ' 
    || 'nisi et tincidunt placerat mauris aliquet facilisis pharetra fusce bibendum tempus rutrum', ' '));
    DECLARE word_options text[] := (string_to_array('lorem ipsum dolor sit amet consectetur adipiscing elit', ' '));
BEGIN
    CREATE EXTENSION pgcrypto;
    CREATE EXTENSION pg_trgm;
    CREATE TABLE samples (
        id uuid NOT NULL DEFAULT gen_random_uuid ( ),
        text_like text NOT NULL,
        text_option text NOT NULL,
        date_value timestamptz NOT NULL,
        number_integer int4 NOT NULL,
        number_long int8 NOT NULL,
        number_big_decimal numeric NOT NULL,
        boolean_value bool NOT NULL,
        CONSTRAINT samples_pkey PRIMARY KEY (id )
    );
    CREATE INDEX idx_boolean_value ON samples USING btree (boolean_value);
    CREATE INDEX idx_date_value_asc ON samples USING btree (date_value);
    CREATE INDEX idx_date_value_desc ON samples USING btree (date_value DESC);
    CREATE INDEX idx_number_big_decimal ON samples USING btree (number_big_decimal);
    CREATE INDEX idx_number_integer ON samples USING btree (number_integer);
    CREATE INDEX idx_number_long ON samples USING btree (number_long);
    CREATE INDEX idx_text_like ON samples USING gin (lower(text_like) gin_trgm_ops);
    CREATE INDEX idx_text_option ON samples USING btree (text_option);
    INSERT INTO samples (id, text_like, text_option, date_value, number_integer, number_long, number_big_decimal, boolean_value)
    WITH series AS (
        SELECT
            generate_series AS value
        FROM
            generate_series(1, n))
    SELECT
        gen_random_uuid () AS id,
    (
        SELECT
            string_agg(words[random() * (array_length(words, 1) - 1) + 1], ' ')
        FROM
            generate_series(1, 20)
        WHERE
            a.value = a.value) AS text_like,
    upper(word_options[random() * (array_length(word_options, 1) - 1) + 1]) AS text_option,
    (now() + (random() * (now() - (now() + '10 years')))) AS date_value,
    (floor(random() * 4294967296) - 2147483648)::int4 AS number_integer,
    (floor(random() * 18446744073709551616) - 9223372036854775808)::int8 AS number_long,
    ((random() * (20001)) - 10000)::numeric AS number_big_decimal,
    (round(random())::int)::boolean AS boolean_value
FROM
    series AS a;
END
$$;
