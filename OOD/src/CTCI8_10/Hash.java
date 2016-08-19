package CTCI8_10;

import java.util.LinkedList;

/**
 * Created by Gautam on 8/18/16.
 */
public class Hash<K,V>
{
    private final int MAX_SIZE = 5;
    LinkedList<Cell<K, V>>[] items;

    public Hash()
    {
        items = (LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
    }

    public int hashCodeOfKey(K key)
    {
        System.out.println("Key: " + key.toString() + " MAPPED TO POSITION: " + key.toString().length() % items.length);
        return key.toString().length() % items.length;
    }

    public void put(K key, V value)
    {
        int x = hashCodeOfKey(key);
        if (items[x] == null)
        {
            items[x] = new LinkedList<Cell<K, V>>();
            System.out.println("FIRST ENTRY AT POSITION: " + x);
        }
        LinkedList<Cell<K, V>> collided = items[x];
        for (Cell<K, V> c : collided)
        {
            if (c.equivalent(key))
            {
                System.out.println("COLLISION WITH KEY: " + key.toString());
                collided.remove(c);
                break;
            }
        }

        Cell<K, V> cell = new Cell<K, V>(key, value);
        collided.add(cell);
        System.out.println( "ADDED NEW CELL FOR: " + cell.toString());
        System.out.println();
    }

    public V get(K key)
    {
        int x = hashCodeOfKey(key);
        if (items[x] == null)
        {
            return null;
        }
        LinkedList<Cell<K, V>> collided = items[x];
        for (Cell<K, V> c : collided)
        {
            if (c.equivalent(key)) {
                return c.getValue();
            }
        }

        return null;
    }

    public void debugPrintHash()
    {
        for (int i = 0; i < items.length; i++)
        {
            System.out.print("items[" + i + "]" + ": ");
            LinkedList<Cell<K, V>> list = items[i];
            if (list != null)
            {
                for (Cell<K, V> cell : list)
                {
                    System.out.print(cell.toString() + ", ");
                }
            }
            System.out.println("");
        }
    }
}
