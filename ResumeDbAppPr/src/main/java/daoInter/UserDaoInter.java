package daoInter;

import model.User;
import java.util.List;

public interface UserDaoInter {
    List<User> getAll();
    List<User> getById(int id);
    boolean update(String field, int id, String set);
    boolean delete(int id);
}
