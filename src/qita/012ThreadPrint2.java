//5个线程，顺序打印数1~无穷大,且5个数为一组,id代表线程id
public class Main47 {
    public static void main(String[] args) {
        int threadCount = 5;
        for (int i = 1; i <= threadCount; i++) {
            new Thread(new PrintSequenceThread(i, threadCount)).start();
        }
    }
}

class PrintSequenceThread implements Runnable {
    private static final Object mLock = new Object();
    public int threadId;
    private int threadCount;
    private static int current = 0;// 它一定要是static的,不然它会每个线程对象各一份
    // public int current = 0;

    public PrintSequenceThread(int threadId, int threadCount) {
        this.threadId = threadId;
        this.threadCount = threadCount;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (mLock) {//同步锁在里面，否则死锁
                while (current % threadCount != threadId-1) {
                    try {
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);// 停顿100ms，为了让打印不要太快
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread-" + threadId + " : " + (++current));
                mLock.notifyAll();
            }
        }

    }

}
