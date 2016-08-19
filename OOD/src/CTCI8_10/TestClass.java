package CTCI8_10;

/**
 * Created by Gautam on 8/18/16.
 */
public class TestClass
{
    private String name;
    private int age;
    public TestClass(String n, int a)
    {
        name = n;
        age = a;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + ")";
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
