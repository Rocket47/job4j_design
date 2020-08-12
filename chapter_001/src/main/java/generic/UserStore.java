package generic;

public class UserStore implements Store<User>{

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        try {
            store.replace(id, model);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean delete(String id) throws NullPointerException {
        store.delete(id);
        return true;
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
