package it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    private int index = 0;
    private int saveNextEvenNumberIndex = 0;

    public EvenIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                if (saveNextEvenNumberIndex == 0) {
                    saveNextEvenNumberIndex = i;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        Integer result = null;
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            result = data[saveNextEvenNumberIndex];
            index = ++saveNextEvenNumberIndex;
            saveNextEvenNumberIndex = 0;
            return result;
        }
    }
}
