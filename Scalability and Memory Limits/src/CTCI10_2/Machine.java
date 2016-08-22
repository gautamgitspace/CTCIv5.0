package CTCI10_2;

import java.util.HashMap;

/**
 * Created by Gautam on 8/21/16.
 */
public class Machine
{
    int MachineID;
    private HashMap<Integer, Person> persons = new HashMap<Integer, Person>();

    private Person getPersonFromPersonID(int personID)
    {
        return persons.get(personID);
    }


}
