import java.io.*;

import java.util.* ;

public class Solution {

    public static int idx=0;

    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {

        // Write your code here.

        if(n==1 && b[0]==0) return head;

        if(head==null) return null;

        if(idx>=n) return head;

        int i=0;

        while(idx<n && b[idx]==0) idx++;

        i=b[idx];

        Node curr=head,pre=null,next=null;

        while(curr!=null && i-->0){

          next=curr.next;

          curr.next=pre;

          pre=curr;

          curr=next;

        }

        idx++;

        head.next= getListAfterReverseOperation(curr,n,b);

        return pre;

    }

}
