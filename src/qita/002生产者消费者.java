//店员类
class Clerk {
    private int product = 0;

    // 进货
    public synchronized void get() {
        while (product >= 1) {
            System.out.println("产品已满！");

            // 等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + ++product);
        // 唤醒
        this.notifyAll();
    }

    // 售货
    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("缺货！");
            // 等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + --product);
        // 唤醒
        this.notifyAll();
    }
}

// 生产者类
class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}

// 消费者类
class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.sale();
        }
    }
}

public class TestProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(productor, "Productor A").start();
        new Thread(consumer, "Consumer B").start();
        new Thread(productor, "Productor C").start();
        new Thread(consumer, "Consumer D").start();
    }
}
