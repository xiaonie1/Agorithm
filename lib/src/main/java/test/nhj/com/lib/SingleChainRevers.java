package test.nhj.com.lib;

/**
 * 链表反转
 */
public class SingleChainRevers {
   static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data ;
        }
        public void setNext(Node next){
            this.next = next ;
        }
    }

    /**
     * 建立带头节点链表
     * @param arr
     * @return
     */
    public Node createEndChain(int [] arr){
        Node head = null;//头指针
        head = new Node(-1);//申请头节点内存
        Node end = head ;//尾指针
        for(int i=0;i<arr.length;i++){
            Node node = new Node(arr[i]) ;
            end.setNext(node);//节点连接
            end = node ;
        }
        return head ;
    }

    /**
     * 打印链表
     */
    public void printChian(Node head){
        Node p ;
        if(head==null){
            return ;
        }else{
            p = head.next;
        }
        while(p!=null){
            System.out.print(p.data+",");
            p = p.next ;
        }
    }

    /**
     *
     * @param head 元首节点
     * @return
     */
    public Node reverse2(Node head){
        if(head==null||head.next==null){
            return head ;
        }
        Node newHead = reverse2(head.next);
        head.next.next = head ;
        head.next = null ;
        return newHead ;
    }

    /**
     *合并两个升序链表
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeTwoLists(Node l1,Node l2){
        Node head = null;
        if(l1==null){
            return l2 ;
        }else if(l2==null){
            return l1;
        }
        if(l1.data<l2.data){
            head = l1 ;
            l1=l1.next;
        }else {
            head=l2;
            l2 = l2.next ;
        }
        Node p = head ;
        while(l1!=null&&l2!=null){
            if(l1.data<l2.data){
                p.next = l1 ;
                l1=l1.next;
            }else {
                p.next =l2;
                l2 = l2.next ;
            }
            p = p.next;
        }
        if(l1==null){
            p.next = l2;
        }

        if(l2==null){
            p.next = l1 ;
        }

        return head ;
    }

    public static void main(String args []){
//        翻转一个单项链表
//        reverse();
        int [] arr = {1,6,89,111};
        int [] arr2 = {2,3,7,34,99};
        SingleChainRevers test1 = new SingleChainRevers();
        Node head1 = test1.createEndChain(arr);
        Node head2 = test1.createEndChain(arr2);
        head1.next = test1.mergeTwoLists(head1.next,head2.next);
        test1.printChian(head1);
    }

    private static void reverse() {
        int [] arr = {12,345,2,5,1,6,33,56,78,27};

        SingleChainRevers test1 = new SingleChainRevers();
        Node head = test1.createEndChain(arr);
        test1.printChian(head);
        head.next = test1.reverse2(head.next);
        System.out.println("");
        test1.printChian(head);
    }
}
