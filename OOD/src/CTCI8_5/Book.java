package CTCI8_5;

/**
 * Created by Gautam on 8/18/16.
 */
public class Book
{
    private int bookID;
    private String bookDetails;

    //DEF CONS
    public Book(int bid, String bookDetails)
    {
        this.bookID = bid;
        this.bookDetails = bookDetails;
    }
    public int getBookdID()
    {
        return bookID;
    }
    public String getBookDetails()
    {return bookDetails;}

}
