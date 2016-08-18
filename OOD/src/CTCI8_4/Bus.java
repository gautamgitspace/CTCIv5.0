package CTCI8_4;

/**
 * Created by Gautam on 8/18/16.
 */
public class Bus extends Vehicle
{
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    public boolean canFitInSpot(ParkingSpot spot)
    {
        return spot.getSize() == VehicleSize.Large;
    }

    public void print() {
        System.out.print("B");
    }

}
