
INSERT INTO people (name, tel_number, parking, flats_id)
SELECT
    CONCAT('Name', ROW_NUMBER() OVER (ORDER BY RAND())) AS name,
    CONCAT('09', LPAD(FLOOR(RAND() * 100000000), 8, '0')) AS tel_number,
    FLOOR(RAND() * 2) AS parking,
    FLOOR(RAND() * 100) + 1 AS flats_id
FROM
    (SELECT 1) dummy
CROSS JOIN
    information_schema.tables
LIMIT 100;