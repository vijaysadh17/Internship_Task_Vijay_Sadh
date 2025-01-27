package com.vj.TODO;

import java.sql.SQLException;
import java.util.Scanner;
import com.vj.DBConnection.DBConnection;


public class ToDoMain {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		TaskBL tb = new TaskBL(DBConnection.getConn());
		int choice;
		do {
			System.out.println("WELCOME TO TODO LIST APPLICATION....");
			System.out.println();
			System.out.println("Choose the Operations You Want ....!!!!!");
			System.out.println();
			System.out.println("Press 1 to add Task");
			System.out.println("Press 2 to edit Task");
			System.out.println("Press 3 to Remove Task");
			System.out.println("Press 4 to List All Task");
			System.out.println("Press 5 to Exit Task");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			
			case 1:
		
				tb.addTask(sc);
				break;
			
			case 2:
			{
				while (true) {
					System.out.println("press 1 to Update task");
					System.out.println("press 2 to Update Status");
					System.out.println("press 3 to Update both");
					System.out.println("press 0 for Main Menu ");
					int choice1 = sc.nextInt();
					if (choice1 == 0) {
						System.out.println("return to main menu....");
						break;
					}
					switch (choice1) {
					case 1: {
						tb.UpdateByTask(sc);
						break;
					}
					case 2: {
						tb.UpdateStatus(sc);
						break;
					}

					case 3: {
						tb.EditTask(sc);
						break;
					}
					default:
						System.out.println("Invalid Choice....");
					}

				}

					break;
				}

			case 3: {
				tb.deleteTask(sc);
				break;
			}
			case 4: {
				tb.ListTask(sc);
				break;
			}
			case 5:
				System.out.println("Exiting application. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 5);

		sc.close();

	}
}
