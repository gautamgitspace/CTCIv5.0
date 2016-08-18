package CTCI8_5;

/**
 * Created by Gautam on 8/18/16.
 */
public class Display {
    private Book currentBook;
    private User currentUser;
    int pageNumber = 0;

    public void displayUserInfo(User user)
    {
        currentUser = user;
        updateUserName();
    }

    public void displayBook(Book b)
    {
        currentBook = b;
        showBookTitle();
        showPage();
        showPageNumber();
    }

    public void turnPage()
    {
        pageNumber++;
        showPage();
    }
    public void turnPageBack()
    {
        pageNumber--;
        showPage();
    }

    public void updateUserName()
    {
        System.out.println(currentUser.getUserID());
        System.out.println(currentUser.getUserName());
        System.out.println(currentUser.getAccountType());
        System.out.println(currentUser.getAccountType());
    }
    public void showBookTitle()
    {
        System.out.println(currentBook.getBookDetails());
    }
    public void showPage()
    {
        /*PAGE CONTENTS*/
    }
    public void showPageNumber()
    {
        System.out.println(pageNumber);
    }





}