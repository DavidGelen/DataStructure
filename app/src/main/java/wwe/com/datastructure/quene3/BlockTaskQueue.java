package wwe.com.datastructure.quene3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene3
 * @class describe
 * @anthor David
 * @time 2019/2/12 5:01 PM
 * @class describe
 */
public class BlockTaskQueue {

    private String TAG = "BlockTaskQueue";

    private AtomicInteger mAtomicInteger = new AtomicInteger();

    //阻塞队列
    private final BlockingQueue<ITask> mTaskQueue = new PriorityBlockingQueue<>();

    private BlockTaskQueue() {
    }

    private static class BlockTaskQueueHolder {
        private final static BlockTaskQueue INSTANCE = new BlockTaskQueue();
    }

    public static BlockTaskQueue getInstance() {
        return BlockTaskQueueHolder.INSTANCE;
    }

    /**当优先级相同时，使用AtomicInteger原子类自增,来为每一个task设置sequence,sequence的作用是标记两个相同优先级的任务入队的次序*/
    public <T extends ITask> int add(T task) {
        if (!mTaskQueue.contains(task)) {
            task.setSequence(mAtomicInteger.incrementAndGet());
            mTaskQueue.add(task);
        }
        return mTaskQueue.size();
    }

    public <T extends ITask> void remove(T task) {
        if (mTaskQueue.contains(task)) {
            mTaskQueue.remove(task);
        }
        if (mTaskQueue.size() == 0) {
            mAtomicInteger.set(0);
        }
    }

    public ITask poll() {
        return mTaskQueue.poll();
    }

    public ITask take() throws InterruptedException {
        return mTaskQueue.take();
    }

    public void clear() {
        mTaskQueue.clear();
    }

    public int size() {
        return mTaskQueue.size();
    }

}
