-- Symmetric Pairs
-- You are given a table, Functions, containing two columns: X and Y. Y is the
-- value of some function F at X -- i.e. Y = F(X).
-- Two pairs (X1, Y1) and (X2, Y2) are said to be symmetric pairs if X1 = Y2 and
-- X2 = Y1.
-- Write a query to output all such symmetric pairs in ascending order by the
-- value of X.

SELECT DISTINCT X,
                Y
FROM Functions F1
WHERE (X = Y
       AND
          (SELECT count(F2.X)
           FROM Functions F2
           WHERE F1.X = F2.Y
              AND F1.Y = F2.X) > 1)
   OR (X < Y
       AND
          (SELECT count(F2.X)
           FROM Functions F2
           WHERE F1.X = F2.Y
              AND F1.Y = F2.X) > 0)
ORDER BY X,
         Y;
