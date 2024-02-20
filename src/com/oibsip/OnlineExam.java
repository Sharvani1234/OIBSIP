package com.oibsip;

import java.util.Scanner;

class Login{
	private String username;
	private String password;
	
	public Login(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	public boolean authentication(String username,String password) {
		return this.username.equals(username) && this.password.equals(password);
	}
}

class MCQExam{
	private static final int TOTAL_QUESTIONS=5;
	private static final int TIME_LIMIT_MINUTES=30;
	
	private Scanner scanner;
	private Login currentUser;
	
	public MCQExam() {
		scanner=new Scanner(System.in);
	}
	
	public void login() {
		System.out.println("Enter username:");
		String username=scanner.nextLine();
		System.out.println("Enter password:");
		String password=scanner.nextLine();
		
		currentUser=new Login("admin","password");
		
		if(currentUser.authentication(username,password)) {
			System.out.println("Login successful!");
		}
		else {
			System.out.println("Invalid username or password.");
			login();
		}
	}
	
	public void updateProfileAndPassword() {
		System.out.println("Profile and password updated successfully.");
	}
	
	public void takeExam() {
		System.out.println("Welcome to the exam!");
		System.out.println("You have "+TIME_LIMIT_MINUTES+" minutes to complete "+TOTAL_QUESTIONS+" questions.");
		System.out.println("Exam completed.Submitting answers...");
		System.out.println("Answers submitted successfully.");
	}
	
	public void logout() {
		System.out.println("Logging out...");
		currentUser=null;
		System.out.println("Logged out successfully.");
	}
}

public class OnlineExam {
	public static void main(String[] args) {
		MCQExam exam=new MCQExam();
		exam.login();
		System.out.println();
		
		exam.updateProfileAndPassword();
		System.out.println();
		
		exam.takeExam();
		System.out.println();
		
		exam.logout();
	}
}