package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public Optional<User> getByName(String name) {
        return Storage.users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public void save(User user) {
        Storage.users.add(user);
    }

    @Override
    public void update(User updatedUser) {
        User oldUser = getByName(updatedUser.getName()).orElseThrow();
        int index = Storage.users.indexOf(oldUser);
        Storage.users.set(index, updatedUser);
    }

    @Override
    public void delete(User user) {
        Storage.users.remove(user);
    }
}
