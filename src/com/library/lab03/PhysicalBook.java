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
        super.displayDetails();
        System.out.println(" shelfLocation " + this.shelfLocation);
    }
}
