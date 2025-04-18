import java.util.*;

public class MotorCycleRentalSystem {
    private List<MotorCycle> motorcycles;
    private List<Customer> customers;
    private List<RentalMotorCycle> rentals;

    public MotorCycleRentalSystem() {
        motorcycles = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addMotorCycle(MotorCycle motorcycle) {
        motorcycles.add(motorcycle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentMotorCycle(MotorCycle motorcycle, Customer customer, int days) {
        if (motorcycle.isAvailable()) {
            motorcycle.rent();
            rentals.add(new RentalMotorCycle(motorcycle, customer, days));

        } else {
            System.out.println("Motorcycle is not available for rent.");
        }
    }

    public void returnCar(MotorCycle motorcycle) {
        motorcycle.returnVehicle();
        RentalMotorCycle rentalToRemove = null;
        for (RentalMotorCycle rental : rentals) {
            if (rental.getMotorCycle() == motorcycle) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);

        } else {
            System.out.println("Motorcycle was not rented.");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                System.out.println("===== MotorCycle Rental System =====");
                System.out.println("1. Rent a Motorcycle");
                System.out.println("2. Return a Motorcycle");
                System.out.println("3. Return to main menu");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.println("\n== Rent a Motorcycle ==\n");
                    System.out.print("Enter your name: ");
                    String customerName = sc.nextLine();

                    System.out.println("\nAvailable MotorCycles:");
                    for (MotorCycle motorcycle : motorcycles) {
                        if (motorcycle.isAvailable()) {
                            System.out.println(motorcycle.getVehicleId() + " - " + motorcycle.getBrand() + " " + motorcycle.getModel());
                        }
                    }

                    System.out.print("\nEnter the Motorcycle ID you want to rent: ");
                    String motorcycleId = sc.nextLine();

                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                    addCustomer(newCustomer);

                    MotorCycle selectedMotorCycle = null;
                    for (MotorCycle motorcycle : motorcycles) {
                        if (motorcycle.getVehicleId().equals(motorcycleId) && motorcycle.isAvailable()) {
                            selectedMotorCycle = motorcycle;
                            break;
                        }
                    }

                    if (selectedMotorCycle != null) {
                        double totalPrice = selectedMotorCycle.calculatePrice(rentalDays);
                        System.out.println("\n== Rental Information ==\n");
                        System.out.println("Customer ID: " + newCustomer.getCustomerId());
                        System.out.println("Customer Name: " + newCustomer.getName());
                        System.out.println("Motorcycle: " + selectedMotorCycle.getBrand() + " " + selectedMotorCycle.getModel());
                        System.out.println("Rental Days: " + rentalDays);
                        System.out.printf("Total Price: $%.2f%n", totalPrice);

                        System.out.print("\nConfirm rental (Y/N): ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {
                            rentMotorCycle(selectedMotorCycle, newCustomer, rentalDays);
                            System.out.println("\nMotorcycle rented successfully.");
                        } else {
                            System.out.println("\nRental canceled.");
                        }
                    } else {
                        System.out.println("\nInvalid motorcycle selection or motorcycle not available for rent.");
                    }
                    System.out.println("\nThank you for using the Motorcycle Rental System!");

                } else if (choice == 2) {
                    System.out.println("\n== Return a Motorcycle ==\n");
                    System.out.print("Enter the motorcycle ID you want to return: ");
                    String motorcycleId = sc.nextLine();

                    MotorCycle motorcycleToReturn = null;
                    for (MotorCycle motorCycle : motorcycles) {
                        if (motorCycle.getVehicleId().equals(motorcycleId) && !motorCycle.isAvailable()) {
                            motorcycleToReturn = motorCycle;
                            break;
                        }
                    }

                    if (motorcycleToReturn != null) {
                        Customer customer = null;
                        for (RentalMotorCycle rental : rentals) {
                            if (rental.getMotorCycle() == motorcycleToReturn) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }

                        if (customer != null) {
                            returnCar(motorcycleToReturn);
                            System.out.println("Motorcycle returned successfully by " + customer.getName());
                        } else {
                            System.out.println("Motorcycle was not rented or rental information is missing.");
                        }
                    } else {
                        System.out.println("Invalid motorcycle ID or motorcycle is not rented.");
                    }
                    System.out.println("\nThank you for using the Motorcycle Rental System!");

                } else if (choice == 3) {
                    Vehicle.menu();
                    break;
                }  else if (choice == 4) {
                    System.out.println("\nThank you for using the Motorcycle Rental System!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a valid option.");
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Error processing input. Please try again.");
            }
        }
        sc.close();
    }
}