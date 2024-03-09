import java.util.function.Consumer;

public class DynamicArray {

    private int size = 0;
    private int capacity = 8;
    private int[] array =  new int[capacity];


    public void add(int index, int element){
        if(index >= 0 && index < size){
            System.arraycopy(array, index,array ,index+1,size-index);
        }
        array[index] = element;
        size++;

    }

    public int get(int index){
        return array[index];
    }

    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }


}
