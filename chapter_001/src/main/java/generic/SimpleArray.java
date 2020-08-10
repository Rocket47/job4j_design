package generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import org.apache.commons.lang.ArrayUtils;

public class SimpleArray<T> implements Iterable {

    private Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        array[index++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, this.index);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, this.index);
        array = ArrayUtils.removeElement(array, index);
        this.index--;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return (T) array[index];
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(this.array).iterator();
    }
}
