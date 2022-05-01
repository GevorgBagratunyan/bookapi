package com.glc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingList {

    private class BookItems {
        Book book;
        String readDate;
        int rating;

        public BookItems(Book book, String readDate, int rating) {
            this.book = book;
            this.readDate = readDate;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return book.toString() + String.format(", read on %s, rating -> %d", readDate, rating);
        }
    }

    private List<BookItems> books;

    public ReadingList() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books.stream()
                .map(bookItems -> bookItems.book)
                .collect(Collectors.toList());
    }

    public void addBook(Book book, String readDate, int rating) {
        if (rating > 5 || rating < 1) {
            throw new RuntimeException("Rating should be between 1 and 5");
        }
        books.add(new BookItems(book, readDate, rating));
    }

    public int numberRead() {
        return books.size();
    }

    public void deleteBook(String title) {
        boolean success = books.removeIf(bookItems -> bookItems.book.getTitle().equals(title));
        if(!success) {
            throw new RuntimeException("The book by given title" + title + " not found");
        }
    }

    public List<Book> getBooksByRating(int rating) {
        return books.stream()
                .filter(bookItems -> bookItems.rating == rating)
                .map(bookItems -> bookItems.book)
                .collect(Collectors.toList());
    }
}
