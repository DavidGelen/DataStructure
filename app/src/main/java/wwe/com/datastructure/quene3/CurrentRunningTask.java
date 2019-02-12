package wwe.com.datastructure.quene3;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene3
 * @class describe
 * @anthor David
 * @time 2019/2/12 5:11 PM
 * @class 有时候要获取一些正在执行的任务的信息，所以这里弄一个类来将正在执行的任务存储起来
 */
public class CurrentRunningTask {

    private static ITask sCurrentShowingTask;

    public static void setCurrentShowingTask(ITask task) {
        sCurrentShowingTask = task;
    }

    public static void removeCurrentShowingTask() {
        sCurrentShowingTask = null;
    }

    public static ITask getCurrentShowingTask() {
        return sCurrentShowingTask;
    }

    public static boolean getCurrentShowingStatus() {
        return sCurrentShowingTask != null && sCurrentShowingTask.getStatus();
    }

}
