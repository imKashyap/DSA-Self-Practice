package practice.hashTables;

public class SimpleHashTable {
	StoredEmployee[] hashTable;

	public SimpleHashTable() {
		hashTable = new StoredEmployee[10];
	}

	private int getKey(String name) {
		return name.length() % hashTable.length;
	}

	public void put(String key, Employee emp) {
		int index = getKey(key);
		if (isOccupied(index)) {
			int stopIndex = index;
			int start = (index + 1) % hashTable.length;
			while (hashTable[start] != null && start != stopIndex)
				start = (start + 1) % hashTable.length;
			if (start == stopIndex)
				System.out.println("Table is full");
			else
				hashTable[start] = new StoredEmployee(key, emp);
		} else
			hashTable[index] = new StoredEmployee(key, emp);
	}

	private boolean isOccupied(int index) {
		return hashTable[index] != null;
	}

	public Employee get(String key) {
		int index = getKey(key);
		if (hashTable[index] == null)
			return null;
		if (!hashTable[index].key.equals(key)) {
			int stopIndex = index;
			index = (index + 1) % hashTable.length;
			while (!hashTable[index].key.equals(key) && index != stopIndex) {
				index = (index + 1) % hashTable.length;
			}
		}
		return hashTable[index].emp;
	}

	public void print() {
		for (int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null)
				System.out.println(i + ": " + hashTable[i].emp.getName());
	}

	public Employee remove(String key) {
		int index = getKey(key);
		if (hashTable[index] == null)
			return null;
		if (!hashTable[index].key.equals(key)) {
			int stopIndex = index;
			index = (index + 1) % hashTable.length;
			while (!hashTable[index].key.equals(key) && index != stopIndex) {
				index = (index + 1) % hashTable.length;
			}
		}
		Employee removed = hashTable[index].emp;
		hashTable[index] = null;
		StoredEmployee[] temp = hashTable;
		hashTable = new StoredEmployee[temp.length];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null)
				put(temp[i].key, temp[i].emp);
		}
		return removed;
	}
}
