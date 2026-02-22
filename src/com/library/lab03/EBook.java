package com.library.lab03;

public class EBook extends LibraryItem {
    private String downloadUrl;
    private  double fileSize;

    public EBook(String name, String author, String isbn, String downloadUrl, double fileSize) {
        super(name, author, isbn, 0.0, "Available");
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
        return 0.0; // E-Book ไม่มีค่าปรับ (ไฟล์หมดอายุอัตโนมัติ)
    }
}
