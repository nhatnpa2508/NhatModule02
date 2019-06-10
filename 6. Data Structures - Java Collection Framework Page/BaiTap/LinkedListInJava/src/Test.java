
public class Test {
    public static void main(String[] args) {
        System.out.println("TEST");
        LinkedList ll = new LinkedList(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.add(4,6);
        ll.add(4,7);
        ll.add(3,7);
        ll.add(13,7);


        ll.printList();
        System.out.println();
        ll.addFirst(14);
        ll.add(6,7);
        ll.printList();
        System.out.println();
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println();
        System.out.println(ll.getNumNodes());
        System.out.println();
        ll.addLast(10);
        ll.addLast(10);
        System.out.println();
        ll.printList();
        System.out.println();

        System.out.println(ll.getNumNodes());
        System.out.println();
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println();

        ll.remove(3);
        ll.printList();
        System.out.println(ll.getNumNodes());
        System.out.println();
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        ll.remove(3);
        ll.printList();
        System.out.println();
        System.out.println(ll.getNumNodes());
        System.out.println(ll.remove1(2));

        ll.printList();
        System.out.println();
        System.out.println(ll.getNumNodes());
        System.out.println(ll.contains(10));
        System.out.println(ll.contains(1));
        System.out.println();

        ll.remove(0);
        ll.printList();
        System.out.println();
        System.out.println(ll.indexOf(10));
        ll.ensureCapacity(6);
        ll.printList();
        System.out.println();
        System.out.println(ll.get(2));
        System.out.println(ll.get(4));
        System.out.println();

        ll.clear();
        System.out.println();
        ll.printList();
    }
}
