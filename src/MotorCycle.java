public class MotorCycle extends Vehicle {

    public MotorCycle(String vehcileId, String brand, String model, double basePricePerDay){

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
        //15% discount for motorcycles
        double discount = 0.85;
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