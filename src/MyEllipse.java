import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyEllipse extends MyShape {

	MyPoint position;
	double width, height;
	
	/**
	 * Constructor
	 * @param type gets shape's type
	 */
	MyEllipse(String type) {
		super(type);
	}
	
	/**
	 * Constructor 
	 * @param position x, y points
	 * @param width gets width of this shape
	 * @param height gets height of this shape
	 */
	MyEllipse(MyPoint position, double width, double height) {
		this("Ellipse");
		this.position = position;
		this.width = width;
		this.height = height;
	}
	

	public void renderShape(Graphics2D g2d) {
		Ellipse2D myEllipse = new Ellipse2D.Double(position.getX(),
				position.getY(), width, height);
		g2d.draw(myEllipse);
	}

	public double calcArea() {
		return ((height / 2) * (width / 2) * Math.PI);
	}

	public void printDetails(int level) {
		System.out.format("%sThe shape is a %s %d %n", getIndent(level), super.TYPE, super.getId());
		System.out.format("%sThe height is a %s%n",getIndent(level), print2DP(height));
		System.out.format("%sThe width is %s%n",getIndent(level), print2DP(width));
		System.out.format("%sThe area is %s%n",getIndent(level), print2DP(calcArea()));
	}
}
