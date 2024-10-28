public class Car extends Vehicle {
    private double costPerKilometer = 40;
    private double feePercentage = 2.5;

    public Car(String plate, int year, double price) {
        super(plate, year, price);
        vehicleType = 1;
    }

    @Override
    public double vehicleFee(){
        return (costPerKilometer * super.kilometers) * feePercentage;
    }
}