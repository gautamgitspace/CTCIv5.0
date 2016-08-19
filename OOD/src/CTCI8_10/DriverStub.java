package CTCI8_10;

/**
 * Created by Gautam on 8/18/16.
 */
public class DriverStub
{
    public static void main(String[] args)
    {
        TestClass bob = new TestClass("Bob", 20);
        TestClass jim = new TestClass("Jim", 25);
        TestClass alex = new TestClass("Alex", 30);
        TestClass tim = new TestClass("Tim", 35);
        TestClass maxwell = new TestClass("Maxwell", 40);
        TestClass john = new TestClass("John", 45);
        TestClass julie = new TestClass("Julie", 50);
        TestClass christy = new TestClass("Christy", 55);
        TestClass tim2 = new TestClass("Tim", 100); // This should replace the first "tim"

        TestClass[] dummies = {bob, jim, alex, tim, maxwell, john, julie, christy, tim2};
		
		/* Test: Insert Elements. */
        /*KEY IS NAME AND VALUE IS OBJECT OF TEST CLASS*/
        Hash<String, TestClass> hash = new Hash<String, TestClass>();
        for (TestClass d : dummies)
        {
            /*INSET KEY(NAME) and VALUE(obj)*/
            hash.put(d.getName(), d);
        }

        hash.debugPrintHash();
		
		/* Test: Recall */
//        for (TestClass d : dummies) {
//            String name = d.getName();
//            TestClass dummy = hash.get(name);
//            System.out.println("TestClass named " + name + ": " + dummy.toString());
//        }
    }
}
