package wwe.com.datastructure.quene2;


/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene2
 * @class describe
 * @anthor David
 * @time 2019/2/12 3:15 PM
 * @class describe
 */
public class Test {

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue(1);
        taskQueue.add(new PrintTask(110));
        taskQueue.add(new PrintTask(112));
        taskQueue.add(new PrintTask(122));

        for (int i = 0; i < 10; i++) {
            PrintTask task = new PrintTask(i);
            if (1 == i) {
                task.setPriority(Priority.LOW);
            } else if (8 == i) {
                task.setPriority(Priority.HIGH);
            } else if (9 == i) {
                task.setPriority(Priority.Immediately);
            }
            taskQueue.add(task);
        }

        taskQueue.start();
    }
}