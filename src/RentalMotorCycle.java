public class RentalMotorCycle {
    private MotorCycle motorcycle;
    private Customer customer;
    private int days;

    public RentalMotorCycle(MotorCycle motorcycle, Customer customer, int days) {
        this.motorcycle = motorcycle;
        this.customer = customer;
        this.days = days;
    }

    public MotorCycle getMotorCycle() {
        return motorcycle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}