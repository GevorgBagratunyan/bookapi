package com.glc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    //Given that I visit the site, when I first start, I expect my list to be empty.
    @Test
    public void onFirstCallBookListShouldBeEmpty() {
        //SETUP
        ReadingList readingList = new ReadingList();

        //EXECUTE
        List<Book> books = readingList.getBooks();

        //ASSERT
        assertEquals(books.size(), 0);
    }

    //Given that I have an empty list, when I add the first book to my list then I expect `numberRead` to return 1.
    @Test
    public void onFirstBookAddedNumberReadShouldBeOne() {
        //SETUP
        ReadingList readingList = new ReadingList();
        Book book = new Book("1984", "George Orwell", 328, 1949);
        readingList.addBook(book, "January 24, 2021", 5);

        //EXECUTE
        int actual =readingList.numberRead();

        //ASSERT
        assertEquals(actual, 1);
    }

    //Given that I have an empty list, when I add additional books to the list I expect the numberRead to return the total number of books in my list.
    @Test
    public void onAdditionalBooksAddedNumberReadShouldReturnTotalNumberOfBooks() {
        //SETUP
        ReadingList readingList = new ReadingList();
        Book book1 = new Book("1984", "George Orwell", 328, 1949);
        Book book2 = new Book("The Da Vinci Code", "Dan Brown", 689, 2003);
        Book book3 = new Book("The Picture of Dorian Gray", "Oscar Wilde", 456, 1890);
        readingList.addBook(book1, "January 24, 2021", 5);
        readingList.addBook(book2, "February 13, 2005", 4);
        readingList.addBook(book3, "October 9, 2008", 5);

        //EXECUTE
        int actual = readingList.numberRead();

        //ASSERT
        assertEquals(actual, 3);
    }

    //Given that I have a book in my list, when I call removeBook("<title>") with "title" representing the title of my book that I want to delete,
    //then when I call getBooks() the book I deleted should no longer be there.
    @Test
    public void removeBookShouldRemoveBookInBookList_And_getBooksShouldReturnListWithoutRemovedOne() {
        //SETUP
        ReadingList readingList = new ReadingList();
        Book book1 = new Book("1984", "George Orwell", 328, 1949);
        Book book2 = new Book("The Da Vinci Code", "Dan Brown", 689, 2003);
        Book book3 = new Book("The Picture of Dorian Gray", "Oscar Wilde", 456, 1890);
        readingList.addBook(book1, "January 24, 2021", 5);
        readingList.addBook(book2, "February 13, 2005", 4);
        readingList.addBook(book3, "October 9, 2008", 5);

        //EXECUTE
        readingList.deleteBook("The Da Vinci Code");
        List<Book> books = readingList.getBooks();

        //ASSERT
        assertFalse(books.contains(book2));
    }

    //Given that I have an empty list, when I add a new book I expect getBooks() to return a list of books that includes the book I added.
    @Test
    public void getBooksShouldReturnListOfAddedBooks() {
        //SETUP
        ReadingList readingList = new ReadingList();
        Book book = new Book("1984", "George Orwell", 328, 1949);
        readingList.addBook(book, "January 24, 2021", 5);

        //EXECUTE
        List<Book> books = readingList.getBooks();

        //ASSERT
        assertTrue(books.contains(book));
    }

    //Given when I call getBooksByRating(), I should return a list of books that all have that rating.
    @Test
    public void getBooksByRatingShouldReturnBooksFilteredByRating() {
        //SETUP
        ReadingList readingList = new ReadingList();
        Book book1 = new Book("1984", "George Orwell", 328, 1949);
        Book book2 = new Book("The Da Vinci Code", "Dan Brown", 689, 2003);
        Book book3 = new Book("The Picture of Dorian Gray", "Oscar Wilde", 456, 1890);
        readingList.addBook(book1, "January 24, 2021", 5);
        readingList.addBook(book2, "February 13, 2005", 4);
        readingList.addBook(book3, "October 9, 2008", 5);

        //EXECUTE
        List<Book> books = readingList.getBooksByRating(5);

        //ASSERT
        assertEquals(books.size(),2);
        assertFalse(books.contains(book2));
    }
}
