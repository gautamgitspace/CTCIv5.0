package CTCI3_7;

import java.util.LinkedList;

/**
 * Created by Gautam on 8/15/16.
 */
public class AnimalQueue
{
    LinkedList<Dog> dogs;
    LinkedList<Cat> cats;
    int order = 0;
    int count = 0;

    /*DEF CONS*/
    AnimalQueue()
    {
        dogs = new LinkedList<Dog>();
        cats = new LinkedList<Cat>();
    }

    /*ENQUEUE*/
    public void enqueue(Animal animal)
    {
        /*SET THE ORDER OF THE ANIMAL, ADD ANIMAL TO THE CORRESPONDING LIST AND INCREMENT ORDER NUMBER*/
        animal.setOrder(order);
        order++;
        count++;
        if(animal instanceof Dog)
        {
            dogs.addLast((Dog) animal);
        }
        else if(animal instanceof Cat)
        {
            cats.addLast((Cat) animal);
        }
    }

    /*DEQUEUE ANY*/
    public Animal dequeueAny()
    {
        /* NO NEED TO CHECK ORDER. JUST PEEK AND RETURN FROM WHICHEVER LIST HAS DOGS/CATS */
        if (dogs.size() == 0)
            return dequeueCats();
        else if (cats.size() == 0)
            return dequeueDogs();

    /*TO DEQUEUE FROM DOGS OR CATS in particular, WE NEED TO CHECK THE ORDER*/
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat))
            return dequeueDogs();
        else
            return dequeueCats();
    }

    /*DEQUEUE DOGS*/
    public Dog dequeueDogs()
    {
        count--;
        return dogs.poll();
    }

    /*DEQUEUE CATS*/
    public Cat dequeueCats()
    {
        count--;
        return cats.poll();
    }

    /*getSize METHOD*/
    public int getSize()
    {
        return count;
    }

}
