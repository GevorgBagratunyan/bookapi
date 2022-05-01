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
    }

    private List<BookItems> books = new ArrayList<>();

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


    public int readNumber() {
        return books.size();
    }
}
