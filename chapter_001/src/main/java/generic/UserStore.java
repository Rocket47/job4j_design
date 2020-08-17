package generic;

public class UserStore implements Store<User>{

    public final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
       return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) throws NullPointerException {
        return store.delete(id);
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
