package CTCI10_2;

import java.util.HashMap;

/**
 * Created by Gautam on 8/21/16.
 */
public class Server
{
    private HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
    private HashMap<Integer, Integer> machineToPersonMap = new HashMap<Integer, Integer>();

    public Machine getMachineByMachineID(int machineID)
    {
       return machines.get(machineID);
    }

    public int getMachineIDFromPersonID(int personID)
    {
        Integer machineID = machineToPersonMap.get(personID);
        if(machineID == null)
        {
            return -1;
        }
        return machineID;
    }

    public Person getPerson(int personID)
    {
        Integer machineID = getMachineIDFromPersonID(personID);
        Machine machine = getMachineByMachineID(machineID);
        /*PERSON LOOKUP*/
        Person person = getPerson(personID);
        return person;
    }


}
