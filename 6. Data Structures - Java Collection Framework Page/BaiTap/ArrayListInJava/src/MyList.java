import java.util.Arrays;

public class MyList<E> {
    private int size=0;
    static private final int DEFAULT_CAPACITY = 10;
    Object[] elements;
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }
    private void ensureCapa(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }
    public void add(E element){
        if (size == elements.length)
            ensureCapa();
        elements[size++] = element;
    }
    public void add(int index, E element){
        if (size == elements.length)
            ensureCapa();
        if (index < 0 || index > elements.length){
            System.out.println("Index khong hop le");
        }else if (index > size && index < elements.length){
            elements[size++] = element;
        } else {
            elements[size++] = 0;
            for (int i = size; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index] = element;
        }
    }
    public Object[] remove(int index){
        if (index>=size || index< 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        for (int i = index; i < size ;i++){
            elements[i] = elements[i+1];
        }
        elements = Arrays.copyOf(elements,size--);
        return elements;
    }
    public int size(){
        return size;
    }
    public Object clone(){
        Object[] newElement = new Object[size()];
        for (int i = 0; i < size;i++) {
            newElement[i] = elements[i];
        }
        return newElement;
    }
    int indexO;
    public boolean contains(E o){
        boolean isO = false;
        for (int i = 0; i < size;i++){
            if (elements[i] == o) {
                isO = true;
                indexO = i;
            }
        }
        return isO;
    }
    public int indexOf(E o){
        if (contains(o)) {
            for (int i = 0; i < size;i++) {
                if (elements[i] == o) {
                    indexO = i;
                }
            }
            return indexO;
        }else return -1;
    }
    public void ensureCapacity(int minCapacity){
        if (size <= minCapacity)
            elements = Arrays.copyOf(elements,minCapacity);
        else elements = Arrays.copyOf(elements,size());
    }
    public E get(int i){
        if (i>=size || i< 0)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        return (E) elements[i];
    }
    public void clear(){
        for (int i = 0; i<size();i++)
            elements[i] = null;
        elements = Arrays.copyOf(elements,0);
    }
    public String toString(){
            String str = "";
            System.out.print("Elements: ");
            for (int i = 0; i < size(); i++) {
                System.out.print(get(i) + "\t");
            }
            System.out.println();
            return str;
    }
}
