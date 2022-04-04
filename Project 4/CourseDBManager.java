package Project4;

/**
 * CDM
 * @author CCPaulHipolito
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure CDS;
	
	/**
	 * Constructor that initializes the size of the hash table
	 */
	public CourseDBManager() {
		CDS = new CourseDBStructure(20);
	}
	
	/**
	 * Create and add an entry using CourseDBStructure's add method
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement CDE = new CourseDBElement(id, crn, credits, roomNum, instructor);
		CDS.add(CDE);
	}

	/**
	 * Get an entry using CourseDBStructure's get method
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return CDS.get(crn);
		} catch(IOException e) {
			System.out.println("");
		}
		return null;
	}

	/**
	 * Read a given file of courses and add them to the Database
	 * Validates entries
	 * Saves any invalid entry in a text file called "invalid_entries.txt"
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("invalid_entries.txt");
		Scanner scanner = new Scanner(input);
		String courseID, roomNum, instructor;
		int credit, crn;
		CourseDBElement CDE;
		String line;
		String[] course;
		
		while(scanner.hasNextLine()) {
			line = scanner.nextLine();
			if(line.startsWith("#")) {
				continue;
			} else if(line.concat(" +") != null) {
				try {
					String after = line.trim().replaceAll(" +", " ");
					course = after.split(" ", 5);
					
					courseID = course[0];
					if(courseID.length() == 0) { throw new FileNotFoundException(); }
					
					crn = Integer.parseInt(course[1]);
					if(crn < 0) { throw new FileNotFoundException(); }
					
					credit = Integer.parseInt(course[2]);
					if(credit < 0) { throw new FileNotFoundException(); }
					
					roomNum = course[3];
					if(roomNum.length() == 0) { throw new FileNotFoundException(); }
					
					instructor = course[4];
					if(instructor.length() == 0) { throw new FileNotFoundException(); }
					
					CDE = new CourseDBElement(courseID, crn, credit, roomNum, instructor);
					CDS.add(CDE);
				} catch(Exception e) {
					writer.write(line + "\n");
				}
 			} else {
 				try {
					course = line.split(" ", 5);
					
					courseID = course[0];
					if(courseID.length() == 0) { throw new FileNotFoundException(); }
					
					crn = Integer.parseInt(course[1]);
					if(crn < 0) { throw new FileNotFoundException(); }
					
					credit = Integer.parseInt(course[2]);
					if(credit < 0) { throw new FileNotFoundException(); }
					
					roomNum = course[3];
					if(roomNum.length() == 0) { throw new FileNotFoundException(); }
					
					instructor = course[4];
					if(instructor.length() == 0) { throw new FileNotFoundException(); }
					
					CDE = new CourseDBElement(courseID, crn, credit, roomNum, instructor);
					CDS.add(CDE);
				} catch(Exception e) {
					writer.write(line + "\n");
				}
			}
		}
		writer.close();
		scanner.close();
	}

	/**
	 * Return an ArrayList of the courses in the order of CRN
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> arrList = new ArrayList<>();
		for(LinkedList<CourseDBElement>cdeList : CDS.hashTable) {
			if(cdeList != null) {
				for(int i = 0; i < cdeList.size(); i++) {
					String course = cdeList.get(i).toString();
					arrList.add(course);
				}
			}
		}
		return arrList;
	}
}
