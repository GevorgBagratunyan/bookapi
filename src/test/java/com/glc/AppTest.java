package com.glc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

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
}
