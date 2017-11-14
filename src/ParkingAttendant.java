import java.util.List;

public class ParkingAttendant {

    List<ParkingLot> parkingLots;

    public ParkingAttendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String park(Vehicle vehicleOne) {

        return this.parkingLots.stream().filter(p->!p.isFull()).findFirst().get().park(vehicleOne);

    }
}