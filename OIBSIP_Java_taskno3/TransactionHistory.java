import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private List<Transaction> history = new ArrayList<>();

    public void addTransaction(String type, double amount) {
        history.add(new Transaction(type, amount));
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("📭 No transactions yet.");
        } else {
            System.out.println("📜 Transaction History:");
            for (Transaction t : history) {
                System.out.println(" - " + t);
            }
        }
    }
}