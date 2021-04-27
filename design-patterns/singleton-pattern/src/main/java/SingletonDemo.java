public class SingletonDemo {
    public static void main(String[] args) {

      //  Singleton singleton = Singleton.getSingleton();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                Singleton singleton = Singleton.getSingleton();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                Singleton singleton = Singleton.getSingleton();
            }
        });
        thread1.run();
        thread2.run();

    }
}

class Singleton {
    public static Singleton singleton;

    private Singleton() {
        System.out.println("Singleton object created!");
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();

                }
            }
        }
        return singleton;
    }
}

