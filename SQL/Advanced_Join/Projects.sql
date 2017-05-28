-- Projects
-- You are given a table, Projects, containing three columns: Task_ID,
-- Start_Date and End_Date. It is guaranteed that the difference between the
-- End_Date and the Start_Date is equal to 1 day for each row in the table.
--
-- If the End_Date of the tasks are consecutive, then they are part of the same
-- project. Samantha is interested in finding the total number of different
-- projects completed.
--
-- Write a query to output the start and end dates of projects listed by the
-- number of days it took to complete the project in ascending order. If there
-- is more than one project that have the same number of completion days, then
-- order by the start date of the project.
--
-- Sample Output:
-- 2015-10-28 2015-10-29
-- 2015-10-30 2015-10-31
-- 2015-10-13 2015-10-15
-- 2015-10-01 2015-10-04
--
-- Referenced: https://docs.oracle.com/cd/B28359_01/olap.111/b28126/dml_functions_2048.htm#OLADM624
--             https://oracle-base.com/articles/misc/lag-lead-analytic-functions

SELECT S,
       E
FROM
   (SELECT min(Start_Date) S,
           max(End_Date) E,
           max(End_Date) - min(Start_Date) AS days_to_complete
    FROM
       (SELECT S.Start_Date,
               S.End_Date,
               row_number() over(
                                 ORDER BY Start_Date) row_num
        FROM
           (SELECT *
            FROM
               (SELECT Start_Date,
                       End_Date,
                       lag(End_Date) over(
                                          ORDER BY Start_Date) led
                FROM Projects)S
            WHERE nvl(led,sysdate+10000) <> Start_Date)S
        UNION ALL SELECT S.Start_Date,
                         S.End_Date,
                         row_number() over(
                                           ORDER BY Start_Date) row_num
        FROM
           (SELECT *
            FROM
               (SELECT Start_Date,
                       End_Date,
                       lead(Start_Date) over(
                                             ORDER BY Start_Date) lsd
                FROM Projects)S
            WHERE nvl(lsd,sysdate+10000) <> End_Date)S)
    GROUP BY row_num)
ORDER BY days_to_complete,
         1;
