import java.util.*;
class User {
    private String name;
    private String address;
    private int meterId;
    public User(String name, String address, int meterId) {
        this.name = name;
        this.address = address;
        this.meterId = meterId;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getMeterId() {
        return meterId;
    }
}
class Bill {
    private User user;
    private int unitsConsumed;
    private double billAmount;

    public Bill(User user, int unitsConsumed) {
        this.user = user;
        this.unitsConsumed = unitsConsumed;
    }

    public void calculateBill() {
        if (unitsConsumed < 100) {
            billAmount = unitsConsumed * 4.5;
        } else {
            billAmount = (100 * 4.5) + (unitsConsumed - 100) * 9;
        }
    }

    public double getBillAmount() {
        return billAmount;
    }
}

public class AmdocsElectricityBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX_USERS = 100;
        User[] users = new User[MAX_USERS];
        int userCount = 0; 

        users[userCount++] = new User("Sunny Sagar", "pune", 101);
        users[userCount++] = new User("Mishra", "goa", 102);

        while (true) {
            System.out.println("\n Amdocs Electricity Billing System Menu:");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Calculate Bills");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (userCount < MAX_USERS) {
                        System.out.print("Enter user name: ");
                        String name = sc.next();
                        sc.nextLine();
                        System.out.print("Enter user address: ");
                        String address = sc.nextLine();
                        System.out.print("Enter user meter ID: ");
                        int meterId = sc.nextInt();
                        users[userCount++] = new User(name, address, meterId);
                        System.out.println("User added successfully!");
                    } else {
                        System.out.println("Maximum number of users reached.");
                    }
                    break;

                case 2:
                    System.out.println("\nAll Users:\n");
                    for (int i = 0; i < userCount; i++) {
                        User user = users[i];
                        System.out.println("Name: " + user.getName());
                        System.out.println("Address: " + user.getAddress());
                        System.out.println("Meter ID: " + user.getMeterId() + "\n");
                    }
                    break;

                case 3:
                    System.out.print("Enter user ID for bill calculation: ");
                    int userId = sc.nextInt();
                    User selectedUser = null;
                    for (int i = 0; i < userCount; i++) {
                        if (users[i].getMeterId() == userId) {
                            selectedUser = users[i];
                            break;
                        }
                    }
                    if (selectedUser != null) {
                        System.out.print("Enter units consumed for " + selectedUser.getName() + ": ");
                        int unitsConsumed = sc.nextInt();
                        Bill bill = new Bill(selectedUser, unitsConsumed);
                        bill.calculateBill();
                        System.out.println("Bill for " + selectedUser.getName() + ": Rs." + bill.getBillAmount());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
