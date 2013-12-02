public class MySquare extends MyRectangle {
	
	/**
	 * Constructor
	 * @param type gets shape's type
	 */
	MySquare(String type) {
		super(type);
	}

	/**
	 * Constructor
	 * @param position gets x, y points
	 * @param height gets height of a square
	 */
	MySquare(MyPoint position, double height) {
		this("Square");
		super.position = position;
		super.height = height;
		super.width = height;
	}
	
	public void printDetails(int level) {
		System.out.format("%sThe shape is a %s %d %n", getIndent(level), super.TYPE, super.getId());
		System.out.format("%sIt has the height of : %s%n", getIndent(level), print2DP(height));
		System.out.format("%sIt has the area of : %s%n", getIndent(level), print2DP(calcArea()));
	}
	
	public double calcArea() {
		return height * width;
	}
}


