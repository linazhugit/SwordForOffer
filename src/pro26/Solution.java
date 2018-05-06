package pro26;
/**
 * @author linazhu
 * @Description 复杂链表的复制
 */

/**
 * 注意：结点中有一个指针指向其他任意一个结点或者NULL
 * 步骤：
 * 1. 复制原始链表的任意结点N并创建新结点N'，再把N'链接到N的后面
 * 2. 设置复制结点的m_pSibling；拷贝原始链表N的m_pSibling指向S结点；N'的m_pSibling指向S'结点
 * 3. 把长链表拆分成两个链表；奇数位置的是原始链表，偶数位置的是新链表
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        cloneNodes(pHead);
        connectSlblingNodes(pHead);
        return reconnectNodes(pHead);

    }

    private void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    private void connectSlblingNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
    }

    private RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        // 初始化两个链表的头结点
        if (pHead != null) {
            pClonedHead = pNode.next;
            pClonedNode = pNode.next;
            pNode.next = pClonedHead.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }
}
