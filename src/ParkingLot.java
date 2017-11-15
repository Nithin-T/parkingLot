public interface ParkingLot {
    ParkingToken park(Vehicle car);

    boolean unPark(Vehicle car);

    void subscribe(ParkingLotNotifiable lotNotifiable);

    boolean isFull();

    int takenSize();
}

