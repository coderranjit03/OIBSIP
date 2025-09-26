import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("user123", "4321", 10000.0);
        TransactionHistory history = new TransactionHistory();
        BankOperations bank = new BankOperations(user, history);

        System.out.println("🔐 Welcome to the ATM Interface");
        System.out.print("Enter User ID: ");
        String inputId = sc.nextLine();
        System.out.print("Enter PIN: ");
        String inputPin = sc.nextLine();

        if (!inputId.equals(user.getUserId()) || !inputPin.equals(user.getPin())) {
            System.out.println("❌ Authentication failed. Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n💳 ATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    history.showHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    bank.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    bank.deposit(sc.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter recipient ID: ");
                    sc.nextLine(); // consume leftover newline
                    String recipient = sc.nextLine();
                    System.out.print("Enter amount to transfer: ₹");
                    bank.transfer(sc.nextDouble(), recipient);
                    break;
                case 5:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid option. Try again.");
            }
        } while (choice != 5);

       
    }
}