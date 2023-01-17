/**
 * Represents a point with x and y
 * @author Thoma
 *
 */
public class Point {
	
	// Instance variables 
	int x;
	int y;
	int sum;
	
	//Constructors 
	/**
	 * Creates a point at the given x and y.
	 * @param x for point
	 * @param y for point 
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.sum = x + y;
	}
	
	
	public Point() {
		//calls the first constructor with defaul values, 0 and 0
		this(0,0);
	}
	
	
	public static void main(String[] args) {
		
		Point point1 = new Point(2, 4);
		System.out.println(point1.x);
		System.out.println(point1.y);
		System.out.println(point1.sum);
		System.out.println();
		
		Point point2 = new Point();
		System.out.println(point2.x);
		System.out.println(point2.y);
		System.out.println(point2.sum);	
	}
}
