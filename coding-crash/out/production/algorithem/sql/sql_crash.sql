-- 按月按课程统计学生成绩
-- stu_tbl
-- |id|stuId|stu_name|
--
-- stu_course_tbl
-- |id|stuId|courseId|
--
-- course_tbl
-- |id|courseId|course_name|
--
-- score_tbl
-- |id|stuId|month|courseId|score|

select avg(score)
from score_tbl
group by courseId,
