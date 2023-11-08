package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;
import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {
	private StudentService studentService = new StudentService();
	private CourseService courseService = new CourseService();
	Scanner scanner = new Scanner(System.in);
	String email = "";
	String password = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SMSRunner sms = new SMSRunner();
		sms.run();
	}

	private void run() {
		// Login or quit
		switch (menu1()) {
		case 1:

			if (studentLogin()) {
				registerMenu();
			}

			break;
		case 2:
			System.out.println("Goodbye!");
			break;

		default:

		}
	}

	private int menu1() {
		System.out.println("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
		int option = scanner.nextInt();

		return option;
	}

	private boolean studentLogin() {
		boolean retValue = false;
		System.out.println("Enter your email address: ");
		email = scanner.next();
		System.out.println("Enter your password: ");
		password = scanner.next();
		retValue = studentService.validateStudent(email, password);
		if (retValue) {
			List<Course> studentCourses = studentService.getStudentCourses(email);
			if (studentCourses.size() == 0) {
				System.out.println("Student has no courses");
			} else {
				System.out.println("My Classes:");
				printCourses(studentCourses);
			}
		} else {
			System.out.println("User Validation failed. GoodBye!");
		}
		return retValue;
	}

	private void registerMenu() {
		System.out.println("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			List<Course> allCourses = courseService.getAllCourses();
			printCourses(allCourses);
			System.out.println("Enter Course ID :");
			option = scanner.nextInt();
			studentService.registerStudentToCourse(option, email);
			List<Course> studentCourse = studentService.getStudentCourses(email);
			System.out.println("My Classes:");
			printCourses(studentCourse);
			System.out.println("You have been signed out.");
			break;
		case 2:
		default:
			System.out.println("Goodbye!");
		}
	}

	private void printCourses(List<Course> courses) {
		System.out.printf("%-12s%-35s%-15s%n", "COURSE ID", "COURSE NAME", "INSTRUCTOR NAME");
		for (Course course : courses) {
			System.out.printf("%-12s%-35s%-15s%n", course.getId(), course.getName(), course.getInstructor());
		}
	}
}
