import java.time.Year;

public abstract class Vehicle {
    protected String plate;
    protected String model;
    protected int fabricationYear;
    protected int kilometers;
    protected int vehicleType;
    protected double sellPrice;
    protected double maintenanceSpendings;
    protected EMaintenance maintenanceLevel;

    public Vehicle(String plate, int year, double price){
        this.plate = plate;
        this.fabricationYear = year;
        this.sellPrice = price;
        this.kilometers = 0;
        this.maintenanceLevel = EMaintenance.getServiceInterval(getVehicleAge());
    }

    public int getVehicleAge() {
        int currentYear = Year.now().getValue();
        return currentYear - this.fabricationYear;
    }

    public void registerKilometers(int kilometers){
        this.kilometers += kilometers;
    }

    public int nextMaintenanceKilometers(){
        maintenanceLevel = EMaintenance.getServiceInterval(getVehicleAge());
        int nextKilometers = maintenanceLevel.getIntervalKm() - (this.kilometers % maintenanceLevel.getIntervalKm());
        return nextKilometers;
    }

    public void maintenance(){
        maintenanceLevel = EMaintenance.getServiceInterval(getVehicleAge());
        maintenanceSpendings = maintenanceLevel.getCost();
    }

    public double totalMaintenanceSpendings(){
        return maintenanceSpendings;
    }

    public abstract double vehicleFee();
}