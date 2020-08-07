package generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {

    Object[] array;
    Object[] newArray;
    int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        array[index++] = model;
    }

    public void set(int index, T model) {
        array[index] = model;
    }

    public void remove(int index) {
        try {
            for (int i = 0; i < array.length; i++) {
                if (i == index) {
                    newArray = new Object[array.length - 1];
                    System.arraycopy(array, 0, newArray, 0, i);
                    if (array.length - 1 - i >= 0) System.arraycopy(array, i + 1, newArray, i, array.length - 1 - i);
                    array = newArray;
                    break;
                }
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public T get(int index) {
        try {
            Objects.checkIndex(index, array.length);
            return (T) array[index];
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(this.array).iterator();
    }
}