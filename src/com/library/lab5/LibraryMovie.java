package com.library.lab5;

public class LibraryMovie implements DigitalContent {
    private String name;
    private String director;
    private String streamUrl;
    private int duration;
    private int releaseYear;
    private String genre;
    private double price;

    public LibraryMovie(String name, String director, String streamUrl, int duration, int releaseYear, String genre, double price) {
        this.name = name;
        this.director = director;
        this.streamUrl = streamUrl;
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return name;
    }

    @Override
    public void streamOnline() {
        System.out.println("Streaming " + name + " from URL: " + streamUrl);
        System.out.println("Starting online stream connected!");
        System.out.println("You can now watch the movie online.");
    }

    @Override
    public void download() {
        System.out.println("Downloading " + name + " from URL: " + streamUrl);
        System.out.println("Downloading video file");
        System.out.println("Download complete File saved to your device.");
    }
}