package services;

import sub.*;

import java.util.ArrayList;
import java.util.List;

public class Paymentservices {
    private List<Payment> payments = new ArrayList<>();

    public void processPayment(Members member, MembershipPlan plan, double amount) {
        Payment payment = new Payment(member, plan, amount);
        payments.add(payment);
        System.out.println("Payment processed: " + member.getName() + " - " + plan.getPlanName() + " - $" + amount);
    }

    public void displayAllPayments() {
        for (Payment payment : payments) {
            System.out.println("Member: " + payment.getMember().getName() + ", Plan: " + payment.getPlan().getPlanName() + ", Amount: $" + payment.getAmount());
        }
    }
}
