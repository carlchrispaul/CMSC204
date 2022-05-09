package Project6;

/**
 * Data Element
 * @author CCPaulHipolito
 */

public class Town implements Comparable<Town> {

	private String name;
	
	/**
	 * Constructor to initialize parameter
	 * @param name
	 */
	public Town(String name) {
		this.name = name;
	}
	
	/**
	 * Copy constructor
	 * @param templateTown
	 */
	public Town(Town templateTown) {
		name = templateTown.getName();
	}
	
	/**
	 * Overrides the hashCode in class Object
	 * @return the hashcode for the name of the town
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * Overrides the toString in class Object
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * from the Comparable Interface
	 * @param town
	 * @return 0 if names are equal, a positive or negative number if the names aren’t equal
	 */
	@Override
	public int compareTo(Town town) {
		return name.compareTo(town.getName());
	}
	
	/**
	 * Overrides the equals in class Object
	 * @param obj
	 * @return true if the town names are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		Town town = (Town) obj;
		return name.equals(town.getName());
	}

	/**
	 * getter method
	 * @return the town's name
	 */
	public String getName() { return name; }
}
