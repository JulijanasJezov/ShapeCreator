public class ShapeCreator {

	private CompositeShape compShape, baseCompShape;
	private DrawGUI frame;
	private static final int INITIAL = 0;
	private int level = INITIAL;

	private static final int ADD_SHAPE = 1;
	private static final int PRINT_DETAILS = 2;
	private static final int DRAW_SHAPES = 3;
	private static final int QUIT_M = 4;

	private static final char ADD_LINE = 'A';
	private static final char ADD_RECT = 'B';
	private static final char ADD_SQUARE = 'C';
	private static final char ADD_ELLIPSE = 'D';
	private static final char ADD_CIRCLE = 'E';
	private static final char ADD_COMP = 'F';
	private static final char GO_BACK = 'G';
	private static final char MAIN_MENU = 'M';
	private static final char QUIT_S = 'Q';
	
	/**
	 * Default Constructor
	 */
	public ShapeCreator() {
		super();
		frame = new DrawGUI();
		compShape = new CompositeShape();
		baseCompShape = compShape;
	}

	public void draw() {
		MyPanel panel = new MyPanel(baseCompShape);
		frame.add(panel);
		frame.setVisible(true);

	}// end draw

	public static void main(String[] args) {
		ShapeCreator aShapeCreator = new ShapeCreator();
		aShapeCreator.processMainMenu();
	}// main end

	/**
	 * Prints the main menu
	 */
	public void printMainMenu() {
		System.out.println("Shape Creator");
		System.out.println("------------- \n");
		System.out.println("1) Add a Shape");
		System.out.println("2) Print Shapes Details");
		System.out.println("3) Draw Shapes");
		System.out.println("4) Quit");
		System.out.println("Enter Choice: ");
	}

	/**
	 * Reads/process user choice
	 */
	public void processMainMenu() {
		int userChoice = 0;

		while (userChoice != 4) {
			printMainMenu();
			userChoice = G51OOPInput.readInt();

			switch (userChoice) {
			case ADD_SHAPE:
				processOptionsMenu();
				break;
			case PRINT_DETAILS:
				baseCompShape.printDetails(INITIAL);
				break;
			case DRAW_SHAPES:
				draw();
				break;
			case QUIT_M:
				quitProgram();
			default:
				System.out.println("Invalid Menu Choice");
			}

		}
	}

	/**
	 * Prints options menus depending on level
	 */
	public void printOptionsMenu() {
		String addShapeStr = null;
		
		if (level != 0) {
			addShapeStr = ("Add a Shape to level " + level + " composite "
					+ compShape.getId());
		} else {
			addShapeStr = ("Add a Shape");
		}
		System.out.println(addShapeStr);
		for (int i = INITIAL; i < addShapeStr.length(); i++) {
			System.out.print("-");
		}
		System.out.println("\nA) Line");
		System.out.println("B) Rectangle");
		System.out.println("C) Square");
		System.out.println("D) Ellipse");
		System.out.println("E) Circle");
		System.out.println("F) Composite Shape");
		if (level != 0) {
			System.out.println("G) Go back to level " + (level - 1));
		}
		System.out.println("M) Back to Main Menu");
		System.out.println("Q) Quit");
		System.out.println("Enter Choice: ");
	}

	/**
	 * Reads user choice
	 * Navigates through menu
	 * Adds shapes to the list
	 */
	public void processOptionsMenu() {
		char userChoice = 0;
		int x, y;
		double width, height, radius;
		MyPoint p1, p2;

		while (userChoice != 'M') {
			printOptionsMenu();
			userChoice = G51OOPInput.getChar();
			userChoice = Character.toUpperCase(userChoice);

			switch (userChoice) {
			case ADD_LINE:
				System.out.println("Enter Point1 X: ");
				x = G51OOPInput.readInt();
				System.out.println("Enter Point1 Y: ");
				y = G51OOPInput.readInt();
				p1 = new MyPoint(x, y);

				System.out.println("Enter Point2 X: ");
				x = G51OOPInput.readInt();
				System.out.println("Enter Point1 Y: ");
				y = G51OOPInput.readInt();
				p2 = new MyPoint(x, y);

				compShape.add(new MyLine(p1, p2));
				break;
			case ADD_RECT:
				System.out.println("Enter height: ");
				height = compShape.round2DP(G51OOPInput.readDouble());
				System.out.println("Enter width: ");
				width = compShape.round2DP(G51OOPInput.readDouble());
				
				System.out.println("Enter Point X: ");
				x = G51OOPInput.readInt();
				System.out.println("Enter Point Y: ");
				y = G51OOPInput.readInt();
				p1 = new MyPoint(x, y);

				compShape.add(new MyRectangle(p1, width, height));
				break;
			case ADD_SQUARE:
				System.out.println("Enter height: ");
				height = compShape.round2DP(G51OOPInput.readDouble());
				System.out.println("Enter top left X: ");
				x = G51OOPInput.readInt();
				System.out.println("Enter top left Y: ");
				y = G51OOPInput.readInt();
				p1 = new MyPoint(x, y);

				compShape.add(new MySquare(p1, height));
				break;
			case ADD_ELLIPSE:
				System.out.println("Enter height: ");
				height = compShape.round2DP(G51OOPInput.readDouble());
				System.out.println("Enter width: ");
				width = compShape.round2DP(G51OOPInput.readDouble());
				System.out.println("Enter top left X: ");
				x = G51OOPInput.readInt();
				System.out.println("Enter top left Y: ");
				y = G51OOPInput.readInt();
				p1 = new MyPoint(x, y);

				compShape.add(new MyEllipse(p1, width, height));
				break;
			case ADD_CIRCLE:
				System.out.println("Enter radius: ");
				radius = compShape.round2DP(G51OOPInput.readDouble());
				System.out.println("Enter top left X: ");
				x = G51OOPInput.readInt();
				System.out.println("Enter top left Y: ");
				y = G51OOPInput.readInt();
				p1 = new MyPoint(x, y);

				compShape.add(new MyCircle(p1, radius));
				break;
			case ADD_COMP:
				compShape.add(new CompositeShape());
				getLevel(++level);
				break;
			case GO_BACK:
				getLevel(--level);
				break;
			case MAIN_MENU:
				level = 0;
				getLevel(level);
				break;
			case QUIT_S:
				quitProgram();
			default:
				System.out.println("Invalid Menu Choice");
			}
		}
	}
	
	/**
	 * Navigates through different levels
	 * @param lvl user's chosen level
	 */
	public void getLevel(int lvl) {
		compShape = baseCompShape;
		for (int i = INITIAL; i < lvl; i++) {
			for (MyShape shp : compShape.getChildShapes()) {
				if (shp instanceof CompositeShape) {
					compShape = (CompositeShape) shp;
				}
			}
		}
	}

	public void quitProgram() {
		System.out
				.println("====================================================");
		System.out.println("You created a total of "
				+ baseCompShape.getLastId() + " shapes");
		System.out
				.println("Quitting, Thank you for using Shapes Creator Program");
		System.out
				.println("====================================================");
		System.exit(0);
	}

}// class end
