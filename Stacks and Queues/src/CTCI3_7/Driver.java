package CTCI3_7;

/**
 * Created by Gautam on 8/15/16.
 */
public class Driver
{
    /* #DRIVER */
    public static void main(String args[])
    {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Dog("Pitsy"));
        animals.enqueue(new Dog("Mel"));
        animals.enqueue(new Dog("Bruno"));
        animals.enqueue(new Dog("Snoopy"));
        animals.enqueue(new Cat("Meow"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Cat("Meow"));
        animals.enqueue(new Cat("Girl"));
        animals.enqueue(new Cat("Boy"));


        System.out.println(animals.dequeueDogs().getName());
        System.out.println(animals.dequeueCats().getName());
        System.out.println(animals.dequeueAny().getName());

        while(animals.getSize()!=0)
        {
            System.out.println(animals.dequeueAny().getName());
        }

    }
}
