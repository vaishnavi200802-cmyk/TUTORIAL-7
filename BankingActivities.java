class BankingTask implements Runnable {
    private String activity;
    private int delay;

    BankingTask(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - " + activity + " - Execution " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class BankingActivities {
    public static void main(String[] args) {
        Thread transaction = new Thread(new BankingTask("Processing transaction", 700));
        Thread balance = new Thread(new BankingTask("Updating balance", 1000));
        Thread sms = new Thread(new BankingTask("Sending SMS notification", 1300));

        transaction.setName("TransactionThread");
        balance.setName("BalanceThread");
        sms.setName("SMSThread");

        transaction.start();
        balance.start();
        sms.start();
    }
}
