package tws.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ParkingLot {
	@NotEmpty(message="ͣ��������Ϊ��")
	private String parkingLotId;
	
	@Max(value = 100,message = "����С��100")
	@Min(value = 1,message = "�������0")
	private int capacity;
	
	@Max(value = 100,message = "����С��100")
	@Min(value = 1,message = "�������0")
	private int availablePositionCount;
	
	@Max(value = 100,message = "����С��100")
	@Min(value = 1,message = "�������0")
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
