package basics;

import java.util.Objects;

public class Line 
{
	    double x1, y1, x2, y2;

	    public Line(double x1, double y1, double x2, double y2) 
	    {
	        this.x1 = x1;
	        this.y1 = y1;
	        this.x2 = x2;
	        this.y2 = y2;
	    }

	    public double calculateLength() {
	        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	    }

	    @Override
	    public boolean equals(Object obj)
	    {
	        if (this == obj)
	        {
	        	return true;
	        }
	        else if (obj == null || getClass() != obj.getClass()) 
	        { 
	        	return false;
	        }
	        else
	        {
	        Line line = (Line) obj;
	        return (Double.compare(line.x1, x1) == 0 && Double.compare(line.y1, y1) == 0 &&
	                Double.compare(line.x2, x2) == 0 && Double.compare(line.y2, y2) == 0) ||
	               (Double.compare(line.x1, x2) == 0 && Double.compare(line.y1, y2) == 0 &&
	                Double.compare(line.x2, x1) == 0 && Double.compare(line.y2, y1) == 0);
	        }
	    }

	    @Override
	    public int hashCode()
	    {
	        return Objects.hash(x1, y1, x2, y2)+ Objects.hash(x2, y2, x1, y1);
	    }

	    public static void main(String[] args) 
	    {
	        Line line1 = new Line(1, 2, 4, 6);
	        Line line2 = new Line(1, 2, 4, 6);
	        Line line3 = new Line(4, 6, 3, 2);
	        Line line4 = new Line(2, 3, 5, 7);

	        System.out.println("Line1 equals Line2: " + line1.equals(line2));
	        System.out.println("Line1 equals Line3: " + line1.equals(line3));
	        System.out.println("Line1 equals Line4: " + line1.equals(line4)); 
	        
	        System.out.println(line1.hashCode());
	        System.out.println(line2.hashCode());
	        System.out.println(line3.hashCode());
	        System.out.println(line4.hashCode());
	    }

}
