package classwork.cw3.shapes;

public class Square implements Shapes {

    private double length;
    private double area;
    private double perimeter;

    public Square(double length) {
        this.length = length;
        this.area = Math.pow(length, 2);
        this.perimeter = 4*length;
    }

    public double getLength() {
        return length;
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
