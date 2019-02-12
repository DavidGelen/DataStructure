package wwe.com.datastructure.quene1;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene1
 * @class describe
 * @anthor David
 * @time 2019/2/12 2:38 PM
 * @class describe
 */
public class Test {

    public static void main(String[] args) {

        //并发三个任务的效果
        TaskQueue taskQueue = new TaskQueue(3);

        for (int i = 0; i < 10; i++) {
            PrintTask pt = new PrintTask(i);
            taskQueue.add(pt);
        }

        taskQueue.start();

    }

}
