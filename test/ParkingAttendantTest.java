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

    ParkingStrategy parkingStrategy = ParkingStrategy.FIRST_AVAILABLE;

    ParkingAttendant parkingAttendant = new ParkingAttendant(Arrays.asList(levelZero,levelOne));
    ParkingToken tokenOne = parkingAttendant.park(parkingStrategy,vehicleOne);
    ParkingToken tokenTwo = parkingAttendant.park(parkingStrategy,vehicleTwo);

    assertEquals("1A",tokenOne.getPlateNo());
    assertEquals("1B",tokenTwo.getPlateNo());

   assertEquals(0,tokenOne.getLevel());
   assertEquals(1,tokenTwo.getLevel());

}

   @Test
   public void shouldParkInLevelZeroWhenItHasLeastNumberOfCars(){

      Vehicle carOne = new Vehicle("1A");
      Vehicle carTwo = new Vehicle("2A");
      Vehicle carThree = new Vehicle("3A");
      Vehicle carFour = new Vehicle("4A");
      Vehicle carFive = new Vehicle("5A");

      ParkingLot parkingLotLevelZero = new ParkingLotImpl(5,0);
      ParkingLot parkingLotLevelOne = new ParkingLotImpl(5,1);
      ParkingLot parkingLotLevelTwo = new ParkingLotImpl(5,2);

      ParkingStrategy parkingStrategy = ParkingStrategy.EVENLY_DISTRIBUTED;

      ParkingAttendant parkingAttendant = new ParkingAttendant(Arrays.asList(parkingLotLevelZero,parkingLotLevelOne,parkingLotLevelTwo));

      parkingLotLevelOne.park(carOne);
      parkingLotLevelZero.park(carTwo);
      parkingLotLevelTwo.park(carThree);
      parkingLotLevelZero.park(carFour);

      assertEquals(1,parkingAttendant.park(parkingStrategy,carFive).getLevel());


}

}
