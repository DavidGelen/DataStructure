package wwe.com.datastructure.quene1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene1
 * @class describe
 * @anthor David
 * @time 2019/2/12 2:33 PM
 * @class describe
 */
public class TaskQueue {

    private BlockingQueue<ITask> mTaskQueue;

    private TaskExecutor[] mTaskExecutors;

    public TaskQueue(int size) {
        mTaskQueue = new LinkedBlockingQueue<>();
        mTaskExecutors = new TaskExecutor[size];
    }

    public void start() {
        stop();
        for (int i = 0; i < mTaskExecutors.length; i++) {
            mTaskExecutors[i] = new TaskExecutor(mTaskQueue);
            mTaskExecutors[i].start();
        }
    }

    public void stop() {
        if (mTaskExecutors != null)
            for (TaskExecutor taskExecutor : mTaskExecutors) {
                if (taskExecutor != null) taskExecutor.quit();
            }
    }

    public <T extends ITask> int add(T task) {
        if (!mTaskQueue.contains(task)) {
            mTaskQueue.add(task);
        }
        return mTaskQueue.size();
    }

}
