INSERT INTO people_owner (people_id_owner, owner)
SELECT
    p.id AS people_id_owner,
    FLOOR(RAND() * 2) AS owner
FROM
    people p
LIMIT 100;