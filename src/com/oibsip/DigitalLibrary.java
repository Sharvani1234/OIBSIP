package com.oibsip;

import java.util.ArrayList;
import java.util.List;

class Book{
	private String title;
	private String author;
	private int quantity;
	
	public Book(String title,String author,int quantity) {
		this.title=title;
		this.author=author;
		this.quantity=quantity;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
}

class Library{
	private List<Book>books;
	
	public Library() {
		this.books=new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void displayBooks() {
		for(Book book:books) {
			System.out.println("Title:"+book.getTitle()+",Author:"+book.getAuthor()+",Quantity:"+book.getQuantity());
		}
	}
	
	public Book searchBook(String title) {
		for(Book book:books) {
			if(book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}
	
	public boolean issueBook(String title) {
		Book book=searchBook(title);
		if(book!=null && book.getQuantity()>0) {
			book.setQuantity(book.getQuantity()-1);
			return true;
		}
		return false;
	}
	
	public void returnBook(String title) {
		Book book=searchBook(title);
		if(book!=null) {
			book.setQuantity(book.getQuantity()+1);
		}
	}
}

class Admin{
	private Library library;
	
	public Admin(Library library) {
		this.library=library;
	}
	
	public void addBook(String title,String author,int quantity) {
		library.addBook(new Book(title,author,quantity));
	}
}

class User{
	private Library library;
	
	public User(Library library) {
		this.library=library;
	}
	
	public void displayBooks() {
		library.displayBooks();
	}
	
	public boolean issueBook(String title) {
		return library.issueBook(title);
	}
	
	public void returnBook(String title) {
		library.returnBook(title);
	}
}

public class DigitalLibrary {
	public static void main(String[] args) {
		Library library=new Library();
		Admin admin=new Admin(library);
		User user=new User(library);
		
		admin.addBook("Book1","Author1",5);
		admin.addBook("Book2","Author2",3);
		
		System.out.println("All books:");
		user.displayBooks();
		
		boolean issued=user.issueBook("Book1");
		if(issued) {
			System.out.println("Book issued successfully.");
		}
		else {
			System.out.println("Book not available or cannot be issued.");
		}
		
		System.out.println("Books after issuing:");
		user.displayBooks();
		
		user.returnBook("Book1");
		
		System.out.println("Books after returning:");
		user.displayBooks();
	}
}