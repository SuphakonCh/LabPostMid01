package com.library.lab04;

public class PhysicalBook extends LibraryItem implements Taxable {
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

    @Override
    public double calculateTax() {
        return getPrice() * 0.07; // ตามโจทย์: Physical items คิดภาษี 7%
    }
}
