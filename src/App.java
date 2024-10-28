import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        try (Scanner keyboard = new Scanner(System.in)) {
            int input;
            do {
                System.out.println("1 - Register vehicle ; 2 - Register kilometers ; 3 - Print stats ; 4 - Check next maintenance ; 5 - Total maintenance spendings ; 6 - Give maintenance to vehicle ; 0 - Leave");
                input = Integer.parseInt(keyboard.nextLine());
                switch (input) {
                    case 1 -> registerVehicle();
                    case 2 -> registerKilometers();
                    case 3 -> printStats();
                    case 4 -> checkNextMaintenance();
                    case 5 -> totalMaintenanceSpendings();
                    case 6 -> giveMaintenanceToVehicle();
                }
            } while (input != 0);
        }
    }

    private static void giveMaintenanceToVehicle(){
        String vehiclePlate;

        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        Vehicle vehicle;

        do {
            System.out.println("Specify the vehicle plate: ");
            vehiclePlate = keyboard.nextLine();
            vehicle = Fleet.findVehicle(vehiclePlate);
        } while (vehicle == null);

        vehicle.maintenance();
    }

    private static void checkNextMaintenance(){
        String vehiclePlate;

        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        Vehicle vehicle;

        do {
            System.out.println("Specify the vehicle plate: ");
            vehiclePlate = keyboard.nextLine();
            vehicle = Fleet.findVehicle(vehiclePlate);
        } while (vehicle == null);
        
        System.out.println("The next maintenance should be given in: " + vehicle.nextMaintenanceKilometers() + " kilometers");
    }

    private static void totalMaintenanceSpendings(){
        String vehiclePlate;

        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        Vehicle vehicle;

        do {
            System.out.println("Specify the vehicle plate: ");
            vehiclePlate = keyboard.nextLine();
            vehicle = Fleet.findVehicle(vehiclePlate);
        } while (vehicle == null);

        System.out.println("Total maintenance spendings for this vehicle: " + vehicle.totalMaintenanceSpendings());
    }

    private static void printStats() {
        System.out.println("Cars Fee: " + Fleet.carsFee());
        System.out.println("Vans Fee: " + Fleet.vansFee());
        System.out.println("Total Fee: " + Fleet.totalFee());
        System.out.println("Fee Average: " + Fleet.feeAverage());
        System.out.println("Highest Fee Vehicle: " + Fleet.vehicleWithHighestFee());
    }

    private static void registerKilometers() {
        int kilometers;
        String vehiclePlate;

        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        Vehicle vehicle;

        do {
            System.out.println("Specify the vehicle plate: ");
            vehiclePlate = keyboard.nextLine();
            vehicle = Fleet.findVehicle(vehiclePlate);
        } while (vehicle == null);

        System.out.println("Specify the kilometers: ");
        kilometers = Integer.parseInt(keyboard.nextLine());
        
        vehicle.registerKilometers(kilometers);
    }

    private static void registerVehicle() {
        String plate;
        double price;
        int year;
        int type;

        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.println("What type of vehicle do you want to register (1 - Car ; 2 - Van)");
            type = Integer.parseInt(keyboard.nextLine());
        } while ((type != 1) && (type != 2));

        System.out.println("Specify the vehicle plate");
        plate = keyboard.nextLine();

        System.out.println("Specify the vehicle sell price");
        price = Double.parseDouble(keyboard.nextLine());

        System.out.println("Specify the vehicle fabrication year");
        year = Integer.parseInt(keyboard.nextLine());

        
        if (type == 1) {
            Car car = new Car(plate, year, price);
            Fleet.addCar(car);
        } else {
            Van van = new Van(plate, year, price);
            Fleet.addVan(van);
        }
    }
}