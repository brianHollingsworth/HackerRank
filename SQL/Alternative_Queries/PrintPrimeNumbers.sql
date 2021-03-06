-- Print Prime Numbers
-- Write a query to print all prime numbers less than or equal to 1000. Print
-- your result on a single line, and use the ampersand (&) character as your
-- separator (instead of a space).
--
-- For example, the output for all prime numbers < 10 would be: 2&3&5&7
-- Referenced: https://docs.oracle.com/cd/E11882_01/server.112/e41084/functions089.htm#SQLRF30030

SELECT LISTAGG(PRIME, '&') WITHIN
GROUP (
       ORDER BY PRIME)
FROM
   (SELECT P1.PRIME
    FROM
       (SELECT LEVEL AS PRIME
        FROM DUAL CONNECT BY LEVEL <= 1000) P1
    WHERE NOT EXISTS
          (SELECT 1
           FROM DUAL P2
           WHERE mod(P1.PRIME, LEVEL) = 0
              AND LEVEL > 1 CONNECT BY LEVEL <= P1.PRIME / 2 ) )
WHERE PRIME > 1;
