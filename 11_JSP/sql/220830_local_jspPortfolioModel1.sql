SELECT *
FROM (SELECT ROWNUM rnum, sortResult.*
      FROM (SELECT *
            FROM board
            ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) sortResult)
WHERE rnum BETWEEN 11 AND 20;