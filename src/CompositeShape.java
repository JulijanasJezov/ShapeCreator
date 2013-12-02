import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class CompositeShape extends MyShape {

	private static final int INITIAL = 0;
	private List<MyShape> childShapes;
	private Color color;
	private int childShapesCount = INITIAL;

	public CompositeShape() {
		super("CompositeShape");
		this.childShapes = new ArrayList<MyShape>();
		int R = (int) (Math.random() * 256);
		int G = (int) (Math.random() * 256);
		int B = (int) (Math.random() * 256);
		this.color = new Color(R, G, B);
	}

	public List<MyShape> getChildShapes() {
		return childShapes;
	}

	public void renderShape(Graphics2D g2d) {
		for (MyShape shape : childShapes) {
			g2d.setColor(this.color);
			shape.renderShape(g2d);
		}
	}

	public void add(MyShape s) {
		childShapes.add(s);
	}

	public double calcArea() {
		double area = INITIAL;
		for (MyShape shp : childShapes) {
			area = area + shp.calcArea();
		}
		return area;
	}

	/**
	 * Prints details of all shapes
	 * @param level gets a level to control indentation
	 */
	public void printDetails(int level) {
		System.out.format("%sA Composite %d%n", getIndent(level), getId());
		for (MyShape shp : getChildShapes()) {
			System.out.format("%s%d. %n", getIndent(level), ++childShapesCount);
			shp.printDetails(level + 1);
		}

		System.out.format("%sTotal Number of Shapes is %d %n",
				getIndent(level), childShapesCount);
		System.out.println();
	}

}
