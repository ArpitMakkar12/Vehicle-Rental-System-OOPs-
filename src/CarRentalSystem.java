import java.util.*;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<RentalCar> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new RentalCar(car, customer, days));

        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(Car car) {
        car.returnVehicle();
        RentalCar rentalToRemove = null;
        for (RentalCar rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);

        } else {
            System.out.println("Car was not rented.");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try{
                System.out.println("===== Car Rental System =====");
                System.out.println("1. Rent a Car");
                System.out.println("2. Return a Car");
                System.out.println("3. Return to main menu");
                System.out.println("4. Exit ");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.println("\n== Rent a Car ==\n");
                    System.out.print("Enter your name: ");
                    String customerName = sc.nextLine();

                    System.out.println("\nAvailable Cars:");
                    for (Car car : cars) {
                        if (car.isAvailable()) {
                            System.out.println(car.getVehicleId() + " - " + car.getBrand() + " " + car.getModel());
                        }
                    }

                    System.out.print("\nEnter the car ID you want to rent: ");
                    String carId = sc.nextLine();

                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for (Car car : cars) {
                        if (car.getVehicleId().equals(carId) && car.isAvailable()) {
                            selectedCar = car;
                            break;
                        }
                    }

                    if (selectedCar != null) {
                        double totalPrice = selectedCar.calculatePrice(rentalDays);
                        System.out.println("\n== Rental Information ==\n");
                        System.out.println("Customer ID: " + newCustomer.getCustomerId());
                        System.out.println("Customer Name: " + newCustomer.getName());
                        System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                        System.out.println("Rental Days: " + rentalDays);
                        System.out.printf("Total Price: $%.2f%n", totalPrice);

                        System.out.print("\nConfirm rental (Y/N): ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {
                            rentCar(selectedCar, newCustomer, rentalDays);
                            System.out.println("\nCar rented successfully.");
                        } else {
                            System.out.println("\nRental canceled.");
                        }
                    } else {
                        System.out.println("\nInvalid car selection or car not available for rent.");
                    }

                    System.out.println("\nThank you for using the Car Rental System!");
                } else if (choice == 2) {
                    System.out.println("\n== Return a Car ==\n");
                    System.out.print("Enter the car ID you want to return: ");
                    String carId = sc.nextLine();

                    Car carToReturn = null;
                    for (Car car : cars) {
                        if (car.getVehicleId().equals(carId) && !car.isAvailable()) {
                            carToReturn = car;
                            break;
                        }
                    }

                    if (carToReturn != null) {
                        Customer customer = null;
                        for (RentalCar rental : rentals) {
                            if (rental.getCar() == carToReturn) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }

                        if (customer != null) {
                            returnCar(carToReturn);
                            System.out.println("Car returned successfully by " + customer.getName());
                        } else {
                            System.out.println("Car was not rented or rental information is missing.");
                        }
                    } else {
                        System.out.println("Invalid car ID or car is not rented.");
                    }
                    System.out.println("\nThank you for using the Car Rental System!");

                } else if(choice == 3){
                    Vehicle.menu();
                    break;
                }
                else if (choice == 4) {
                    System.out.println("\nThank you for using the Car Rental System!");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Error processing input. Please try again.");
            }
        }
        sc.close();
    }
}