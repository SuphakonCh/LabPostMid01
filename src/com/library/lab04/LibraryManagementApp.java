package com.library.lab04;

import java.util.ArrayList;
import java.util.List;
public class LibraryManagementApp {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" LIBRARY MANAGEMENT SYSTEM - POLYMORPHISM DEMO");
        System.out.println("=".repeat(60));
// Create a list of LibraryItem (demonstrates polymorphism)
//        List<PhysicalBook> physicalBooks = new ArrayList<>();
//        List<EBook> eBooks = new ArrayList<>();
        List<LibraryItem> allItem = new ArrayList<>();
// Add Physical Books
        allItem.add(new PhysicalBook("Java Programming", "John Smith", "978-0134685991",
                450.0, "A1-04"));
        allItem.add(new PhysicalBook("Clean Code", "Robert Martin", "978-0132350884", 520.0,
                "B2-15"));
        allItem.add(new PhysicalBook("Design Patterns", "Gang of Four", "978-0201633612",
                680.0, "A3-22"));
// Add E-Books
        allItem.add(new EBook("Effective Java", "Joshua Bloch", "978-0134685991", "https://library.ebooks.com/effective-java.pdf", 5.2));
        allItem.add(new EBook("Python Crash Course", "Eric Matthes", "978-1593279288", "https://library.ebooks.com/python-crash.pdf", 8.7));
// Instantiate member object
        Member member1 = new Member("M001", "Somsak");
        Member member2 = new Member("M002", "Suda");
// Display all items using polymorphism
        System.out.println("\n--- ALL LIBRARY ITEMS (Polymorphism Demo) ---");
        System.out.println("Calling displayDetails() on each item in the list:");
        System.out.println();
//        for (PhysicalBook item : physicalBooks) {
//            item.displayDetails();
//        }
//        for (EBook item : eBooks) {
//            item.displayDetails();
//        }
        for (LibraryItem item: allItem){
            item.displayDetails();
        }
// Demonstrate checkOut() method
        System.out.println("\n--- TESTING CHECKOUT FUNCTIONALITY ---");
        System.out.println("\nMember Somsak borrows Physical Book:");
        allItem.get(0).checkOut(member1);
        System.out.println("\nMember Suda borrows E-Book:");
        allItem.get(4).checkOut(member2);
        System.out.println("\nAttempting to checkout an already borrowed item:");
        allItem.get(0).checkOut(member2);
// Display items after checkout using polymorphism
        System.out.println("\n--- ITEMS STATUS AFTER CHECKOUT ---");
        for (LibraryItem item: allItem) {
            item.displayDetails();
        }
// Demonstrate returnItem() method
        System.out.println("\n--- TESTING RETURN FUNCTIONALITY ---");
        System.out.println("\nReturning Physical Book:");
        allItem.get(0).returnItem();
// Test borrowing limit
        System.out.println("\n--- TESTING BORROW LIMIT ---");
        allItem.get(0).checkOut(member1);
        allItem.get(1).checkOut(member1);
        allItem.get(2).checkOut(member1);
        allItem.get(4).checkOut(member1); // Should be denied (limit reached)
// Final display using polymorphism
        System.out.println("\n--- FINAL LIBRARY STATUS (Polymorphism Demo) ---");
        for (LibraryItem item: allItem) {
            item.displayDetails();
        }
//        for (EBook item : eBooks) {
//            item.displayDetails();
//        }
// ==================== METHOD OVERRIDING: Late Fee Demo ====================
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" METHOD OVERRIDING: LATE FEE CALCULATION DEMO");
        System.out.println("=".repeat(60));

// Simulate late returns
        int daysLate = 5;
        System.out.println("\n--- Late Fee Calculation (" + daysLate + " days late) ---");
        System.out.println("\nPhysical Books (5 Baht per day late fee) and E-Books (NO late fees - files auto-expire)::");
        for (LibraryItem item: allItem) {
            double lateFee = item.calculateLateFee(daysLate);
            System.out.printf(" \uD83D\uDCDA %s: %.2f Baht\n", item.getName(), lateFee);
        }

// ==================== INTERFACE IMPLEMENTATION: TAXABLE DEMO ====================
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" INTERFACE IMPLEMENTATION: TAXABLE DEMO");
        System.out.println("=".repeat(60));
        System.out.println("Tax Calculation for Physical Books (7%) and E-Books (5%):");

        for (LibraryItem item : allItem) {
            if (item instanceof Taxable) {
                Taxable taxableItem = (Taxable) item;
                double tax = taxableItem.calculateTax();
                System.out.printf(" \uD83D\uDCB0 %s: Price = %.2f Baht, Tax = %.2f Baht, Total = %.2f Baht\n",
                        item.getName(), item.getPrice(), tax, item.getPrice() + tax);
            }
        }

// ==================== UNIVERSAL STREAMING PLAYER ====================
// Create a list for DigitalContent items (can contain both EBooks and Movies!)
        List<DigitalContent> digitalContent = new ArrayList<>();

// Add movies (NOTE: Movies do NOT inherit from LibraryItem!)
        LibraryMovie movie1 = new LibraryMovie("The Matrix", "Lana Wachowski",
                "https://streaming.library.com/matrix.mp4", 136, 1999, "Sci-Fi", 199.0);
        LibraryMovie movie2 = new LibraryMovie("Inception", "Christopher Nolan",
                "https://streaming.library.com/inception.mp4", 148, 2010, "Sci-Fi/Thriller", 249.0);

// Add them to the digital content list
        digitalContent.add(movie1);
        digitalContent.add(movie2);

// Also add ebooks to the digital content list
        digitalContent.add(new EBook("Effective Java", "Joshua Bloch", "978-0134685991",
                "https://library.ebooks.com/effective-java.pdf", 5.2));

// Demonstrate the Universal Streaming Player
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" UNIVERSAL STREAMING PLAYER (Polymorphism via Interfaces)");
        System.out.println("=".repeat(60));
        System.out.println("\nThis demonstrates interface-based polymorphism:");
        System.out.println("A single player can handle BOTH movies and e-books!\n");

// Play through each digital content without caring about their actual type
        for (DigitalContent content : digitalContent) {
            if (content instanceof LibraryMovie) {
                LibraryMovie movie = (LibraryMovie) content;
                System.out.println(" STREAMING PLAYER - Playing Movie: " + movie.getTitle());
            } else if (content instanceof EBook) {
                EBook book = (EBook) content;
                System.out.println(" STREAMING PLAYER - Reading E-Book: " + book.getName());
            }
            System.out.println("---");
            launchStreamingPlayer(content);
        }
    }

    public static void launchStreamingPlayer(DigitalContent content) {
        System.out.println("Connecting to streaming service...");
        System.out.println("Loading content...\n");
        content.streamOnline();
        System.out.println("User requests offline copy:");
        content.download();
    }
}