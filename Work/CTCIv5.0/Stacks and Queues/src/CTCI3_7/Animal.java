package CTCI3_7;

/**
 * Created by Gautam on 8/15/16.
 */
public class Animal
{
    private int order;
    private String name;

    Animal(String id)
    {
        name=id;
    }

    public void setOrder(int order_id)
    {
        order = order_id;
    }

    public int getOrder()
    {
        return order;
    }
    public String getName()
    {
        return name;
    }

    public boolean isOlderThan(Animal obj)
    {
        return this.order < obj.getOrder();
    }

}
