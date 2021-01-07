package core.basesyntax.dao;

import core.basesyntax.db.UserStorage;
import core.basesyntax.model.User;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public Optional<User> get(int id) {
        return Optional.ofNullable(UserStorage.users.get(id));
    }

    @Override
    public List<User> getAll() {
        return UserStorage.users;
    }

    @Override
    public void save(User user) {
        UserStorage.users.add(user);
    }

    @Override
    public void update(User user) {
        UserStorage.users.set(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        UserStorage.users.remove(user);
    }
}
