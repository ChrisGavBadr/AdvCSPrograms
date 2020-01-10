package classwork.cw3.shapes;

public class Circle implements Shapes {

    private double radius;
    private double area;
    private double perimeter;

    Circle(double radius) {
        this.radius = radius;
        this.area = Math.PI*Math.pow(radius, 2);
        this.perimeter = 2*Math.PI*radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }
}
