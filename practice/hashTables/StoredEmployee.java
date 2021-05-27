package practice.hashTables;

public class StoredEmployee {
	public String key;
	public Employee emp;

	StoredEmployee(String key, Employee emp) {
		this.emp = emp;
		this.key = key;
	}
}
