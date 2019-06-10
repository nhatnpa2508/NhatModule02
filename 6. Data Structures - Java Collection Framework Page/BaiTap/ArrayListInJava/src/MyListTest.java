public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.toString();
        System.out.println(list.size());
        list.add(3,5);
        list.toString();
        list.add(5,7);
        list.toString();
        System.out.println(list.size());
        list.remove(3);
        list.toString();

        System.out.println(list.clone());
        System.out.println(list.contains(7));
        System.out.println(list.indexOf(7));
        list.clear();
        list.toString();
    }
}
