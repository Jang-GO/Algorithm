SELECT DISTINCT d.id, d.email, d.first_name, d.last_name
FROM skillcodes s, developers d
WHERE s.code & d.skill_code > 0
AND s.category = 'Front end'
ORDER BY d.id;