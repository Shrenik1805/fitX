package sub;

public class MembershipPlan {
    private String planName;
    private double price;

    public MembershipPlan(String planName, double price) {
        this.planName = planName;
        this.price = price;
    }

    public String getPlanName() {
        return planName;
    }

    public double getPrice() {
        return price;
    }

    public void displayPlanDetails() {
        System.out.println("Plan Name: " + planName + ", Price: " + price);
    }
}
