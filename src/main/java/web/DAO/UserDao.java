package web.DAO;

import web.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    void save(User user);
    List<User> listUsers();
    Optional<User> findById(int id);
    void editUser( User user);
    void deleteUser(int  id);

}
