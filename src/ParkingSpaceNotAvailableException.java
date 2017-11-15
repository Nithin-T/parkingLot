public class ParkingSpaceNotAvailableException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Parking is Full";
    }
}
