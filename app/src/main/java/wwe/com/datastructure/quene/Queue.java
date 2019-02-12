package wwe.com.datastructure.quene;

/**
 * @name DataStructure
 * @package name：wwe.com.datastructure.quene
 * @anthor DavidZhang
 * @time 2019/2/11 15:26
 * @class describe
 */
public class Queue<E> {
    private Object[] data = null;// 队列
    private int front;// 队列头，允许删除
    private int rear;// 队列尾，允许插入

    public Queue() {
        this(10);// 默认队列的大小为10
    }

    private Queue(int initialSize) {
        data = new Object[initialSize];
        front = rear = 0;
    }

    // 入列一个元素
    public void offer(E e) {
        data[rear++] = e;
    }

    // 返回队首元素，但不删除,不出队列
    public E peek() {
        return (E) data[front];
    }

    // 出队排在最前面的一个元素
    public E poll() {
        E value = (E) data[front];// 保留队列的front端的元素的值
        data[front++] = null;// 释放队列的front端的元素
        return value;
    }
}
