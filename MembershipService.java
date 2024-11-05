package services;

import sub.*;

import java.util.ArrayList;
import java.util.List;

public class MembershipService {
    private List<Members> members = new ArrayList<>();
    private List<Trainer> trainers = new ArrayList<>();
    private List<MembershipPlan> plans = new ArrayList<>();

    public MembershipService() {
        // Initialize default membership plans
        addMembershipPlan(new MembershipPlan("Gold", 5000));
        addMembershipPlan(new MembershipPlan("Elite", 10000));
        addMembershipPlan(new MembershipPlan("Comp", 15000));
    }

    public void addMember(Members member) {
        members.add(member);
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void addMembershipPlan(MembershipPlan plan) {
        plans.add(plan);
    }

    public List<Members> getMembers() {
        return members;
    }

    public void displayAllMembers() {
        for (Members member : members) {
            member.displayDetails();
        }
    }

    public void displayAllTrainers() {
        for (Trainer trainer : trainers) {
            trainer.displayDetails();
        }
    }

    public MembershipPlan findPlanByName(String planName) {
        for (MembershipPlan plan : plans) {
            if (plan.getPlanName().equalsIgnoreCase(planName)) {
                return plan;
            }
        }
        System.out.println("Membership plan not found: " + planName);
        return null;
    }
}
