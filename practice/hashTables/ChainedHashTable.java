package practice.hashTables;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {
	LinkedList<StoredEmployee>[] hashTable;

	public ChainedHashTable() {
		hashTable = new LinkedList[10];
		for (int i = 0; i < hashTable.length; i++)
			hashTable[i] = new LinkedList<StoredEmployee>();
	}

	public int getHash(String key) {
		return key.length() % hashTable.length;
	}

	public void put(String key, Employee e) {
		int hash = getHash(key);
		hashTable[hash].add(new StoredEmployee(key, e));
	}

	public Employee get(String key) {
		int hash = getHash(key);
		ListIterator<StoredEmployee> iterator = hashTable[hash].listIterator();
		StoredEmployee emp = null;
		while (iterator.hasNext()) {
			emp = iterator.next();
			if (emp.key.equals(key))
				break;
		}
		return emp.emp;
	}

	public Employee remove(String key) {
		int hash = getHash(key);
		ListIterator<StoredEmployee> iterator = hashTable[hash].listIterator();
		StoredEmployee emp = null;
		while (iterator.hasNext()) {
			emp = iterator.next();
			if (emp.key.equals(key)) {
				hashTable[hash].remove(emp);
			}
		}
		return emp.emp;
	}

	public void print() {
		for (int i = 0; i < hashTable.length; i++) {
			ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();
			System.out.print(i + ": ");
			while (iterator.hasNext()) {
				StoredEmployee emp = iterator.next();
				System.out.print(emp.emp.getName() + " ");
			}
			System.out.println();
		}
	}
}
