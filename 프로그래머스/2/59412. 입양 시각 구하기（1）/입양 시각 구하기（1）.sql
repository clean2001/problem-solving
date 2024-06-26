SELECT CAST(DATE_FORMAT(DATETIME, '%H') AS UNSIGNED) HOUR, COUNT(*) COUNT
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME, '%H:%i') BETWEEN '09:00' AND '19:59'
GROUP BY HOUR ORDER BY HOUR;