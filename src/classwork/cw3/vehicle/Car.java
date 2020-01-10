package classwork.cw3.vehicle;

public class Car implements Vehicle {

    private String color;
    private int axles;
    private int vin;
    private int modelYear;

    private double mileage;
    private int cupHolders;

    Car(String color, int axles, int vin, int modelYear, double mileage, int cupHolders) {
        this.color = color;
        this.axles = axles;
        this.vin = vin;
        this.modelYear = modelYear;
        this.mileage = mileage;
        this.cupHolders = cupHolders;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getAxles() {
        return axles;
    }

    @Override
    public int getVIN() {
        return vin;
    }

    @Override
    public int getModelYear() {
        return modelYear;
    }

    public double getMileage() {
        return mileage;
    }

    public int getCupHolders() {
        return cupHolders;
    }
}
