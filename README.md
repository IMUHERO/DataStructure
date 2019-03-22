# DataStructure<br>

* #### 大家好！欢迎来到IMUHERO的数据结构代码仓，本项目是博主在学习数据结构的过程中的心血结晶，每一个部分数据结构都通过java认认真真实现了，并且还提出了不少改进方法，比如在队列一节中就实现了三种不同形式：简单队列、循环队列、链表队列，相信能给同样学习数据结构的同学带来不小帮助。本项目中的所有代码，博主都通过测试函数进行检验，有很小的概率存在bug，如果有发现欢迎及时批评指正。<br>
* #### 同时在该项目中还有许多稍微复杂一些的数据结构没有实现，比如双向链表、红黑树等等，博主会在后续不断更新，也希望喜欢探索的你一起参与项目的书写。
* ####  `如果喜欢的话，记得打个☆Star哦~~~`

### [一、数组](https://github.com/IMUHERO/DataStructure/tree/master/1-Array)
* [JAVA内置数组的简单使用](https://github.com/IMUHERO/DataStructure/blob/master/1-Array/1-ArrayBasic/Main.java)
* [自己实现的多功能数组](https://github.com/IMUHERO/DataStructure/blob/master/1-Array/2-Function-Of-Array/Array.java)
  * 功能：getCapacity()、 getSize()、 getSize()、isEmpty()、addLast(E e)、addFirst(E e)、add(int index, E e)、<br>get(int index)、set(int index, E e)、boolean judge(int e)、int find(E e)E delete(int index)、 E deleteFirst()、<br>E deleteLast()、String deleteElement(E e)、void resize(int num)、String toString()
  * 特别：`动态数组`、`泛型`
  
### [二、栈](https://github.com/IMUHERO/DataStructure/tree/master/2-Stacks)<br>
* [基于数组实现的栈](https://github.com/IMUHERO/DataStructure/tree/master/2-Stacks/ArrayStack) : 数组的功能与[`数组`](https://github.com/IMUHERO/DataStructure/blob/master/2-Stacks/ArrayStack/Array.java)功能相同。
* [基于链表实现的栈](https://github.com/IMUHERO/DataStructure/tree/master/2-Stacks/LinkedListStack) : 链表的功能与[`链表`](https://github.com/IMUHERO/DataStructure/blob/master/2-Stacks/LinkedListStack/LinkedList.java)功能相同。

### [三、队列](https://github.com/IMUHERO/DataStructure/tree/master/3-Queue)
* [简单队列](https://github.com/IMUHERO/DataStructure/tree/master/2-Stacks/ArrayStack) : 基于[`数组`](https://github.com/IMUHERO/DataStructure/blob/master/3-Queue/1-ArrayQueue/Array.java)实现。
* [循环队列](https://github.com/IMUHERO/DataStructure/tree/master/2-Stacks/ArrayStack) : 基于[`数组`](https://github.com/IMUHERO/DataStructure/blob/master/3-Queue/2-LoopQueue/Array.java)实现。
* [链表队列](https://github.com/IMUHERO/DataStructure/tree/master/2-Stacks/ArrayStack) : 基于[`链表`](https://github.com/IMUHERO/DataStructure/tree/master/4-Linked-List)实现。

### [四、链表](https://github.com/IMUHERO/DataStructure/tree/master/4-Linked-List)
* [带虚拟头结点的链表](https://github.com/IMUHERO/DataStructure/tree/master/4-Linked-List/1-DummyHead-Linked-List)
* [基于链表实现的队列](https://github.com/IMUHERO/DataStructure/tree/master/4-Linked-List/3-Implement-Queue-in-LinkedList) 
* [基于链表实现的栈](https://github.com/IMUHERO/DataStructure/tree/master/4-Linked-List/2-Implement-Stack-in-LinkedList) 

### [五、二分搜索树](https://github.com/IMUHERO/DataStructure/tree/master/5-Binary-Search-Tree)
* 在二分搜索树中不满足于`递归求法`，还列出了`非递归求法`
* 实现前序遍历、中序遍历、后序遍历、层序遍历
* 完成基本的增删改查的功能<br>
------二分搜索树的中序遍历可以完成排序功能------

### [六、集合与映射](https://github.com/IMUHERO/DataStructure/tree/master/6-Set-and-Map)
* [集合Set](https://github.com/IMUHERO/DataStructure/tree/master/6-Set-and-Map/Set):可用于存储不重复元素<br>
底层实现包含：[`二叉树集合`](https://github.com/IMUHERO/DataStructure/tree/master/6-Set-and-Map/Set/BSTSet)+[`链表集合`](https://github.com/IMUHERO/DataStructure/tree/master/6-Set-and-Map/Set/LinkedListSet)
* [映射Map](https://github.com/IMUHERO/DataStructure/tree/master/6-Set-and-Map/Map):可用于存储
`不重复元素`<br>
底层实现包含：[`二叉树映射`](https://github.com/IMUHERO/DataStructure/tree/master/6-Set-and-Map/Set/BSTSet)+[`链表映射`](https://github.com/IMUHERO/DataStructure/tree/master/6-Set-and-Map/Set/LinkedListSet)

### [七、堆与优先队列](https://github.com/IMUHERO/DataStructure/tree/master/7-Heap-and-Priority-Queue)
* [`堆：Map`](https://github.com/IMUHERO/DataStructure/tree/master/7-Heap-and-Priority-Queue/Heap):实现[最大堆](https://github.com/IMUHERO/DataStructure/blob/master/7-Heap-and-Priority-Queue/Heap/MaxHeap.java)<br>
注：基于`数组`实现`二叉树`，进而实现`堆`。
* [`优先队列：PriorityQueue`](https://github.com/IMUHERO/DataStructure/tree/master/7-Heap-and-Priority-Queue/PriorityQueue)<br>
注：基于`最大堆`实现的`优先队列`

### [八、哈希表](https://github.com/IMUHERO/DataStructure/blob/master/8-Hash-Table/HashTable.java)
注：使用系统java.util.TreeMap实现HashMap,哈希表底层采用数组，数组中每一个位置链接一科红黑树。







