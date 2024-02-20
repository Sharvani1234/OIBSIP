package com.oibsip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservationSystem {
	private static Map<String,String>userCredentials=new HashMap<>();
	private static Map<String,Reservation>reservations=new HashMap<>();
	private static int reservationCounter=0;

	public static void main(String[] args) {
		userCredentials.put("user123","password123");
		
		Scanner scanner=new Scanner(System.in);
		boolean loggedIn=false;
		
		while(!loggedIn) {
			System.out.println("Enter your username:");
			String username=scanner.nextLine();
			System.out.println("Enter your password:");
			String password=scanner.nextLine();
			
			if(isValidCredentials(username,password)) {
				loggedIn=true;
				System.out.println("Login successful!\n");
			}
			else {
				System.out.println("Invalid username or password.Please try again.\n");
			}
		}
		
		while(loggedIn) {
			System.out.println("1.Make a reservation");
			System.out.println("2.Cancel reservation");
			System.out.println("3.Logout");
			System.out.println("Enter your choice:");
			
			int choice=scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				makeReservation(scanner);
				break;
			case 2:
				cancelReservation(scanner);
				break;
			case 3:
				loggedIn=false;
				System.out.println("Logged out successfully.");
				break;
				default:
					System.out.println("Invalid choice.Please try again.");
			}
		}
	}
	
	private static boolean isValidCredentials(String username,String password) {
		return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
	}
	
	private static void makeReservation(Scanner scanner) {
		System.out.println("Enter train number:");
		String trainNumber=scanner.nextLine();
		System.out.println("Enter class type:");
		String classType=scanner.nextLine();
		System.out.println("Enter date of journey:");
		String dateOfJourney=scanner.nextLine();
		System.out.println("Enter source station:");
		String sourceStation=scanner.nextLine();
		System.out.println("Enter destination station:");
		String destinationStation=scanner.nextLine();
		
		String pnr=generatePNR();
		Reservation reservation=new Reservation(pnr,trainNumber,classType,dateOfJourney,sourceStation,destinationStation);
		reservations.put(pnr,reservation);
		
		System.out.println("Reservation successful.Your PNR is:"+pnr);
	}
	
	private static void cancelReservation(Scanner scanner) {
		System.out.println("Enter your PNR:");
		String pnr=scanner.nextLine();
		
		if(reservations.containsKey(pnr)) {
			reservations.remove(pnr);
			System.out.println("Reservation with PNR "+pnr+" has been cancelled successfully.");
		}
		else {
			System.out.println("No reservation found with PNR"+pnr);
		}
	}
	
	private static String generatePNR() {
		return"PNR"+(++reservationCounter);
	}
}

class Reservation{
	private String pnr;
	private String trainNumber;
	private String classType;
	private String dateOfJourney;
	private String sourceStation;
	private String destinationStation;
	
	public Reservation(String pnr,String trainNumber,String classType,String dateOfJourney,String sourceStation,String destinationStation) {
		this.pnr=pnr;
		this.trainNumber=trainNumber;
		this.classType=classType;
		this.dateOfJourney=dateOfJourney;
		this.sourceStation=sourceStation;
		this.destinationStation=destinationStation;
	}
}