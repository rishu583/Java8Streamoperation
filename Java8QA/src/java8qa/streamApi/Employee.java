package java8qa.streamApi;

public class Employee {
	
	private int id;
	private String name;
	private int sallary;
	private String city;
	
	public Employee(int id,String name,int sallary,String city) {
		this.id=id;
		this.name=name;
		this.sallary=sallary;
		this.city=city;

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

	public int getSallary() {
		return sallary;
	}

	public void setSallary(int sallary) {
		this.sallary = sallary;
	}
	public String getCity() {
		
		return city;
	}
	public void setCity(String city) {
	this.city=city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sallary=" + sallary + ", city=" + city + "]";
	}

	
	
	

}
