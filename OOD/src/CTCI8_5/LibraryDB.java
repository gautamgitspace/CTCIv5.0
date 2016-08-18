package CTCI8_5;

import java.util.Hashtable;

/**
 * Created by Gautam on 8/18/16.
 */
public class LibraryDB
{
    private Hashtable<Integer, Book> libraryOfBooks;

    //CONS
    LibraryDB()
    {
        libraryOfBooks = new Hashtable<Integer, Book>();
    }
    /*ADDITION METHOD*/
    public Book addBookToLibrary(int id, String bookdetails)
    {
        Book book = new Book(id, bookdetails);
        if(libraryOfBooks.containsKey(id))
        {
            return null;
        }
        libraryOfBooks.put(id, book);
        return book;
    }
    /*REMOVAL METHOD*/
    public boolean removeBook(Book b)
    {
        return removeBookFromLibrary(b.getBookdID());
    }

    public boolean removeBookFromLibrary(int id)
    {
        if(!libraryOfBooks.containsKey(id))
            return false;
        libraryOfBooks.remove(id);
        return true;
    }
    /*SEARCH BOOK*/
    public Book search(int id)
    {
        return libraryOfBooks.get(id);
    }



}
