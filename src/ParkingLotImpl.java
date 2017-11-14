import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotImpl implements ParkingLot {
    private Map<String, Vehicle> parkingSlots = new HashMap<>();
    private List<ParkingLotNotifiable> notifiables = new ArrayList<>();
    private final int capacity;
    private final int level;

    public ParkingLotImpl(int capacity, int level) {
        this.capacity = capacity;
        this.level = level;
    }

    public String park(Vehicle car) {
        if (isFull() || wasParked(car))
            return "P-FAIL";
        parkingSlots.put(car.getPlateNo(), car);
        if (isFull()) {
            for (ParkingLotNotifiable notifiable : notifiables) {
                notifiable.notifyFull();
            }
        }
        return "P-" + car.getPlateNo()+"-"+level;
    }

    public boolean unPark(Vehicle car) {
        if (!wasParked(car)) {
            return false;
        }

        boolean wasFull = isFull();
        parkingSlots.remove(car.getPlateNo());
        if (wasFull) {
            notifyAvailable();
        }
        return true;
    }

    private void notifyAvailable() {
        for (ParkingLotNotifiable notifiable : notifiables) {
            notifiable.notifyAvailable();
        }
    }

    public void subscribe(ParkingLotNotifiable lotNotifiable) {
        notifiables.add(lotNotifiable);
    }

    private boolean wasParked(Vehicle car) {
        return parkingSlots.containsKey(car.getPlateNo());
    }

    public boolean isFull() {
        return parkingSlots.size() == capacity;
    }

}
