package nodes;

public class OdnosvyazaniSpisok {
    Node head;
    Node tail;

    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previus = node;
        head = node;
    }

    public Integer pop(){
        Integer result = null;
        if (head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }

    public Integer peek(){
        Integer result = null;
        if (tail != null){
            result = tail.value;
            tail.previus.next = null;
            tail = tail.previus;
        }
        return result;
    }


    public class Node{
        int value;
        Node next;
        Node previus;
    }
}
