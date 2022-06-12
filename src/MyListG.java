import java.util.Arrays;

public class MyListG<T> {

    private T[] array;
    private int size;
    private int capacity;

    private T[] tempArray;

    public MyListG() {
        this.capacity = 10;
        this.array = (T[]) new Object[this.capacity];
    }

    public MyListG(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[this.capacity];
    }

    public void add(T data) {


        if (size() >= getCapacity()) {
            this.tempArray = this.array;
            ciftCapacity(this.tempArray);
        }
        this.array[size++] = data;
    }

    public void ciftCapacity(T[] array) {


        setCapacity(getCapacity() * 2);
        this.array = (T[]) new Object[getCapacity()];
        this.array = Arrays.copyOf(array, getCapacity());

    }

    public T get(int index){
        if (array[index] != null) {
            return array[index];
        } else return null;
    }

    public T remove(int index){
        if (invalidIndex(index)) {
            return null;
        }
        T removed = this.array[index];

        this.array[index] = null;

        arrCln(index);

        this.size--;
        return removed;
    }
    public void arrCln(int select) {

        for (int i = select; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
    }

    public T set(int index,T data){
        if (invalidIndex(index)) {
            return null;
        }
        this.array[index]=data;

        return data;
    }
    public String toString() {
        if (size() > 0) {
            StringBuilder str = new StringBuilder("[");
            for (int i = 0; i < size(); i++) {
                if (i == (size() - 1)) {
                    str.append(array[i]).append("]");
                } else str.append(array[i]).append(",");

            }
            return str.toString();
        }
        return "[]";
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public boolean invalidIndex(int index) {
        return index > this.size;
    }
}