WITH CNT AS (
    SELECT BOOK_SALES.BOOK_ID AS BOOK_ID, SUM(BOOK_SALES.SALES * BOOK.PRICE) AS PRICE
    FROM BOOK_SALES
    JOIN BOOK ON BOOK.BOOK_ID=BOOK_SALES.BOOK_ID
    WHERE YEAR(BOOK_SALES.SALES_DATE) = 2022 AND MONTH(BOOK_SALES.SALES_DATE) = 1
    GROUP BY BOOK_SALES.BOOK_ID
)
SELECT B.AUTHOR_ID AS AUTHOR_ID, A.AUTHOR_NAME AS AUTHOR_NAME, B.CATEGORY AS CATEGORY, SUM(C.PRICE) AS TOTAL_SALES
FROM BOOK AS B
JOIN AUTHOR AS A ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN CNT AS C ON C.BOOK_ID = B.BOOK_ID
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY AUTHOR_ID, CATEGORY DESC;