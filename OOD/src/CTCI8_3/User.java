package CTCI8_3;

/**
 * Created by Gautam on 8/17/16.
 */
public class User
{
    String name;
    Long user_id;
    Double balance;
    public User(String name, Long ID)
    {
        this.name = name;
        user_id = ID;
        balance = 0.0;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setUser_id(Long ID)
    {
        user_id = ID;
    }
    public String getName()
    {
        return name;
    }
    public Long getUser_id()
    {
        return user_id;
    }
    public User addUser(String name, Long ID)
    {
        return new User(name, ID);
    }
    public void setBalance(Double rechageAmount, long UID)
    {
        if(user_id==UID) {
            balance = balance + rechageAmount;
        }
    }
    public Double getCurrentBalance()
    {
        return balance;
    }




}
