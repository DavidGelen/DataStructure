package wwe.com.datastructure.quene3;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene3
 * @class describe
 * @anthor David
 * @time 2019/2/12 5:17 PM
 * @class 任务调度类，里面封装了入队以及对队列操作的一些功能
 */
public class TaskScheduler {

    private final String TAG = "TaskScheduler";
    private BlockTaskQueue mTaskQueue = BlockTaskQueue.getInstance();
    private ShowTaskExecutor mExecutor;

    private static class ShowDurationHolder {
        private final static TaskScheduler INSTANCE = new TaskScheduler();
    }

    private TaskScheduler() {
        initExecutor();
    }

    private void initExecutor() {
        mExecutor = new ShowTaskExecutor(mTaskQueue);
        mExecutor.start();
    }

    public static TaskScheduler getInstance() {
        return ShowDurationHolder.INSTANCE;
    }

    public void enqueue(ITask task) {
        //因为TaskScheduler这里写成单例，如果isRunning改成false的话，不判断一下，就会一直都是false
        if (!mExecutor.isRunning()) {
            mExecutor.startRunning();
        }
        //按照优先级插入队列 依次播放
        mTaskQueue.add(task);
    }

    public void resetExecutor() {
        mExecutor.resetExecutor();
    }

    public void clearExecutor() {
        mExecutor.clearExecutor();
    }

}
