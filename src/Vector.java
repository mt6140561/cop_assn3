/*
 * Creates a tuple of doubles
 * dotProd(v):	returns dot product with v
 * distance(v):	distance between two point vectors
 * mod():		absolute value of vector
 */
public class Vector {
	public double x;//x coordinate
	public double y;//y coordinate
	
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double dotProd(Vector v) {
		double a = (x*v.x)+(y*v.y);
		return a;
	}
	
	public double distance(Vector v) {
		double a = (x-v.x)*(x-v.x);
		double b = (y-v.y)*(y-v.y);
		double ret = Math.sqrt(a+b);
		return ret;
	}
	
	public double mod() {
		double ret = Math.sqrt(x*x + y*y);
		return ret;
	}
}
