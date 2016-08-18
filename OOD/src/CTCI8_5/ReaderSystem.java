package CTCI8_5;

/**
 * Created by Gautam on 8/18/16.
 */
public class ReaderSystem
{
    private  LibraryDB libraryDB;
    private Book book;
    private User user;
    private UserManager userManager;
    private Display display;

    //DEF CONS
    public ReaderSystem()
    {
        userManager = new UserManager();
        libraryDB = new LibraryDB();
        display = new Display();
    }

    public LibraryDB getLibraryDB()
    {
        return libraryDB;
    }
    public UserManager getUserManager()
    {
        return userManager;
    }
    public Display getDisplay()
    {
        return display;
    }
    public Book getBook()
    {
        return book;
    }
    public User getUser()
    {
        return user;
    }


}
