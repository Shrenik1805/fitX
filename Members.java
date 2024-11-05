package sub;

public class Members extends User {
    private static int idCounter = 1;
    private int memberId;
    private MembershipPlan plan;

    public Members(String name, String email) {
        super(name, email);
        this.memberId = idCounter++;
    }

    public int getMemberId() {
        return memberId;
    }

    public void choosePlan(MembershipPlan plan) {
        this.plan = plan;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    @Override
    public void displayDetails() {
        System.out.println("Member ID: " + memberId + ", Name: " + getName() + ", Email: " + getEmail());
    }
}
