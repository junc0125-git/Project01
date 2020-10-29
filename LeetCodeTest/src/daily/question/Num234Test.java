package daily.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2020-10-23 9:17
 */
public class Num234Test {
    public static void main(String[] args) {
        ListNode head=new ListNode(-129);
        ListNode p=new ListNode(-129);
        head.next=p;
        Num234Solution01 test=new Num234Solution01();
        boolean bool=test.isPalindrome(head);
        System.out.println(bool);
    }

}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Num234Solution01 {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        List<Integer> list=new ArrayList<>();
        ListNode q=head;
        while(q.next!=null){
            list.add(q.val);
            q=q.next;
        }
        list.add(q.val);
//        int[] array;
        Integer[] array=new Integer[list.size()];
//        int[] array=new int[list.size()];
        list.toArray(array);
        for(int num:array){
            System.out.println(num);
        }
        int i,j;
        i=0;
        j=array.length-1;
        while(i<=j){
            if(!array[i].equals(array[j])){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}