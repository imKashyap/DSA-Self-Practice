package practice.hashTables;

public class MainClass {

	public static void main(String[] args) {
		SimpleHashTable ht = new SimpleHashTable();
		Employee e1 = new Employee("Rahul Kashyap", 0);
		Employee e2 = new Employee("Ravi Shankar", 1);
		Employee e3 = new Employee("Diksha Dixit", 2);
		Employee e4 = new Employee("Sarvjeet Kumar", 3);
		Employee e5 = new Employee("Ayush Raj", 4);
		ht.put("Rahul", e1);
		ht.put("Ravi", e2);
		ht.put("Diksha", e3);
		ht.put("Ayush", e5);
		ht.put("Sarvjeet", e4);
		ht.print();
		System.out.println("After remove");
		ht.remove("Rahul");
		ht.print();
	}
}
