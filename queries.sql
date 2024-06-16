--Part 1
Table: job
Columns:
id int PK
employer varchar(255)
name varchar(255)
skills varchar(255)
--Part 2
SELECT name FROM employer WHERE location = "St. Louis City";
--Part 3
DROP TABLE job;
--Part 4
SELECT * FROM skill INNER JOIN job_skills ON skill.id = job_skills.skills_id ORDER BY name ASC;
--SELECT * FROM skill INNER JOIN job_skills ON (skill.id = job_skills.skill_id) WHERE job_skills.job_id IS NOT NULL ORDER BY name ASC;