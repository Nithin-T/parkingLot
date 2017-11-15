import java.util.List;
import java.util.stream.Collectors;

public class EvenlyDitributedStrategy implements ParkingStrategy {

    @Override
    public ParkingLot getAvailableLot(List<ParkingLot> parkingLots) {

        List<ParkingLot> availableLots = parkingLots.stream().filter(p->!p.isFull()).collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        ParkingLot nextAvailableLot = null;
        for(ParkingLot parkingLot: availableLots){
            if(min > parkingLot.takenSize()) {
                min = parkingLot.takenSize();
                nextAvailableLot = parkingLot;
            }
        }
        return nextAvailableLot;
    }
}
