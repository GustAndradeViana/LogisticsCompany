import java.util.ArrayList;

public class Fleet {
    private static ArrayList<Vehicle> Vehicles = new ArrayList<>();

    public static double carsFee(){
        double fee = 0;

        for (Vehicle vehicle : Vehicles){
            if (vehicle.vehicleType == 1){
                fee += vehicle.vehicleFee();
            } 
        }

        return fee;
    }

    public static double vansFee(){
        double fee = 0;

        for (Vehicle vehicle : Vehicles){
            if (vehicle.vehicleType == 2){
                fee += vehicle.vehicleFee();
            } 
        }

        return fee;
    }

    public static double totalFee(){
        double fee = 0;

        for (Vehicle vehicle : Vehicles){
            fee += vehicle.vehicleFee();
        }

        return fee;
    }

    public static double feeAverage(){
        return totalFee() / Vehicles.size();
    }

    public static String vehicleWithHighestFee(){
        String vehiclePlate = "";
        double highestFee = 0;
        for (Vehicle vehicle : Vehicles){
            double fee = vehicle.vehicleFee();
            if (fee > highestFee){
                highestFee = fee;
                vehiclePlate = vehicle.plate;
            }
        }
        return vehiclePlate;
    }

    public static void addCar(Car car){
        Vehicles.add(car);
    }

    public static void addVan(Van van){
        Vehicles.add(van);
    }
    
    public static Vehicle findVehicle(String vehiclePlate){
        Vehicle foundVehicle = null;
        for (Vehicle vehicle : Vehicles) {
            if (vehiclePlate.equals(vehicle.plate)) {
                foundVehicle = vehicle;
            }
        }
        return foundVehicle;
    }
}