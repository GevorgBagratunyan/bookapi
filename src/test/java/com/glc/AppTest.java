package com.glc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
        List<Book> books = readingList.getBookList();

        //ASSERT
        assertEquals(books.size(), 0);
    }
}
