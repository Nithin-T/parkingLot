public class ParkingToken {

    private final String plateNo;
    private final int level;

    public ParkingToken(String plateNo, int level) {
        this.plateNo = plateNo;
        this.level = level;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public int getLevel() {
        return level;
    }
}
