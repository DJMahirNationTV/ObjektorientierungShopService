package Order;

public enum OrderStatus {
    IN_PROGRESS("In Progress"),
    WAITING_FOR_PAYMENT("Waiting for Payment"),
    IN_DELIVERY("In Delivery"),
    COMPLETED("Completed"),;

    private final String description;

    private OrderStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
