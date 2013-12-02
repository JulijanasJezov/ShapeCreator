import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class MyRectangle extends MyShape {

	MyPoint position;
	double width, height;
	
	/**
	 * Constructor
	 * @param type gets shape's type
	 */
	MyRectangle(String type) {
		super(type);
	}
	
	/**
	 * Constructor
	 * @param position gets x, y points
	 * @param height gets height of a this shape
	 * @param width gets width of a this shape
	 */
	MyRectangle(MyPoint position, double width, double height) {
		this("Rectangle");
		this.position = position;
		this.width = width;
		this.height = height;
	}

	public void renderShape(Graphics2D g2d) {
		Rectangle2D rect = new Rectangle2D.Double(position.getX(), position
				.getY(), width, height);
		g2d.draw(rect);

	}


	public void printDetails(int level) {
		System.out.format("%sThe shape is a %s %d %n", getIndent(level), super.TYPE, super.getId());
		System.out.format("%sIt has the height of : %s%n", getIndent(level), print2DP(height));
		System.out.format("%sIt has the width of : %s%n", getIndent(level), print2DP(width));
		System.out.format("%sIt has the area of : %s%n", getIndent(level), print2DP(calcArea()));
		
	}
	
	public double calcArea() {
		return height * width;
	}
}
