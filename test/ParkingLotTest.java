import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {

    @Test
    public void shouldParkIfNotParked() {
        Vehicle car = vehicle("abc");
        ParkingLot lot = new ParkingLotImpl(2,0);
        assertEquals(car.getPlateNo(), lot.park(car).getPlateNo());

    }

    @Test(expected = ParkingSpaceNotAvailableException.class)
    public void shouldNotParkIfAlreadyParked() {
        Vehicle car = vehicle("abc");
        ParkingLot lot = new ParkingLotImpl(2,0);
        lot.park(car);
        lot.park(car);

    }

    @Test
    public void shouldUnParkIfAlreadyParked() {
        Vehicle car = vehicle("abc");
        ParkingLot lot = new ParkingLotImpl(2,0);
        lot.park(car);
        assertEquals(true, lot.unPark(car));

    }

    @Test
    public void shouldNotUnParkIfAlreadyUnParked() {
        Vehicle car = vehicle("abc");
        ParkingLot lot = new ParkingLotImpl(2,0);
        lot.park(car);
        lot.unPark(car);
        assertEquals(false, lot.unPark(car));

    }

    @Test(expected = ParkingSpaceNotAvailableException.class)
    public void shouldNotParkIfParkingLotIsFull() {
        ParkingLot lot = new ParkingLotImpl(2,0);

        lot.park(vehicle("abc"));
        lot.park(vehicle("123"));
        lot.park(vehicle("678"));

    }

    @Test
    public void shouldNotifyIfParkingLotIsFull(){
        ParkingLot lot = new ParkingLotImpl(2,0);
        lot.park(vehicle("abc"));
        DummyParkingLotNotifiable lotNotifiable = new DummyParkingLotNotifiable();
        lot.subscribe(lotNotifiable);
        Vehicle secondCar = vehicle("123");
        lot.park(secondCar);
        assertEquals(true,lotNotifiable.isFull);
    }

    @Test
    public void shouldNotifyIfParkingLotIsAvailable(){
        ParkingLot lot = new ParkingLotImpl(2,0);
        lot.park(vehicle("abc"));
        DummyParkingLotNotifiable lotNotifiable = new DummyParkingLotNotifiable();
        lot.subscribe(lotNotifiable);
        Vehicle secondCar = vehicle("123");
        lot.park(secondCar);
        lot.unPark(secondCar);
        assertEquals(false,lotNotifiable.isFull);
    }

    private Vehicle vehicle(String id) {
        return new Vehicle(id);
    }

    private class DummyParkingLotNotifiable implements ParkingLotNotifiable {
        boolean isFull;

        @Override
        public void notifyFull() {
            isFull = true;
        }

        @Override
        public void notifyAvailable() {
            isFull = false;
        }
    }
}
