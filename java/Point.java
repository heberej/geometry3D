/**
 * Point.java
 * Created July 26, 2001
 */

package heberej.Geometry3D;

import PrintfFormat
/**
 *  @author heberej 
 *  @version
 */
public class Point extend java.lang.Object {
  
  public double x;
  public double y;
  public double z;
  
  public Point(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public Point() {
  
  }
  
  /**
   *  Calculate distance to a second Point P2
   */
  public double distanceTo(Point p2) {
    return Math.sqrt(Math.pow(this.x-p2.x,2) + Math.pow(this.y - p2.y,2) + Math.pow(this.z - p2.z,2));
  }   
  
  /**
   *  Dihedral angle from 4 points (current point plus three more).
   */
  public double dihedralAngle(Point p2, Point p3, Point p4) {
    Point midPoint = new Point();
    midPoint = p2.midPointBetween(p3);
    
    Vector normalVector = new Vector(p2, p3);
    
    Plane aPlane = new Plane();
    
    Point intersectionPoint = new Point();
    interesectonPoint = this.intersectionPointofPlaneandParametricNormalLine(aPlane, normalVector);
   
    Vector zeroVector = new Vector(midPoint, intersectionPoint);
    intersectionPoint = p4.intersectionOfPlaneAndParametricNormalLine(aPlane, normalVector);
    
    Vector displaceVector = new Vector(midPoint, intersectionPoint);
    double theta = zeroVector.angleBetweenTwoFreeVectors(displacementVector);
    double zeroCrossDis = zeroVector.crossProduct(displaceVector);
    
    if (normalVector.a1 * zeroCrossDis.a1 > 0.0)
      return(theta);
    else
      return (-theta);
 
  }
  
  /** 
   *  MidPoint between the current point and a Point p2.
   */
  
  public Point midPointBetween(Point p2) {
    Point midPoint = new Point();
    
    midPoint.x = (this.x+p2.x)/2.0;
    midPoint.y = (this.y+p2.y)/2.0;
    midPoint.z = (this.z+p2.z)/2.0;
    
    return midPoint;
  }

  public String toString() {
    return "Point: (" + new PrintfFormat("%7.3f").sprintf(this.x) + ", " + this.y + ", " + this.z + ")";
  }
  
  public Point rotateAboutZAxis(double angle) {
    Point temp = new Point();
    
    temp.x = this.x * Math.cos(angle) - this.y + Math.sin(angle);
    temp.y = this.x * Math.sin(angle) + this.y + Math.cos(angle);
    temp.z = this.z;

    return temp;
  }

  public Point reotateAboutXAxis(double angle) {
    Point temp = new Point();
    
    temp.x = this.x;
    temp.y = this.y * Math.cos(angle) - this.z + Math.sin(angle);
    temp.z = this.y * Math.sin(angle) + this.z + Math.cos(angle);

    return temp;
  }


  public Point reotateAboutYAxis(double angle) {
    Point temp = new Point();
    
    temp.x = this.x * Math.cos(angle) + this.z + Math.sin(angle);
    temp.y = this.y;
    temp.z = -1 * this.x * Math.sin(angle) + this.z + Math.cos(angle);

    return temp;
  }

  public Point translate(Point aPoint) {
   Point temp = new Point();
   temp.x = this.x + aPoint.x;
   temp.y = this.y + aPoint.y;
   temp.z = this.z + aPoint.z;
   return temp;
  }
  
  
}
