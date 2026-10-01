class ExamActivity implements Runnable {
    private String activity;

    ExamActivity(String activity) {
        this.activity = activity;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - " + activity + " (Step " + i + ")");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class OnlineExam {
    public static void main(String[] args) {
        Thread timer = new Thread(new ExamActivity("Displaying remaining time"));
        Thread save = new Thread(new ExamActivity("Auto-saving answers"));
        Thread network = new Thread(new ExamActivity("Checking network connection"));

        timer.setName("TimerThread");
        save.setName("AutoSaveThread");
        network.setName("NetworkThread");

        timer.start();
        save.start();
        network.start();
    }
}
