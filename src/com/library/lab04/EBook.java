package com.library.lab04;

public class EBook extends LibraryItem implements DigitalContent,Taxable {
    private String downloadUrl;
    private  double fileSize;

    public EBook(String name, String author, String isbn, String downloadUrl, double fileSize) {
        super(name, author, isbn, 99.0, "Available");
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;

    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }
    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        super.displayDetails();
        System.out.println(" Download URL " + this.downloadUrl);
        System.out.println(" File Size " + this.fileSize);

    }
    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0;
    }

    @Override
    public void streamOnline() {
        System.out.println("Streaming '" + getName() + "' from URL: " + downloadUrl);
    }

    @Override
    public void download() {
        System.out.println("Downloading E-Book file... (" + fileSize + " MB)");
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // ตามโจทย์: Digital items คิดภาษี 5%
    }
}
