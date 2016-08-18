package CTCI8_4;

/**
 * Created by Gautam on 8/18/16.
 */
public class Car extends Vehicle
{
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }

    public void print() {
        System.out.print("C");
    }
}
