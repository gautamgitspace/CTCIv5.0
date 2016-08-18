package CTCI8_5;

/**
 * Created by Gautam on 8/18/16.
 */
public class User
{
    private String userID;
    private String userName;
    private String accountType;
    private float currentBalance;

    //DEFCONS
    public User(String u, String un, String at, float bal)
    {
        this.userID = u;
        this.userName = un;
        this.accountType = at;
        this.currentBalance = bal;

    }
    public void setCurrentBalance(float amount)
    {
        currentBalance+=amount;
    }
    public float getCurrentBalance()
    {
        return currentBalance;
    }
    public void setUserID(String userID)
    {this.userID = userID;}
    public void setUserName(String userName)
    {this.userName = userName;}
    public void setAccountType(String accountType)
    {this.accountType = accountType;}
    public String getUserID()
    {return userID;}
    public String getUserName()
    {return userName;}
    public String getAccountType()
    {
        return accountType;
    }
}
