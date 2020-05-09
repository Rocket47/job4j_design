package it;

import java.util.*;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> separateIterator = (new ArrayList<Integer>()).iterator();
            @Override
            public boolean hasNext() {
                while (it.hasNext() && !separateIterator.hasNext()) {
                    separateIterator = it.next();
                }
                return separateIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return separateIterator.next();
            }
        };
    }
}
