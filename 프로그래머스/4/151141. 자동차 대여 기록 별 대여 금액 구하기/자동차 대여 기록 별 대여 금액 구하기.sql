WITH DISCOUNT AS (
SELECT H.HISTORY_ID AS HISTORY_ID, C.DAILY_FEE AS DAILY_FEE,DATEDIFF(H.END_DATE, H.START_DATE) + 1 AS DATEDIFF, C.CAR_TYPE AS CAR_TYPE, (
    CASE WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 90 THEN '90일 이상'
    WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 30 THEN '30일 이상'
    WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 7 THEN '7일 이상'
    ELSE ''
    END
) AS DURATION_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
JOIN CAR_RENTAL_COMPANY_CAR C ON C.CAR_ID = H.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON P.CAR_TYPE = C.CAR_TYPE
WHERE C.CAR_TYPE = '트럭'
)
SELECT D.HISTORY_ID AS HISTORY_ID,
(CASE WHEN P.DISCOUNT_RATE IS NULL THEN D.DAILY_FEE * D.DATEDIFF
    ELSE CONVERT(D.DAILY_FEE * D.DATEDIFF * (100 - P.DISCOUNT_RATE) / 100, SIGNED) END
) AS FEE
FROM DISCOUNT AS D
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P ON P.CAR_TYPE = D.CAR_TYPE AND P.DURATION_TYPE = D.DURATION_TYPE
GROUP BY HISTORY_ID
ORDER BY FEE DESC, HISTORY_ID DESC;

