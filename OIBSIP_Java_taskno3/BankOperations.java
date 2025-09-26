public class BankOperations {
    private User user;
    private TransactionHistory history;

    public BankOperations(User user, TransactionHistory history) {
        this.user = user;
        this.history = history;
    }

    public void deposit(double amount) {
        user.setBalance(user.getBalance() + amount);
        history.addTransaction("Deposit", amount);
        System.out.println("✅ ₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount > user.getBalance()) {
            System.out.println("❌ Insufficient balance.");
        } else {
            user.setBalance(user.getBalance() - amount);
            history.addTransaction("Withdraw", amount);
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        }
    }

    public void transfer(double amount, String recipientId) {
        if (amount > user.getBalance()) {
            System.out.println("❌ Insufficient balance.");
        } else {
            user.setBalance(user.getBalance() - amount);
            history.addTransaction("Transfer to " + recipientId, amount);
            System.out.println("✅ ₹" + amount + " transferred to " + recipientId);
        }
    }
}