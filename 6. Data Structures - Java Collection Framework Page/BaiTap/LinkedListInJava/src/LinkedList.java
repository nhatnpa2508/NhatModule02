
public class LinkedList<E> {

    private class Node {
        private Node next;
        private Object data;

        public Node(E data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private Node tail;
    private int numNodes;

    public LinkedList(E data) {
        head = new Node(data);
        tail = new Node(data);
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null){
            tail = temp;
        }
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public Object getFirst() {
        return head.data;
    }

    public void addLast(E element) {
        Node temp = new Node(element);
        tail.next = temp;
        tail = temp;
        numNodes++;
    }

    public Object getLast() {
        return tail.data;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    public int getNumNodes() {
        return numNodes;
    }
    public void remove(int index){
        Node temp = head;
        Node holder;
        if (index == 0)head = temp.next;
        else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            holder = temp.next.next;
            temp.next = holder;
        }
        numNodes--;
    }
    public boolean remove1(E e){
        boolean isRemove = false;
        int index = 0;
        Node temp = head;
        while(temp != null) {
            index++;
            if (temp.data == e) {
                remove(index-1);
                isRemove = true;
            }
            temp = temp.next;
        }
        return isRemove;
    }
    public int size(){
        return numNodes;
    }
    public LinkedList<E> clone(){
        LinkedList Node2 = new LinkedList(0);
        Node temp = head;
        int index = 0;
        while(temp != null) {
            Node2.add(index,temp.data);
            temp = temp.next;
        }
        return Node2;
    }
    public boolean contains(E e){
        boolean isRemove = false;
        Node temp = head;
        while(temp != null) {
            if (temp.data == e) {
                isRemove = true;
                break;
            }
            temp = temp.next;
        }
        return isRemove;
    }
    public int indexOf(E e){
        boolean isRemove = false;
        int index = 0;
        Node temp = head;
        while(temp != null) {
            if (temp.data == e) {
                isRemove = true;
                break;
            }
            index++;
            temp = temp.next;
        }if (isRemove)
        return index;
        else return -1;
    }
    public boolean add(E element) {
        addLast(element);
        return true;
    }
    public void ensureCapacity(int minCapacity){
        int index = 0;
        Node temp = head;
        while(temp != null && index < minCapacity) {
            index++;
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }
    public Object get(int i){
        int index = 0;
        Node temp = head;
        while (index!=i && temp.next != null){
            temp=temp.next;
            index++;
        }
        return temp.data;
    }
    public void clear(){
        head = null;
        tail = null;
    }
}
