import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner; 
public class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String brand,String model, double basePricePerDay){
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getVehicleId(){
        return vehicleId;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public double calculatePrice(int rentalDays){
        return basePricePerDay * rentalDays;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void rent(){
        isAvailable = false;
    }

    public void returnVehicle(){
        isAvailable = true;
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===========Welcome to Vehicle Rental System===========");
        System.out.println("1. Enter 1 to rent a Car :");
        System.out.println("2. Enter 2 to rent a Motorcycle :");
        System.out.println("3. Enter 3 to Exit ");
        System.out.print("Enter Your Choice: ");

        try{

        int choice = sc.nextInt();

        if(choice == 1){
            Main.carRentalSystem.menu();
        }else if (choice == 2){
            Main.bikeRentalSystem.menu();
        } else if(choice == 3){
            System.out.println("Thank You for visiting our Vehicle Rental System.");
        }
        sc.close();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error processing input. Please try again");
        }
    }
}