SELECT *
  FROM (SELECT b.*, 
               LAG(no) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) preNo,
               LAG(subject) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) preSubject,
               LEAD(no) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) nxtNo,
               LEAD(subject) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) nxtSubject
        FROM board b
        ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) 
 WHERE no = 46;