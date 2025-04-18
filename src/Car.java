public class Car extends Vehicle {

    public Car(String vehcileId, String brand, String model, double basePricePerDay){

        super(vehcileId, brand, model,basePricePerDay);
    }

    @Override
    public String getVehicleId(){
        return super.getVehicleId();
    }
    
    @Override
    public String getBrand(){
        return super.getBrand();
    }

    @Override
    public String getModel(){
        return super.getModel();
    }

    @Override
    public double calculatePrice(int rentalDays){
        //10% discount for cars
        double discount = 0.9;
        return super.calculatePrice(rentalDays) * discount;
    }

    @Override
    public void rent(){
        super.rent();
    }

    @Override
    public void returnVehicle(){
        super.returnVehicle();
    }
}