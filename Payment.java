package sub;

public class Payment {
    private Members member;
    private MembershipPlan plan;
    private double amount;

    public Payment(Members member, MembershipPlan plan, double amount) {
        this.member = member;
        this.plan = plan;
        this.amount = amount;
    }

    public Members getMember() {
        return member;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public double getAmount() {
        return amount;
    }
}
