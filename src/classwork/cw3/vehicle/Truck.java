package classwork.cw3.vehicle;

public class Truck implements Vehicle {

    private String color;
    private int axles;
    private int vin;
    private int modelYear;

    private double horsepower;
    private boolean hasPlowPackage;

    Truck(String color, int axles, int vin, int modelYear, double horsepower, boolean hasPlowPackage) {
        this.color = color;
        this.axles = axles;
        this.vin = vin;
        this.modelYear = modelYear;
        this.horsepower = horsepower;
        this.hasPlowPackage = hasPlowPackage;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getAxles() {
        return axles;
    }

    public int getVIN() {
        return vin;
    }

    @Override
    public int getModelYear() {
        return modelYear;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public boolean hasPlowPackage() {
        return hasPlowPackage;
    }
}
