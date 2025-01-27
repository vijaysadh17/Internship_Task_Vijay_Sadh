package com.vj.NewsFeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewsBL {

	private static List<News> newList = new ArrayList<News>();

	public void addNews(Scanner sc) {
		System.out.println("Enter the News Title: ");
		String title = sc.nextLine(); // Use nextLine to capture the full line
		sc.next();
		System.out.println("Enter News Details: ");
		String newsDetails = sc.nextLine(); // Use nextLine for multi-word input
		
		System.out.println("Enter Image Path or URL: ");
		String image = sc.nextLine(); // Use nextLine for multi-word input if needed
		

		// Add the news to the list
		News news = new News(title, newsDetails, image);
		newList.add(news);
		System.out.println("News Added Successfully...");
	}

	public void listNews(Scanner sc) {
		if (newList.isEmpty()) {
			System.out.println("No News Available....!!!");
		} else {
			for (int i = 0; i < newList.size(); i++) 
			{
				System.out.println("News " + (i + 1) + " : ");
			}
		}

	}

	public void Exit(Scanner sc) {
		System.out.println("Exiting Application..Good Bye...");
	}

}
