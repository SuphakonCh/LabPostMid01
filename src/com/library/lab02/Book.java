package com.library.lab02;

import java.time.LocalDate;

public class Book {
    private String name;
    private double price;
    private String author;
    private String isbn;
    private String status;
    private String returnDate;

    public Book(String name, String author, String isbn, double price, String status) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
        this.returnDate = "N/A (Book is available)";
    }

    public void displayDetails() {
        System.out.println("\n - Title:           " + name);
        System.out.println(" - Author:          " + author);
        System.out.println(" - ISBN:            " + isbn);
        System.out.println(" - Price:           " + price);
        System.out.println(" - Status:          " + status);
        System.out.println(" - Return Due Date: " + returnDate);
    }

    public void checkOut(Member member) {
        if (status.equals("Available")) {
            if (member.canBorrow()) {
                status = "Borrowed";
                LocalDate date = LocalDate.now();
                returnDate = date.toString();

                member.incrementBorrowCount();
                System.out.println("\n   Book \"" + name + "\" has been checked out successfully.");
                System.out.println("   Book " + name + " has been borrowed by " + member.getMemberName() + ".");
                System.out.println("   Return Due Date: " + returnDate);
            } else {
                System.out.println("\n   Member " + member.getMemberName() + " has reached the borrow limit (3).");
                System.out.println("   Borrow request denied for member " + member.getMemberName() + ".");
            }

        } else {
            System.out.println(" Error: Book \"" + name + "\" is already borrowed and cannot be checked out again.");
        }
    }

    public void returnBook() {
        status = "Available";
        returnDate = "N/A (Book is available)";
        System.out.println("   Book \"" + name + "\" has been returned successfully.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}