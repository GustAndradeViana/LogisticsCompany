public class Van extends Vehicle {
    private double costPerKilometer = 60;
    private double feePercentage = 5.5;

    public Van(String plate, int year, double price) {
        super(plate, year, price);
        vehicleType = 2;
    }

    @Override
    public double vehicleFee(){
        return (costPerKilometer * super.kilometers) * feePercentage;
    }
}