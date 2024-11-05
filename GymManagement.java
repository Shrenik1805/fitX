package main;

import sub.*;
import services.*;
import Auth.*;
import java.util.Scanner;

public class GymManagement {
    public static void main(String[] args) {
        MembershipService membershipService = new MembershipService();
        Paymentservices paymentservices = new Paymentservices();
        UserService userService = new UserService();
        Authentication auth = new Authentication();

        auth.register("admin", "hulkonroids");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if(auth.login(username, password)) {
            System.out.println("Login successful!");

            boolean exit = false;
            while (!exit) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Member");
                System.out.println("2. Add Trainer");
                System.out.println("3. Display Trainer List");
                System.out.println("4. Add Membership Plan");
                System.out.println("5. Display All Members");
                System.out.println("6. Generate Report");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter member name: ");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter member email: ");
                        String memberEmail = scanner.nextLine();
                        Members member = new Members(memberName, memberEmail);
                        membershipService.addMember(member);
                        System.out.print("Choose membership plan for this member (Gold, Elite, Comp): ");
                        String planName = scanner.nextLine();
                        MembershipPlan chosenPlan = membershipService.findPlanByName(planName);
                        if (chosenPlan != null) {
                            member.choosePlan(chosenPlan);
                            System.out.println("Membership plan assigned successfully.");
                        } else {
                            System.out.println("Invalid membership plan.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter trainer name: ");
                        String trainerName = scanner.nextLine();
                        System.out.print("Enter trainer email: ");
                        String trainerEmail = scanner.nextLine();
                        System.out.print("Enter trainer specialty: ");
                        String specialty = scanner.nextLine();
                        Trainer trainer = new Trainer(trainerName, trainerEmail, specialty);
                        membershipService.addTrainer(trainer);
                        System.out.println("Trainer added successfully.");
                        break;

                    case 3:
                        System.out.println("\nTrainer List:");
                        membershipService.displayAllTrainers();
                        break;

                    case 4:
                        System.out.print("Enter membership plan name: ");
                        String newPlanName = scanner.nextLine();
                        System.out.print("Enter membership plan price: ");
                        double price = scanner.nextDouble();
                        MembershipPlan plan = new MembershipPlan(newPlanName, price);
                        membershipService.addMembershipPlan(plan);
                        System.out.println("Membership plan added successfully.");
                        break;

                    case 5:
                        System.out.println("\nAll Members:");
                        membershipService.displayAllMembers();
                        break;

                    case 6:
                        ReportGenerator reportGen = new ReportGenerator();
                        reportGen.generateReport(membershipService.getMembers());
                        break;

                    case 7:
                        exit = true;
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed!");
        }

        scanner.close();
    }
}
