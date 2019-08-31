package tws.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class Parkingboy {
	@Length(min = 1, max = 10, message = "id 长度必须在 {min} - {max} 之间")
	@Max(value = 100,message = "必须小于100")
	@Min(value = 1,message = "必须大于0")
	private int id;
	
	@NotEmpty(message="名字不能为空")
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
