package nodes;

public class DvuxsvyazaniSpisok{
    Node head;
    Node tail;

    public void add(int value){
        Node node = new  Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.previus = tail;
            tail = node;
        }
    }

    public void add(Node node, int value){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previus = node;
        if (next == null){
            tail = newNode;
        }else {
            next.previus = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node){
        Node previus = node.previus;
        Node next = node.next;
        if (previus == null){
            next.previus = null;
            head = next;
        }else{
            if (next == null){
                previus.next = null;
                tail = previus;
            }else {
                previus.next = next;
                next.previus = previus;
            }
        }
    }

    public void revert(){
        Node curentNode = head;
        while(curentNode != null){
            Node next = curentNode.next;
            Node previus = curentNode.previus;
            curentNode.next = previus;
            curentNode.previus = next;
            if (previus == null){
                tail = curentNode;
            }
            if (next == null){
                head = curentNode;
            }
            curentNode = next;
        }
    }

    public Node find(int value){
        Node curentNode = head;
        while (curentNode != null){
            if (curentNode.value == value){
                return curentNode;
            }
            curentNode = curentNode.next;
        }
        return null;
    }


    public class Node{
        int value;
        Node next;
        Node previus;
    }
}