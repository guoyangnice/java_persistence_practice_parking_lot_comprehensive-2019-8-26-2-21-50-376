package tws.entity;

public class ParkingLot {
	private String parkingLotStringID;
	private int capacity;
	private int availablePositionCount;
	private String parkingboyID;
	
	public String getParkingLotStringID() {
		return parkingLotStringID;
	}
	public void setParkingLotStringID(String parkingLotStringID) {
		this.parkingLotStringID = parkingLotStringID;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailablePositionCount() {
		return availablePositionCount;
	}
	public void setAvailablePositionCount(int availablePositionCount) {
		this.availablePositionCount = availablePositionCount;
	}
	
	
}
