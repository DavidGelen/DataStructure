package wwe.com.datastructure.quene1;

import java.util.concurrent.BlockingQueue;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene1
 * @class describe
 * @anthor David
 * @time 2019/2/12 2:27 PM
 * @class describe
 */
public class TaskExecutor extends Thread {

    private BlockingQueue<ITask> taskQueue;

    private boolean isRunning = true;

    public TaskExecutor(BlockingQueue<ITask> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void quit() {
        isRunning = false;
        interrupt();
    }

    @Override
    public void run() {
        while (isRunning) {
            ITask iTask;
            try {
                iTask = taskQueue.take(); //阻塞式的，没有就等着。
            } catch (InterruptedException e) {
                if (!isRunning) {
                    interrupt();
                    break;
                }
                continue;
            }
            iTask.run();
        }
    }
}
