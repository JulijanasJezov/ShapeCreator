public class MyCircle extends MyEllipse {
	
	double radius;
	
	/**
	 * Constructor
	 * @param type gets shape's type
	 */
	MyCircle(String type) {
		super(type);
	}
	
	/**
	 * Constructor
	 * @param position gets x, y points
	 * @param radius gets radius
	 */
	MyCircle(MyPoint position, double radius) {
		this("Circle");
		super.position = position;
		this.radius = radius;
		super.width = (radius * 2);
		super.height = super.width;
	}
	
	public double calcArea() {
		return Math.PI * (Math.pow(radius, 2));
	}
	
	public void printDetails(int level) {
		System.out.format("%sThe shape is a %s %d %n", getIndent(level), super.TYPE, super.getId());
		System.out.format("%sThe radius is %s %n", getIndent(level), print2DP(radius));
		System.out.format("%sThe area is %s",getIndent(level), print2DP(calcArea()));
		System.out.println("\n");
	}
	
}
