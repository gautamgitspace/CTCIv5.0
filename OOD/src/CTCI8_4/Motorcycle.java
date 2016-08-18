package CTCI8_4;

/**
 * Created by Gautam on 8/18/16.
 */
public class Motorcycle extends Vehicle
{
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    public void print() {
        System.out.print("M");
    }
}
