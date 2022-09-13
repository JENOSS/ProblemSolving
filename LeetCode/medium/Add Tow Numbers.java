import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 * [leetcode] [medium] [2] Add Two Numbers
 *
 * 상황을 잘 파악해야함
 **/

public class Main {

    public static void main(String[] args) throws IOException {
    }

 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newNode = new ListNode();
        next(newNode, l1, l2);

        return newNode;

    }

    public void next(ListNode current, ListNode l1, ListNode l2){
        if(current == null) return;

        if(l1 != null){
            current.val += l1.val;
        }

        if(l2 != null){
            current.val += l2.val;
        }

        if(current.val > 9){
            current.val -= 10;
            current.next = new ListNode(1);
        }else{
            if((l1 != null && l1.next != null) || (l2 != null && l2.next != null)){
                current.next = new ListNode();
            }
        }

        next(current.next, l1 == null ? null : l1.next, l2 == null ? null : l2.next);

    }

}
