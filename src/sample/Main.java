package sample;

public class Main {
    public static void main(String[] args) {

        Thread thread2 = new Thread() {
            public void run() {
                new IHMFX().lance();
            }
        };
        thread2.start();
    }
}
