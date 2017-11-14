import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ParkingAttendantTest {

@Test
 public void parkingAttendantshouldParkTheCar(){

    ParkingLot levelZero = new ParkingLotImpl(1,0);
    ParkingLot levelOne = new ParkingLotImpl(1,1);

    Vehicle vehicleOne = new Vehicle("1A");
    Vehicle vehicleTwo = new Vehicle("1B");

    ParkingAttendant parkingAttendant = new ParkingAttendant(Arrays.asList(levelZero,levelOne));
    String recieptOne = parkingAttendant.park(vehicleOne);
    String recieptTwo = parkingAttendant.park(vehicleTwo);

    assertEquals("P-1A-0",recieptOne);
    assertEquals("P-1B-1",recieptTwo);


}

}
