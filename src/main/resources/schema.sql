DROP TABLE IF EXISTS student;
  
CREATE TABLE student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  student_name VARCHAR(250) NOT NULL,
  standard VARCHAR(250) NOT NULL,
  total_marks INT DEFAULT NULL
);