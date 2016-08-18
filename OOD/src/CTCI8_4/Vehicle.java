package CTCI8_4;

import java.util.ArrayList;

/**
 * Created by Gautam on 8/18/16.
 */
public abstract class Vehicle
{
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    /* Park vehicle in this spot (among others, potentially) */
    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    /* Remove car from spot, and notify spot that it's gone */
    public void clearSpots()
    {
        for (int i = 0; i < parkingSpots.size(); i++)
        {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}
