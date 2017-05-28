-- Draw the Triangle 2
-- P(R) represents a pattern drawn by Julia in R rows. The following pattern represents P(5):
--
-- *
-- * *
-- * * *
-- * * * *
-- * * * * *
-- Write a query to print the pattern P(20).

SELECT rpad('* ',LEVEL*2,'* ')
FROM dual CONNECT BY LEVEL <=20;
