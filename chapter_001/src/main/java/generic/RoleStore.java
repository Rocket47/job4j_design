package generic;

public class RoleStore implements Store<User>{

    public final Store<User> roleStore = new MemStore<>();

    @Override
    public void add(User model) {
        roleStore.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return roleStore.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return roleStore.delete(id);
    }

    @Override
    public User findById(String id) {
        return roleStore.findById(id);
    }
}
