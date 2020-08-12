package generic;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndex(id);
        if (index >= 0) {
            mem.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndex(id);
        try {
            if (index >= 0)
                mem.remove(index);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        for (T user : mem) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public int getIndex(String id) {
        int index = 0;
        boolean result = false;
        for (T object : mem) {
            if (object.getId().equals(id)) {
                result = true;
            } else {
                index++;
            }
        }
        if (!result) {
            index = -1;
        }
        return index;
    }
}
