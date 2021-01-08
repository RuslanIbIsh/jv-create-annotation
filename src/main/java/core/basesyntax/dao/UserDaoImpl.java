package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public Optional<User> getByName(String name) {
        return Optional.ofNullable(Storage.users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .get()
        );
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
    public void update(String name) {
        User user = getByName(name).get();
        int index = Storage.users.indexOf(user);
        Storage.users.set(index, user);
    }

    @Override
    public void delete(User user) {
        Storage.users.remove(user);
    }
}
