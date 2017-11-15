import java.util.List;

public interface ParkingStrategy {

    ParkingStrategy FIRST_AVAILABLE = new FirstAvailableStrategy();
    ParkingStrategy EVENLY_DISTRIBUTED = new EvenlyDitributedStrategy();

    ParkingLot getAvailableLot(List<ParkingLot> parkingLots);

}
