package sub;

public class Trainer extends User {
    private String specialty;

    public Trainer(String name, String email, String specialty) {
        super(name, email);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public void displayDetails() {
        System.out.println("Trainer Name: " + getName() + ", Email: " + getEmail() + ", Specialty: " + specialty);
    }
}
