
设计一个优先级队列

把上面的LinkedBlockingQueue替换成PriorityBlockingQueue<E>，因为它可以自动做到优先级的比较，

它要求泛型<E>，也就是我们的Task必须实现Comparable<E>接口

---

当优先级别一样的时候怎么办，那就是谁先加入队列谁排到前面呗，

我们怎么知道哪个Task先加入队列呢？给它给一个序列标记它什么时候加入队列的不久完事了，所以我们引入了sequence

---

**封装的队列需要有什么功能:**

- 任务的排队执行

- 排队执行，当然会有优先级之分，所以每个任务都能设置优先级，队列可以根据优先级去排队执行任务。

至于队列选哪一个，我这里选择的是 PriorityBlockingQueue（阻塞优先级队列），
这个队列的特点是存储的对象必须是实现Comparable接口，而且它是阻塞队列。