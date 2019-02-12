package wwe.com.datastructure.quene2;

/**
 * @name DataStructure
 * @class name：wwe.com.datastructure.quene2
 * @class describe
 * @anthor David
 * @time 2019/2/12 3:05 PM
 * @class describe
 */
public abstract class BasicTask implements ITask {

    private Priority priority = Priority.DEFAULT;

    private int sequence;

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public int getSequence() {
        return sequence;
    }

    // 做优先级比较。
    @Override
    public int compareTo(ITask another) {
        final Priority me = this.getPriority();
        final Priority it = another.getPriority();
        return me == it ?  this.getSequence() - another.getSequence() :
                it.ordinal() - me.ordinal();
    }


}
