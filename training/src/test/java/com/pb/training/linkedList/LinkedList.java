package com.pb.training.linkedList;

import org.junit.Test;

import java.util.Objects;

/**
 * @Author pengbin
 * @date 2020/5/12 16:29
 */
public class LinkedList {

    /**
     * 链表反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)){
            return head;
        }
        ListNode next = null;
        ListNode container = head;
        ListNode node;
        while (container.next != null){
            node = new ListNode(container.val);
            node.next = next;
            next = node;
            container = container.next;
        }
        node = new ListNode(container.val);
        node.next = next;
        return node;
    }

    public ListNode reverseList2(ListNode head) {
        // 虚拟头，用于存放反转结果
        ListNode result = new ListNode(0);

        ListNode item = head;
        ListNode next;
        while(true){
            if(item == null){
                break;
            }
            // 为了保证循环正常后移，先把下一个元素临时取出来
            next = item.next;
            // 因为需要移动到result链表中最前一个，所以我们需要把result的next节点，赋值给最新元素的item
            item.next = result.next;
            // 然后再把item插入到result当中
            result.next = item;
            // 元素后移继续循环
            item = next;
        }
        // 由于我们使用的虚拟头，第一个元素是无效的，直接取下一个节点就行了
        return result.next;
    }

    public ListNode reverseList3(ListNode head) {
        if (Objects.isNull(head)){
            return head;
        }
        ListNode next = null;
        ListNode container = head;
        ListNode tmp;
        while (container.next != null){
            tmp = container.next;
            container.next = next;
            next = container;
            container = tmp;
        }
        container.next = next;
        return container;
    }

    @Test
    public void t1(){
        LinkedList linkedList = new LinkedList();
        ListNode node = build();
        ListNode node1 = linkedList.reverseList3(node);
        while (node1.next!=null){
            System.err.println(node1.val);
            node1 = node1.next;
        }

    }

    public ListNode build(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        return node;
    }

}
