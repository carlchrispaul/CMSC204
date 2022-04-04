package Project4;

/**
 * CDS
 * @author CCPaulHipolito
 */

import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	protected LinkedList<CourseDBElement>[] hashTable;
	protected int hashSize;
	
	/**
	 * Parameterized Constructor
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) {
		hashSize = size;
		hashTable = new LinkedList[hashSize];
	}
	
	/**
	 * Parameterized Constructor
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int size) {
		hashSize = size;
		hashTable = new LinkedList[hashSize];
	}
	
	/**
	 * Use the hashcode of the CourseDBElement to see if it’s in the hashtable. 
	 * If the CourseDBElement doesn’t exist in the hashtable, add it to the hashtable.
	 */
	@Override
	public void add(CourseDBElement element) {
		int hashIndex = element.hashCode() % hashTable.length;
		if(hashTable[hashIndex] != null) {
			hashTable[hashIndex].add(element);
		} else {
			hashTable[hashIndex] = new LinkedList<CourseDBElement>();
			hashTable[hashIndex].add(element);
		}
	}

	/**
	 * If the CourseDBElement is in the hashtable, return it. 
	 * If not, throw an IOException
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String element = Integer.toString(crn);
		int hashIndex = element.hashCode() % hashTable.length;
		LinkedList<CourseDBElement> hTable = hashTable[hashIndex];
		
		if(hashTable[hashIndex] != null) {
			for(int i = 0; i < hTable.size(); i++) {
				if(crn == hTable.get(i).getCRN()) {
					return hTable.get(i);
				}
			}
			throw new IOException("IOException");
		} else {
			throw new IOException("IOException");
		}
	}

	/**
	 * Returns the size of the ConcordanceDataStructure 
	 * (number of indexes in the array)
	 */
	@Override
	public int getTableSize() {
		return hashTable.length;
	}
}
