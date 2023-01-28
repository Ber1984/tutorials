package multithreading;

public class RaceConditions {
    private int sum1 = 0;
    private int sum2 = 0;

    public void add(int val1, int val2) {
        synchronized (this) {
            this.sum1 += val1;
            this.sum2 += val2;
        }
    }

    public static void main(String[] args) {
        RaceConditions race = new RaceConditions();
        race.add(1, 2);
    }
}
