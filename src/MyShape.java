import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.List;

/**
 * To be implemented by all shapes. 
 * It should contain the signature of all the methods that a shape must have. 
 */
public abstract class MyShape {
	
	protected final String TYPE;
	private static final int INITIAL = 0;
	private static int lastID = INITIAL;
	private int uniqueID;
	
	/**
	 * Constructor
	 * @param type gets type of the child shape
	 */
	public MyShape(String type) {
		TYPE = type;
		uniqueID = ++lastID;
	}

	/**
	 * Draw shape on screen
	 * 
	 * Method that must be implemented by Basic as well as complex shapes
	 */
	public abstract void renderShape(Graphics2D g2d);
	
	public abstract void printDetails(int level);
	
	public abstract double calcArea();
	
	/**
	 * Builds a string of arrows depending on level
	 * @param level gets a level of composite shape
	 * @return string of arrows
	 */
	public String getIndent(int level) {
		String indentSymb = "-->", indent = "";
		
		for (int i = 0; i < level; i++) {
			indent = indent + indentSymb;
		}
		
		return indent;
	}
	
	/**
	 * Rounds double to 2 decimal places
	 * @param result gets double number
	 * @return rounded double
	 */
	public double round2DP(double result) {
		return Math.round(result * 100) / 100.0;
	}
	
	/**
	 * Builds a string of a number with 1 or 2 decimal places
	 * @param result gets double number
	 * @return string to print
	 */
	public String print2DP(double result) {
		return new DecimalFormat(".0#").format(result);
	}
	
	public List<MyShape> getChildShapes() {
		System.out.println("Error, shape is not composite shape");
		return null;
	}
	
	public void add(MyShape s) {
		System.out.println("Error, shape is not composite shape");
	}
	
	public int getId(){
		return uniqueID;
	}
	
	public int getLastId(){
		return lastID;
	}
}
