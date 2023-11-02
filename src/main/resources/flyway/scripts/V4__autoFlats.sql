INSERT INTO flats (number, sq, building_id)
SELECT
    FLOOR(RAND() * 100) + 1 AS number,
    CAST((RAND() * 100 + 1) AS FLOAT) AS sq,
    FLOOR(RAND() * 100) + 1 AS building_id
FROM
    information_schema.tables
LIMIT 100;

