SELECT i.NAME AS NAME, i.DATETIME AS DATETIME
FROM ANIMAL_INS AS i
LEFT JOIN ANIMAL_OUTS AS o ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.DATETIME IS NULL
ORDER BY i.DATETIME
LIMIT 3;