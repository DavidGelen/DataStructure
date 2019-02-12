
设计一个优先级队列

把上面的LinkedBlockingQueue替换成PriorityBlockingQueue<E>，因为它可以自动做到优先级的比较，

它要求泛型<E>，也就是我们的Task必须实现Comparable<E>接口