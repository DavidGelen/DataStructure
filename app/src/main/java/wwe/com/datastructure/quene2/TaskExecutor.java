package wwe.com.datastructure.quene2;

import java.util.concurrent.BlockingQueue;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene2
 * @class describe
 * @anthor David
 * @time 2019/2/12 2:57 PM
 * @class describe
 */
public class TaskExecutor extends Thread {

    private BlockingQueue<ITask> quene;

    private boolean isRunning = true;

    TaskExecutor(BlockingQueue<ITask> mTaskQueue) {
        this.quene = mTaskQueue;
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
                iTask = quene.take(); //阻塞式的，没有就等着。
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
