package tws.entity;

import org.hibernate.validator.constraints.Length;

public class Parkingboy {
	@Length(min = 1, max = 100, message = "id 长度必须在 {min} - {max} 之间")
	private int id;
	
	private String name;
	
	public Parkingboy() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Parkingboy(@Length(min = 1, max = 100, message = "id 长度必须在 {min} - {max} 之间") int id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
