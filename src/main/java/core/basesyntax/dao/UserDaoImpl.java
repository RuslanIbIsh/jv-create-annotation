package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public Optional<User> get(int index) {
        return Optional.ofNullable(Storage.users.get(index));
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
    public void update(int index, User user) {
        Storage.users.set(index, user);
    }

    @Override
    public void delete(User user) {
        Storage.users.remove(user);
    }
}
