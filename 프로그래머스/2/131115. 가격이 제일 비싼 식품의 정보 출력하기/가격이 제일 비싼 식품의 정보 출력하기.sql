SELECT FR.PRODUCT_ID AS PRODUCT_ID, FR.PRODUCT_NAME AS PRODUCT_NAME, FR.PRODUCT_CD AS PRODUCT_CD, FR.CATEGORY AS CATEGORY, FR.PRICE AS PRICE
FROM FOOD_PRODUCT AS FR
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT);