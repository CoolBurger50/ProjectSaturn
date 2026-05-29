SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS Grades;
DROP TABLE IF EXISTS Assignments;
DROP TABLE IF EXISTS Sections;
DROP TABLE IF EXISTS Enrollments;
DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS Teachers;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS Departments;
DROP TABLE IF EXISTS Rooms;
SET FOREIGN_KEY_CHECKS = 1;


CREATE TABLE `Students` (
  `student_id` INT PRIMARY KEY AUTO_INCREMENT,
  `first_name` VARCHAR(255),
  `last_name` VARCHAR(255)
);


CREATE TABLE `Departments` (
  `department_id` INT PRIMARY KEY AUTO_INCREMENT,
  `department_name` VARCHAR(255)
);


CREATE TABLE `Teachers` (
  `teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
  `first_name` VARCHAR(255),
  `last_name` VARCHAR(255),
  `department_id` INT
);


CREATE TABLE `Courses` (
  `course_id` INT PRIMARY KEY AUTO_INCREMENT,
  `course_name` VARCHAR(255),
  `course_type` VARCHAR(255),
  `department_id` INT
);


CREATE TABLE `Rooms` (
  `room_id` INT PRIMARY KEY AUTO_INCREMENT,
  `room_floor` INT,
  `room_wing` VARCHAR(255),
  `room_number` INT
);


CREATE TABLE `Sections` (
  `section_id` INT PRIMARY KEY AUTO_INCREMENT,
  `course_id` INT,
  `room_id` INT,
  `teacher_id` INT,
  `period_number` INT
);


CREATE TABLE `Enrollments` (
  `section_id` INT,
  `student_id` INT
);


CREATE TABLE `Assignments` (
  `assignment_id` INT PRIMARY KEY AUTO_INCREMENT,
  `course_id` INT,
  `assignment_name` VARCHAR(255),
  `assignment_type` VARCHAR(50)
);


CREATE TABLE `Grades` (
  `grade_id` INT,
  `assignment_id` INT,
  `student_id` INT,
  `grade` INT
);


CREATE UNIQUE INDEX `Rooms_index_0` ON `Rooms` (`room_floor`, `room_wing`, `room_number`);


ALTER TABLE `Teachers` ADD FOREIGN KEY (`department_id`) REFERENCES `Departments` (`department_id`);


ALTER TABLE `Courses` ADD FOREIGN KEY (`department_id`) REFERENCES `Departments` (`department_id`);


ALTER TABLE `Sections` ADD FOREIGN KEY (`course_id`) REFERENCES `Courses` (`course_id`);


ALTER TABLE `Sections` ADD FOREIGN KEY (`room_id`) REFERENCES `Rooms` (`room_id`);


ALTER TABLE `Sections` ADD FOREIGN KEY (`teacher_id`) REFERENCES `Teachers` (`teacher_id`);


ALTER TABLE `Enrollments` ADD FOREIGN KEY (`section_id`) REFERENCES `Sections` (`section_id`);


ALTER TABLE `Enrollments` ADD FOREIGN KEY (`student_id`) REFERENCES `Students` (`student_id`);


ALTER TABLE `Grades` ADD FOREIGN KEY (`assignment_id`) REFERENCES `Assignments` (`assignment_id`);


ALTER TABLE `Grades` ADD FOREIGN KEY (`student_id`) REFERENCES `Students` (`student_id`);


ALTER TABLE `Assignments` ADD FOREIGN KEY (`course_id`) REFERENCES `Courses` (`course_id`);