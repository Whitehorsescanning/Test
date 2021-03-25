总结：
1：对于map/set的选择使用
HashMap 无序
TreeMap  排序
LinkedHashMap 加链表

Hashtable
Collections.sychronizedXXX

ConcurrentHashMap  CAS
ConcurrentSkipListMap  高并发且排序

2：队列
ArrayList
LinkedList
Collections.synchronizedXXX
CopyOnWriteList
Queue  有对线程友好的API offer() add()  poll() peek()
	CocurrentLinkedQueue //concurrentArrayQueue
	BlockingQueue
		LinkedBQ
		ArrayBQ
		TransferQueue
		SynchronusQueue
	DelayQueue执行定时任务
		
	