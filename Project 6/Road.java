package Project6;

/**
 * Data Element
 * @author CCPaulHipolito
 */

public class Road implements Comparable<Road> {
	
	private Town source, destination;
	private int weight;
	private String name;
	
	/**
	 * Constructor to initialize the parameters
	 * @param source
	 * @param destination
	 * @param degrees
	 * @param name
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		weight = degrees;
		this.name = name;
	}
	
	/**
	 * Constructor with weight preset to 1
	 * @param source
	 * @param destination
	 * @param name
	 */
	public Road(Town source, Town destination, String name) {
		this(source, destination, 1, name);
	}
	
	/**
	 * Getter methods for the 4 parameters
	 * @param source, destination, weight, name
	 */
	public Town getSource() { return source; }
	public Town getDestination() { return destination; }
	public String getName() { return name; }
	public int getWeight() { return weight; }
	
	/**
	 * contains method
	 * @param town
	 * @return true only if the edge contains the given town
	 */
	public boolean contains(Town town) {
		return (town.getName().equals(source.getName()) || town.getName().equals(destination.getName()));
	}
	
	/**
	 * compareTo method from the Comparable interface
	 * @param r
	 * @return 0 if names are equal, a positive or negative number if the names aren’t equal
	 */
	@Override
	public int compareTo(Road r) {
		return name.compareTo(r.getName());
	}
	
	/**
	 * Remember that a road that goes from point A to point B is the same as 
	 * a road that goes from point B to point A.
	 * @param r
	 * @return true if each of the ends of the road r is the same as the ends of this road. 
	 */
	@Override
	public boolean equals(Object r) {
		String roadSource = ((Road) r).getSource().getName();
		String roadDestination = ((Road) r).getDestination().getName();
		return((source.getName().equals(roadSource) ||
				source.getName().equals(roadDestination)) &&
				(destination.getName().equals(roadSource) ||
				destination.getName().equals(roadDestination)));
	}
	
	/**
	 * Overrides the toString in class Object
	 */
	@Override
	public String toString() {
		return name + ": " + source.getName() + " - " + destination.getName() + ", " + weight;
	}
}
