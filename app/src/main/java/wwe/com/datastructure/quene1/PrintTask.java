package wwe.com.datastructure.quene1;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene1
 * @class describe
 * @anthor David
 * @time 2019/2/12 2:36 PM
 * @class describe
 */
public class PrintTask implements ITask {

    private int id;

    public PrintTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }

        System.out.println("我的id是：" + id);
    }
}
