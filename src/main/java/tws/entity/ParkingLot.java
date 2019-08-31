package tws.entity;

import org.hibernate.validator.constraints.Length;

public class ParkingLot {
	@Length(min = 1, max = 100, message = "parkinglotId ���ȱ����� {min} - {max} ֮��")
	private String parkingLotId;
	
	@Length(min = 1, max = 100, message = "capacity ���ȱ����� {min} - {max} ֮��")
	private int capacity;
	
	private int availablePositionCount;
	
	@Length(min = 1, max = 100, message = "parkingboyID ���ȱ����� {min} - {max} ֮��")
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
