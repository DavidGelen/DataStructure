package wwe.com.datastructure.quene2;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene2
 * @class describe
 * @anthor David
 * @time 2019/2/12 2:53 PM
 * @class describe
 */
public interface ITask extends Comparable<ITask> {
    void run();
    void setPriority(Priority priority);
    Priority getPriority();

    //给一个序列标记,告知什么时候加入队列，即谁先加入，谁后加入
    void setSequence(int sequence);
    int getSequence();
}
