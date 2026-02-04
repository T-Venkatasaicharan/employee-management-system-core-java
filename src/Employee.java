
public class Employee {
	private int id;
	private String name;
	private double salary;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	public int getId() {
		return id;
	}
	public double getSalary() {
		return salary;
	}
	
	public String getName() {
		return name;
	}
	public Employee(int id,String name,double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
}
