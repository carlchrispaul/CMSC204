package Project4;

/**
 * CDE
 * @author CCPaulHipolito
 */

public class CourseDBElement implements Comparable<CourseDBElement> {

	private String courseID, roomNumber, instructorName;
	private int CRN, numOfCredits;
	
	/**
	 * Constructor that initializes the private attributes
	 */
	public CourseDBElement() {
		this.courseID = "";
		this.CRN = 0;
		this.numOfCredits = 0;
		this.roomNumber = "";
		this.instructorName = "";
	}

	/**
	 * Parameterized Constructor
	 * @param courseID
	 * @param CRN
	 * @param numOfCredits
	 * @param roomNum
	 * @param instructorName
	 */
	public CourseDBElement(String courseID, int CRN, int numOfCredits, String roomNum, String instructorName) {
		this.courseID = courseID;
		this.CRN = CRN;
		this.numOfCredits = numOfCredits;
		this.roomNumber = roomNum;
		this.instructorName = instructorName;
	}
	
	/**
	 * getter methods
	 */
	public String getCourseID() { return courseID; }
	public int getCRN() { return CRN; }
	public int getNumOfCredits() { return numOfCredits; }
	public String getRoomNum() { return roomNumber; }
	public String getInstructorName() { return instructorName; }
	
	/**
	 * setter methods
	 */
	public void setCourseID(String courseID) { this.courseID = courseID; }
	public void setCRN(int CRN) { this.CRN = CRN; }
	public void setNumOfCredits(int numOfCredits) { this.numOfCredits = numOfCredits; }
	public void setRoomNum(String roomNumber) { this.roomNumber = roomNumber; }
	public void setInstructorName(String instructorName) {this.instructorName = instructorName; }
	
	/**
	 * Returns the computed code of the CRN
	 */
	public int hashCode() {
		String crn = Integer.toString(CRN);
		return crn.hashCode();
	}
	
	/**
	 * From the Comparable Interface
	 * @param element
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		return Integer.compare(this.getCRN(), element.getCRN());
	}
	
	/**
	 * Returns the proper format
	 */
	public String toString() {
		return "\nCourse:" + getCourseID() + " CRN:" + getCRN() + " Credits:" + getNumOfCredits() + " Instructor:" + getInstructorName() + " Room:" + getRoomNum();
	}
}
