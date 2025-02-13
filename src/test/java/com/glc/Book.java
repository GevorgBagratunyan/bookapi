package com.glc;

public class Book {

    private String title;
    private String author;
    private int length;
    private int year;

    public Book(String title, String author, int length, int year) {
        this.title = title;
        this.author = author;
        this.length = length;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getLength() {
        return length;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s by %s, %d pages, %d", title, author, length, year);
    }
}
