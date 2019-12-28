//*********3个线程交替打印0->100***************
public class Main012 {
    public static void main(String[] args) {
        int threadCount = 3;
        int max = 100;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new PrintSequenceThread(i, threadCount, max)).start();
        }
    }
}

class PrintSequenceThread implements Runnable {
    private static final Object mLock = new Object();
	
    /**
     * 当前即将打印的数字
     */
    private static int current = 0;
	
    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;
    /**
     * 线程数量
     */
    private int threadCount;
	
    /**
     * 打印的最大数值
     */
    private int max;
    public PrintSequenceThread(int threadNo, int threadCount, int max) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.max = max;
    }
	
    @Override
    public void run() {
        while (true) {
            synchronized (mLock) {
                // 判断是否轮到当前线程执行
                while (current % threadCount != threadNo) {
                    if (current > max) {
                        break;
                    }
                    try {
                        // 如果不是，则当前线程进入wait
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 最大值跳出循环
                if (current > max) {
                    break;
                }
                System.out.println("thread-" + threadNo + " : " + current);
                current++;
                // 唤醒其他wait线程
                mLock.notifyAll();
            }
        }
    }
}
//*******************************************************************************************
//3个线程并发打印从0到n，不是交替打印,每个线程可能连续执行,有的线程可能长时间按得不到执行
public class Main12_1 {
    public static void main(String[] args) {
        int threadCount = 3;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new PrintSequenceThread1(i, threadCount)).start();
        }
    }
}
class PrintSequenceThread1 implements Runnable {
	
    private static final Object mLock = new Object();
	
    /**
     * 当前即将打印的数字
     */
    private static int current = 0;
	
    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;
	
    /**
     * 线程数量
     */
    private int threadCount;
	
    public PrintSequenceThread1(int threadNo, int threadCount) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
    }
	
    @Override
    public void run() {//3个线程并发打印从0到n，不是交替打印,每个线程可能连续执行,有的线程可能长时间按得不到执行
        while (true) {
            synchronized (mLock) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread-" + threadNo + " : " + current);
                current++;
            }
        }
    }
}
***********************************************************************************************************
//***************//3个线程交替打印从0到n*****************
public class Main12_2 {
    public static void main(String[] args) {
        int threadCount = 3;
        for (int i = 0; i < threadCount; i++) {
            //3个线程交替打印从0到n
            new Thread(new PrintSequenceThread2(i, threadCount)).start();
        }
    }
}
class PrintSequenceThread2 implements Runnable {
    private static final Object mLock = new Object();
    /**
     * 当前即将打印的数字
     */
    private static int current = 0;
    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;
    /**
     * 线程数量
     */
    private int threadCount;
    
    public PrintSequenceThread2(int threadNo, int threadCount) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
    }
    
    @Override
    public void run() {//3个线程交替打印从0到n
        while (true) {
            synchronized (mLock) {
                // 判断是否轮到当前线程执行
                while (current % threadCount != threadNo) {//一定是while，而不是if
                    try {
                        //是while的原因,当这个线程被notifyAll时,它会从mLock.wait()这句之后继续往下执行,即使当前没有轮到它
                        //写成while，如果它依然满足条件(没有轮到它),它会一直阻塞在这里
                        // 如果不是，则当前线程进入wait
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);//停顿100ms，为了让打印不要太快
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread-" + threadNo + " : " + current);
                current++;
                // 唤醒其他wait线程
                mLock.notifyAll();
            }
        }
    }
}
