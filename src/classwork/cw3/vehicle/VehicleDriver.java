package classwork.cw3.vehicle;

public class VehicleDriver {

    public static void main(String[] args) {
        Car car = new Car("Red", 4, 987654321, 2002, 60000, 4);
        Truck truck = new Truck("Blue", 16, 123456789, 2001, 420, true);

        System.out.println("Car Specs");
        System.out.printf("\tColor: %s\n", car.getColor());
        System.out.printf("\tAxles: %d\n", car.getAxles());
        System.out.printf("\tVIN: %d\n", car.getVIN());
        System.out.printf("\tModel Year: %d\n", car.getModelYear());
        System.out.printf("\tMileage: %.2f\n", car.getMileage());
        System.out.printf("\t# Cup Holders: %d\n", car.getCupHolders());

        System.out.println("Truck Specs");
        System.out.printf("\tColor: %s\n", truck.getColor());
        System.out.printf("\tAxles: %d\n", truck.getAxles());
        System.out.printf("\tVIN: %d\n", truck.getVIN());
        System.out.printf("\tModel Year: %d\n", truck.getModelYear());
        System.out.printf("\tHorsepower: %.2f\n", truck.getHorsepower());
        System.out.printf("\tHas Plow Package: %b\n", truck.hasPlowPackage());
    }
}
