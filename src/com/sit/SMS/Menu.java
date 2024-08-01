package com.sit.SMS;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Student stud = new Student();

		boolean loop = true;

		while (loop) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nTo add Students press 1:\n" + "To Update Students details press 2:\n"
					+ "To Delete Students details press 3:\n" + "To list all Students press 4:\n" + "To Exit  press 5");
			System.out.println("");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				stud.addStudent();
				
				break;
			case 2:

				stud.updatingStudent();
				
				break;
			case 3:

				stud.deletingStudent();
				
				break;
			case 4:

				stud.listAllStudent();
				break;

			case 5:
				loop = false;
				break;
				
			default:
				System.out.println("Invalid choice");
			
			}
		}
	}
}
