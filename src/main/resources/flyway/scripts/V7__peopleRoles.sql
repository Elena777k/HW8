INSERT INTO people_roles (people_id, role)
SELECT
    p.id AS people_id_owner,
    ELT(FLOOR(RAND() * 4) + 1, 'STAFF', 'RESIDENT', 'PRESIDENT', 'NULL') AS role
FROM
    people p
LIMIT 100;