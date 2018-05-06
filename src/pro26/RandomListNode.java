package pro26;

/**
 * @author linazhu
 * @Description 复杂链表中的一个结点 有一个指针指向链表中的任意一个结点
 */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
