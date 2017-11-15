import java.util.List;

public class FirstAvailableStrategy implements ParkingStrategy {

    @Override
    public ParkingLot getAvailableLot(List<ParkingLot> parkingLots) {
        return parkingLots.stream().filter(p->!p.isFull()).findFirst().get();
    }
}
