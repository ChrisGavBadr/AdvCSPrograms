package classwork.cw3.shapes;

public class ShapesDriver {

    public static void main(String[] args) {
        Circle circle = new Circle(4);
        Square square = new Square(2);

        System.out.printf("Circle (radius = %.2f)\n", circle.getRadius());
        System.out.printf("\tArea: %.2f\n", circle.getArea());
        System.out.printf("\tPerimeter: %.2f\n", circle.getPerimeter());

        System.out.printf("Square (length = %.2f)\n", square.getLength());
        System.out.printf("\tArea: %.2f\n", square.getArea());
        System.out.printf("\tPerimeter: %.2f", square.getPerimeter());
    }
}
