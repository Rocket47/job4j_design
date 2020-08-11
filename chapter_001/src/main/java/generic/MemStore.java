package generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();


    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        try {
            int integerId = Integer.parseInt(id);
            mem.set(integerId, model);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            int integerId = Integer.parseInt(id);
            mem.remove(integerId);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        int integerId = Integer.parseInt(id);
        return mem.get(integerId);
    }
}
