package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{       // java lambda expression

			// createStudent(studentDAO);

			 createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students....");

		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted Row count : " +numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Deleting student id : " +studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve the student based on id : primary key
		int studentId = 1;
		System.out.println("Getting student with an Id : " +studentId);
		Student mystudent = studentDAO.findById(studentId);

		// change first name to Mohit & email
		System.out.println("Updating student.....");
		mystudent.setFirstName("Mohit");
		mystudent.setEmail("mohit67@gmail.com");

		// update the student
		studentDAO.update(mystudent);

		// display the updated student
		System.out.println("Updated Student : " +mystudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Thakre");

		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object.....");
		Student temp = new Student("Ravi","Chahal","ravichahal@gmail.com");

		// save the student
		System.out.println("Saving the student.....");
		studentDAO.save(temp);

		// display id of the saved student
		int theId = temp.getId();
		System.out.println("Saved Student. Generated id : " +theId);

		// retrieve student based on id : primary key
		System.out.println("Retrieving student with id : " +theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student : " +myStudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple student
		System.out.println("Creating 3 student objects.....");
		Student tempStudent1 = new Student("Shubham","Rathee",
				                         "shubhamrathee17@gmail.com");
		Student tempStudent2 = new Student("Komal","Thakre",
				                           "komalthakre17@gmail.com");
		Student tempStudent3 = new Student("Jitender","Rathee",
				                               "dreamr420@gmail.com");

		// save the student objects
		System.out.println("Saving the students.....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display the id of students
		System.out.println("Saved Student. Generated id : " +tempStudent1.getId());
		System.out.println("Saved Student. Generated id : " +tempStudent2.getId());
		System.out.println("Saved Student. Generated id : " +tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object......");
		Student tempStudent = new Student("Shubham","Rathee",
				                           "shubhamrathee17@gmail.com");

		// save the student object
		System.out.println("Saving the student......");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved Student. Generated id : " +tempStudent.getId());
	}

}
