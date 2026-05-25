public class DeadLockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("T1 acquired lock1");
                try { Thread.sleep(100); } catch (Exception ignored) {}
                synchronized (lock2) {
                    System.out.println("T1 acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("T2 acquired lock2");
                try { Thread.sleep(100); } catch (Exception ignored) {}
                synchronized (lock1) {
                    System.out.println("T2 acquired lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
