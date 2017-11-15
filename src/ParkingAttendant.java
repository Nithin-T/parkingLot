import java.util.List;
import java.util.stream.Collectors;

public class ParkingAttendant {

    List<ParkingLot> parkingLots;

    public ParkingAttendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingToken park(ParkingStrategy parkingStrategy,Vehicle vehicle) {

        return parkingStrategy.getAvailableLot(this.parkingLots).park(vehicle);

    }
//
//    public ParkingToken parkEvenOnAllLevels(Vehicle vehicle) {
//        List<ParkingLot> availableLots = this.parkingLots.stream().filter(p->!p.isFull()).collect(Collectors.toList());
//        int min = Integer.MAX_VALUE;
//        ParkingLot nextAvailableLot = null;
//        for(ParkingLot parkingLot: availableLots){
//            if(min > parkingLot.takenSize()) {
//                min = parkingLot.takenSize();
//                nextAvailableLot = parkingLot;
//            }
//        }
//        return nextAvailableLot.park(vehicle);
//    }
}