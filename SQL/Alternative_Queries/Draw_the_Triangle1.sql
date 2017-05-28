-- Draw the Triangle 1
-- P(R) represents a pattern drawn by Julia in R rows. The following pattern represents P(5):
--
-- * * * * *
-- * * * *
-- * * *
-- * *
-- *
-- Write a query to print the pattern P(20).
-- Referenced: https://docs.oracle.com/cd/B19306_01/server.102/b14200/functions140.htm
-- It also works with (21-LEVEL)*2, but I couldn't resist 42 being in the function! :-D

SELECT RPAD('*',42-(LEVEL*2),' *')
FROM DUAL CONNECT BY LEVEL <= 20;
