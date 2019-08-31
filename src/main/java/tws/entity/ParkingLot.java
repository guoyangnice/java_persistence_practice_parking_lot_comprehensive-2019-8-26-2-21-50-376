package tws.entity;

public class ParkingLot {
	private String parkingLotId;
	private int capacity;
	private int availablePositionCount;
	private int parkingboyID;
	
	public String getParkingLotId() {
		return parkingLotId;
	}
	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
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
	public int getParkingboyID() {
		return parkingboyID;
	}
	public void setParkingboyID(int parkingboyID) {
		this.parkingboyID = parkingboyID;
	}
	
	
}
