package conur;

import java.util.LinkedList;

class SimpleThreadPool {
    private final PoolWorker[] threads;
    private final LinkedList<Runnable> queue;

    public SimpleThreadPool(int numThreads) {
        queue = new LinkedList<>();
        threads = new PoolWorker[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (queue) {
            queue.addLast(task);
            queue.notify();
        }
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable task;
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    task = queue.removeFirst();
                }
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool task exception: " + e);
                }
            }
        }
    }
}

public class ThreadPerTaskExecutor {
    // Using the pool:
    public static void main(String[] args) {
        SimpleThreadPool threadPool = new SimpleThreadPool(5);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> System.out.println("Task executed"));
        }
    }
}
