public class Main{
    static CarRentalSystem carRentalSystem = new CarRentalSystem();
    static MotorCycleRentalSystem bikeRentalSystem = new MotorCycleRentalSystem();

    public static void initalizeData() {
        Car car1 = new Car("C001", "Toyota", "Camry", 135.0); // Different base price per day for each car
        Car car2 = new Car("C002", "Honda", "Accord", 120.0);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150.0);
        Car car4 = new Car("C004", "Maruti Suzuki", "Alto", 100.0);
        Car car5 = new Car("C005", "Tata", "Nexon", 175.0);
        Car car6 = new Car("C006", "Tata", "Harrier", 200.0);
        Car car7 = new Car("C007", "Kia", "Sonet", 160.0);
        Car car8 = new Car("C008", "Toyota", "Innova", 170.0);

        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);
        carRentalSystem.addCar(car4);
        carRentalSystem.addCar(car5);
        carRentalSystem.addCar(car6);
        carRentalSystem.addCar(car7);
        carRentalSystem.addCar(car8);

        MotorCycle cycle1 = new MotorCycle("M001","Bajaj","Discover",65.0); //Different base price per day for each motorcycle
        MotorCycle cycle2 = new MotorCycle("M002","Honda","Splendor",45.0);
        MotorCycle cycle3 = new MotorCycle("M003","Bajaj","Pulsar",80.0);
        MotorCycle cycle4 = new MotorCycle("M004","Royal Enfield","Bullet",90.0);
        MotorCycle cycle5 = new MotorCycle("M005","Harley","Davidson",170.0);
        MotorCycle cycle6 = new MotorCycle("M006","Honda","Apache RTR 160",110.0);
        MotorCycle cycle7 = new MotorCycle("M007","TVS","Raider",75.0);
        MotorCycle cycle8 = new MotorCycle("M008","Hero","Xtreme 125R",70.0);

        bikeRentalSystem.addMotorCycle(cycle1);
        bikeRentalSystem.addMotorCycle(cycle2);
        bikeRentalSystem.addMotorCycle(cycle3);
        bikeRentalSystem.addMotorCycle(cycle4);
        bikeRentalSystem.addMotorCycle(cycle5);
        bikeRentalSystem.addMotorCycle(cycle6);
        bikeRentalSystem.addMotorCycle(cycle7);
        bikeRentalSystem.addMotorCycle(cycle8);


    }
    public static void main(String[] args) {      
        initalizeData();  
        Vehicle.menu();
    }
}