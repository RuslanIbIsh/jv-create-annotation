package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> getByName(String name);

    List<User> getAll();

    void save(User user);

    void update(String name);

    void delete(User user);
}
