package daoInter;

import model.User;
import java.util.List;

public interface UserDaoInter {
    List<User> getAll();
    User getById(int id);
    boolean update(User u);
    boolean delete(int id);
}
