package com.library.lab03;

public class PhysicalBook extends LibraryItem {
    private String shelfLocation;

    public PhysicalBook(String name, String author, String isbn, double price,String shelfLocation){
        super(name, author, isbn, price,"Available");
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        super.displayDetails();
        System.out.println(" - Shelf Location:  " + this.shelfLocation);
    }
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 5.0;
    }
}
