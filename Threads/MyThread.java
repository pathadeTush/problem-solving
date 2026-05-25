public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.getName() + " is running!");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }

}
