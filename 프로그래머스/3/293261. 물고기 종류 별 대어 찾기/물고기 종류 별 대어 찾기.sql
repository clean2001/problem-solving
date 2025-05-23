SELECT FI.ID AS ID, FISH_NAME_INFO.FISH_NAME AS FISH_NAME, FI.LENGTH AS LENGTH
FROM FISH_INFO AS FI
INNER JOIN FISH_NAME_INFO ON FI.FISH_TYPE = FISH_NAME_INFO.FISH_TYPE
WHERE FI.LENGTH = (SELECT MAX(LENGTH) FROM FISH_INFO AS F WHERE FI.FISH_TYPE = F.FISH_TYPE)
ORDER BY ID;