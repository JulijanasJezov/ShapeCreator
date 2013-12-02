import java.awt.Graphics2D;

public class MyLine extends MyShape {
	MyPoint p1, p2;
	
	/**
	 * Constructor
	 * @param type gets shape's type
	 */
	MyLine(String type) {
		super(type);
	}

	/**
	 * Constructor getting coordinates
	 * @param p1 x,y start points
	 * @param p2 x, y end points
	 */
	MyLine(MyPoint p1, MyPoint p2) {
		this("Line");
		this.p1 = p1;
		this.p2 = p2;
	}

	public void renderShape(Graphics2D g2d) {
		g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}

	public MyPoint getP1() {
		return p1;
	}

	public MyPoint getP2() {
		return p2;
	}

	public double calcLength() {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2)
				+ Math.pow(p1.getY() - p2.getY(), 2));
	}
	
	public double calcArea() {
		return 0;
	}

	public void printDetails(int level) {
		System.out.format("%sThe shape is a %s %d %n", getIndent(level), super.TYPE,super.getId());
		System.out.format("%sThe lenght is %s%n", getIndent(level), print2DP(calcLength()));
	}
}
