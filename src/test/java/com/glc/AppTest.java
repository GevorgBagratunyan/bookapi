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
        int actual =readingList.readNumber();

        //ASSERT
        assertEquals(actual, 1);
    }
}
