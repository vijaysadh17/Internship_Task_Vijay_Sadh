package com.vj.TODO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TaskBL {
	private Connection con;

	public TaskBL(Connection con) {
		super();
		this.con = con;
	}

	public void addTask(Scanner sc) throws SQLException {

		System.out.println("Enter how many Task you want to Add : ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter Task Title : ");
			String title = sc.next();

			String query = "Insert into task (title) values(?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, title);

			int r = ps.executeUpdate();
			if (r > 0) {
				System.out.println("Task Added Successfully");
			} else {
				System.out.println("Failed To Add Task....");
			}
			System.out.println();
			ps.close();
		}
	}

	public void EditTask(Scanner sc) throws SQLException // Edit All things IE..TAsk & Status

	{

		System.out.println("Enter how many task you want to update : ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter the serial number u want to edit : ");
			int id = sc.nextInt();

			System.out.println("Enter Task Title : ");
			String title = sc.next();
			System.out.println("Enter Status(Start , In progress , Completed) : ");
			String status = sc.next();

			String query = "update task set title=?,status=? where sno=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, status);
			ps.setInt(3, id);

			int j = ps.executeUpdate();
			if (j > 0) {
				System.out.println("Task Updated Successfully...");
			} else {
				System.out.println("Enabled to Update Task....");
			}
			System.out.println();
			ps.close();
		}
	}

	public void UpdateByTask(Scanner sc) throws SQLException {
		System.out.println("Enter how many Task you want to Update : ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter Task Id You want to Update : ");
			int id = sc.nextInt();
			System.out.println("Enter the New Title : ");
			String title = sc.next();
			String sql = "UPDATE Task SET title = ? WHERE sno = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, id);
			int row = ps.executeUpdate();
			if (row > 0) {
				System.out.println("Task Updated successfully");
			} else {
				System.out.println("failed to Update Task");
			}
			System.out.println();
			ps.close();

		}
	}

	public void UpdateStatus(Scanner sc) throws SQLException {
		System.out.println("Enter how many Task Status you want to Update : ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter Task Id You want to Update : ");
			int id = sc.nextInt();
			System.out.println("Enter the New Status : ");
			String status = sc.next();
			String sql = "UPDATE Task SET status = ? WHERE sno = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, id);
			int row = ps.executeUpdate();
			if (row > 0) {
				System.out.println("Status Updated successfully......");
			} else {
				System.out.println("failed to Update Task Status......");
			}
			System.out.println();
			ps.close();

		}
	}

	public void ListTask(Scanner sc) throws SQLException {

		String query = "select * from task";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("[ Task ID = "+rs.getInt(1)+"| Task = "+rs.getString(2)+"| Status = "+rs.getString(3)+" ]");
		}
		System.out.println();
		ps.close();

	}

	public void deleteTask(Scanner sc) throws SQLException {

		System.out.println("Enter the serial number u want to delete : ");
		int id = sc.nextInt();

		String query = "delete from task where sno=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);

		int i = ps.executeUpdate();
		if (i > 0) {
			System.out.println("Task deleted Successfully.....");
		} else {
			System.out.println("Failed to delete Task....");
		}
		System.out.println();
		ps.close();

	}

}
