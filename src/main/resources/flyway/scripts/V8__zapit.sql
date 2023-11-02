SELECT
    p.id AS 'ID власника',
    p.name AS 'ПІБ власника',
    p.tel_number AS 'Номер телефону',
    p.parking AS 'Має паркомісце',
    f.number AS 'Номер квартири',
    f.sq AS 'Площа квартири',
    b.house AS 'Номер будинку',
    b.street AS 'Вулиця'
FROM
    people p
JOIN
    people_owner po ON p.id = po.people_id_owner
JOIN
    flats f ON p.flats_id = f.id
JOIN
    buildings b ON f.building_id = b.id
WHERE
    po.owner = 0
    AND (SELECT COUNT(*) FROM flats WHERE flats_id = f.id) < 2;