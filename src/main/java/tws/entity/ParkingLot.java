package tws.entity;

import org.hibernate.validator.constraints.Length;

public class ParkingLot {
	@Length(min = 1, max = 100, message = "parkinglotId 长度必须在 {min} - {max} 之间")
	private String parkingLotId;
	
	@Length(min = 1, max = 100, message = "capacity 长度必须在 {min} - {max} 之间")
	private int capacity;
	
	private int availablePositionCount;
	
	@Length(min = 1, max = 100, message = "parkingboyID 长度必须在 {min} - {max} 之间")
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
