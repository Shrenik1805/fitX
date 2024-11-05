package Auth;

import sub.Members;
import java.util.List;

public class ReportGenerator {
    public void generateReport(List<Members> members) {
        System.out.println("\nGenerating Report...");
        for (Members member : members) {
            member.displayDetails();
            if (member.getPlan() != null) {
                member.getPlan().displayPlanDetails();
            } else {
                System.out.println("No membership plan chosen.");
            }
        }
    }
}
