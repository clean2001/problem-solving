SELECT i.ANIMAL_ID AS ANIMAL_ID, i.ANIMAL_TYPE AS ANIMAL_TYPE, i.NAME AS NAME
FROM ANIMAL_INS AS i JOIN ANIMAL_OUTS AS o ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.SEX_UPON_INTAKE LIKE 'Intact%'
AND (o.SEX_UPON_OUTCOME LIKE 'Spayed%' OR o.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY i.ANIMAL_ID;

