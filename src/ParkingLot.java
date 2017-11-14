public interface ParkingLot {
    String park(Vehicle car);

    boolean unPark(Vehicle car);

    void subscribe(ParkingLotNotifiable lotNotifiable);

    boolean isFull();
}

