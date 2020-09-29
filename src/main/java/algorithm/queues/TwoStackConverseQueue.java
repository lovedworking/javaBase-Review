package algorithm.queues;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * stack
 *      1  获取栈顶元素 top of this stack
 *                  a 不删除 peek
 *                  b 删除  pop  在peek的基础上添加了 removeElementAt()
 *
 *      2  添加元素
 *                  入栈在栈尾部  push addElement
 *
 * queue
 *      1   获取元素
 *  *                  a 不移除元素
 *                                  抛异常  element
 *                                  不抛异常 peek  null
 *  *                  b  移除元素
 *                                  抛异常 remove
 *                                 不抛异常 poll   null
 *
 *      2   添加元素
 *                     带异常  add   如果成功 true否则 IllegalStateException
 *
 *                     不抛异常offer 成功 true 否则 false

 *
 *
 *
 */
public class TwoStackConverseQueue {

}

















