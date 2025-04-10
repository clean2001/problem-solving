-- 가장 리뷰를 많이 작성한 회원을 찾기
SELECT m.MEMBER_NAME AS MEMBER_NAME,
r.REVIEW_TEXT AS REVIEW_TEXT,
DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE AS m
JOIN REST_REVIEW AS r ON m.MEMBER_ID = r.MEMBER_ID
WHERE m.MEMBER_ID = (SELECT MEMBER_ID FROM REST_REVIEW GROUP BY MEMBER_ID ORDER BY COUNT(*) DESC LIMIT 1)
ORDER BY r.REVIEW_DATE, r.REVIEW_TEXT;

