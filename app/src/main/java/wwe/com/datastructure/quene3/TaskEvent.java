package wwe.com.datastructure.quene3;

import java.lang.ref.WeakReference;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene3
 * @class describe
 * @anthor David
 * @time 2019/2/12 5:19 PM
 * @class describe
 */
public class TaskEvent {

    private WeakReference<ITask> mTask;
    int mEventType;

    public ITask getTask() {
        return mTask.get();
    }

    public void setTask(ITask mTask) {
        this.mTask = new WeakReference<>(mTask);
    }

    public int getEventType() {
        return mEventType;
    }

    public void setEventType(int mEventType) {
        this.mEventType = mEventType;
    }

    public static class EventType {
        public static final int DO = 0X00;
        public static final int FINISH = 0X01;
    }

}
