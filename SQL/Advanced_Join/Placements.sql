-- Placements
-- You are given three tables: Students, Friends and Packages. Students contains
-- two columns: ID and Name. Friends contains two columns: ID and Friend_ID (ID
-- of the ONLY best friend). Packages contains two columns: ID and Salary
-- (offered salary in $ thousands per month).
-- Write a query to output the names of those students whose best friends got
-- offered a higher salary than them. Names must be ordered by the salary amount
-- offered to the best friends. It is guaranteed that no two students got same
-- salary offer.

SELECT S.Name
FROM Students S
JOIN Friends F ON S.ID = F.ID
JOIN Packages P1 ON P1.ID = S.ID
JOIN Packages P2 ON P2.ID = F.Friend_ID
WHERE P1.Salary < P2.Salary
ORDER BY P2.Salary;
