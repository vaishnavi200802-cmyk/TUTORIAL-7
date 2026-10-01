class Junction extends Thread {
    private String trafficStatus;
    private int delay;

    Junction(String name, String trafficStatus, int delay) {
        this.trafficStatus = trafficStatus;
        this.delay = delay;
        setName(name);
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Traffic Status: "
                    + trafficStatus + " (Report " + i + ")");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
                interrupt();
                return;
            }
        }
    }
}

public class TrafficManagement {
    public static void main(String[] args) {
        Junction j1 = new Junction("Junction 1", "Heavy Traffic", 700);
        Junction j2 = new Junction("Junction 2", "Moderate Traffic", 1000);
        Junction j3 = new Junction("Junction 3", "Light Traffic", 1300);

        j1.start();
        j2.start();
        j3.start();
    }
}
