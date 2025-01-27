package com.vj.NewsFeed;

import java.util.Scanner;

public class DynamicNews {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NewsBL nb = new NewsBL();
		int choice;
		do {
			System.out.println("Choose Operations you want to Perform ...!!!!\n");
			System.out.println("Press 1 for Add Title : ");
			System.out.println("Press 2 for List News : ");
			System.out.println("Press 3 for Exit App : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				nb.addNews(sc);
				break;
			case 2:
				nb.listNews(sc);
				break;
			case 3:
				nb.Exit(sc);
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice..Please Try Again......");

			}
		} while (choice != 3);
		sc.close();
	}
}
