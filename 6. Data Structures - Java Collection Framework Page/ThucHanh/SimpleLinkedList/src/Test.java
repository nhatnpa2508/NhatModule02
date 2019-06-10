public class Test {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.add(3,11);
        ll.add(4,9);
        ll.add(4,9);
        ll.printList();
        System.out.println();
        ll.addFirst(14);
        ll.add(6,7);
        ll.printList();
        System.out.println(ll.getNumNodes());
    }
}
